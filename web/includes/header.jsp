<%--
    Document   : manageClients
    Created on : Aug 28, 2010, 1:14:25 PM
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

        <c:if test="${not empty noMenu}">
            <link rel="stylesheet" href="print.css">
        </c:if>


        <script src="main.js"></script>
    </head>
    <body>

        <c:if test="${not empty user and empty noMenu}">
            <div class="logout"><a href="logout">Log Out</a></div>
        </c:if>

        <div id="allbutlogout">
            <c:if test="${empty noMenu}">
                <h1>Practice Solution</h1><br/>
            </c:if>

            <c:if test="${not empty user and empty noMenu}">
                <c:if test="${user.userType eq 'admin'}">
                        <jsp:include page="/includes/menuAdmin.jsp" />
                </c:if>
                <c:if test="${user.userType eq 'nonadmin'}">
                        <jsp:include page="/includes/menuNonAdmin.jsp" />
                </c:if>

                <div id="content">
            </c:if>

            <c:if test="${empty user}">
                <c:redirect url="index.jsp" />
            </c:if>
    