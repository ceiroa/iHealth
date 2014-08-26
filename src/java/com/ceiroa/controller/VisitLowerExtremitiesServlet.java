/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.controller;

import com.ceiroa.db.LowerExtremitiesDB;
import com.ceiroa.model.DateHelper;
import com.ceiroa.model.IntHelper;
import com.ceiroa.model.LowerExtremitiesVisit;
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
public class VisitLowerExtremitiesServlet extends HttpServlet {

    final String tableName = "lowerExtremitiesVisits";
    final String className = "com.ceiroa.model.LowerExtremitiesVisit";
    
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

        String url = "/visitLowerExtremities.jsp";
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

        LowerExtremitiesDB leDB = new LowerExtremitiesDB();

        //Save new visit - The user already filled the information
        if(postReqSource.equals("entryForm") && !clientId.isEmpty() && visitId.isEmpty()) {
            iVisit visit = new LowerExtremitiesVisit();
            VisitHelper.setCommonFields(visit, request);
            //Set lowerExtremities-specific fields
            setVisitFields(visit, request);

            int success = LowerExtremitiesDB.insert(visit, "lowerExtremitiesVisits");
            if(success==1) {
                request.setAttribute("successMessage", "Visit successfully created");
            } else {
                request.setAttribute("errorMessage", "Couldn't create visit. Please try"
                    + " again later or contact support.");
            }
            url = "/newVisit.jsp";
        //View
        } else if(postReqSource.equals("visitsLog") && !visitId.isEmpty()) {
            iVisit visit = leDB.getVisitByID(visitId, tableName, className);
            request.setAttribute("visit", visit);
            String dateCreated = visit.getDateCreated();
            if(dateCreated != null) {
                request.setAttribute("date", dateCreated);
            } else {
                request.setAttribute("date", DateHelper.now());
            }
            url = "/visitLowerExtremities.jsp";
        //Update
        } else if(postReqSource.equals("entryForm") && !visitId.isEmpty()) {
            String date = request.getParameter("dateCreated");
                if(!date.isEmpty()) {
                iVisit visit = new LowerExtremitiesVisit();
                visit.setId(Long.parseLong(visitId));
                visit.setClientId(Long.parseLong(clientId));
                VisitHelper.setCommonFields(visit, request);
                VisitHelper.setDateCreated(visit, request);
                setVisitFields(visit, request);

                int message = LowerExtremitiesDB.update(visit, Integer.parseInt(visitId),
                        "lowerExtremitiesVisits");
                if(message!=0) {
                    LowerExtremitiesDB.updateDateCreated(visit, Integer.parseInt(visitId),
                            "lowerExtremitiesVisits");
                    request.setAttribute("successMessage", "Visit successfully updated");
                } else {
                    request.setAttribute("errorMessage", "Error. Visit could not "
                            + "be updated. Please try again or contact support.");
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
            iVisit visit = leDB.getVisitByClientID(clientId, tableName, className);
            if(visit != null) {
                request.setAttribute("visit", visit);
                request.setAttribute("date", visit.getDateCreated());
            } else {
                request.setAttribute("date", DateHelper.now());
            }
            url = "/visitLowerExtremities.jsp";
        }

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private void setVisitFields(iVisit visit, HttpServletRequest request) {
        ((LowerExtremitiesVisit)visit).setKneeFlex(IntHelper.parseInt(request.getParameter("kneeFlex")));
        ((LowerExtremitiesVisit)visit).setKneeExt(IntHelper.parseInt(request.getParameter("kneeExt")));
        ((LowerExtremitiesVisit)visit).setPf(IntHelper.parseInt(request.getParameter("pf")));
        ((LowerExtremitiesVisit)visit).setDf(IntHelper.parseInt(request.getParameter("df")));
        ((LowerExtremitiesVisit)visit).setInv(IntHelper.parseInt(request.getParameter("inv")));
        ((LowerExtremitiesVisit)visit).setEv(IntHelper.parseInt(request.getParameter("ev")));
        ((LowerExtremitiesVisit)visit).setHipFlex(IntHelper.parseInt(request.getParameter("hipFlex")));
        ((LowerExtremitiesVisit)visit).setHipExt(IntHelper.parseInt(request.getParameter("hipExt")));
        ((LowerExtremitiesVisit)visit).setHipAbd(IntHelper.parseInt(request.getParameter("hipAbd")));
        ((LowerExtremitiesVisit)visit).setHipAdd(IntHelper.parseInt(request.getParameter("hipAdd")));
        ((LowerExtremitiesVisit)visit).setHipLr(IntHelper.parseInt(request.getParameter("hipLr")));
        ((LowerExtremitiesVisit)visit).setHipMr(IntHelper.parseInt(request.getParameter("hipMr")));
        ((LowerExtremitiesVisit)visit).setHipHyp(IntHelper.parseInt(request.getParameter("hipHyp")));
        ((LowerExtremitiesVisit)visit).setTrendelenbarg(request.getParameter("trendelenbarg"));
        ((LowerExtremitiesVisit)visit).setLegLength(request.getParameter("legLength"));
        ((LowerExtremitiesVisit)visit).setThomasTest(request.getParameter("thomasTest"));
        ((LowerExtremitiesVisit)visit).setOberTest(request.getParameter("oberTest"));
        ((LowerExtremitiesVisit)visit).setMcMurray(request.getParameter("mcMurray"));
        ((LowerExtremitiesVisit)visit).setApleyTest(request.getParameter("apleyTest"));
        ((LowerExtremitiesVisit)visit).setBounceHome(request.getParameter("bounceHome"));
        ((LowerExtremitiesVisit)visit).setPatellaGrinding(request.getParameter("patellaGrinding"));
        ((LowerExtremitiesVisit)visit).setApprehensionPatella(request.getParameter("apprehensionPatella"));
        ((LowerExtremitiesVisit)visit).setTinelSign(request.getParameter("tinelSign"));
        ((LowerExtremitiesVisit)visit).setEffusionTest(request.getParameter("effusionTest"));
        ((LowerExtremitiesVisit)visit).setRigidFlatFeet(request.getParameter("rigidFlatFeet"));
        ((LowerExtremitiesVisit)visit).setTibialTorsion(request.getParameter("tibialTorsion"));
        ((LowerExtremitiesVisit)visit).setHomansSign(request.getParameter("homansSign"));
        ((LowerExtremitiesVisit)visit).setForefootTest(request.getParameter("forefootTest"));
        ((LowerExtremitiesVisit)visit).setAnkleDorsiflexion(request.getParameter("ankleDorsiflexion"));
    }

}
