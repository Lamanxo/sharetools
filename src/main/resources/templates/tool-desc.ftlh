<!DOCTYPE html>
<html>
<head>
    <title>SHARE TOOLS</title>
</head>
<body>
<h1> Share tools app </h1>
<hr>
<h3>Tool description</h3>
<#list images as img>
    <img src="/images/${img.id}" height = "60px"/><br><br>
</#list>
<b>Tool name: </b>${tool.title}<br>
<b>Tool description: </b>${tool.description}<br>
<b>Tool owner: </b>${tool.user.name}<br>
<b>Tool address: </b>${tool.address}<br>
<hr>
</body>
</html>