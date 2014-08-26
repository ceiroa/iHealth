/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.controller;

import com.ceiroa.db.LumbarSpineDB;
import com.ceiroa.model.DateHelper;
import com.ceiroa.model.IntHelper;
import com.ceiroa.model.LumbarSpineVisit;
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
public class VisitLumbarSpineServlet extends HttpServlet {

    final String tableName = "lumbarSpineVisits";
    final String className = "com.ceiroa.model.LumbarSpineVisit";
    
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

        String url = "/visitLumbarSpine.jsp";
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

        LumbarSpineDB lsDB = new LumbarSpineDB();

        //Save new visit - The user already filled the information
        if(postReqSource.equals("entryForm") && !clientId.isEmpty() && visitId.isEmpty()) {
            iVisit visit = new LumbarSpineVisit();
            VisitHelper.setCommonFields(visit, request);
            //Set lumbarSpine-specific fields
            setVisitFields(visit, request);

            int success = LumbarSpineDB.insert(visit, "lumbarSpineVisits");
            if(success==1) {
                request.setAttribute("successMessage", "Visit successfully created");
            } else {
                request.setAttribute("errorMessage", "Couldn't create visit. Please try"
                    + " again later or contact support.");
            }
            url = "/newVisit.jsp";
        //View
        } else if(postReqSource.equals("visitsLog") && !visitId.isEmpty()) {
            iVisit visit = lsDB.getVisitByID(visitId, tableName, className);
            request.setAttribute("visit", visit);
            String dateCreated = visit.getDateCreated();
            if(dateCreated != null) {
                request.setAttribute("date", dateCreated);
            } else {
                request.setAttribute("date", DateHelper.now());
            }
            url = "/visitLumbarSpine.jsp";
        //Update
        } else if(postReqSource.equals("entryForm") && !visitId.isEmpty()) {
            String date = request.getParameter("dateCreated");
            if(!date.isEmpty()) {
                iVisit visit = new LumbarSpineVisit();
                visit.setId(Long.parseLong(visitId));
                visit.setClientId(Long.parseLong(clientId));
                VisitHelper.setCommonFields(visit, request);
                VisitHelper.setDateCreated(visit, request);
                setVisitFields(visit, request);

                int message = LumbarSpineDB.update(visit, Integer.parseInt(visitId),
                        "lumbarSpineVisits");

                if(message!=0) {
                    LumbarSpineDB.updateDateCreated(visit, Integer.parseInt(visitId) ,
                            "lumbarSpineVisits");
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
            iVisit visit = lsDB.getVisitByClientID(clientId, tableName, className);
            if(visit != null) {
                request.setAttribute("visit", visit);
                request.setAttribute("date", visit.getDateCreated());
            } else {
                request.setAttribute("date", DateHelper.now());
            }
            url = "/visitLumbarSpine.jsp";
        }

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private void setVisitFields(iVisit visit, HttpServletRequest request) {
        ((LumbarSpineVisit)visit).setFlex(IntHelper.parseInt(request.getParameter("flex")));
        ((LumbarSpineVisit)visit).setExt(IntHelper.parseInt(request.getParameter("ext")));
        ((LumbarSpineVisit)visit).setLlf(IntHelper.parseInt(request.getParameter("llf")));
        ((LumbarSpineVisit)visit).setRlf(IntHelper.parseInt(request.getParameter("rlf")));
        ((LumbarSpineVisit)visit).setLlr(IntHelper.parseInt(request.getParameter("llr")));
        ((LumbarSpineVisit)visit).setRlr(IntHelper.parseInt(request.getParameter("rlr")));
        ((LumbarSpineVisit)visit).setValsavas(request.getParameter("valsavas"));
        ((LumbarSpineVisit)visit).setStraightLeg(request.getParameter("straightLeg"));
        ((LumbarSpineVisit)visit).setBrowstringTest(request.getParameter("browstringTest"));
        ((LumbarSpineVisit)visit).setLasegueTest(request.getParameter("lasegueTest"));
        ((LumbarSpineVisit)visit).setElyTest(request.getParameter("elyTest"));
        ((LumbarSpineVisit)visit).setThomasTest(request.getParameter("thomasTest"));
        ((LumbarSpineVisit)visit).setSpringTest(request.getParameter("springTest"));
        ((LumbarSpineVisit)visit).setTrenderlenburgTest(request.getParameter("trenderlenburgTest"));
        ((LumbarSpineVisit)visit).setBilateralLegRaise(request.getParameter("bilateralLegRaise"));
        ((LumbarSpineVisit)visit).setPelvicRock(request.getParameter("pelvicRock"));
        ((LumbarSpineVisit)visit).setPatrickFabere(request.getParameter("patrickFabere"));
        ((LumbarSpineVisit)visit).setMilgram(request.getParameter("milgram"));
        ((LumbarSpineVisit)visit).setMedLegFoot(request.getParameter("medLegFoot"));
        ((LumbarSpineVisit)visit).setLatLeg(request.getParameter("latLeg"));
        ((LumbarSpineVisit)visit).setLatFoot(request.getParameter("latFoot"));
        ((LumbarSpineVisit)visit).setPatellar(request.getParameter("patellar"));
        ((LumbarSpineVisit)visit).setHamstring(request.getParameter("hamstring"));
        ((LumbarSpineVisit)visit).setAchilles(request.getParameter("achilles"));
        ((LumbarSpineVisit)visit).setAntTibialis(request.getParameter("antTibialis"));
        ((LumbarSpineVisit)visit).setExtHallucis(request.getParameter("extHallucis"));
        ((LumbarSpineVisit)visit).setPeroneus(request.getParameter("peroneus"));
    }

}
