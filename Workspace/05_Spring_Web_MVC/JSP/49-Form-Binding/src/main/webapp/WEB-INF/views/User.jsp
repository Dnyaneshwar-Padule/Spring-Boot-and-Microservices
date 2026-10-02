<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
<form action="/register" method="post">
    Username : <input type="text" name="name"> <br>
    Email : <input type="email" name="email"> <br>
    Phone : <input type="number" name="phone"> <br>
    Gender : <input type="radio" name="gender" value="male"> Male <input type="radio" name="gender" value="female"> Female <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>