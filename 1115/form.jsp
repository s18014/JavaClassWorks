<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>ポストデータ</title>
</head>
<body>
<form method="POST" action="result.jsp">
あなたの好きな食べ物は？
<select name="food">
    <option value="ラーメン">ラーメン</option>
    <option value="カレーライス">カレーライス</option>
    <option value="納豆ごはん">納豆ごはん</option>
</select>
<input type="submit" value="送信" />
</form>
</body>
</html>