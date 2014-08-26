/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.controller;

import com.ceiroa.model.iVisit;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ceiroa
 */
public class VisitHelper {

    static void setCommonFields(iVisit visit, HttpServletRequest request) {
        visit.setDateCreated(request.getParameter("dateCreated"));
        visit.setAchingDullSore(request.getParameter("achingDullSore"));
        visit.setBurning(request.getParameter("burning"));
        visit.setComplaint(request.getParameter("complaint"));
        visit.setFrequency(request.getParameter("frequency"));
        visit.setClientId(Long.parseLong(request.getParameter("clientId")));
        visit.setNumbnessTingling(request.getParameter("numbnessTingling"));
        visit.setPainChange(request.getParameter("painChange"));
        visit.setPainLevel(Integer.parseInt(request.getParameter("painLevel")));
        visit.setSameComplaint(request.getParameter("sameComplaint"));
        visit.setSharpShooting(request.getParameter("sharpShooting"));
        visit.setSharpStabbing(request.getParameter("sharpStabbing"));
        visit.setSnapPopGrind(request.getParameter("snapPopGrind"));
        visit.setStiffnessTightness(request.getParameter("stiffnessTightness"));
        visit.setSwelling(request.getParameter("swelling"));
        visit.setThrobbing(request.getParameter("throbbing"));
        visit.setInspection(request.getParameter("inspection"));
        visit.setPalpation(request.getParameter("palpation"));
        visit.setDxAction(request.getParameter("dxAction"));
    }

    static void setDateCreated(iVisit visit, HttpServletRequest request) {
        visit.setDateCreated(request.getParameter("dateCreated"));
    }

}
