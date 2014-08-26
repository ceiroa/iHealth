<%-- 
    Document   : manageClients
    Created on : Aug 29, 2010, 1:14:25 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">
    <jsp:include page="/includes/header.jsp" />

    <h2>Manage Clients</h2>
    <p class="error">${errorMessage}</p>
    <p class="success">${successMessage}</p>
    <p class="info">${infoMessage}</p>
    
    <jsp:include page="/includes/clientSearch.jsp" />

    <br/><br/>

    <c:if test="${not empty clients}">
        <table>
            <tr>
                <th>SSN</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Zip Code</th>
                <th>Phone</th>
                <th>Email</th>
            </tr>
            <c:forEach var="client" items="${clients}">
                <tr>
                    <td>${client.ssn}</td>
                    <td>${client.firstName}</td>
                    <td>${client.lastName}</td>
                    <td>${client.address}</td>
                    <td>${client.city}</td>
                    <td>${client.state}</td>
                    <td>${client.zipcode}</td>
                    <td>${client.cellPhone}</td>
                    <td>${client.email}</td>
                    <td>
                        <form action="newClient" method="post">
                            <input type="hidden" name="id" value="${client.id}"/>
                            <input type="hidden" name="postReqSource" value="manage"/>
                            <input type="hidden" name="update" value="false"/>
                            <input type="Submit" value="View/Edit" />
                        </form>
                    </td>
                    <td>
                        <form action="deleteClient" method="post" onsubmit="return confirmDelete()">
                            <input type="hidden" name="id" value="${client.id}"/>
                            <input type="Submit" value="Delete" />
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