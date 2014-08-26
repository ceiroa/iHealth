/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.controller;

import com.ceiroa.model.AccessController;
import com.ceiroa.model.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ceiroa
 */
public class IndexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //Get params from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //Find user
        User user = null;
        try {
            user = AccessController.findUser(username, password);
        } catch (Exception ex) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url;

        if(user!=null) {
            //Create session

            //Log access to application in database

            //Create session
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(1800);
            session.setAttribute("user", user);

            //Redirect to home page
            url = "/home.jsp";
        } else {
            //Send back to log in page with error message
            request.setAttribute("errorMessage", "Wrong Username <br/> or Password");

            url = "/index.jsp";
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
        return "Servlet that acts as controller for the index (log in) page.";
    }

}
