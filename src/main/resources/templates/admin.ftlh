<!DOCTYPE html>
<html>
<head>
    <title>SHARETOOLS</title>
</head>
<body>
<h1>SHARETOOLS</h1>
<hr>
<h4>Control panel</h4>
<table border="1">
    <tr>
        <th>Email</th>
        <th>Phone number</th>
        <th>Activity</th>
        <th>Roles</th>
        <th>Ban</th>
        <th>Edit user</th>
        <th>Description</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th>${user.phoneNumber}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role>${role}</#list></th>
            <th>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Ban/Unban">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Edit</a></th>
            <th><a href="/user/${user.id}">Description</a></th>
        </tr>
    <#else>
        <h3>Users not found</h3>
    </#list>
</table>
</body>
</html>