<!DOCTYPE html>
<html>
<head>
    <title>SHARE TOOLS</title>
</head>
<body>
<h1> Share tools app</h1><hr>
<#if user.email??>
    <h3>User name: ${user.name}</h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="logout"/>
    </form>
<#else>
    <a href="/login">Log in</a> </h1>
</#if>



<h3> All available tools</h3>
<form action="/" method="get">
    Search by title: <input type="text" name="title"/><br>
    <input type="submit" value="Search"/>
</form>

<#list tools as tool>
    <div>
        <p><b>${tool.title} ${tool.price} usd </b> | <a href="/tool/${tool.id}">Details...</a></p>
    </div>
    <#else>
    <h3>No tools available</h3>
</#list>
<#if user.email??>
    <hr>
    <hr3>Add new Household tool</hr3>
    <form action="/tool/create" method="post" enctype="multipart/form-data">
        Tool name: <input type="text" name="title"/><br><br>
        Tool description: <input type="text" name="description"/><br><br>
        Tool price: <input type="number" name="price"/><br><br>
        Tool address: <input type="text" name="address"/><br><br>
        Photo 1 : <input type="file" name="file1"/><br><br>
        Photo 2 : <input type="file" name="file2"/><br><br>
        Photo 3 : <input type="file" name="file3"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Add tool"/>
    </form>
</#if>
</body>
</html>