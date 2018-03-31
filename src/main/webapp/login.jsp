<%@include file="header.jsp"%>

<form method="post" action="/login">
    Username: <input type="text" name="login"><br>
    Password: <input type="password" name="password"><br>
    <% String loginError = (String) request.getAttribute("loginError");
    if (loginError != null){%>
    <%=loginError.toString()%><br>
    <%}%>
    <input type="submit" value="Login">
</form>

<%@include file="footer.jsp"%>