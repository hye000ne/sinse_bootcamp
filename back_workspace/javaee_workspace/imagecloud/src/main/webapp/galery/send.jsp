<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(()=>{
		$("button").click(()=>{
			/* $("form").attr("method","post");
			$("form").attr("action","/upload/regist");
			// 텍스트뿐 아니라 바이너리 파일로 폼전송을 하려면 복합적 형식을 선언
			$("form").attr("enctype","multipart/form-data"); */
			
			// 위의 html DOM 속성을 명시하기 보다는 json을 이용하여 코드를 줄여보자
			$("form").attr({
				"method" : "post",
				"action" : "/upload/regist",
				"enctype" : "multipart/form-data"
			});
			
			$("form").submit(); // 전송
		});
	});
</script>
</head>
<body>
	<pre>
		<form>
			<input type="text" name="title">
			<input type="file" name="photo">
			<button type="button">업로드</button>
		</form>
		
	</pre>
</body>
</html>