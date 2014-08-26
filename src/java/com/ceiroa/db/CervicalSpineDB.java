/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.db;

import com.ceiroa.model.CervicalSpineVisit;
import com.ceiroa.model.iVisit;
import java.sql.*;

/**
 *
 * @author ceiroa
 */
public class CervicalSpineDB extends abstractVisitDB {

    public static int insert(iVisit visit, String table) {
        int visitId = insertCommon(visit, table);
        if( visitId!=0) {
            if(visit.getDateCreated() != null) {
                updateDateCreated(visit, visitId, "cervicalSpineVisits");
            }
            int success = updateCervicalSpine(visit, visitId);
            if(success==1)
                return 1;
        }
        return 0;
    }
    
    public static int update(iVisit visit, int visitId, String table) {
        int commonUpdateSuccess = updateCommon(visit, visitId, table);
        if( commonUpdateSuccess!=0) {
            int success = updateCervicalSpine(visit, visitId);
            if(success==1)
                return 1;
        }
        return 0;
    }

    public static int updateCervicalSpine(iVisit visit, int visitId) {
        prepare();

        String query = "UPDATE cervicalSpineVisits "
          + "SET flex = ?, llf = ?, llr = ?, ext = ?,"
          + "rlf = ?, rlr = ?, jacksonComp = ?, "
          + "maxComp = ?, shoulderDep = ?, sotoHall = ?, "
          + "spurlings = ?, csDistraction = ?, "
          + "valsavas = ?, baccody = ?, latArm = ?, "
          + "latForearm = ?, middleFinger = ?, "
          + "medForearm = ?, medArm = ?, biceps = ?, "
          + "brachiorad = ?, triceps = ?, shoulderAbd = ?, "
          + "wristExt = ?, wristFlex = ?, fingerExt = ?, "
          + "fingerFlex = ?, fingerAbd = ? "
          + "WHERE id = " + visitId;
        try {
            ps = connection.prepareStatement(query);

            setPsStrings(visit);

            return ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
            return 0;

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    
    private static void setPsStrings(iVisit ivisit) throws SQLException {
        CervicalSpineVisit visit = (CervicalSpineVisit) ivisit;
        ps.setString(1, String.valueOf(visit.getFlex()));
        ps.setString(2, String.valueOf(visit.getLlf()));
        ps.setString(3, String.valueOf(visit.getLlr()));
        ps.setString(4, String.valueOf(visit.getExt()));
        ps.setString(5, String.valueOf(visit.getRlf()));
        ps.setString(6, String.valueOf(visit.getRlr()));
        ps.setString(7, visit.getJacksonComp());
        ps.setString(8, visit.getMaxComp());
        ps.setString(9, visit.getShoulderDep());
        ps.setString(10, visit.getSotoHall());
        ps.setString(11, visit.getSpurlings());
        ps.setString(12, visit.getCsDistraction());
        ps.setString(13, visit.getValsavas());
        ps.setString(14, visit.getBaccody());
        ps.setString(15, visit.getLatArm());
        ps.setString(16, visit.getLatForearm());
        ps.setString(17, visit.getMiddleFinger());
        ps.setString(18, visit.getMedForearm());
        ps.setString(19, visit.getMedArm());
        ps.setString(20, visit.getBiceps());
        ps.setString(21, visit.getBrachiorad());
        ps.setString(22, visit.getTriceps());
        ps.setString(23, visit.getShoulderAbd());
        ps.setString(24, visit.getWristExt());
        ps.setString(25, visit.getWristFlex());
        ps.setString(26, visit.getFingerExt());
        ps.setString(27, visit.getFingerFlex());
        ps.setString(28, visit.getFingerAbd());
    }

    private static void setCervicalSpineVisitFields(ResultSet rs, iVisit visit) throws SQLException {
        setTypeController(visit);
        ((CervicalSpineVisit)visit).setFlex(Integer.parseInt(rs.getString("flex")));
        ((CervicalSpineVisit)visit).setLlf(Integer.parseInt(rs.getString("llf")));
        ((CervicalSpineVisit)visit).setLlr(Integer.parseInt(rs.getString("llr")));
        ((CervicalSpineVisit)visit).setExt(Integer.parseInt(rs.getString("ext")));
        ((CervicalSpineVisit)visit).setRlf(Integer.parseInt(rs.getString("rlf")));
        ((CervicalSpineVisit)visit).setRlr(Integer.parseInt(rs.getString("rlr")));
        ((CervicalSpineVisit)visit).setJacksonComp(rs.getString("jacksonComp"));
        ((CervicalSpineVisit)visit).setMaxComp(rs.getString("maxComp"));
        ((CervicalSpineVisit)visit).setShoulderDep(rs.getString("shoulderDep"));
        ((CervicalSpineVisit)visit).setSotoHall(rs.getString("sotoHall"));
        ((CervicalSpineVisit)visit).setSpurlings(rs.getString("spurlings"));
        ((CervicalSpineVisit)visit).setCsDistraction(rs.getString("csDistraction"));
        ((CervicalSpineVisit)visit).setValsavas(rs.getString("valsavas"));
        ((CervicalSpineVisit)visit).setBaccody(rs.getString("baccody"));
        ((CervicalSpineVisit)visit).setLatArm(rs.getString("latArm"));
        ((CervicalSpineVisit)visit).setLatForearm(rs.getString("latForearm"));
        ((CervicalSpineVisit)visit).setMiddleFinger(rs.getString("middleFinger"));
        ((CervicalSpineVisit)visit).setMedForearm(rs.getString("medForearm"));
        ((CervicalSpineVisit)visit).setMedArm(rs.getString("medArm"));
        ((CervicalSpineVisit)visit).setBiceps(rs.getString("Biceps"));
        ((CervicalSpineVisit)visit).setBrachiorad(rs.getString("brachiorad"));
        ((CervicalSpineVisit)visit).setTriceps(rs.getString("triceps"));
        ((CervicalSpineVisit)visit).setShoulderAbd(rs.getString("shoulderAbd"));
        ((CervicalSpineVisit)visit).setWristExt(rs.getString("wristExt"));
        ((CervicalSpineVisit)visit).setWristFlex(rs.getString("wristFlex"));
        ((CervicalSpineVisit)visit).setFingerExt(rs.getString("fingerExt"));
        ((CervicalSpineVisit)visit).setFingerFlex(rs.getString("fingerFlex"));
        ((CervicalSpineVisit)visit).setFingerAbd(rs.getString("fingerAbd"));
    }

    private static void setTypeController(iVisit visit) {
        visit.setVisitType("Cervical Spine");
        visit.setController("cervicalSpine");
    }

    protected void setVisitProperties(ResultSet rs, iVisit visit) throws SQLException {
        setTypeController(visit);
        setCommonVisitFields(rs, visit);
        setCervicalSpineVisitFields(rs, visit);
    }
}
