<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>


    <link rel="stylesheet" type="text/css" href="css/register.css">

</head>
<body>

<%
    String missingEmail = "";
    String missingUsername = "";
    String missingPassword = "";
    String missingRetypePassword = "";
    String unSuccessfulReg = "   ";
%>

<%
    if (request.getAttribute("missingEmail") != null) {
        missingEmail = (String) request.getAttribute("missingEmail");
    }
    if (request.getAttribute("missingUsername") != null) {
        missingUsername = (String) request.getAttribute("missingUsername");
    }
    if (request.getAttribute("missingPassword") != null) {
        missingPassword = (String) request.getAttribute("missingPassword");
    }
    if (request.getAttribute("missingRetypePassword") != null) {
        missingRetypePassword = (String) request.getAttribute("missingRetypePassword");
    }
    if (request.getAttribute("unSuccessfulReg") != null) {
        unSuccessfulReg = (String) request.getAttribute("unSuccessfulReg");
    }
%>

<div class="loginbox">
    <div>
        <p class="nosuccess">&#160<%= unSuccessfulReg%>
        </p>
    </div>

    <form method="post" name="Login" action="register">
        <p class="form-group">
        <p class="first" align="center">
            <label><%= missingEmail%>
            </label> &ensp; &#160<input type="text" name="email" placeholder="E-mail" size="40"/>
        </p>
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
        <p class="fourth" align="center">
            <label><%= missingRetypePassword%>
            </label> &#160<input type="password" name="retypePass" placeholder="Retype password" size="40"/>
        </p>
        <br>
        <input type="submit" value="Register">
        </p>
    </form>

</div>

</body>
</html>