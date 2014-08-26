/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.controller;

import com.ceiroa.db.ClientDB;
import com.ceiroa.db.VisitsDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crme1980
 */
public class deleteClientServlet extends HttpServlet {

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
        request.setAttribute("active", "manageClients");

        String clientId = request.getParameter("id");

        //There are visits associated with this client-cannot delete
        if(VisitsDB.isVisitsForClient(clientId)) {
            request.setAttribute("errorMessage", "Visits exist for this client. It cannot be deleted."
                    + "<br/> If you still want to delete it, delete first all his/her visits.");
        } else {
            int success = ClientDB.delete(clientId);
            if(success==1) {
                    request.setAttribute("successMessage", "Client successfully deleted");
            } else {
                    request.setAttribute("errorMessage", "Couldn't delete client. Please try"
                        + " again later or contact support.");
            }
        }

        String url = "/manageClients.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
