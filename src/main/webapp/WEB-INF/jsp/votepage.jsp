<%-- 
    Document   : votepage
    Created on : Mar 26, 2020, 12:27:36 PM
    Author     : George.Giazitzis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>Vote Page</title>
    </head>
    <body>
        <div class="container">
            <div class="card">
                <h3 class="card-header text-center font-weight-bold py-4">Candidate List</h3>
                <div class="card-body">
                    <div id="table" class="table-editable">
                        <table class="table table-bordered table-responsive-md table-striped text-center">
                            <thead>
                                <tr>
                                    <th class="text-center">First Name</th>
                                    <th class="text-center">Last Name</th>
                                    <th class="text-center">Vote</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${allcandidates}" var="t">
                                    <tr>
                                        <td class="pt-3-half">${t.userfirstname}</td>
                                        <td class="pt-3-half">${t.userlastname}</td>
                                        <td class="pt-3-half">
                                            <form action="voteSubmit" method="POST">
                                                <input name="CandidateID" value="${t.userid}" type="hidden">
                                                <input type="submit" value="VOTE" class="btn btn-primary btn-rounded btn-sm my-0"></form>
                                        </td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
