<%-- 
    Document   : register
    Created on : Mar 21, 2020, 12:42:37 PM
    Author     : George.Giazitzis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="css/maincss.css" rel="stylesheet"/>
        <title>Registration Page</title>
        <style>
            .error {
                color: #ff0000;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="span12">
                    <form:form cssClass="form-horizontacssClassl" action='doregister' method="POST"
                               modelAttribute="registeruser">
                        <fieldset>
                            <div id="legend">
                                <legend class="">Register</legend>
                            </div>
                            <div class="control-group">
                                <!-- Username -->
                                <label class="control-label" for="username">Username</label>
                                <div class="controls">
                                    <form:input path="username" cssClass="input-xlarge" id="username"/>
                                    <form:errors path="username" cssClass="error"/>
                                    <spann id="checkresult"></spann>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Password-->
                                <label class="control-label" for="password">Password</label>
                                <div class="controls">
                                    <form:input path="password" cssClass="input-xlarge" type="password"/>
                                    <form:errors path="password" cssClass="error"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Password-->
                                <label class="control-label" for="password">Retype Password</label>
                                <div class="controls">
                                    <form:input path="password2" cssClass="input-xlarge" type="password"/>
                                    <form:errors path="password2" cssClass="error"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Password-->
                                <label class="control-label" for="firstname">First Name</label>
                                <div class="controls">
                                    <form:input path="firstname" cssClass="input-xlarge"/>
                                    <form:errors path="firstname" cssClass="error"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Password-->
                                <label class="control-label" for="lastname">Last Name</label>
                                <div class="controls">
                                    <form:input path="lastname" cssClass="input-xlarge"/>
                                    <form:errors path="lastname" cssClass="error"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Select role:</label>
                                <form:select path="role" cssClass="form-control">
                                    <form:options items="${allroles}" itemValue="roleid" itemLabel="rolename"/>
                                </form:select>
                            </div>
                            <br><br>
                            <div class="control-group">
                                <!-- Button -->
                                <div class="controls">
                                    <button class="btn btn-success">Register</button>
                                </div>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
                ${message}
            </div>
        </div>
    </body>
</html>