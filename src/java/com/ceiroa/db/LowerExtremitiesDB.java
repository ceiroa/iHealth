/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.db;

import com.ceiroa.model.LowerExtremitiesVisit;
import com.ceiroa.model.iVisit;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ceiroa
 */
public class LowerExtremitiesDB extends abstractVisitDB {

    public static int insert(iVisit visit, String table) {
        int visitId = insertCommon(visit, table);
        if( visitId!=0) {
            if(visit.getDateCreated() != null) {
                updateDateCreated(visit, visitId, "lowerExtremitiesVisits");
            }
            int success = updateLowerExtremities(visit, visitId);
            if(success==1)
                return 1;
        }
        return 0;
    }

    public static int update(iVisit visit, int visitId, String table) {
        int commonUpdateSuccess = updateCommon(visit, visitId, table);
        if( commonUpdateSuccess!=0) {
            int success = updateLowerExtremities(visit, visitId);
            if(success==1)
                return 1;
        }
        return 0;
    }
    
    public static int updateLowerExtremities(iVisit visit, int visitId) {
        prepare();

        String query = "UPDATE lowerExtremitiesVisits "
          + "SET kneeFlex = ?, kneeExt = ?, pf = ?, df = ?, "
          + "inv = ?, ev = ?, hipFlex = ?, hipExt = ?, "
          + "hipAbd = ?, hipAdd = ?, hipLr = ?, hipMr = ?, "
          + "hipHyp = ?, trendelenbarg = ?, legLength = ?, "
          + "thomasTest = ?, oberTest = ?, mcMurray = ?, "
          + "apleyTest = ?, bounceHome = ?, patellaGrinding = ?, "
          + "apprehensionPatella = ?, tinelSign = ?, effusionTest = ?, "
          + "rigidFlatFeet = ?, tibialTorsion = ?, homansSign  = ?, "
          + "forefootTest = ?, ankleDorsiflexion  = ?"
          + " WHERE id = " + visitId;
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
        LowerExtremitiesVisit visit = (LowerExtremitiesVisit)ivisit;
        ps.setString(1, String.valueOf(visit.getKneeFlex()));
        ps.setString(2, String.valueOf(visit.getKneeExt()));
        ps.setString(3, String.valueOf(visit.getPf()));
        ps.setString(4, String.valueOf(visit.getDf()));
        ps.setString(5, String.valueOf(visit.getInv()));
        ps.setString(6, String.valueOf(visit.getEv()));
        ps.setString(7, String.valueOf(visit.getHipFlex()));
        ps.setString(8, String.valueOf(visit.getHipExt()));
        ps.setString(9, String.valueOf(visit.getHipAbd()));
        ps.setString(10, String.valueOf(visit.getHipAdd()));
        ps.setString(11, String.valueOf(visit.getHipLr()));
        ps.setString(12, String.valueOf(visit.getHipMr()));
        ps.setString(13, String.valueOf(visit.getHipHyp()));
        ps.setString(14, String.valueOf(visit.getTrendelenbarg()));
        ps.setString(15, String.valueOf(visit.getLegLength()));
        ps.setString(16, String.valueOf(visit.getThomasTest()));
        ps.setString(17, String.valueOf(visit.getOberTest()));
        ps.setString(18, String.valueOf(visit.getMcMurray()));
        ps.setString(19, String.valueOf(visit.getApleyTest()));
        ps.setString(20, String.valueOf(visit.getBounceHome()));
        ps.setString(21, String.valueOf(visit.getPatellaGrinding()));
        ps.setString(22, String.valueOf(visit.getApprehensionPatella()));
        ps.setString(23, String.valueOf(visit.getTinelSign()));
        ps.setString(24, String.valueOf(visit.getEffusionTest()));
        ps.setString(25, String.valueOf(visit.getRigidFlatFeet()));
        ps.setString(26, String.valueOf(visit.getTibialTorsion()));
        ps.setString(27, String.valueOf(visit.getHomansSign()));
        ps.setString(28, String.valueOf(visit.getForefootTest()));
        ps.setString(29, String.valueOf(visit.getAnkleDorsiflexion()));
    }

    private static void setLowerExtremitiesVisitFields(ResultSet rs, iVisit visit) throws SQLException {
        setTypeController(visit);
        ((LowerExtremitiesVisit)visit).setKneeFlex(Integer.parseInt(rs.getString("kneeFlex")));
        ((LowerExtremitiesVisit)visit).setKneeExt(Integer.parseInt(rs.getString("kneeExt")));
        ((LowerExtremitiesVisit)visit).setPf(Integer.parseInt(rs.getString("pf")));
        ((LowerExtremitiesVisit)visit).setDf(Integer.parseInt(rs.getString("df")));
        ((LowerExtremitiesVisit)visit).setInv(Integer.parseInt(rs.getString("inv")));
        ((LowerExtremitiesVisit)visit).setEv(Integer.parseInt(rs.getString("ev")));
        ((LowerExtremitiesVisit)visit).setHipFlex(Integer.parseInt(rs.getString("hipFlex")));
        ((LowerExtremitiesVisit)visit).setHipExt(Integer.parseInt(rs.getString("hipExt")));
        ((LowerExtremitiesVisit)visit).setHipAbd(Integer.parseInt(rs.getString("hipAbd")));
        ((LowerExtremitiesVisit)visit).setHipAdd(Integer.parseInt(rs.getString("hipAdd")));
        ((LowerExtremitiesVisit)visit).setHipLr(Integer.parseInt(rs.getString("hipLr")));
        ((LowerExtremitiesVisit)visit).setHipMr(Integer.parseInt(rs.getString("hipMr")));
        ((LowerExtremitiesVisit)visit).setHipHyp(Integer.parseInt(rs.getString("hipHyp")));
        ((LowerExtremitiesVisit)visit).setTrendelenbarg(rs.getString("trendelenbarg"));
        ((LowerExtremitiesVisit)visit).setLegLength(rs.getString("legLength"));
        ((LowerExtremitiesVisit)visit).setThomasTest(rs.getString("thomasTest"));
        ((LowerExtremitiesVisit)visit).setOberTest(rs.getString("oberTest"));
        ((LowerExtremitiesVisit)visit).setMcMurray(rs.getString("mcMurray"));
        ((LowerExtremitiesVisit)visit).setApleyTest(rs.getString("apleyTest"));
        ((LowerExtremitiesVisit)visit).setBounceHome(rs.getString("bounceHome"));
        ((LowerExtremitiesVisit)visit).setPatellaGrinding(rs.getString("patellaGrinding"));
        ((LowerExtremitiesVisit)visit).setApprehensionPatella(rs.getString("apprehensionPatella"));
        ((LowerExtremitiesVisit)visit).setTinelSign(rs.getString("tinelSign"));
        ((LowerExtremitiesVisit)visit).setEffusionTest(rs.getString("effusionTest"));
        ((LowerExtremitiesVisit)visit).setRigidFlatFeet(rs.getString("rigidFlatFeet"));
        ((LowerExtremitiesVisit)visit).setTibialTorsion(rs.getString("tibialTorsion"));
        ((LowerExtremitiesVisit)visit).setHomansSign(rs.getString("homansSign"));
        ((LowerExtremitiesVisit)visit).setForefootTest(rs.getString("forefootTest"));
        ((LowerExtremitiesVisit)visit).setAnkleDorsiflexion(rs.getString("ankleDorsiflexion"));
    }

    private static void setTypeController(iVisit visit) {
        visit.setVisitType("Lower Extremities");
        visit.setController("lowerExtremities");
    }

    protected void setVisitProperties(ResultSet rs, iVisit visit) throws SQLException {
        setTypeController(visit);
        setCommonVisitFields(rs, visit);
        setLowerExtremitiesVisitFields(rs, visit);
    }
}
