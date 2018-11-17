<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" type="text/css" href="css/login.css">

</head>
<body>

<%
    String missingUsername = "";
    String missingPassword = "";
    String unSuccessfulLog = "   ";

%>

<%
    if (request.getAttribute("missingUsername") != null) {
        missingUsername = (String) request.getAttribute("missingUsername");
    }
    if (request.getAttribute("missingPassword") != null) {
        missingPassword = (String) request.getAttribute("missingPassword");
    }
    if (request.getAttribute("unsuccessfulLog") != null) {
        unSuccessfulLog = (String) request.getAttribute("unsuccessfulLog");
    }
%>


<div class="loginbox">

    <div>
        <p class="nosuccess">&#160<%= unSuccessfulLog%>
        </p>
    </div>
    <form method="post" name="Login" action="login">
        <p class="form-group" align="center">

            <br>
        <p class="second" align="center">
            <label><%= missingUsername%>
            </label>&ensp; &#160<input type="text" name="user" placeholder="Username" size="40"/>

        </p>
        <br>
        <p class="third" align="center">
            <label><%= missingPassword%>
            </label> &nbsp; &#160;<input type="password" name="pass" placeholder="Password" size="40"/>

        </p>
        <br>
        <input type="submit" value="Login">
        </p>
    </form>
</div>
</body>
</html>
