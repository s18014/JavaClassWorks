<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>ポストデータ</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String food = request.getParameter("food");
if (food.equals("ラーメン")){
	out.println("ぼくも大好きです。");
} else if (food.equals("カレーライス")) {
	out.println("まぁまぁですね。");
} else if (food.equals("納豆ごはん")) {
	out.println("この世の食べ物とも思えない。");
} else {
	out.println("？？？");
}
%>
</body>
</html>