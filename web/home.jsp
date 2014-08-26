<%-- 
    Document   : home
    Created on : Aug 29, 2010, 11:58:21 AM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">

    <jsp:include page="/includes/header.jsp" />

    <br/>
    <h2>Welcome to iHealth Management System</h2>
    <h3>Please select one of the options from the menu above.</h3>
    <br/>
    
    <h4></h4>

    <jsp:include page="/includes/footer.jsp" />

</c:if>

<c:if test="${empty user}">
    <c:redirect url="index.jsp" />
</c:if>