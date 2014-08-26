    <%--
    Document   : newVisitUpperExtremities
    Created on : Aug 13, 2010, 5:09:48 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">
    <jsp:include page="/includes/header.jsp" />

    <h2>Upper Extremities</h2>

    <jsp:include page="/includes/newVisitCommon1.jsp" />

    <br/>
    
    <form action="upperExtremities" method="post" onsubmit="return validatedate()">

        <input type="hidden" name="visitId" value="${visitId}" />
        <input type="hidden" name="clientId" value="${clientId}" />
        <input type="hidden" name="postReqSource" value="entryForm" />

        <jsp:include page="/includes/newVisitCommon2.jsp" />

        <br/>
        <h4>Range of Motion Upper Extremity</h4>
        <table>
            <tr>
                <td>
                    <table>
                        <tr>
                            <th colspan="9">Shoulder</th>
                        </tr>
                        <tr>
                            <td>Flex:</td>
                            <td><input type="text" name="shoulderFlex" size="1" value="${visit.shoulderFlex}" /></td>
                            <td>/90</td>
                            <td>LR:</td>
                            <td><input type="text" name="shoulderLr" size="1" value="${visit.shoulderLr}" /></td>
                            <td>/90</td>
                            <td>Abd:</td>
                            <td><input type="text" name="shoulderAbd" size="1" value="${visit.shoulderAbd}" /></td>
                            <td>/90</td>
                        </tr>
                        <tr>
                            <td>Ext:</td>
                            <td><input type="text" name="shoulderExt" size="1" value="${visit.shoulderExt}" /></td>
                            <td>/50</td>
                            <td>MR:</td>
                            <td><input type="text" name="shoulderMr" size="1" value="${visit.shoulderMr}" /></td>
                            <td>/90</td>
                            <td>Add:</td>
                            <td><input type="text" name="shoulderAdd" size="1" value="${visit.shoulderAdd}" /></td>
                            <td>/90</td>
                        </tr>
                    </table>
                </td>
                <td>
                    <table class="leftBorderTable">
                        <tr>
                            <th colspan="6">Elbow</th>
                        </tr>
                        <tr>
                            <td>Flex:</td>
                            <td><input type="text" name="elbowFlex" size="1" value="${visit.elbowFlex}" /></td>
                            <td>/160</td>
                            <td>Pro:</td>
                            <td><input type="text" name="elbowPro" size="1" value="${visit.elbowPro}" /></td>
                            <td>/90</td>
                        </tr>
                        <tr>
                            <td>Ext:</td>
                            <td><input type="text" name="elbowExt" size="1" value="${visit.elbowExt}" /></td>
                            <td>/145</td>
                            <td>Sup:</td>
                            <td><input type="text" name="elbowSup" size="1" value="${visit.elbowSup}" /></td>
                            <td>/90</td>
                        </tr>
                    </table>
                </td>
                <td>
                    <table class="leftBorderTable">
                        <tr>
                            <th colspan="6">Wrist</th>
                        </tr>
                        <tr>
                            <td>Flex:</td>
                            <td><input type="text" name="wristFlex" size="1" value="${visit.wristFlex}" /></td>
                            <td>/90</td>
                            <td>Abd:</td>
                            <td><input type="text" name="wristAbd" size="1" value="${visit.wristAbd}" /></td>
                            <td>/25</td>
                        </tr>
                        <tr>
                            <td>Ext:</td>
                            <td><input type="text" name="wristExt" size="1" value="${visit.wristExt}" /></td>
                            <td>/70</td>
                            <td>Add:</td>
                            <td><input type="text" name="wristAdd" size="1" value="${visit.wristAdd}" /></td>
                            <td>/65</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="4"><hr /></td>
            </tr>
        </table>
        <table>
            <tr>
                <td><h4>Ortho/Neuro</h4></td>
                <td>
                    <table>
                        <tr>
                            <th colspan="6">Shoulder</th>
                        </tr>
                        <tr>
                            <td>Drop Arm Test</td>
                            <td>
                                <select name="dropArmTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.dropArmTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.dropArmTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Drawbarn's Sign</td>
                            <td>
                                <select name="drawbarnTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.drawbarnTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.drawbarnTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Supraspinatus Test</td>
                            <td>
                                <select name="supraspinatusTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.supraspinatusTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.supraspinatusTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Apley's Scratch Test</td>
                            <td>
                                <select name="apleyScratchTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.apleyScratchTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.apleyScratchTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Post Impingement Sign</td>
                            <td>
                                <select name="postImpingSign">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.postImpingSign eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.postImpingSign eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Speed's Test</td>
                            <td>
                                <select name="speedTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.speedTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.speedTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Cross-Over Impingement Test</td>
                            <td>
                                <select name="crossOverImpTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.crossOverImpTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.crossOverImpTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Yergason Test</td>
                            <td>
                                <select name="yergasonTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.yergasonTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.yergasonTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Apprehension Test</td>
                            <td>
                                <select name="apprehensionTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.apprehensionTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.apprehensionTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Drawer Test</td>
                            <td>
                                <select name="drawerTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.drawerTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.drawerTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th colspan="6">Elbow</th>
                        </tr>
                        <tr>
                            <td>Varus Stress Test</td>
                            <td>
                                <select name="varusStressTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.varusStressTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.varusStressTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Cozens Test</td>
                            <td>
                                <select name="cozensTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.cozensTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.cozensTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Valgus Stress Test</td>
                            <td>
                                <select name="valgusStressTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.valgusStressTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.valgusStressTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Golfer's Elbow Test</td>
                            <td>
                                <select name="golferElbow">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.golferElbow eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.golferElbow eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Tinel's Sign</td>
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
                            <td>Pinch Grip Test</td>
                            <td>
                                <select name="pinchGripTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.pinchGripTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.pinchGripTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th colspan="6">Wrist</th>
                        </tr>
                        <tr>
                            <td>Froment's Sign</td>
                            <td>
                                <select name="fromentTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.fromentTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.fromentTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Phalen Test</td>
                            <td>
                                <select name="phalenTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.phalenTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.phalenTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Finger Tap Test</td>
                            <td>
                                <select name="fingerTapTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.fingerTapTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.fingerTapTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Tinel's Sign Finkelstenin's Test</td>
                            <td>
                                <select name="finkelsteninTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.finkelsteninTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.finkelsteninTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Bunnel Littler Test</td>
                            <td>
                                <select name="bunnelLitter">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.bunnelLitter eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.bunnelLitter eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td></td>
                            <td></td>
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