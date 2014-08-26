<%--
    Document   : manageClients
    Created on : Aug 29, 2010, 1:14:25 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">
    <jsp:include page="/includes/header.jsp" />

    <h2>Manage Uploads</h2>
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
                <!-- <th>Existing Files</th> -->
                <th>Number of Files to Upload</th>
            </tr>
            <c:forEach var="client" items="${clients}">
                <tr>
                    <td>${client.firstName}</td>
                    <td>${client.lastName}</td>
                    <td>${client.email}</td>
                    <!-- <td><span class="error">TODO</span></td> -->
                    <td>
                        <form action="upload" method="post">
                            <input type="hidden" name="postReqSource" value="manageUploads"/>
                            <input type="hidden" name="firstName" value="${client.firstName}"/>
                            <input type="hidden" name="lastName" value="${client.lastName}"/>
                            <input type="hidden" name="clientId" value="${client.id}"/>
                            <input type="text" name="numberOfFiles" size="3"/>
                            <input type="Submit" value="Go" />
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