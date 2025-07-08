<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script type="text/javascript">
	
		function getFoodList() {
			$.ajax({
				type:"GET",
				url:"/foodtype/list",
				success: function(result, status, xhr) {
					console.log(result);
					var html = "<option value='0'>식당유형</option>";
					for(let i=0;i<result.length;i++){
						html += "<option value='"+result[i].food_type_id+"'>"+result[i].title+"</option>";
					}
					$("#foodTypeSel").html(html);
					$("#foodTypeSel2").html(html);
				},
				error: function(xhr, status, error) {

				}
			});
		}
		
		
		function getDetail(storeId){
			$.ajax({
				type: "GET",
				url: "/store/detail?store_id="+storeId,
				success: function(result) {
					console.log(result);
					$("#foodTypeSel2").val(result.foodType.food_type_id);
					$("#storeId2").val(result.store_id);
					$("#storeName2").val(result.store_name);
					$("#tel2").val(result.tel);
				}
			});
		}
	
		function getStoreList() {
			$.ajax({
				url:"/store/list",
				type: "GET",
				success: function(result, status, xhr) {
					printList(result);
				},
				error: function(xhr, status, err){

				}
			});
		}
		
		function regist() {
			$.ajax({
				type: "POST",
				url: "/store/regist",
				data: {
					foodTypeSel : $("#foodTypeSel").val(),
					storeName : $("#storeName").val(),
					tel : $("#tel").val()
				} ,
				success: function(result, status, xhr) {
					if(result.result === "success") {
		                alert("등록성공");
		                getStoreList();
		            } else {
		                alert(result.msg);
		            }
				},
				error: function(xhr, status, error) {
					try {
		                let json = JSON.parse(xhr.responseText);
		                alert(json.msg);
		            } catch(e) {
		                alert("알 수 없는 오류: " + error);
		            }
				}
			})	
		}
		
		function update() {
			$.ajax({
				type: "POST",
				url: "/store/update",
				data : {
					foodTypeSel : $("#foodTypeSel2").val(),
					storeName : $("#storeName2").val(),
					tel : $("#tel2").val(),
					storeId : $("#storeId2").val()
				}, 
				success: function(result) {
					console.log(result);
					if(result.result === "success") {
		                alert("수정성공");
		                getStoreList();
		            } else {
		                alert(result.msg);
		            }
				},
				error: function(xhr, status, error) {
					try {
		                let json = JSON.parse(xhr.responseText);
		                alert(json.msg);
		            } catch(e) {
		                alert("알 수 없는 오류: " + error);
		            }
				}
			});
		}
		
		function deletes() {
			$.ajax({
				type: "POST",
				url: "/store/delete",
				data : {
					storeId : $("#storeId2").val()
				},
				success: function(result){
					console.log(result);
					if(result.result === "success") {
		                alert("삭제성공");
		                getStoreList();
		            } else {
		                alert(result.msg);
		            }
				},
				error: function(xhr, status, error) {
					try {
		                let json = JSON.parse(xhr.responseText);
		                alert(json.msg);
		            } catch(e) {
		                alert("알 수 없는 오류: " + error);
		            }
				}
			});
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