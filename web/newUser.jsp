<%-- 
    Document   : newUser
    Created on : Sep 12, 2010, 10:08:16 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">
    <jsp:include page="/includes/header.jsp" />

    <h2>New User</h2>
    <p class="error">${errorMessage}</p>
    <p class="success">${successMessage}</p>
    <p class="info">${infoMessage}</p>

    <form action="newUser" method="post">
        <table>
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="firstName" value="${firstName}" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><input type="text" name="lastName" value="${lastName}" /></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" value="${username}" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password1" /></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td><input type="password" name="password2" /></td>
            </tr>
            <tr>
                <td>User Type:</td>
                <td>
                    <select name="userType">
                        <option value="admin">Admin</option>
                        <option value="nonadmin">Non Admin</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" value="${email}" /></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td>
                    <select name="status">
                        <option value="active">Active</option>
                        <option value="inactive">Inactive</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="Submit" value="Submit" /></td>
            </tr>
        </table>
    </form>
    <jsp:include page="/includes/footer.jsp" />
</c:if>

<c:if test="${empty user}">
    <c:redirect url="index.jsp" />
</c:if>