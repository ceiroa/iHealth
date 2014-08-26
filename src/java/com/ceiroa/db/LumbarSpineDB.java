/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.db;

import com.ceiroa.model.LumbarSpineVisit;
import com.ceiroa.model.iVisit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ceiroa
 */
public class LumbarSpineDB extends abstractVisitDB {

    public static int insert(iVisit visit, String table) {
        int visitId = insertCommon(visit, table);
        if( visitId!=0) {
            if(visit.getDateCreated() != null) {
                updateDateCreated(visit, visitId, "lumbarSpineVisits");
            }
            int success = updateLumbarSpine((LumbarSpineVisit)visit,
                    visitId);
            if(success==1)
                return 1;
        }
        return 0;
    }

    public static int update(iVisit visit, int visitId, String table) {
        int commonUpdateSuccess = updateCommon(visit, visitId, table);
        if( commonUpdateSuccess!=0) {
            int success = updateLumbarSpine(visit, visitId);
            if(success==1)
                return 1;
        }
        return 0;
    }

    public static int updateLumbarSpine(iVisit visit, int visitId) {
        prepare();

        String query = "UPDATE lumbarSpineVisits "
          + "SET flex = ?, ext = ?, llf = ?, rlf = ?, llr = ?, "
          + "rlr = ?, valsavas = ?, straightLeg = ?, "
          + "browstringTest = ?, lasegueTest = ?, elyTest = ?, "
          + "thomasTest = ?, springTest = ?, trenderlenburgTest = ?, "
          + "bilateralLegRaise = ?, pelvicRock = ?, "
          + "patrickFabere = ?, milgram = ?, medLegFoot = ?, "
          + "latLeg = ?, latFoot = ?, patellar = ?, hamstring = ?, "
          + "achilles = ?, antTibialis = ?, extHallucis = ?, "
          + "peroneus = ? WHERE id = " + visitId;
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

        LumbarSpineVisit visit = (LumbarSpineVisit)ivisit;

        ps.setString(1, String.valueOf(visit.getFlex()));
        ps.setString(2, String.valueOf(visit.getExt()));
        ps.setString(3, String.valueOf(visit.getLlf()));
        ps.setString(4, String.valueOf(visit.getRlf()));
        ps.setString(5, String.valueOf(visit.getLlr()));
        ps.setString(6, String.valueOf(visit.getRlr()));
        ps.setString(7, visit.getValsavas());
        ps.setString(8, visit.getStraightLeg());
        ps.setString(9, visit.getBrowstringTest());
        ps.setString(10, visit.getLasegueTest());
        ps.setString(11, visit.getElyTest());
        ps.setString(12, visit.getThomasTest());
        ps.setString(13, visit.getSpringTest());
        ps.setString(14, visit.getTrenderlenburgTest());
        ps.setString(15, visit.getBilateralLegRaise());
        ps.setString(16, visit.getPelvicRock());
        ps.setString(17, visit.getPatrickFabere());
        ps.setString(18, visit.getMilgram());
        ps.setString(19, visit.getMedLegFoot());
        ps.setString(20, visit.getLatLeg());
        ps.setString(21, visit.getLatFoot());
        ps.setString(22, visit.getPatellar());
        ps.setString(23, visit.getHamstring());
        ps.setString(24, visit.getAchilles());
        ps.setString(25, visit.getAntTibialis());
        ps.setString(26, visit.getExtHallucis());
        ps.setString(27, visit.getPeroneus());
    }

    private static void setLumbarSpineVisitFields(ResultSet rs, iVisit visit) throws SQLException {
        setTypeController(visit);
        ((LumbarSpineVisit)visit).setFlex(Integer.parseInt(rs.getString("flex")));
        ((LumbarSpineVisit)visit).setExt(Integer.parseInt(rs.getString("ext")));
        ((LumbarSpineVisit)visit).setLlf(Integer.parseInt(rs.getString("llf")));
        ((LumbarSpineVisit)visit).setRlf(Integer.parseInt(rs.getString("rlf")));
        ((LumbarSpineVisit)visit).setLlr(Integer.parseInt(rs.getString("llr")));
        ((LumbarSpineVisit)visit).setRlr(Integer.parseInt(rs.getString("rlr")));
        ((LumbarSpineVisit)visit).setValsavas(rs.getString("valsavas"));
        ((LumbarSpineVisit)visit).setStraightLeg(rs.getString("straightLeg"));
        ((LumbarSpineVisit)visit).setBrowstringTest(rs.getString("browstringTest"));
        ((LumbarSpineVisit)visit).setLasegueTest(rs.getString("lasegueTest"));
        ((LumbarSpineVisit)visit).setElyTest(rs.getString("elyTest"));
        ((LumbarSpineVisit)visit).setThomasTest(rs.getString("thomasTest"));
        ((LumbarSpineVisit)visit).setSpringTest(rs.getString("springTest"));
        ((LumbarSpineVisit)visit).setTrenderlenburgTest(rs.getString("trenderlenburgTest"));
        ((LumbarSpineVisit)visit).setBilateralLegRaise(rs.getString("bilateralLegRaise"));
        ((LumbarSpineVisit)visit).setPelvicRock(rs.getString("pelvicRock"));
        ((LumbarSpineVisit)visit).setPatrickFabere(rs.getString("patrickFabere"));
        ((LumbarSpineVisit)visit).setMilgram(rs.getString("milgram"));
        ((LumbarSpineVisit)visit).setMedLegFoot(rs.getString("medLegFoot"));
        ((LumbarSpineVisit)visit).setLatLeg(rs.getString("latLeg"));
        ((LumbarSpineVisit)visit).setLatFoot(rs.getString("latFoot"));
        ((LumbarSpineVisit)visit).setPatellar(rs.getString("patellar"));
        ((LumbarSpineVisit)visit).setHamstring(rs.getString("hamstring"));
        ((LumbarSpineVisit)visit).setAchilles(rs.getString("achilles"));
        ((LumbarSpineVisit)visit).setAntTibialis(rs.getString("antTibialis"));
        ((LumbarSpineVisit)visit).setExtHallucis(rs.getString("extHallucis"));
        ((LumbarSpineVisit)visit).setPeroneus(rs.getString("peroneus"));
    }

    private static void setTypeController(iVisit visit) {
        visit.setVisitType("Lumbar Spine");
        visit.setController("lumbarSpine");
    }

    protected void setVisitProperties(ResultSet rs, iVisit visit) throws SQLException {
        setTypeController(visit);
        setCommonVisitFields(rs, visit);
        setLumbarSpineVisitFields(rs, visit);
    }
}
