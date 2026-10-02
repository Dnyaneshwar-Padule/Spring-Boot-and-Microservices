<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
    <spring:form modelAttribute="user" action="/register" method="POST">
        Username : <spring:input type="text" path="name" /> <br>
        Email    : <spring:input type="email" path="email"/> <br>
        Phone    : <spring:input type="number" path="phone"/> <br>
        Gender   : <spring:radiobutton path="gender" value="male" label="Male"/> <spring:radiobutton path="gender" value="female" label="Female"/>
        <input type="submit" value="Submit">
    </spring:form>
</body>
</html>