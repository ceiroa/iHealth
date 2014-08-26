/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.controller;

import com.ceiroa.db.AeSimpleMD5;
import com.ceiroa.db.UserDB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crme1980
 */
public class ChangeMyPsswServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        request.setAttribute("active", "changeMyPssw");

        String url = "/changeMyPssw.jsp";
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
        request.setAttribute("active", "changeMyPssw");

        String id = request.getParameter("id");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if(!id.isEmpty() && !password1.isEmpty()) {
            if(password1.equals(password2)) {
                try {
                    String encPassword = AeSimpleMD5.MD5(password1);
                    int message = UserDB.updatePassword(Long.parseLong(id), encPassword);

                    if(message!=0) {
                        request.setAttribute("successMessage", "Password successfully updated");
                    } else {
                        request.setAttribute("errorMessage", "Error. Your password could not "
                                + "be updated. Please try again or contact support.");
                    }
                } catch (Exception ex) {
                        Logger.getLogger(ChangeMyPsswServlet.class.getName()).log(Level.SEVERE, null, ex);
                        request.setAttribute("errorMessage", "Your password could not be updated. Please try "
                                + "again later or contact support. (Exception thrown)");
                }
           } else {
                request.setAttribute("errorMessage", "Passwords don't match");
           }
        } else {
            request.setAttribute("errorMessage", "Please fill all fields");
        }

        String url = "/changeMyPssw.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
