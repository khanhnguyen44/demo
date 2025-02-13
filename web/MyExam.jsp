<%-- 
    Document   : MyExam
    Created on : Jan 3, 2025, 8:14:39 PM
    Author     : tungn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        List of Students:
        <table border = "1">
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Date of birth</td>
                <td>Gender</td>
                <td>Subject</td>
            </tr>

            <c:forEach var="s" items="${st}">
                <tr>
                    <td>${s.code}</td>
                    <td>${s.name}</td>
                    <td>${s.date}</td>
                    <td>${s.gender}</td>
                    <td>${s.sub}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        Detail information:
        <form action="add" method="post">
            <table>
                <tr>
                    <td>Code:</td>
                    <td><input name="code" type="text" required></td>
                    <td>Name:</td>
                    <td><input name="name" type="text" required></td>
                </tr>
                <tr>
                    <td>Date of birth:</td>
                    <td><input name="dob" type="text" required></td>
                    <td>Gender:</td>
                    <td>
                        <input type="radio" name="gender" value="Male">Male
                        <input type="radio" name="gender" value="Female">Female
                    </td>
                </tr>
                <tr>
                    <td>Subject:</td>
                    <td>
                        <select name="option">
                            <option>Java core</option>
                            <option>Java web</option>
                            <option>Database</option>
                            <option>Operating system</option>
                        </select>
                    </td>
                    <td><button type="submit">CREATE</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
