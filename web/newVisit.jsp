<%-- 
    Document   : newVisit
    Created on : Aug 29, 2010, 1:11:24 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">
    <jsp:include page="/includes/header.jsp" />

    <h2>New Visit</h2>
    <p class="error">${errorMessage}</p>
    <p class="success">${successMessage}</p>
    <p class="info">${infoMessage}</p>
    
    <jsp:include page="/includes/clientSearch.jsp" />

    <br/><br/>
    <c:if test="${not empty clients}">
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th colspan="4">Create New Visit</th>
            </tr>
            <c:forEach var="client" items="${clients}">
                <tr>
                    <td>${client.firstName}</td>
                    <td>${client.lastName}</td>
                    <td>${client.email}</td>
                    <td>
                        <form action="cervicalSpine" method="post">
                            <input type="hidden" name="postReqSource" value="newVisit" />
                            <input type="hidden" name="clientId" value="${client.id}" />
                            <input type="Submit" value="Cervical Spine" />
                        </form>
                    </td>
                    <td>
                        <form action="upperExtremities" method="post">
                            <input type="hidden" name="postReqSource" value="newVisit" />
                            <input type="hidden" name="clientId" value="${client.id}" />
                            <input type="Submit" value="Upper Extremities" />
                        </form>
                    </td>
                    <td>
                        <form action="lumbarSpine" method="post">
                            <input type="hidden" name="postReqSource" value="newVisit" />
                            <input type="hidden" name="clientId" value="${client.id}" />
                            <input type="Submit" value="Lumbar Spine" />
                        </form>
                    </td>
                    <td>
                        <form action="lowerExtremities" method="post">
                            <input type="hidden" name="postReqSource" value="newVisit" />
                            <input type="hidden" name="clientId" value="${client.id}" />
                            <input type="Submit" value="Lower Extremities" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <jsp:include page="/includes/footer.jsp" />
</c:if>

<c:if test="${empty user}">
    <c:redirect url="index.jsp" />
</c:if>