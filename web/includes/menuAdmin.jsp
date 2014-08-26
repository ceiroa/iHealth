<%-- 
    Document   : adminMenu
    Created on : Aug 13, 2010, 6:26:39 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul id="tabmenu">
    <li><a <c:if test="${active eq 'manageClients'}">class="active"</c:if> href="manageClients">Manage Clients</a></li>
    <li><a <c:if test="${active eq 'newClient'}">class="active"</c:if> href="newClient">New Client</a></li>
    <li><a <c:if test="${active eq 'manageUploads'}">class="active"</c:if> href="manageUploads">Upload Documents</a></li>
    <li><a <c:if test="${active eq 'visits'}">class="active"</c:if> href="visits">Manage Visits</a></li>
    <li><a <c:if test="${active eq 'newVisit'}">class="active"</c:if> href="newVisit">New Visit</a></li>
    <li><a <c:if test="${active eq 'manageUsers'}">class="active"</c:if> href="manageUsers">Manage Users</a></li>
    <li><a <c:if test="${active eq 'changeMyPssw'}">class="active"</c:if> href="changeMyPssw">Change My Password</a></li>
</ul>
