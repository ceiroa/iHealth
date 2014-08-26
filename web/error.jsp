<%--
    Document   : home
    Created on : Aug 29, 2010, 11:58:21 AM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">

    <jsp:include page="/includes/header.jsp" />

    <div class="error"><p>There has been an error processing your request.</p>
        <p>Please go back and try again. Make sure that all the data has been
        properly entered.</p></div>

    <jsp:include page="/includes/footer.jsp" />

</c:if>

<c:if test="${empty user}">
    <c:redirect url="index.jsp" />
</c:if>