<html>
<style>
    .buttonHolder{ text-align: center; }
    button {
        background-color: #f44336; /* Green */
        color: white;
        padding: 15px 32px;
        font-size: 24px;
    }
    img {
        display: block;
        margin: 0 auto;
    }
</style>

<head>
    <title>HomePage</title>
</head>
<body bgcolor="#e7e7e7">
<div class="buttonHolder">
    <button onclick="location.href = 'http://localhost:8080/CatalogFacultate/student';" id="Student" class="float-left submit-button" >Student</button>
    <button onclick="location.href = 'http://localhost:8080/CatalogFacultate/professor';" id="Profesor" class="float-left submit-button" >Professor</button>
</div>
<img src="resources/logo.jpg">
</body>
</html>
