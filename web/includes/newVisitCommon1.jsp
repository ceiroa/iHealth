<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p class="error">${message}</p>

    <c:if test="${not empty visit.firstName}">
        <p><strong>Client:</strong> ${visit.firstName} ${visit.lastName}</p>
    </c:if>

    <c:if test="${empty noMenu}">
        <form action="${visit.controller}" method="post" target="_blank">
            <input type="hidden" name="visitId" value="${visit.id}" />
            <input type="hidden" name="clientId" value="${visit.clientId}" />
            <input type="hidden" name="postReqSource" value="visitsLog" />
            <input type="hidden" name="controller" value="${visit.controller}" />
            <input type="hidden" name="noMenu" value="true" />
            <input type="Submit" value="Print Format" />
        </form>
    </c:if>
