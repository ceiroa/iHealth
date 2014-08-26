<%--
    Document   : manageClients
    Created on : Aug 29, 2010, 1:14:25 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">
    <jsp:include page="/includes/header.jsp" />

    <h2>Documents Upload</h2>
    <p class="error">${errorMessage}</p>
    <p class="success">${successMessage}</p>
    <p class="info">${infoMessage}</p>

    <c:if test="${not empty firstName}">
        <h4>Upload files for ${firstName} ${lastName}</h4>

        <form action="upload" enctype="multipart/form-data" method="POST">
            <input type="hidden" name="firstName" value="${firstName}"/>
            <input type="hidden" name="lastName" value="${lastName}"/>
            <input type="hidden" name="clientId" value="${clientId}"/>
            <input type="hidden" name="numberOfFiles" value="${numberOfFiles}"/>
            <table>
                <tr>
                    <th>Choose Files:</th>
                </tr>
                <c:forEach items="${numberOfFilesArray}">
                    <tr>
                        <td><input type="file" name="file1"></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><input type="Submit" value="Upload Files"></td>
                </tr>
            </table>
        </form>
    </c:if>
    <jsp:include page="/includes/footer.jsp" />
</c:if>

<c:if test="${empty user}">
    <c:redirect url="index.jsp" />
</c:if>