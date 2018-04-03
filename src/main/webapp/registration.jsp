<%--
  Created by IntelliJ IDEA.
  User: DARJ
  Date: 26.03.2018
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>Please register:</h1>
<%-- TODO: Change get to post, and set action --%>
<form method="post" action="/userRegistration">
    Login:<br>
    <input type="text" name="login"><br>

    <%if (request.getAttribute("uniquelogin") != null){
        Boolean isUniqueLogin = (Boolean) request.getAttribute("uniquelogin");
        if (false == isUniqueLogin){
    %><span class="error"> Login is already used </span><br><%
        }}%>

    E-mail:<br>
    <input type="email" name="email"><br>

    <%if (request.getAttribute("uniqueemail") != null){
                Boolean isUniqueEmail = (Boolean) request.getAttribute("uniqueemail");
        if (false == isUniqueEmail){
    %> <span class="error"> Email is already used </span><br><%
        }}%>

    Password:<br>
    <input type="password" name="password"><br>
    Confirm password:<br>
    <input type="password" name="passwordConf"><br>

    <%if (request.getAttribute("passwordsmatch") != null){
    Boolean doesPasswordsMatch = (Boolean) request.getAttribute("passwordsmatch");
    if (false == doesPasswordsMatch){
    %> <span class="error"> Password does not mach </span><br><%
    }}%>

    <br>
    <input type="submit" value="Register">

</form>
<%@include file="footer.jsp"%>
