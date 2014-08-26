<%-- 
    Document   : newClient.jsp
    Created on : Aug 13, 2010, 5:02:18 PM
    Author     : ceiroa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">
    <jsp:include page="/includes/header.jsp" />

    <h2>Client Information</h2>
    <p class="error">${errorMessage}</p>
    <p class="success">${successMessage}</p>
    <p class="info">${infoMessage}</p>

    <!-- Show the warning only if the user is going to create a new client, not
    edit an existing one. -->
    <c:if test="${empty client.id and user.userType eq 'admin'}">
        <p><span class="warning">Check first if the <a href="manageClients">client already exists</a> before adding him/her to the system.</span></p>
</c:if>
    <h3>Patient Information</h3>
    <br/>
    <form action="newClient" method="post">
        <input type="hidden" name="id" value="${client.id}"/>
        <input type="hidden" name="postReqSource"
               value="<c:if test="${postReqSource eq 'manage'}">manage</c:if><c:if test="${empty postReqSource}">viewEdit</c:if><c:if test="${postReqSource eq 'viewEdit'}">viewEdit</c:if>"/>
        <input type="hidden" name="update" value="true"/>
        <table>
            <tr>
                <td>Last Name:</td>
                <td><input type="text" name="lastName" id="lastName" value="${client.lastName}"/></td>
                <td>MI:</td>
                <td><input type="text" name="middleInitial" id="middleInitial" value="${client.middleInitial}"/></td>
                <td>First Name:</td>
                <td><input type="text" name="firstName" id="firstName" value="${client.firstName}" /></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td><input type="text" name="gender" id="gender"value="${client.gender}" /></td>
                <td>Address:</td>
                <td><input type="text" name="address" id="address" value="${client.address}" /></td>
                <td>City:</td>
                <td><input type="text" name="city" id="city" value="${client.city}" /></td>
            </tr>
            <tr>            
                <td>State:</td>
                <td><input type="text" name="usState" id="state" value="${client.state}" /></td>
                <td>Zip:</td>
                <td><input type="text" name="zipcode" id="zipcode" value="${client.zipcode}" /></td>
                <td>Email:</td>
                <td><input type="text" name="email" id="email" value="${client.email}" /></td>
            </tr>

            <tr>
                <td>Referred by:</td>
                <td colspan="3"><input type="text" name="referrer" id="referrer" size="53" value="${client.referrer}" /></td>
            </tr>

            <tr>
                <td>Home #:</td>
                <td><input type="text" name="homePhone" id="homePhone" value="${client.homePhone}" /></td>
                <td>Cell #:</td>
                <td><input type="text" name="cellPhone" id="cellPhone" value="${client.cellPhone}" /></td>
                 <td>Work #:</td>
                <td><input type="text" name="workPhone" id="workPhone" value="${client.workPhone}" /></td>
            </tr>

            <tr>
                <td>Date of Birth:</td>
                <td><input type="text" name="dob" id="dob" value="${client.dob}" /></td>
                <td>SSN #:</td>
                <td><input type="text" name="ssn" id="ssn" value="${client.ssn}" /></td>
                 <td>Driver's License #:</td>
                <td><input type="text" name="driverLicense" id="driverLicense" value="${client.driverLicense}" /></td>
            </tr>
        </table>

        <h3>Employment Information</h3>
        <br/>
        <table>
            <tr>
                <td>Employer:</td>
                <td><input type="text" name="employer" id="employer" value="${client.employer}" /></td>
                <td>Occupation:</td>
                <td><input type="text" name="occupation" id="occupation"value="${client.occupation}" /></td>
            </tr>
            <tr>
                <td>Employer Address:</td>
                <td><input type="text" name="employerAddress" id="employerAddress" value="${client.employerAddress}" /></td>
                <td>Employer Phone #:</td>
                <td><input type="text" name="employerPhoneNum" id="employerPhoneNum" value="${client.employerPhoneNum}" /></td>
            </tr>
        </table>
        <h3>Emergency Contact</h3>
        <table>
            <tr>
                <td>Contact Name:</td>
                <td><input type="text" name="contactName" id="contactName" value="${client.contactName}" /></td>
                <td>Relationship:</td>
                <td><input type="text" name="contactRelation" id="contactRelation" value="${client.contactRelation}" /></td>
                <td>Contact #:</td>
                <td><input type="text" name="contactPhone" id="contactPhone" value="${client.contactPhone}" /></td>
            </tr>
        </table>
        <h3>Insurance Information</h3>
        <table>
            <tr>
                <td>Primary Insurance:</td>
                <td><input type="text" name="insurance" id="insurance" value="${client.insurance}" /></td>
                <td>Insurance Address:</td>
                <td><input type="text" name="insuranceAddress" id="insuranceAddress" value="${client.insuranceAddress}" /></td>
            </tr>
            <tr>
                <td>Policy Holder's Name:</td>
                <td><input type="text" name="policyHolderName" id="policyHolderName" value="${client.policyHolderName}" /></td>
                <td>Policy Holder's Address:</td>
                <td><input type="text" name="policyHolderAddress" id="policyHolderAddress" value="${client.policyHolderAddress}" /></td>
            </tr>
            <tr>
                <td>Policy Holder's Date of Birth:</td>
                <td><input type="text" name="policyHolderDob" id="policyHolderDob" value="${client.policyHolderDob}" /></td>
                <td>SSN #:</td>
                <td><input type="text" name="policyHolderSsn" id="policyHolderSsn" value="${client.policyHolderSsn}" /></td>
            </tr>
            <tr>
                <td>Policy #:</td>
                <td><input type="text" name="policyNumber" id="policyNumber" value="${client.policyNumber}" /></td>
                <td>Group #:</td>
                <td><input type="text" name="groupNumber" id="groupNumber" value="${client.groupNumber}" /></td>
            </tr>
            <tr>
                <td>Relationship to Insured:</td>
                <td colspan="3"><input type="text" name="policyHolderRelation" id="policyHolderRelation" size="62" value="${client.policyHolderRelation}" /></td>
            </tr>
        </table>
        <!-- Secondary Insurance -->
        <table>
            <tr>
                <td colspan="4"><hr /></td>
            </tr>
            <tr>
                <td>Secondary Insurance:</td>
                <td><input type="text" name="insurance2" id="insurance2" value="${client.insurance2}" /></td>
                <td>Insurance Address:</td>
                <td><input type="text" name="insuranceAddress2" id="insuranceAddress2" value="${client.insuranceAddress2}" /></td>
            </tr>
            <tr>
                <td>Policy Holder's Name:</td>
                <td><input type="text" name="policyHolderName2" id="policyHolderName2" value="${client.policyHolderName2}" /></td>
                <td>Policy Holder's Address:</td>
                <td><input type="text" name="policyHolderAddress2" id="policyHolderAddress2" value="${client.policyHolderAddress2}" /></td>
            </tr>
            <tr>
                <td>Policy Holder's Date of Birth:</td>
                <td><input type="text" name="policyHolderDob2" id="policyHolderDob2" value="${client.policyHolderDob2}" /></td>
                <td>SSN #:</td>
                <td><input type="text" name="policyHolderSsn2" id="policyHolderSsn2" value="${client.policyHolderSsn2}" /></td>
            </tr>
            <tr>
                <td>Policy #:</td>
                <td><input type="text" name="policyNumber2" id="policyNumber2" value="${client.policyNumber2}" /></td>
                <td>Group #:</td>
                <td><input type="text" name="groupNumber2" id="groupNumber2" value="${client.groupNumber2}" /></td>
            </tr>
            <tr>
                <td>Relationship to Insured:</td>
                <td colspan="3"><input type="text" name="policyHolderRelation2" id="policyHolderRelation2" size="62" value="${client.policyHolderRelation2}" /></td>
            </tr>
        </table>

        <h3>Accident Information</h3>
        <table>
            <tr>
                <td>Auto Accident Information:</td>
                <td><input type="text" name="accidentInfo" id="accidentInfo" size="60" value="${client.accidentInfo}" /></td>
            </tr>
            <tr>
                <td>Worker's Compensation Information:</td>
                <td><input type="text" name="compInfo" id="compInfo" size="60" value="${client.compInfo}" /></td>
            </tr>
        </table>
        <br/>
        <input type="submit" value="Save"/>
    </form>
    <jsp:include page="/includes/footer.jsp" />
</c:if>

<c:if test="${empty user}">
    <c:redirect url="index.jsp" />
</c:if>