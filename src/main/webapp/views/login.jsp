<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/5
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="config.jsp" %>
<html>
<head>
    <title>login</title>
    <script type="text/javascript" src="${jquery_js}"></script>
    <script type="text/javascript" src="${login_js}"></script>
</head>
<body>
    <form action="${context}/page/login.do?" method="post" id="submitForm">
        username:<input type="text" name="username"/><br/>
        password:<input type="password" name="password"/><br/>
        <input type="button" value="submit" id="submit1"/>
    </form>
</body>
</html>
