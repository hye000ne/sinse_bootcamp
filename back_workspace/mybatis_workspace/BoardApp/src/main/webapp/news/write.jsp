<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=button] {
	background-color: #04AA6D;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=button]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<%@ include file="/inc/head_link.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$('#content').summernote({
			height : 200
		}); // 서머노트 연동
		
		//버튼에 이벤트 연결
		$("input[type='button']").click(()=>{
			$("form").attr({
				action:"/news/regist",
				method:"POST" 
			});
			$("form").submit();//전송
		});
	});
</script>

<body>

	<h3>Contact Form</h3>

	<div class="container">
		<form method="post">
			<label for="fname">Title</label> <input type="text" id="fname" name="title" placeholder="제목을 입력하세요"> 
			<label for="lname">Writer</label>
			<input type="text" id="writer" name="writer" placeholder="작성자를 입력하세요"> 
			<label for="subject">Content</label>
			
			<textarea id="content" name="content" placeholder="Write something.." style="height: 200px"></textarea>

			<input type="button" value="Submit">
		</form>
	</div>

</body>
</html>
