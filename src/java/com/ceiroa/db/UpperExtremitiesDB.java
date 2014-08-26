/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.db;

import com.ceiroa.model.UpperExtremitiesVisit;
import com.ceiroa.model.iVisit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ceiroa
 */
public class UpperExtremitiesDB extends abstractVisitDB {

    public static int insert(iVisit visit, String table) {
        int visitId = insertCommon(visit, table);
        if( visitId!=0) {
            if(visit.getDateCreated() != null) {
                updateDateCreated(visit, visitId, "upperExtremitiesVisits");
            }
            int success = updateUpperExtremities((UpperExtremitiesVisit)
                    visit, visitId);
            if(success==1)
                return 1;
        }
        return 0;
    }

    public static int update(iVisit visit, int visitId, String table) {
        int commonUpdateSuccess = updateCommon(visit, visitId, table);
        if( commonUpdateSuccess!=0) {
            int success = updateUpperExtremities(visit, visitId);
            if(success==1)
                return 1;
        }
        return 0;
    }

    public static int updateUpperExtremities(iVisit visit, int visitId) {
        prepare();

        String query = "UPDATE upperExtremitiesVisits "
          + "SET shoulderFlex = ?, shoulderLr = ?, "
          + "shoulderAbd = ?, shoulderExt = ?, shoulderMr = ?, "
          + "shoulderAdd = ?, elbowFlex = ?, elbowPro = ?, "
          + "elbowExt = ?, elbowSup = ?, wristFlex = ?, "
          + "wristAbd = ?, wristExt = ?, wristAdd = ?, "
          + "dropArmTest = ?, drawbarnTest = ?, "
          + "supraspinatusTest = ?, apleyScratchTest = ?, "
          + "postImpingSign = ?, speedTest = ?, "
          + "crossOverImpTest = ?, yergasonTest = ?, "
          + "apprehensionTest = ?, drawerTest = ?, "
          + "varusStressTest = ?, cozensTest = ?, "
          + "valgusStressTest = ?, golferElbow = ?, "
          + "tinelSign = ?, pinchGripTest = ?, fromentTest = ?, "
          + "phalenTest = ?, fingerTapTest = ?, "
          + "finkelsteninTest = ?, bunnelLitter = ? "
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

        UpperExtremitiesVisit visit = (UpperExtremitiesVisit)ivisit;

        ps.setString(1, String.valueOf(visit.getShoulderFlex()));
        ps.setString(2, String.valueOf(visit.getShoulderLr()));
        ps.setString(3, String.valueOf(visit.getShoulderAbd()));
        ps.setString(4, String.valueOf(visit.getShoulderExt()));
        ps.setString(5, String.valueOf(visit.getShoulderMr()));
        ps.setString(6, String.valueOf(visit.getShoulderAdd()));
        ps.setString(7, String.valueOf(visit.getElbowFlex()));
        ps.setString(8, String.valueOf(visit.getElbowPro()));
        ps.setString(9, String.valueOf(visit.getElbowExt()));
        ps.setString(10, String.valueOf(visit.getElbowSup()));
        ps.setString(11, String.valueOf(visit.getWristFlex()));
        ps.setString(12, String.valueOf(visit.getWristAbd()));
        ps.setString(13, String.valueOf(visit.getWristExt()));
        ps.setString(14, String.valueOf(visit.getWristAdd()));
        ps.setString(15, visit.getDropArmTest());
        ps.setString(16, visit.getDrawbarnTest());
        ps.setString(17, visit.getSupraspinatusTest());
        ps.setString(18, visit.getApleyScratchTest());
        ps.setString(19, visit.getPostImpingSign());
        ps.setString(20, visit.getSpeedTest());
        ps.setString(21, visit.getCrossOverImpTest());
        ps.setString(22, visit.getYergasonTest());
        ps.setString(23, visit.getApprehensionTest());
        ps.setString(24, visit.getDrawerTest());
        ps.setString(25, visit.getVarusStressTest());
        ps.setString(26, visit.getCozensTest());
        ps.setString(27, visit.getValgusStressTest());
        ps.setString(28, visit.getGolferElbow());
        ps.setString(29, visit.getTinelSign());
        ps.setString(30, visit.getPinchGripTest());
        ps.setString(31, visit.getFromentTest());
        ps.setString(32, visit.getPhalenTest());
        ps.setString(33, visit.getFingerTapTest());
        ps.setString(34, visit.getFinkelsteninTest());
        ps.setString(35, visit.getBunnelLitter());
    }

    private static void setUpperExtremitiesVisitFields(ResultSet rs, iVisit visit) throws SQLException {
        setTypeController(visit);
        ((UpperExtremitiesVisit)visit).setShoulderFlex(Integer.parseInt(rs.getString("shoulderFlex")));
        ((UpperExtremitiesVisit)visit).setShoulderLr(Integer.parseInt(rs.getString("shoulderLr")));
        ((UpperExtremitiesVisit)visit).setShoulderAbd(Integer.parseInt(rs.getString("shoulderAbd")));
        ((UpperExtremitiesVisit)visit).setShoulderExt(Integer.parseInt(rs.getString("shoulderExt")));
        ((UpperExtremitiesVisit)visit).setShoulderMr(Integer.parseInt(rs.getString("shoulderMr")));
        ((UpperExtremitiesVisit)visit).setShoulderAdd(Integer.parseInt(rs.getString("shoulderAdd")));
        ((UpperExtremitiesVisit)visit).setElbowFlex(Integer.parseInt(rs.getString("elbowFlex")));
        ((UpperExtremitiesVisit)visit).setElbowPro(Integer.parseInt(rs.getString("elbowPro")));
        ((UpperExtremitiesVisit)visit).setElbowExt(Integer.parseInt(rs.getString("elbowExt")));
        ((UpperExtremitiesVisit)visit).setElbowSup(Integer.parseInt(rs.getString("elbowSup")));
        ((UpperExtremitiesVisit)visit).setWristFlex(Integer.parseInt(rs.getString("wristFlex")));
        ((UpperExtremitiesVisit)visit).setWristAbd(Integer.parseInt(rs.getString("wristAbd")));
        ((UpperExtremitiesVisit)visit).setWristExt(Integer.parseInt(rs.getString("wristExt")));
        ((UpperExtremitiesVisit)visit).setWristAdd(Integer.parseInt(rs.getString("wristAdd")));
        ((UpperExtremitiesVisit)visit).setDropArmTest(rs.getString("dropArmTest"));
        ((UpperExtremitiesVisit)visit).setDrawbarnTest(rs.getString("drawbarnTest"));
        ((UpperExtremitiesVisit)visit).setSupraspinatusTest(rs.getString("supraspinatusTest"));
        ((UpperExtremitiesVisit)visit).setApleyScratchTest(rs.getString("apleyScratchTest"));
        ((UpperExtremitiesVisit)visit).setPostImpingSign(rs.getString("postImpingSign"));
        ((UpperExtremitiesVisit)visit).setSpeedTest(rs.getString("speedTest"));
        ((UpperExtremitiesVisit)visit).setCrossOverImpTest(rs.getString("crossOverImpTest"));
        ((UpperExtremitiesVisit)visit).setYergasonTest(rs.getString("yergasonTest"));
        ((UpperExtremitiesVisit)visit).setApprehensionTest(rs.getString("apprehensionTest"));
        ((UpperExtremitiesVisit)visit).setDrawerTest(rs.getString("drawerTest"));
        ((UpperExtremitiesVisit)visit).setVarusStressTest(rs.getString("varusStressTest"));
        ((UpperExtremitiesVisit)visit).setCozensTest(rs.getString("cozensTest"));
        ((UpperExtremitiesVisit)visit).setValgusStressTest(rs.getString("valgusStressTest"));
        ((UpperExtremitiesVisit)visit).setGolferElbow(rs.getString("golferElbow"));
        ((UpperExtremitiesVisit)visit).setTinelSign(rs.getString("tinelSign"));
        ((UpperExtremitiesVisit)visit).setPinchGripTest(rs.getString("pinchGripTest"));
        ((UpperExtremitiesVisit)visit).setFromentTest(rs.getString("fromentTest"));
        ((UpperExtremitiesVisit)visit).setPhalenTest(rs.getString("phalenTest"));
        ((UpperExtremitiesVisit)visit).setFingerTapTest(rs.getString("fingerTapTest"));
        ((UpperExtremitiesVisit)visit).setFinkelsteninTest(rs.getString("finkelsteninTest"));
        ((UpperExtremitiesVisit)visit).setBunnelLitter(rs.getString("bunnelLitter"));
    }

    private static void setTypeController(iVisit visit) {
        visit.setVisitType("Upper Extremities");
        visit.setController("upperExtremities");
    }

    protected void setVisitProperties(ResultSet rs, iVisit visit) throws SQLException {
        setTypeController(visit);
        setCommonVisitFields(rs, visit);
        setUpperExtremitiesVisitFields(rs, visit);
    }
}
