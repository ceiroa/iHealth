<%-- 
    Document   : newVisitCervicalSpine
    Created on : Aug 13, 2010, 5:07:59 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">
    <jsp:include page="/includes/header.jsp" />

    <h2>Cervical Spine</h2>
    
    <jsp:include page="/includes/newVisitCommon1.jsp" />

    <br/>

    <form action="cervicalSpine" method="post" onsubmit="return validatedate()">

        <input type="hidden" name="visitId" value="${visitId}" />
        <input type="hidden" name="clientId" value="${clientId}" />
        <input type="hidden" name="postReqSource" value="entryForm" />
  
        <jsp:include page="/includes/newVisitCommon2.jsp" />

        <br/>
        <table>
            <tr>
                <td><h4>Range of Motion<br/>Cervical Spine</h4></td>
                <td>
                    <table>
                        <tr>
                            <td>Flex:</td>
                            <td><input type="text" name="flex" size="2" value="${visit.flex}" /></td>
                            <td>/45</td>
                            <td>LLF:</td>
                            <td><input type="text" name="llf" size="2" value="${visit.llf}" /></td>
                            <td>/45</td>
                            <td>LR:</td>
                            <td><input type="text" name="llr" size="2" value="${visit.llr}" /></td>
                            <td>/80</td>
                        </tr>
                        <tr>
                            <td>Ext:</td>
                            <td><input type="text" name="ext" size="2" value="${visit.ext}" /></td>
                            <td>/45</td>
                            <td>RLF:</td>
                            <td><input type="text" name="rlf" size="2" value="${visit.rlf}" /></td>
                            <td>/45</td>
                            <td>RR:</td>
                            <td><input type="text" name="rlr" size="2" value="${visit.rlr}" /></td>
                            <td>/80</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="4"><hr /></td>
            </tr>
            <tr>
                <td><h4>Ortho/Neuro</h4></td>
                <td>
                    <table>
                        <tr>
                            <th colspan="6">C/S Test</th>
                        </tr>
                        <tr>
                            <td>Jackson Compression</td>
                            <td>
                                <select name="jacksonComp">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.jacksonComp eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                             <c:if test="${visit.jacksonComp eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Max Compression</td>
                            <td>
                                <select name="maxComp">
                                    <option></option>
                                    <option value="plus"
                                             <c:if test="${visit.maxComp eq 'plus'}"> selected="selected"</c:if>
                                             >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.maxComp eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Shoulder Depression</td>
                            <td>
                                <select name="shoulderDep">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.shoulderDep eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.shoulderDep eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Soto-Hall</td>
                            <td>
                                <select name="sotoHall">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.sotoHall eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.sotoHall eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Spurling's</td>
                            <td>
                                <select name="spurlings">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.spurlings eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.spurlings eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>C/S Distraction</td>
                            <td>
                                <select name="csDistraction">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.csDistraction eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.csDistraction eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Valsava's</td>
                            <td>
                                <select name="valsavas">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.valsavas eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.valsavas eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Baccody Sign</td>
                            <td>
                                <select name="baccody">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.baccody eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.baccody eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th colspan="6">Sensation Test</th>
                        </tr>
                        <tr>
                            <td>Lat Arm/C5</td>
                            <td>
                                <select name="latArm">
                                    <option></option>
                                    <option value="hyper"
                                            <c:if test="${visit.latArm eq 'hyper'}"> selected="selected"</c:if>
                                            >Hyper</option>
                                    <option value="normal"
                                            <c:if test="${visit.latArm eq 'normal'}"> selected="selected"</c:if>
                                            >Normal</option>
                                    <option value="hypo"
                                            <c:if test="${visit.latArm eq 'hypo'}"> selected="selected"</c:if>
                                            >Hypo</option>
                                </select>
                            </td>
                            <td>Lat Forearm/C6</td>
                            <td>
                                <select name="latForearm">
                                    <option></option>
                                    <option value="hyper"
                                            <c:if test="${visit.latForearm eq 'hyper'}"> selected="selected"</c:if>
                                            >Hyper</option>
                                    <option value="normal"
                                            <c:if test="${visit.latForearm eq 'normal'}"> selected="selected"</c:if>
                                            >Normal</option>
                                    <option value="hypo"
                                            <c:if test="${visit.latForearm eq 'hypo'}"> selected="selected"</c:if>
                                            >Hypo</option>
                                </select>
                            </td>
                            <td>Middle Finger/C7</td>
                            <td>
                                <select name="middleFinger">
                                    <option></option>
                                    <option value="hyper"
                                            <c:if test="${visit.middleFinger eq 'hyper'}"> selected="selected"</c:if>
                                            >Hyper</option>
                                    <option value="normal"
                                            <c:if test="${visit.middleFinger eq 'normal'}"> selected="selected"</c:if>
                                            >Normal</option>
                                    <option value="hypo"
                                            <c:if test="${visit.middleFinger eq 'hypo'}"> selected="selected"</c:if>
                                            >Hypo</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Med Forearm/C8</td>
                            <td>
                                <select name="medForearm">
                                    <option></option>
                                    <option value="hyper"
                                            <c:if test="${visit.medForearm eq 'hyper'}"> selected="selected"</c:if>
                                            >Hyper</option>
                                    <option value="normal"
                                            <c:if test="${visit.medForearm eq 'normal'}"> selected="selected"</c:if>
                                            >Normal</option>
                                    <option value="hypo"
                                            <c:if test="${visit.medForearm eq 'hypo'}"> selected="selected"</c:if>
                                            >Hypo</option>
                                </select>
                            </td>
                            <td>Med Arm/TI</td>
                            <td>
                                <select name="medArm">
                                    <option></option>
                                    <option value="hyper"
                                            <c:if test="${visit.medArm eq 'hyper'}"> selected="selected"</c:if>
                                            >Hyper</option>
                                    <option value="normal"
                                            <c:if test="${visit.medArm eq 'normal'}"> selected="selected"</c:if>
                                            >Normal</option>
                                    <option value="hypo"
                                            <c:if test="${visit.medArm eq 'hypo'}"> selected="selected"</c:if>
                                            >Hypo</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th colspan="6">DTR</th>
                        </tr>
                        <tr>
                            <td>Biceps/C5</td>
                            <td><input type="text" name="biceps" size="3" value="${visit.biceps}" /></td>
                            <td>Brachioradialis/C6</td>
                            <td><input type="text" name="brachiorad" size="3" value="${visit.brachiorad}" /></td>
                            <td>Triceps/C7</td>
                            <td><input type="text" name="triceps" size="3" value="${visit.triceps}" /></td>
                        </tr>
                        <tr>
                            <th colspan="6">Muscle Test</th>
                        </tr>
                        <tr>
                            <td>Shoulder Abd/C5</td>
                            <td><input type="text" name="shoulderAbd" size="3" value="${visit.shoulderAbd}" /></td>
                            <td>Wrist Ext/C6</td>
                            <td><input type="text" name="wristExt" size="3" value="${visit.wristExt}" /></td>
                            <td>Wrist Flex/C7</td>
                            <td><input type="text" name="wristFlex" size="3" value="${visit.wristFlex}" /></td>
                        </tr>
                        <tr>
                            <td>Finger Ext/C7</td>
                            <td><input type="text" name="fingerExt" size="3" value="${visit.fingerExt}" /></td>
                            <td>Finger Flx/C8</td>
                            <td><input type="text" name="fingerFlex" size="3" value="${visit.fingerFlex}" /></td>
                            <td>Finger Abd/TI</td>
                            <td><input type="text" name="fingerAbd" size="3" value="${visit.fingerAbd}" /></td>
                        </tr>
                    </table>
                </td>
            </tr>
            <jsp:include page="/includes/newVisitCommon3.jsp" />
        </table>
    </form>
    <jsp:include page="/includes/footer.jsp" />
</c:if>

<c:if test="${empty user}">
    <c:redirect url="index.jsp" />
</c:if>