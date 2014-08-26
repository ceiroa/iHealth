/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.controller;

import com.ceiroa.db.AeSimpleMD5;
import com.ceiroa.db.UserDB;
import com.ceiroa.model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ceiroa
 */
public class NewUserServlet extends HttpServlet {

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
        request.setAttribute("active", "manageUsers");

        String url = "/newUser.jsp";
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
        
        String url;
        request.setAttribute("active", "manageUsers");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");
        String userType = request.getParameter("userType");
        String status = request.getParameter("status");

        if(!firstName.isEmpty() && !lastName.isEmpty() &&
                !username.isEmpty() && !password1.isEmpty() &&
                !email.isEmpty()) {
            if(password1.equals(password2)) {
                try {
                    String encPassword = AeSimpleMD5.MD5(password1);

                    int success = UserDB.insert(firstName, lastName,
                            username, encPassword, userType, email,
                            status);

                    if(success==1)
                        request.setAttribute("successMessage", "User successfully created");
                    else
                        request.setAttribute("errorMessage", "Couldn't create merchant. Please try"
                            + "again later or contact support.");

                    //Retrieve all users from database
                    ArrayList<User> users = UserDB.getUsers();
                    request.setAttribute("users", users);

                } catch (Exception ex) {
                    Logger.getLogger(NewUserServlet.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("errorMessage", "Couldn't create merchant. Please try "
                            + "again later or contact support. (Exception thrown)");
                }
                 url = "/manageUsers.jsp";
            } else {
                request.setAttribute("firstName", firstName);
                request.setAttribute("lastName", lastName);
                request.setAttribute("username", firstName);
                request.setAttribute("email", email);
                request.setAttribute("errorMessage", "Passwords don't match");
                url = "/newUser.jsp";
            }
        } else {
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("username", firstName);
            request.setAttribute("email", email);
            request.setAttribute("errorMessage", "Please fill all fields");
            url = "/newUser.jsp";
        }

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
