<html>
<style>
    form{
        text-align:center;
    }
    input {
        vertical-align: top;
    }
</style>
<head>
    <title>Login</title>
</head>
<body>
<form action="/CatalogFacultate/studentCheckCredentials" method="post">
    <input type = "text" name = "id" value="id">
    <input type = "password" name = "password" value="password">
    <input type = "submit" value ="Login">
</form>

</body>
</html>
