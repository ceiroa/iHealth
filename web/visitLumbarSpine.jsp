<%-- 
    Document   : newVisitLumbarSpine
    Created on : Aug 13, 2010, 5:08:21 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">
    <jsp:include page="/includes/header.jsp" />

    <h2>Lumbar Spine Form</h2>

    <jsp:include page="/includes/newVisitCommon1.jsp" />

    <br/>
    
    <form action="lumbarSpine" method="post" onsubmit="return validatedate()">

        <input type="hidden" name="visitId" value="${visitId}" />
        <input type="hidden" name="clientId" value="${clientId}" />
        <input type="hidden" name="postReqSource" value="entryForm" />

        <jsp:include page="/includes/newVisitCommon2.jsp" />

        <br/>
        <table>
            <tr>
                <td>Range of Motion<br/>Thoracolumbar Spine</td>
                <td>
                    <table>
                        <tr>
                            <td>Flex:</td>
                            <td><input type="text" name="flex" size="3" value="${visit.flex}" /></td>
                            <td>/90</td>
                            <td>LLF:</td>
                            <td><input type="text" name="llf" size="3" value="${visit.llf}" /></td>
                            <td>/30</td>
                            <td>LR:</td>
                            <td><input type="text" name="llr" size="3" value="${visit.llr}" /></td>
                            <td>/30</td>
                        </tr>
                        <tr>
                            <td>Ext:</td>
                            <td><input type="text" name="ext" size="3" value="${visit.ext}" /></td>
                            <td>/30</td>
                            <td>RLF:</td>
                            <td><input type="text" name="rlf" size="3" value="${visit.rlf}" /></td>
                            <td>/30</td>                   
                            <td>RR:</td>
                            <td><input type="text" name="rlr" size="3" value="${visit.rlr}" /></td>
                            <td>/30</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="4"><hr /></td>
            </tr>
            <tr>
                <td>Ortho/Neuro</td>
                <td>
                    <table>
                        <tr>
                            <th colspan="6">L/S Test</th>
                        </tr>
                        <tr>
                            <td>Valsalva's</td>
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
                            <td>Straight Leg</td>
                            <td>
                                <select name="straightLeg">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.straightLeg eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.straightLeg eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Browstring Test</td>
                            <td>
                                <select name="browstringTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.browstringTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.browstringTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Lasegue Test</td>
                            <td>
                                <select name="lasegueTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.lasegueTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.lasegueTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Ely's Test</td>
                            <td>
                                <select name="elyTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.elyTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.elyTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
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
                        </tr>
                        <tr>
                            <td>Spring Test</td>
                            <td>
                                <select name="springTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.springTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.springTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Trenderlenburg's Test</td>
                            <td>
                                <select name="trenderlenburgTest">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.trenderlenburgTest eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.trenderlenburgTest eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Bilateral Straight Leg Raise</td>
                            <td>
                                <select name="bilateralLegRaise">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.bilateralLegRaise eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.bilateralLegRaise eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Pelvic Rock</td>
                            <td>
                                <select name="pelvicRock">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.pelvicRock eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.pelvicRock eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Patrick/Fabere</td>
                            <td>
                                <select name="patrickFabere">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.patrickFabere eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.patrickFabere eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                            <td>Milgram</td>
                            <td>
                                <select name="milgram">
                                    <option></option>
                                    <option value="plus"
                                            <c:if test="${visit.milgram eq 'plus'}"> selected="selected"</c:if>
                                            >+</option>
                                    <option value="minus"
                                            <c:if test="${visit.milgram eq 'minus'}"> selected="selected"</c:if>
                                            >-</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th  colspan="6">Sensation Test</th>
                        </tr>
                        <tr>
                            <td>Med. Leg/foot/L3-L4</td>
                            <td>
                                <select name="medLegFoot">
                                    <option></option>
                                    <option value="hyper"
                                            <c:if test="${visit.medLegFoot eq 'hyper'}"> selected="selected"</c:if>
                                            >Hyper</option>
                                    <option value="normal"
                                            <c:if test="${visit.medLegFoot eq 'normal'}"> selected="selected"</c:if>
                                            >Normal</option>
                                    <option value="hypo"
                                            <c:if test="${visit.medLegFoot eq 'hypo'}"> selected="selected"</c:if>
                                            >Hypo</option>
                                </select>
                            </td>
                            <td>Lat. Leg/L5</td>
                            <td>
                                <select name="latLeg">
                                    <option></option>
                                    <option value="hyper"
                                            <c:if test="${visit.latLeg eq 'hyper'}"> selected="selected"</c:if>
                                            >Hyper</option>
                                    <option value="normal"
                                            <c:if test="${visit.latLeg eq 'normal'}"> selected="selected"</c:if>
                                            >Normal</option>
                                    <option value="hypo"
                                            <c:if test="${visit.latLeg eq 'hypo'}"> selected="selected"</c:if>
                                            >Hypo</option>
                                </select>
                            </td>
                            <td>Lat. Foot/L5</td>
                            <td>
                                <select name="latFoot">
                                    <option></option>
                                    <option value="hyper"
                                            <c:if test="${visit.latFoot eq 'hyper'}"> selected="selected"</c:if>
                                            >Hyper</option>
                                    <option value="normal"
                                            <c:if test="${visit.latFoot eq 'normal'}"> selected="selected"</c:if>
                                            >Normal</option>
                                    <option value="hypo"
                                            <c:if test="${visit.latFoot eq 'hypo'}"> selected="selected"</c:if>
                                            >Hypo</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th  colspan="6">DTR</th>
                        </tr>
                        <tr>
                            <td>Patellar/L4</td>
                            <td><input type="text" name="patellar" size="3" value="${visit.patellar}" /></td>
                            <td>Hamstring/L5</td>
                            <td><input type="text" name="hamstring" size="3" value="${visit.hamstring}" /></td>
                            <td>Achilles/SI</td>
                            <td><input type="text" name="achilles" size="3" value="${visit.achilles}" /></td>
                        </tr>
                        <tr>
                            <th  colspan="6">Muscle Test</th>
                        </tr>
                        <tr>
                            <td>Ant. Tibialis/L4</td>
                            <td><input type="text" name="antTibialis" size="3" value="${visit.antTibialis}" /></td>
                            <td>Ext. Hallucis/L5</td>
                            <td><input type="text" name="extHallucis" size="3" value="${visit.extHallucis}" /></td>
                            <td>Peroneus/SI</td>
                            <td><input type="text" name="peroneus" size="3" value="${visit.peroneus}" /></td>
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