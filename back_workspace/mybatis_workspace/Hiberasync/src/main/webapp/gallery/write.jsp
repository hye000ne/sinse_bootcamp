<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		function upload() {
			//동기 방식으로 전송
			$("form").attr({
				enctype : "multipart/form-data",
				action : "/upload/regist",
				method : "post"
			});
			
			$("form").submit();
		}
		
		$(()=>{
			$("#uploadBtn").click(()=>{
				upload();
			});
		});
	</script>
</head>
<body>
	<pre>
		<form>
			<input type="text" id="title" name="title">
			<input type="file" id="pic" name="pic">
			<input type="button" id="uploadBtn" value="업로드">
		</form>
	</pre>
</body>
</html>