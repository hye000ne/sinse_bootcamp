<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script type="text/javascript">
	
		function getDetail(store_id){
			let xhttp = new XMLHttpRequest();
			
			xhttp.open("GET", "/store/detail?store_id="+store_id);
			xhttp.onload = function(){
				let json = JSON.parse(this.responseText);
				$("#storeId2").val(json.store_id);
				$("#foodTypeSel2").val(json.foodType.food_type_id);
				$("#storeName2").val(json.store_name);
				$("#tel2").val(json.tel);
			};
			xhttp.send();
		}
		
		function printList(json) {
			let tag="<table width='90%'>";
			tag+="<tr>";
			tag+="	<th>음식 분류</th>";
			tag+="	<th>상호명</th>";
			tag+="	<th>연락처</th>";
			tag+="</tr>";
			for(let i=0;i<json.length;i++){
				tag+="<tr>";
				tag+="	<td>"+json[i].foodType.title +"</td>";
				tag+="	<td><a href='javascript:getDetail("+json[i].store_id +")'>"+json[i].store_name+"</a></td>";
				tag+="	<td>"+json[i].tel+"</td>";
				tag+="</tr>";
			}
			tag+="</table>"
			$("#content_list").html(tag);
		}
	
		function getStoreList() {
			let xhttp = new XMLHttpRequest();
			xhttp.open("GET", "/store/list");
			xhttp.onload = function() {
				let json = JSON.parse(this.responseText);
				printList(json);
			}
			xhttp.send();
		}
	
		function getFoodList(taget) {
			/* Ajax(Asynchronous JavaScript And XML) */
			let xhttp = new XMLHttpRequest();
			xhttp.open("GET", "/foodtype/list");
			xhttp.onload = function() { // 웹 브라우저가 서버로부터 응답을 받았을 경우 이 메서드 호출
				let foodTypeList = JSON.parse(this.responseText);
				let tag ="<option value='0'>유형 선택</option>";
				for(let i=0;i<foodTypeList.length;i++) {
					tag += "<option value='"+foodTypeList[i].food_type_id+"'>"+foodTypeList[i].title+"</option>"
				}
				
				$("#foodTypeSel").html(tag);
				$("#foodTypeSel2").html(tag);
			}
			xhttp.send(); //요청 시점이 발생하는 지점
		}
		
		function regist() {
			let xhttp = new XMLHttpRequest();
			xhttp.open("POST", "/store/regist");
			//아래의 post 전송 요청 헤더는 표준이고, 그 동안은 브라우저가 대신 해주었으나 비동기 통신에서는 개발자가 직접 다 해줘야 함
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.onload = function() {
				if(this.status == 201) { 
					// 서버의 응답 코드 200번대 성공 / 400~500 오류
					getStoreList();
				} else {
					let json = JSON.parse(this.responseText); //서버가 보내온 응답 문자열
					alert(json.msg);
				}
			}
			
			xhttp.send("foodTypeSel="+$("#foodTypeSel").val()+"&storeName="+$("#storeName").val()+"&tel="+$("#tel").val());
			//전송 파라미터 만들기
			 //요청 -> 비동기 시작
		}
		
		function update() {
			let xhttp = new XMLHttpRequest();
			xhttp.open("POST", "/store/update");
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.onload = function() {
				if(this.status == 201) { 
					getStoreList();
				} else {
					let json = JSON.parse(this.responseText); //서버가 보내온 응답 문자열
					alert(json.msg);
				}
			}
			
			xhttp.send("storeId="+$("#storeId2").val()+"&foodTypeSel="+$("#foodTypeSel2").val()+"&storeName="+$("#storeName2").val()+"&tel="+$("#tel2").val());
		}
		
		function deletes() {
			let xhttp = new XMLHttpRequest();
			xhttp.open("POST", "/store/delete");
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.onload = function() {
				if(this.status == 201) { 
					getStoreList();
				} else {
					let json = JSON.parse(this.responseText); //서버가 보내온 응답 문자열
					alert(json.msg);
				}
			}
			
			xhttp.send("storeId="+$("#storeId2").val());
		}
		
		$(()=>{
			getStoreList();
			getFoodList();
			$("#registBtn").click(()=>{
				regist();
			});	
			$("#updBtn").click(()=>{
				if(confirm("정말 수정하시겠어요?")) update();
			});	
			$("#delBtn").click(()=>{
				if(confirm("정말 삭제하시겠어요?")) deletes();
			});	
			
		});
	
	</script>
	
	<style type="text/css">
		#wrapper {
			width: 1200px;
			height: 800px;
			display: flex;
		}
		
		#aside_regist, #aside_detail {
			width: 200px;
			height: 800px;
			background-color: yellow;
		}
		
		#content {
			width: 1000px;
			height: 800px;
			display: flex;
			flex-direction: column;
		}
		
		#content_header {
			height: 50px;
			line-height: 50px;
			text-align: center;
		}
		
		#content_list {
			height: 750px;
		}
		
		table {
			border-collapse: collapse;
			border-spacing: 0;
			width: 100%;
			border: 1px solid #ddd;
		}
		
		th, td {
			text-align: left;
			padding: 16px;
		}
		
		tr:nth-child(even) {
			background-color: #f2f2f2;
		}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="aside_regist">
			<select id="foodTypeSel" name="foodTypeSel"></select>
			<input type="text" id="storeName" name="storeName" placeholder="맛집 상호명">
			<input type="text" id="tel" name="tel" placeholder="연락처">
			<button type="button" id="registBtn">등록</button>
		</div>
		<div id="content">
			<div id="content_header">
				<select>
					<option>전체</option>
					<option>상호명</option>
					<option>연락처</option>
				</select>
				<input type="text" placeholder="검색 키워드">
				<button>검색</button>
			</div>
			<div id="content_list"></div>
		</div>
		<div id="aside_detail">
			<select id="foodTypeSel2" name="foodTypeSel"></select>
			<input type="hidden" id="storeId2">
			<input type="text" id="storeName2" placeholder="맛집 상호명">
			<input type="text" id="tel2" placeholder="연락처">
			<button type="button" id="updBtn">수정</button>
			<button type="button" id="delBtn">삭제</button>
		</div>
	</div>
		
</body>
</html>