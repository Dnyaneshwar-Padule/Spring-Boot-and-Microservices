<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
        <spring:form modelAttribute="user" method="POST" action="/register">
            Username: <spring:input type="text" path="name"/>
            <spring:errors path="name" cssClass="error-message"/>
            <br>

            Email :  <spring:input type="text" path="email"/>
            <spring:errors path="email" cssClass="error-message"/>
            <br>

            Phone :  <spring:input type="text" path="phone"/>
            <spring:errors path="phone" cssClass="error-message"/>
            <br>

            Gender : <spring:radiobutton path="gender" value="male" label="Male" /> <spring:radiobutton path="gender" value="female" label="Female"/>
            <spring:errors path="gender" cssClass="error-message"/>
            <br>

            Birth Date : <spring:input type="date" path="birthDate"/>
            <spring:errors path="birthDate" cssClass="error-message"/>
            <br>
            <input type="submit" value="Submit">
        </spring:form>
</body>
</html>