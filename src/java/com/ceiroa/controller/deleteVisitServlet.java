/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.controller;

import com.ceiroa.db.abstractVisitDB;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crme1980
 */
public class deleteVisitServlet extends HttpServlet {
 
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
        request.setAttribute("active", "visits");

        String visitId = request.getParameter("visitId");
        String tableName = request.getParameter("controller") + "Visits";

        int success = abstractVisitDB.deleteVisit(visitId, tableName);
        if(success==1) {
                request.setAttribute("successMessage", "Visit successfully deleted");
        } else {
                request.setAttribute("errorMessage", "Couldn't delete visit. Please try"
                    + " again later or contact support.");
        }

        String url = "/visitsLog.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
