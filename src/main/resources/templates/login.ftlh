<!DOCTYPE html>
<html>
<head>
    <title>SHARETOOLS</title>
</head>
<body>
<h1>SHARETOOLS</h1><hr>
<h4>SIGN IN</h4>
<form action="/login" method="post">
    email: <input type="email" name="username"><br><br>
    password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Login"/>
</form>
<a href="/registration">Registration</a>
</body>
</html>