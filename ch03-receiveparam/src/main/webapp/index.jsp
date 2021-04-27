<%--
  Created by IntelliJ IDEA.
  User: STARLINK
  Date: 2021/4/23
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>提交参数给Controller</p>
<form action="receiveparam.do" method="post">
    姓名:<input type="text" name="name">
    年龄:<input type="text" name="age">
    <input type="submit" value="提交参数">
</form>

</body>
</html>
