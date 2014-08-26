<%-- 
    Document   : newVisitCommon2
    Created on : Sep 25, 2010, 7:16:40 PM
    Author     : ceiroa
--%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <tr>
        <td><h4>Inspection</h4></td>
        <td><textarea cols="100" rows="15" name="inspection">${visit.inspection}</textarea>
    </tr>
    <tr>
        <td><h4>Palpation</h4></td>
        <td><textarea cols="100" rows="15" name="palpation">${visit.palpation}</textarea>
    </tr>
    <tr>
        <td><h4>DX/Assessment/Action</h4></td>
        <td><textarea cols="100" rows="20" name="dxAction">${visit.dxAction}</textarea>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>
            <c:if test="${empty noMenu}">
                <input type="Submit" value="Submit" />
            </c:if>
        </td>
    </tr>
