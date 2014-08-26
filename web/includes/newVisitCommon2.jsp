<%-- 
    Document   : newVisitCommon
    Created on : Sep 17, 2010, 4:06:22 PM
    Author     : ceiroa
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <c:if test="${not empty date}">
        <fmt:parseDate value="${date}" type="both" pattern="yyyy-MM-dd HH:mm:ss" var="formatedDateTime"/>
        <fmt:formatDate value="${formatedDateTime}" pattern="yyyy-MM-dd" type="date" var="formattedDate" /> 

        <%-- <c:if test="${empty noMenu}">
            <p><span class="warning">Remember to update the date if necessary.</span></p>
        </c:if> --%>
        
        <p>
            <strong>Date:</strong>
            <input type="text" name="dateCreated" id="dateCreated" value="${formattedDate}" />
            (yyyy-mm-dd)
        </p>

    </c:if>


<table>
    <tr>
        <td>Is the current complaint different from
            the reason for the last visit?</td>
        <td>
            <select name="sameComplaint">
                <option value="yes"
                        <c:if test="${visit.sameComplaint eq 'yes'}"> selected="selected"</c:if>
                        >Yes</option>
                <option value="no"
                        <c:if test="${visit.sameComplaint eq 'no'}"> selected="selected"</c:if>
                        >No</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>Select the word that better describes the patient's
        pain since the last visit:</td>
        <td>
            <select name="painChange">
                <option value="same"
                        <c:if test="${visit.painChange eq 'same'}"> selected="selected"</c:if>
                        >Same</option>
                <option value="better"
                        <c:if test="${visit.painChange eq 'better'}"> selected="selected"</c:if>
                        >Better</option>
                <option value="worse"
                        <c:if test="${visit.painChange eq 'worse'}"> selected="selected"</c:if>
                        >Worse</option>
            </select>
        </td>
    </tr>
</table>
<br/>
<p>Select the areas of complaint and enter the
    number(s) that describe the pain:</p>

<table>
    <tr>
        <td>
            <table>
                <tr>
                    <td>Aching/Dull/Sore</td>
                    <td>
                        <select name="achingDullSore">
                            <option value="no"
                                    <c:if test="${visit.achingDullSore eq 'no'}"> selected="selected"</c:if>
                                    >No</option>
                            <option value="yes"
                                    <c:if test="${visit.achingDullSore eq 'yes'}"> selected="selected"</c:if>
                                    >Yes</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Burning</td>
                    <td>
                        <select name="burning">
                            <option value="no"
                                    <c:if test="${visit.burning eq 'no'}"> selected="selected"</c:if>
                                    >No</option>
                            <option value="yes"
                                    <c:if test="${visit.burning eq 'yes'}"> selected="selected"</c:if>
                                    >Yes</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Numbness or Tingling</td>
                    <td>
                        <select name="numbnessTingling">
                            <option value="no"
                                    <c:if test="${visit.numbnessTingling eq 'no'}"> selected="selected"</c:if>
                                    >No</option>
                            <option value="yes"
                                    <c:if test="${visit.numbnessTingling eq 'yes'}"> selected="selected"</c:if>
                                    >Yes</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Sharp/Shooting</td>
                    <td>
                        <select name="sharpShooting">
                            <option value="no"
                                    <c:if test="${visit.sharpShooting eq 'no'}"> selected="selected"</c:if>
                                    >No</option>
                            <option value="yes"
                                    <c:if test="${visit.sharpShooting eq 'yes'}"> selected="selected"</c:if>
                                    >Yes</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Sharp/Stabbing</td>
                    <td>
                        <select name="sharpStabbing">
                            <option value="no"
                                    <c:if test="${visit.sharpStabbing eq 'no'}"> selected="selected"</c:if>
                                    >No</option>
                            <option value="yes"
                                    <c:if test="${visit.sharpStabbing eq 'yes'}"> selected="selected"</c:if>
                                    >Yes</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Stiffness/Tightness</td>
                    <td>
                        <select name="stiffnessTightness">
                            <option value="no"
                                    <c:if test="${visit.stiffnessTightness eq 'no'}"> selected="selected"</c:if>
                                    >No</option>
                            <option value="yes"
                                    <c:if test="${visit.stiffnessTightness eq 'yes'}"> selected="selected"</c:if>
                                    >Yes</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Swelling</td>
                    <td>
                        <select name="swelling">
                            <option value="no"
                                    <c:if test="${visit.swelling eq 'no'}"> selected="selected"</c:if>
                                    >No</option>
                            <option value="yes"
                                    <c:if test="${visit.swelling eq 'yes'}"> selected="selected"</c:if>
                                    >Yes</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Throbbing</td>
                    <td>
                        <select name="throbbing">
                            <option value="no"
                                    <c:if test="${visit.throbbing eq 'no'}"> selected="selected"</c:if>
                                    >No</option>
                            <option value="yes"
                                    <c:if test="${visit.throbbing eq 'yes'}"> selected="selected"</c:if>
                                    >Yes</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Snapping/Popping/Grinding</td>
                    <td>
                        <select name="snapPopGrind">
                            <option value="no"
                                    <c:if test="${visit.snapPopGrind eq 'no'}"> selected="selected"</c:if>
                                    >No</option>
                            <option value="yes"
                                    <c:if test="${visit.snapPopGrind eq 'yes'}"> selected="selected"</c:if>
                                    >Yes</option>
                        </select>
                </tr>
                <tr>
                    <td>Level of Pain</td>
                    <td>
                        <select name="painLevel">
                            <option value="1"
                                    <c:if test="${visit.painLevel eq '1'}"> selected="selected"</c:if>
                                    >1</option>
                            <option value="2"
                                    <c:if test="${visit.painLevel eq '2'}"> selected="selected"</c:if>
                                    >2</option>
                            <option value="3"
                                    <c:if test="${visit.painLevel eq '3'}"> selected="selected"</c:if>
                                    >3</option>
                            <option value="4"
                                    <c:if test="${visit.painLevel eq '4'}"> selected="selected"</c:if>
                                    >4</option>
                            <option value="5"
                                    <c:if test="${visit.painLevel eq '5'}"> selected="selected"</c:if>
                                    >5</option>
                            <option value="6"
                                    <c:if test="${visit.painLevel eq '6'}"> selected="selected"</c:if>
                                    >6</option>
                            <option value="7"
                                    <c:if test="${visit.painLevel eq '7'}"> selected="selected"</c:if>
                                    >7</option>
                            <option value="8"
                                    <c:if test="${visit.painLevel eq '8'}"> selected="selected"</c:if>
                                    >8</option>
                            <option value="9"
                                    <c:if test="${visit.painLevel eq '9'}"> selected="selected"</c:if>
                                    >9</option>
                            <option value="10"
                                    <c:if test="${visit.painLevel eq '10'}"> selected="selected"</c:if>
                                    >10</option>
                        </select>
                </tr>
            </table>
        </td>
        <td>
            <img src="body.png" alt="body" />
        </td>
    </tr>
</table>
<br/>
<table>
    <tr>
        <td><h4>SUBJECTIVE complaint</h4></td>
        <td><textarea name="complaint" cols="100" rows="10" >${visit.complaint}</textarea></td>
    </tr>
    <tr>
        <td><h4>Frequency</h4></td>
        <td><textarea name="frequency" cols="100" rows="6" >${visit.frequency}</textarea></td>
    </tr>
</table>
<h3>Objective Findings</h3>