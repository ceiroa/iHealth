 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.controller;

import com.ceiroa.db.ClientDB;
import com.ceiroa.model.Client;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ceiroa
 */
public class NewClientServlet extends HttpServlet {

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setAttribute("active", "newClient");

        String url = "/newClient.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setAttribute("active", "newClient");

        String id = request.getParameter("id");
        String postReqSource = request.getParameter("postReqSource");
        request.setAttribute("postReqSource", postReqSource);
        String update = request.getParameter("update");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        String url = "";

        //TODO: clean newClient view/new/edit logic. Two variables
        //should be enough to uniquely identify three different states.
        
        //View-We display the client information
        if(!id.isEmpty() && postReqSource.equals("manage") && update.equals("false")) {

            Client client = ClientDB.selectClientByID(id);
            request.setAttribute("client", client);

            url = "/newClient.jsp";

        //New-A new client is created
        } else if(id.isEmpty() && postReqSource.equals("viewEdit") &&
                !firstName.isEmpty() && !lastName.isEmpty()) {

            Client client = new Client();
            setClientFields(client, request);

            int message = ClientDB.insert(client);
            if(message != 0) {
                request.setAttribute("successMessage", "Client successfully created");
                url = "/manageClients.jsp";
            } else {
                request.setAttribute("errorMessage", "Error. Client could not "
                        + "be created. Please try again or contact support.");
                url = "/newClient.jsp";
            }

        //Update-We update and already existing client
        } else if(!id.isEmpty() && postReqSource.equals("manage") && update.equals("true")) {

            Client client = new Client();
            client.setId(Long.parseLong(request.getParameter("id")));
            setClientFields(client, request);

            int message = ClientDB.update(client);

            if(message!=0) {
                request.setAttribute("successMessage", "Client successfully updated");
            } else {
                request.setAttribute("errorMessage", "Error. Client could not "
                        + "be updated. Please try again or contact support.");
            }

            request.setAttribute("active", "manageClients");
            url = "/manageClients.jsp";
        } else {
            request.setAttribute("errorMessage", "Please fill at least the"
                    + " first and last name fields.");
            url = "/newClient.jsp";
        }

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private void setClientFields(Client client, HttpServletRequest request) {
        client.setFirstName(request.getParameter("firstName"));
        client.setMiddleInitial(request.getParameter("middleInitial"));
        client.setLastName(request.getParameter("lastName"));
        client.setGender(request.getParameter("gender"));
        client.setAddress(request.getParameter("address"));
        client.setCity(request.getParameter("city"));
        client.setState(request.getParameter("usState"));
        client.setZipcode(request.getParameter("zipcode"));
        client.setEmail(request.getParameter("email"));
        client.setReferrer(request.getParameter("referrer"));
        client.setHomePhone(request.getParameter("homePhone"));
        client.setCellPhone(request.getParameter("cellPhone"));
        client.setWorkPhone(request.getParameter("workPhone"));
        client.setDob(request.getParameter("dob"));
        client.setSsn(request.getParameter("ssn"));
        client.setDriverLicense(request.getParameter("driverLicense"));
        client.setEmployer(request.getParameter("employer"));
        client.setOccupation(request.getParameter("occupation"));
        client.setEmployerAddress(request.getParameter("employerAddress"));
        client.setEmployerPhoneNum(request.getParameter("employerPhoneNum"));
        client.setContactName(request.getParameter("contactName"));
        client.setContactRelation(request.getParameter("contactRelation"));
        client.setContactPhone(request.getParameter("contactPhone"));
        client.setInsurance(request.getParameter("insurance"));
        client.setInsuranceAddress(request.getParameter("insuranceAddress"));
        client.setPolicyHolderName(request.getParameter("policyHolderName"));
        client.setPolicyHolderAddress(request.getParameter("policyHolderAddress"));
        client.setPolicyHolderDob(request.getParameter("policyHolderDob"));
        client.setPolicyHolderSsn(request.getParameter("policyHolderSsn"));
        client.setPolicyNumber(request.getParameter("policyNumber"));
        client.setGroupNumber(request.getParameter("groupNumber"));
        client.setPolicyHolderRelation(request.getParameter("policyHolderRelation"));
        client.setInsurance2(request.getParameter("insurance2"));
        client.setInsuranceAddress2(request.getParameter("insuranceAddress2"));
        client.setPolicyHolderName2(request.getParameter("policyHolderName2"));
        client.setPolicyHolderAddress2(request.getParameter("policyHolderAddress2"));
        client.setPolicyHolderDob2(request.getParameter("policyHolderDob2"));
        client.setPolicyHolderSsn2(request.getParameter("policyHolderSsn2"));
        client.setPolicyNumber2(request.getParameter("policyNumber2"));
        client.setGroupNumber2(request.getParameter("groupNumber2"));
        client.setPolicyHolderRelation2(request.getParameter("policyHolderRelation2"));
        client.setAccidentInfo(request.getParameter("accidentInfo"));
        client.setCompInfo(request.getParameter("compInfo"));
    }
}
