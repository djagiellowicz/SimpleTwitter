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
<form method="get" action="">
    Login:<br>
    <input type="text" name="login"><br>
    E-mail:<br>
    <input type="email" name="email">
    <br>
    Password:<br>
    <input type="password" name="password">
    <br>
    Confirm password:<br>
    <input type="password" name="passwordConfirmation">
    <br>
    <input type="submit" value="Register">
</form>
<%@include file="footer.jsp"%>
