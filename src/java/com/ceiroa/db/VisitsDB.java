/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.db;

import com.ceiroa.model.iVisit;
import java.util.ArrayList;

/**
 *
 * @author ceiroa
 */
public class VisitsDB {

    final static CervicalSpineDB csDB = new CervicalSpineDB();
    final static LowerExtremitiesDB leDB = new LowerExtremitiesDB();
    final static LumbarSpineDB lsDB = new LumbarSpineDB();
    final static UpperExtremitiesDB ueDB = new UpperExtremitiesDB();

    final static String csTableName = "cervicalSpineVisits";
    final static String leTableName = "lowerExtremitiesVisits";
    final static String lsTableName = "lumbarSpineVisits";
    final static String ueTableName = "upperExtremitiesVisits";

    final static String csClassName = "com.ceiroa.model.CervicalSpineVisit";
    final static String leClassName = "com.ceiroa.model.LowerExtremitiesVisit";
    final static String lsClassName = "com.ceiroa.model.LumbarSpineVisit";
    final static String ueClassName = "com.ceiroa.model.UpperExtremitiesVisit";

    public static boolean isVisitsForClient(String clientId) {
        ArrayList<iVisit> csVisits = csDB.getVisitsForClient(clientId, csTableName, csClassName);
        if(!csVisits.isEmpty())
            return true;
        ArrayList<iVisit> leVisits = leDB.getVisitsForClient(clientId, leTableName, leClassName);
        if(!leVisits.isEmpty())
            return true;
        ArrayList<iVisit> lsVisits = lsDB.getVisitsForClient(clientId, lsTableName, lsClassName);
        if(!lsVisits.isEmpty())
            return true;
        ArrayList<iVisit> ueVisits = ueDB.getVisitsForClient(clientId, ueTableName, ueClassName);
        if(!ueVisits.isEmpty())
            return true;
        
        return false;
    }

    public ArrayList<iVisit> getVisitsForClient(String clientId) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getVisitsForClient(clientId, csTableName, csClassName));
        visits.addAll(leDB.getVisitsForClient(clientId, leTableName, leClassName));
        visits.addAll(lsDB.getVisitsForClient(clientId, lsTableName, lsClassName));
        visits.addAll(ueDB.getVisitsForClient(clientId, ueTableName, ueClassName));

        return visits;
    }

    public ArrayList<iVisit> getAllVisits() {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisits(csTableName, csClassName));
        visits.addAll(leDB.getAllVisits(leTableName, leClassName));
        visits.addAll(lsDB.getAllVisits(lsTableName, lsClassName));
        visits.addAll(ueDB.getAllVisits(ueTableName, ueClassName));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByDate(String date) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByDate(date, csTableName, csClassName));
        visits.addAll(leDB.getAllVisitsByDate(date, leTableName, leClassName));
        visits.addAll(lsDB.getAllVisitsByDate(date, lsTableName, lsClassName));
        visits.addAll(ueDB.getAllVisitsByDate(date, ueTableName, ueClassName));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByLastName(String lastName) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByLastName(lastName, csTableName, csClassName));
        visits.addAll(leDB.getAllVisitsByLastName(lastName, leTableName, leClassName));
        visits.addAll(lsDB.getAllVisitsByLastName(lastName, lsTableName, lsClassName));
        visits.addAll(ueDB.getAllVisitsByLastName(lastName, ueTableName, ueClassName));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByFirstName(String firstName) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByFirstName(firstName, csTableName, csClassName));
        visits.addAll(leDB.getAllVisitsByFirstName(firstName, leTableName, leClassName));
        visits.addAll(lsDB.getAllVisitsByFirstName(firstName, lsTableName, lsClassName));
        visits.addAll(ueDB.getAllVisitsByFirstName(firstName, ueTableName, ueClassName));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByFirstLastName(String firstName, String lastName) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByFirstLastName(firstName, lastName, csTableName, csClassName));
        visits.addAll(leDB.getAllVisitsByFirstLastName(firstName, lastName, leTableName, leClassName));
        visits.addAll(lsDB.getAllVisitsByFirstLastName(firstName, lastName, lsTableName, lsClassName));
        visits.addAll(ueDB.getAllVisitsByFirstLastName(firstName, lastName, ueTableName, ueClassName));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByDateLastName(String date, String lastName) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByDateLastName(date, lastName, csTableName, csClassName));
        visits.addAll(leDB.getAllVisitsByDateLastName(date, lastName, leTableName, leClassName));
        visits.addAll(lsDB.getAllVisitsByDateLastName(date, lastName, lsTableName, lsClassName));
        visits.addAll(ueDB.getAllVisitsByDateLastName(date, lastName, ueTableName, ueClassName));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByDateFirstName(String date, String firstName) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByDateFirstName(date, firstName, csTableName, csClassName));
        visits.addAll(leDB.getAllVisitsByDateFirstName(date, firstName, leTableName, leClassName));
        visits.addAll(lsDB.getAllVisitsByDateFirstName(date, firstName, lsTableName, lsClassName));
        visits.addAll(ueDB.getAllVisitsByDateFirstName(date, firstName, ueTableName, ueClassName));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByDateFirstLastName(String date, String firstName, String lastName) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByDateFirstLastName(date, firstName, lastName, csTableName, csClassName));
        visits.addAll(leDB.getAllVisitsByDateFirstLastName(date, firstName, lastName, leTableName, leClassName));
        visits.addAll(lsDB.getAllVisitsByDateFirstLastName(date, firstName, lastName, lsTableName, lsClassName));
        visits.addAll(ueDB.getAllVisitsByDateFirstLastName(date, firstName, lastName, ueTableName, ueClassName));

        return visits;
    }
}
