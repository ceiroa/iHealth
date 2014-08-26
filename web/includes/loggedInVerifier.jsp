<%--
    Document   : manageClients
    Created on : Aug 29, 2010, 1:14:25 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.ceiroa.common.model.User"%>

<%
    User user = (User)session.getAttribute("user");

    if(user!=null) {
%>
        <p>User not null</p>
<%
    } else {
        //Redirect to home
        String url = "/index.jsp";
        response.sendRedirect(url);
%>
        <p>User null, but redirect not working</p>
<%
    }
%>
