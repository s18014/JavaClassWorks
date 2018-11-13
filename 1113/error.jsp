<%@ page contentType="text/html;charset=UTF-8" %>
<%! String title = "サーバサイドjavaの学習"; %>
<html>
<head>
    <meta charset="UTF-8" />
    <title><%=title %></title>
</head>
<body>
    <%
    for (int i = 0; i < 5; i++ ) {
    out.println(title + "<br/>");
    }
    %>
</body>
</html>
