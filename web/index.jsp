<%-- 
    Document   : index
    Created on : Aug 10, 2010, 1:31:52 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practice Solution</title>

        <link rel="stylesheet" href="main.css">

        <script src="main.js"></script>
    </head>
    <body>

<c:if test="${empty user}">
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <div align="center">
        <span id="indexTitle">Practice Solution 1.2</span>
        <form action="index" method="post" onsubmit="return validatelogin()">
           <table class="enterinfoform">
               <tr>
                   <td>Username:</td>
                   <td><input type="text" name="username"
                              id="username"/></td>
               </tr>
               <tr>
                   <td>Password:</td>
                   <td><input type="password" name="password"
                              id="password"/></td>
               </tr>
               <tr>
                   <td></td>
                   <td><input type="submit" value="Submit" /></td>
               </tr>
               <tr>
                   <td></td>
                   <td>
                       <span class="error">${errorMessage}</span>
                       <span class="success">${successMessage}</span>
                       <span class="info">${infoMessage}</span>
                   </td>
               </tr>
           </table>
        </form>
    </div>
</c:if>

<jsp:include page="/includes/footer.jsp" />