<!DOCTYPE html>
<html>
<head>
    <title>SHARE TOOLS</title>
</head>
<body>
<h1> Share tools app </h1>
<hr>
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
<hr>
<hr3>Add new Household tool</hr3>
<form action="/tool/create" method="post">
    Tool name: <input type="text" name="title"/><br><br>
    Tool description: <input type="text" name="description"/><br><br>
    Tool owner: <input type="text" name="owner"/><br><br>
    Tool price: <input type="number" name="price"/><br><br>
    Tool address: <input type="text" name="address"/><br><br>
    <input type="submit" value="Add tool"/>
</form>
</body>
</html>