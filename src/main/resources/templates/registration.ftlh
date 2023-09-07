<!DOCTYPE html>
<html>
<head>
    <title>SHARETOOLS</title>
</head>
<body>
<h1>SHARETOOLS</h1><hr>
<h4>Registration</h4>
<form action="/registration" method="post">
    name: <input type="text" name="name"><br><br>
    phone number: <input type="text" name="phoneNumber"><br><br>
    email: <input type="email" name="email"><br><br>
    password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Create account"/>
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>