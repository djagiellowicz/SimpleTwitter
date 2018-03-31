<%@ page import="com.simpletwitter.jsp.model.User" %><%--
  Created by IntelliJ IDEA.
  User: DARJ
  Date: 26.03.2018
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Twitter</title>
</head>
<body>
<%  User loggedUser = (User) request.getSession().getAttribute("loggedUser");
if (loggedUser != null){%>
    Logged User: <%=loggedUser.getLogin()%>
<%}%>

