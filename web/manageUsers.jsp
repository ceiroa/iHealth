<%-- 
    Document   : manageUsers
    Created on : Aug 29, 2010, 1:13:55 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">
    <jsp:include page="/includes/header.jsp" />

    <h2>Manage Users</h2>
    <p class="error">${errorMessage}</p>
    <p class="success">${successMessage}</p>
    <p class="info">${infoMessage}</p>
    
    <div class="link"><p><a href="newUser">Create New User</a></p></div>
    <table>
        <tr>
            <th>Username</th>
            <th>User Type</th>
            <th>Email</th>
            <th>Status</th>
        </tr>
        <c:forEach var="managedUser" items="${users}">
            <tr>
                <td>${managedUser.username}</td>
                <td>${managedUser.userType}</td>
                <td>${managedUser.email}</td>
                <td>${managedUser.status}</td>
                <td>
                    <form action="manageUsers" method="post">
                        <input type="hidden" name="id" value="${managedUser.id}" />
                        <c:if test="${managedUser.status eq 'active'}">
                             <input type="hidden" name="action" value="deactivate" />
                             <input type="Submit" value="Deactivate" />
                        </c:if>
                        <c:if test="${managedUser.status eq 'inactive'}">
                             <input type="hidden" name="action" value="activate" />
                             <input type="Submit" value="Activate" />
                        </c:if>
                    </form>
                </td>
                <!--<td>
                    <form action="manageUsers" method="post">
                        <input type="hidden" name="id" value="${managedUser.id}" />
                        <input type="hidden" name="action" value="archive" />
                        <input type="Submit" value="Archive" />
                    </form>
                </td>-->
            </tr>
        </c:forEach>
    </table>

    <jsp:include page="/includes/footer.jsp" />
</c:if>

<c:if test="${empty user}">
    <c:redirect url="index.jsp" />
</c:if>