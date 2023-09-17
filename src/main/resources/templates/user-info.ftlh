<!DOCTYPE html>
<html>
<head>
    <title>SHARETOOLS</title>
</head>
<body>
<h1>SHARETOOLS</h1><hr>
<h3>User description</h3>
<b>Phone number: </b> ${user.phoneNumber}<br>
<b>Date of registration: </b> ${user.createDate}<br>

<h4>${user.name} user's tools</h4>
<#list tools as tool>
    <div>
        <p><b>${tool.title} ${tool.price} usd </b> | <a href="/tool/${tool.id}">Details...</a></p>
    </div>
    <#else>
    <h3>User has no tools</h3>
</#list>
</body>
</html>