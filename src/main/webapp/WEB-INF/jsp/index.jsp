<%-- 
    Document   : index
    Created on : Mar 26, 2020, 11:13:40 AM
    Author     : George.Giazitzis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <style>
            .error {
                color: #ff0000;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div>Login:</div>
        <form:form method="POST" modelAttribute="myuser"
                   action="dologin">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><form:input path="username" id="username"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:input path="userpassword" type="password"/></td>
                </tr>          
                <tr>
                    <tr><form:errors path="username" cssClass="error"/></tr>
                    <td colspan="3"><input type="submit" value="Login"></td>
                </tr>
            </table>
        </form:form>
        <h3>${message}</h3>
        <br>
        <div>Registration:</div>
        <a href="preRegister">Register here</a>
    </body>
</html>
