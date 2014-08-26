/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.controller;

import com.ceiroa.db.UpperExtremitiesDB;
import com.ceiroa.model.DateHelper;
import com.ceiroa.model.IntHelper;
import com.ceiroa.model.UpperExtremitiesVisit;
import com.ceiroa.model.iVisit;
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
public class VisitUpperExtremitiesServlet extends HttpServlet {

    final String tableName = "upperExtremitiesVisits";
    final String className = "com.ceiroa.model.UpperExtremitiesVisit";

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
        request.setAttribute("active", "newVisit");

        String url = "/visitUpperExtremities.jsp";
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
        request.setAttribute("active", "newVisit");

        String visitId = request.getParameter("visitId");
        String clientId = request.getParameter("clientId");
        String postReqSource = request.getParameter("postReqSource");
        String noMenu = request.getParameter("noMenu");

        request.setAttribute("visitId", visitId);
        request.setAttribute("clientId", clientId);
        request.setAttribute("noMenu", noMenu);

        String url="";

        UpperExtremitiesDB ueDB = new UpperExtremitiesDB();

        //Save new visit - The user already filled the information
        if(postReqSource.equals("entryForm") && !clientId.isEmpty() && visitId.isEmpty()) {
            iVisit visit = new UpperExtremitiesVisit();
            VisitHelper.setCommonFields(visit, request);
            //Set uppesExtremities-specific fields
            setVisitFields(visit, request);

            int success = UpperExtremitiesDB.insert(visit, "upperExtremitiesVisits");
            if(success==1) {
                request.setAttribute("successMessage", "Visit successfully created");
            } else {
                request.setAttribute("errorMessage", "Couldn't create visit. Please try"
                    + " again later or contact support.");
            }
            url = "/newVisit.jsp";
        //View
        } else if(postReqSource.equals("visitsLog") && !visitId.isEmpty()) {
            iVisit visit = ueDB.getVisitByID(visitId, tableName, className);
            request.setAttribute("visit", visit);
            String dateCreated = visit.getDateCreated();
            if(dateCreated != null) {
                request.setAttribute("date", dateCreated);
            } else {
                request.setAttribute("date", DateHelper.now());
            }
            url = "/visitUpperExtremities.jsp";
        //Update
        } else if(postReqSource.equals("entryForm") && !visitId.isEmpty()) {
            String date = request.getParameter("dateCreated");
            if(!date.isEmpty()) {
                iVisit visit = new UpperExtremitiesVisit();
                visit.setId(Long.parseLong(visitId));
                visit.setClientId(Long.parseLong(clientId));
                VisitHelper.setCommonFields(visit, request);
                VisitHelper.setDateCreated(visit, request);
                setVisitFields(visit, request);

                int message = UpperExtremitiesDB.update(visit, Integer.parseInt(visitId),
                        "upperExtremitiesVisits");

                if(message!=0) {
                    UpperExtremitiesDB.updateDateCreated(visit, Integer.parseInt(visitId),
                            "upperExtremitiesVisits");
                    request.setAttribute("successMessage", "Visit successfully updated");
                } else {
                    request.setAttribute("errorMessage", "Error. Visit could not "
                            + "be updated. Please try again or contact support. (Update Visit.)");
                }
            } else {
                request.setAttribute("errorMessage", "Please click the back button on the "
                        + "browser and enter a valid date.");
            }
            request.setAttribute("active", "visits");
            url = "/visitsLog.jsp";
        //The user wants to create a new visit. We check first if
        //a visit of this type exists for this client
        } else {
            iVisit visit = ueDB.getVisitByClientID(clientId, tableName, className);
            if(visit != null) {
                request.setAttribute("visit", visit);
                request.setAttribute("date", visit.getDateCreated());
            } else {
                request.setAttribute("date", DateHelper.now());
            }
            url = "/visitUpperExtremities.jsp";
        }

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private void setVisitFields(iVisit visit, HttpServletRequest request) {
        ((UpperExtremitiesVisit)visit).setShoulderFlex(IntHelper.parseInt(request.getParameter("shoulderFlex")));
        ((UpperExtremitiesVisit)visit).setShoulderLr(IntHelper.parseInt(request.getParameter("shoulderLr")));
        ((UpperExtremitiesVisit)visit).setShoulderAbd(IntHelper.parseInt(request.getParameter("shoulderAbd")));
        ((UpperExtremitiesVisit)visit).setShoulderExt(IntHelper.parseInt(request.getParameter("shoulderExt")));
        ((UpperExtremitiesVisit)visit).setShoulderMr(IntHelper.parseInt(request.getParameter("shoulderMr")));
        ((UpperExtremitiesVisit)visit).setShoulderAdd(IntHelper.parseInt(request.getParameter("shoulderAdd")));
        ((UpperExtremitiesVisit)visit).setElbowFlex(IntHelper.parseInt(request.getParameter("elbowFlex")));
        ((UpperExtremitiesVisit)visit).setElbowPro(IntHelper.parseInt(request.getParameter("elbowPro")));
        ((UpperExtremitiesVisit)visit).setElbowExt(IntHelper.parseInt(request.getParameter("elbowExt")));
        ((UpperExtremitiesVisit)visit).setElbowSup(IntHelper.parseInt(request.getParameter("elbowSup")));
        ((UpperExtremitiesVisit)visit).setWristFlex(IntHelper.parseInt(request.getParameter("wristFlex")));
        ((UpperExtremitiesVisit)visit).setWristAbd(IntHelper.parseInt(request.getParameter("wristAbd")));
        ((UpperExtremitiesVisit)visit).setWristExt(IntHelper.parseInt(request.getParameter("wristExt")));
        ((UpperExtremitiesVisit)visit).setWristAdd(IntHelper.parseInt(request.getParameter("wristAdd")));
        ((UpperExtremitiesVisit)visit).setDropArmTest(request.getParameter("dropArmTest"));
        ((UpperExtremitiesVisit)visit).setDrawbarnTest(request.getParameter("drawbarnTest"));
        ((UpperExtremitiesVisit)visit).setSupraspinatusTest(request.getParameter("supraspinatusTest"));
        ((UpperExtremitiesVisit)visit).setApleyScratchTest(request.getParameter("apleyScratchTest"));
        ((UpperExtremitiesVisit)visit).setPostImpingSign(request.getParameter("postImpingSign"));
        ((UpperExtremitiesVisit)visit).setSpeedTest(request.getParameter("speedTest"));
        ((UpperExtremitiesVisit)visit).setCrossOverImpTest(request.getParameter("crossOverImpTest"));
        ((UpperExtremitiesVisit)visit).setYergasonTest(request.getParameter("yergasonTest"));
        ((UpperExtremitiesVisit)visit).setApprehensionTest(request.getParameter("apprehensionTest"));
        ((UpperExtremitiesVisit)visit).setDrawerTest(request.getParameter("drawerTest"));
        ((UpperExtremitiesVisit)visit).setVarusStressTest(request.getParameter("varusStressTest"));
        ((UpperExtremitiesVisit)visit).setCozensTest(request.getParameter("cozensTest"));
        ((UpperExtremitiesVisit)visit).setValgusStressTest(request.getParameter("valgusStressTest"));
        ((UpperExtremitiesVisit)visit).setGolferElbow(request.getParameter("golferElbow"));
        ((UpperExtremitiesVisit)visit).setTinelSign(request.getParameter("tinelSign"));
        ((UpperExtremitiesVisit)visit).setPinchGripTest(request.getParameter("pinchGripTest"));
        ((UpperExtremitiesVisit)visit).setFromentTest(request.getParameter("fromentTest"));
        ((UpperExtremitiesVisit)visit).setPhalenTest(request.getParameter("phalenTest"));
        ((UpperExtremitiesVisit)visit).setFingerTapTest(request.getParameter("fingerTapTest"));
        ((UpperExtremitiesVisit)visit).setFinkelsteninTest(request.getParameter("finkelsteninTest"));
        ((UpperExtremitiesVisit)visit).setBunnelLitter(request.getParameter("bunnelLitter"));
    }
}