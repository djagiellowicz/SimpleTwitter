<%@include file="header.jsp"%>

<form action="/post" method="post">
    <input type="text" name="postText" placeholder="enter your text here"><br>
    <input type="submit" value="Post message">
    <%
        if (request.getAttribute("postError") != null)
        {
            Boolean hasErorrOccured = (Boolean) request.getAttribute("postError");
            if (hasErorrOccured){
    %> <span class="error"> Error - post has not been saved</span> <%
        }}%>
</form>

<%@include file="footer.jsp"%>