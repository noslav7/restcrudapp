<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>CRUD Servlet</title>
</head>
<body>
<h1>Enter details to save in database</h1>
<form action="reportservlet" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Department:</td>
            <td><input type="text" name="department" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form>
<br />
<a href="viewservlet">view employees</a>
</body>
</html>
