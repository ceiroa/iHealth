 <%--
    Document   : newVisitLowerExtremities
    Created on : Aug 13, 2010, 5:09:32 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">
    <jsp:include page="/includes/header.jsp" />

    <h2>Lower Extremities</h2>

    <jsp:include page="/includes/newVisitCommon1.jsp" />

    <br/>
    
    <form action="lowerExtremities" method="post" onsubmit="return validatedate()">

        <input type="hidden" name="visitId" value="${visitId}" />
        <input type="hidden" name="clientId" value="${clientId}" />
        <input type="hidden" name="postReqSource" value="entryForm" />

        <jsp:include page="/includes/newVisitCommon2.jsp" />

        <br/>
        <table>
            <tr>
                <td><h4>Range of Motion<br/>Lower Extremity</h4></td>
                <td>
                    <table>
                        <tr>
                            <th colspan="9">Knee</th>
                        </tr>
                        <tr>
                            <td>Flex:</td>
                            <td><input type="text" name="kneeFlex" size="3" value="${visit.kneeFlex}" /></td>
                            <td>/130</td>
                            <td>Ext:</td>
                            <td><input type="text" name="kneeExt" size="3" value="${visit.kneeExt}"/></td>
                            <td>/120</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <th colspan="12">Ankle/Foot</th>
                        </tr>
                        <tr>
                            <td>PF:</td>
                            <td><input type="text" name="pf" size="3" value="${visit.pf}" /></td>
                            <td>/50</td>
                            <td>DF:</td>
                            <td><input type="text" name="df" size="3" value="${visit.df}" /></td>
                            <td>/20</td>
                            <td>Inv:</td>
                            <td><input type="text" name="inv" size="3" value="${visit.inv}" /></td>
                            <td>/35</td>
                            <td>Ev:</td>
                            <td><input type="text" name="ev" size="3" value="${visit.ev}" /></td>
                            <td>/25</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <th colspan="12">Hip</th>
                        </tr>
                        <tr>
                            <td>Flex:</td>
                            <td><input type="text" name="hipFlex" size="3" value="${visit.hipFlex}" /></td>
                            <td>/125</td>
                            <td>Ext:</td>
                            <td><input type="text" name="hipExt" size="3" value="${visit.hipExt}" /></td>
                            <td>/115</td>
                            <td>Abd:</td>
                            <td><input type="text" name="hipAbd" size="3" value="${visit.hipAbd}" /></td>
                            <td>/45</td>
                            <td>Add:</td>
                            <td><input type="text" name="hipAdd" size="3" value="${visit.hipAdd}" /></td>
                            <td>/45</td>
                        </tr>
                        <tr>
                            
                            <td>LR:</td>
                            <td><input type="text" name="hipLr" size="3" value="${visit.hipLr}" /></td>
                            <td>/45</td>
                            <td>MR:</td>
                            <td><input type="text" name="hipMr" size="3" value="${visit.hipMr}" /></td>
                            <td>/45</td>
                            <td>Hyp:</td>
                            <td><input type="text" name="hipHyp" size="3" value="${visit.hipHyp}" /></td>
                            <td>/15</td>
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
                            <th colspan="6">Hip Test</th>
                        </tr>
                        <tr>
                            <td>Trendelenbarg Test</td>
                            <td>
                                <select name="trendelenbarg">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.trendelenbarg eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                             <c:if test="${visit.trendelenbarg eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Leg Length Discrepancy</td>
                            <td>
                                <select name="legLength">
                                    <option></option>
                                    <option value="plus"
                                             <c:if test="${visit.legLength eq 'plus'}"> selected="selected"</c:if>
                                             >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.legLength eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Thomas Test</td>
                            <td>
                                <select name="thomasTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.thomasTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.thomasTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Ober Test for IT Band Contraction</td>
                            <td>
                                <select name="oberTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.oberTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.oberTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th colspan="6">Knee Test</th>
                        </tr>
                        <tr>
                            <td>McMurray Test</td>
                            <td>
                                <select name="mcMurray">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.mcMurray eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.mcMurray eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Apley's CD Tests</td>
                            <td>
                                <select name="apleyTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.apleyTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.apleyTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Bounce Home Test</td>
                            <td>
                                <select name="bounceHome">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.bounceHome eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.bounceHome eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Patella Femoral Grinding Test</td>
                            <td>
                                <select name="patellaGrinding">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.patellaGrinding eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.patellaGrinding eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Apprehension Test for Patella</td>
                            <td>
                                <select name="apprehensionPatella">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.apprehensionPatella eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.apprehensionPatella eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Tinel Sign</td>
                            <td>
                                <select name="tinelSign">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.tinelSign eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.tinelSign eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Knee Joint Effusion Test</td>
                            <td>
                                <select name="effusionTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.effusionTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.effusionTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th colspan="6">Ankle Test</th>
                        </tr>
                        <tr>
                            <td>Test for Rigid and Supple Flat Feet</td>
                            <td>
                                <select name="rigidFlatFeet">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.rigidFlatFeet eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.rigidFlatFeet eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Tibial Torsion Test</td>
                            <td>
                                <select name="tibialTorsion">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.tibialTorsion eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.tibialTorsion eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Homans' Sign</td>
                            <td>
                                <select name="homansSign">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.homansSign eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.homansSign eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Forefoot Adduction Correction Test</td>
                            <td>
                                <select name="forefootTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.forefootTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.forefootTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Ankle Dorsiflexion Test</td>
                            <td>
                                <select name="ankleDorsiflexion">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.ankleDorsiflexion eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.ankleDorsiflexion eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
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