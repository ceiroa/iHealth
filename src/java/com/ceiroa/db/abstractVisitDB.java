/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.db;

import com.ceiroa.model.iVisit;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ceiroa
 */
public abstract class abstractVisitDB {

    protected static ConnectionPool pool;
    protected static Connection connection;
    protected static PreparedStatement ps;

    protected abstract void setVisitProperties(ResultSet rs, iVisit visit)  throws SQLException;

    public static void prepare() {
        pool = ConnectionPool.getInstance();
        connection = pool.getConnection();
        ps = null;
    }

    protected static void closeResultSetPrepStatmtFreeConn(ResultSet rs) {
        DBUtil.closeResultSet(rs);
        DBUtil.closePreparedStatement(ps);
        pool.freeConnection(connection);
    }

    protected static void setCommonPsStrings(iVisit visit) throws SQLException {
        ps.setString(1, String.valueOf(visit.getClientId()));
        ps.setString(2, String.valueOf(visit.getDateCreated()));
        ps.setString(3, visit.getSameComplaint());
        ps.setString(4, visit.getPainChange());
        ps.setString(5, visit.getAchingDullSore());
        ps.setString(6, visit.getBurning());
        ps.setString(7, visit.getNumbnessTingling());
        ps.setString(8, visit.getSharpShooting());
        ps.setString(9, visit.getSharpStabbing());
        ps.setString(10, visit.getStiffnessTightness());
        ps.setString(11, visit.getSwelling());
        ps.setString(12, visit.getThrobbing());
        ps.setString(13, visit.getSnapPopGrind());
        ps.setString(14, String.valueOf(visit.getPainLevel()));
        ps.setString(15, visit.getComplaint());
        ps.setString(16, visit.getFrequency());
        ps.setString(17, visit.getInspection());
        ps.setString(18, visit.getPalpation());
        ps.setString(19, visit.getDxAction());
    }

    protected static void setCommonVisitFields(ResultSet rs, iVisit visit) throws SQLException {
        visit.setId(Long.parseLong(rs.getString("id")));
        visit.setClientId(Long.parseLong(rs.getString("clientId")));
        visit.setFirstName(rs.getString("firstName"));
        visit.setLastName(rs.getString("lastName"));
        try {
            visit.setDateCreated(rs.getString("dateCreated"));
        } catch (SQLException e) {
            visit.setDateCreated("");
        }
        try {
            visit.setDateUpdated(rs.getString("dateUpdated"));
        } catch (SQLException e) {
            visit.setDateUpdated("");
        }
        visit.setSameComplaint(rs.getString("sameComplaint"));
        visit.setPainChange(rs.getString("painChange"));
        visit.setAchingDullSore(rs.getString("achingDullSore"));
        visit.setBurning(rs.getString("burning"));
        visit.setNumbnessTingling(rs.getString("numbnessTingling"));
        visit.setSharpShooting(rs.getString("sharpShooting"));
        visit.setSharpStabbing(rs.getString("sharpStabbing"));
        visit.setStiffnessTightness(rs.getString("stiffnessTightness"));
        visit.setSwelling(rs.getString("swelling"));
        visit.setThrobbing(rs.getString("throbbing"));
        visit.setSnapPopGrind(rs.getString("snapPopGrind"));
        visit.setPainLevel(Integer.parseInt(rs.getString("painLevel")));
        visit.setComplaint(rs.getString("complaint"));
        visit.setFrequency(rs.getString("frequency"));
        visit.setDxAction(rs.getString("dxAction"));
        visit.setInspection(rs.getString("inspection"));
        visit.setPalpation(rs.getString("palpation"));
    }

    public static int insertCommon(iVisit visit, String table) {
        prepare();

        String query = "INSERT INTO "+ table + "("
          + "clientId, dateCreated, dateUpdated, sameComplaint, "
          + "painChange, achingDullSore, burning, numbnessTingling, "
          + "sharpShooting, sharpStabbing, stiffnessTightness, swelling, "
          + "throbbing, snapPopGrind, painLevel, complaint, frequency, "
          + "inspection, palpation, dxAction) "
          + "VALUES ("
          + "?, ?, NULL, ?, "
          + "?, ?, ?, ?, "
          + "?, ?, ?, ?, "
          + "?, ?, ?, ?, ?, "
          + "?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);

            setCommonPsStrings(visit);

            int result = ps.executeUpdate();
            if(result==1) {
                ResultSet resultSet = ps.getGeneratedKeys();
                if (resultSet != null && resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
            return 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return 0;

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int updateCommon(iVisit visit, int visitId, String table) {
        prepare();

        String query = "UPDATE "+ table + " SET "
          + "clientId=?, "
          + "dateCreated=?, "
          + "dateUpdated=NULL, "
          + "sameComplaint=?, "
          + "painChange=?, "
          + "achingDullSore=?, "
          + "burning=?, "
          + "numbnessTingling=?, "
          + "sharpShooting=?, "
          + "sharpStabbing=?, "
          + "stiffnessTightness=?, "
          + "swelling=?, "
          + "throbbing=?, "
          + "snapPopGrind=?, "
          + "painLevel=?, "
          + "complaint=?, "
          + "frequency=?, "
          + "inspection=?, "
          + "palpation=?, "
          + "dxAction=? "
          + "WHERE id=" + visitId;
        try {
            ps = connection.prepareStatement(query);

            setCommonPsStrings(visit);

            return ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
            return 0;

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int updateDateCreated(iVisit visit, int visitId, String table) {
        prepare();

        String query = "UPDATE " + table
          + " SET dateCreated=? WHERE id = " + visitId;
        
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, String.valueOf(visit.getDateCreated()));

            return ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
            return 0;

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int deleteVisit(String visitId, String table) {
        prepare();

        String query = "DELETE FROM " + table
          + " WHERE id = " + visitId;

        try {
            ps = connection.prepareStatement(query);
            return ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
            return 0;

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public ArrayList<iVisit> getVisitsForClient(String clientId, String table,
            String visitType) {
        prepare();
        ResultSet rs = null;
        String query = "SELECT * FROM " + table
                + " WHERE clientId=?";

        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, clientId);
            rs = ps.executeQuery();
            
            Class c = Class.forName(visitType);

            while (rs.next()) {
                iVisit visit = (iVisit) c.newInstance();
                setVisitProperties(rs, visit);
                visits.add(visit);
            }
            return visits;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } finally {
            closeResultSetPrepStatmtFreeConn(rs);
        }
    }

    public iVisit getVisitByID(String visitId, String table, String visitType) {
        prepare();
        ResultSet rs = null;
        String query = "SELECT * FROM " + table + ", clients "
                + "WHERE " + table + ".id=? AND "
                + "clients.id=" + table + ".clientId";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, visitId);
            rs = ps.executeQuery();

            Class c = Class.forName(visitType);

            if (rs.next()) {
                iVisit visit = (iVisit) c.newInstance();
                setVisitProperties(rs, visit);
                return visit;
            } else {
                return null;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } finally {
            closeResultSetPrepStatmtFreeConn(rs);
        }
    }

    public iVisit getVisitByClientID(String clientId, String table, String visitType) {
        prepare();
        ResultSet rs = null;
        String query = "SELECT * FROM " + table + ", clients "
                + "WHERE " + table + ".clientId=? AND "
                + "clients.id=" + table + ".clientId "
                + "ORDER BY " + table + ".id DESC LIMIT 1";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, clientId);
            rs = ps.executeQuery();

            Class c = Class.forName(visitType);

            if (rs.next()) {
                iVisit visit = (iVisit) c.newInstance();
                setVisitProperties(rs, visit);
                return visit;
            } else {
                return null;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } finally {
            closeResultSetPrepStatmtFreeConn(rs);
        }
    }

    public ArrayList<iVisit> getAllVisits(String table, String visitType) {
        prepare();
        ResultSet rs = null;
        String query = "SELECT * FROM " + table + ", clients "
                + "WHERE clients.id=" + table + ".clientId";

        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            Class c = Class.forName(visitType);

            while (rs.next()) {
                iVisit visit = (iVisit) c.newInstance();
                setVisitProperties(rs, visit);
                visits.add(visit);
            }
            return visits;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } finally {
            closeResultSetPrepStatmtFreeConn(rs);
        }
    }

    public ArrayList<iVisit> getAllVisitsByDate(String date, String table, String
            visitType) {
        prepare();
        ResultSet rs = null;
        String query = "SELECT * FROM " + table + ", clients "
                + "WHERE clients.id=" + table + ".clientId "
                + "AND dateCreated LIKE ?";

        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, date+"%");
            rs = ps.executeQuery();

            Class c = Class.forName(visitType);

            while (rs.next()) {
                iVisit visit = (iVisit) c.newInstance();
                setVisitProperties(rs, visit);
                visits.add(visit);
            }
            return visits;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } finally {
            closeResultSetPrepStatmtFreeConn(rs);
        }
    }

    public ArrayList<iVisit> getAllVisitsByLastName(String lastName, String table,
            String visitType) {
        prepare();
        ResultSet rs = null;
        String query = "SELECT * FROM " + table + ", clients "
                + "WHERE clients.id=" + table + ".clientId "
                + "AND lastName LIKE ?";

        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%"+lastName+"%");
            rs = ps.executeQuery();

            Class c = Class.forName(visitType);

            while (rs.next()) {
                iVisit visit = (iVisit) c.newInstance();
                setVisitProperties(rs, visit);
                visits.add(visit);
            }
            return visits;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } finally {
            closeResultSetPrepStatmtFreeConn(rs);
        }
    }

    public ArrayList<iVisit> getAllVisitsByFirstName(String firstName, String
            table, String visitType) {
        prepare();
        ResultSet rs = null;
        String query = "SELECT * FROM " + table + ", clients "
                + "WHERE clients.id=" + table + ".clientId "
                + "AND firstName LIKE ?";

        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%"+firstName+"%");
            rs = ps.executeQuery();

            Class c = Class.forName(visitType);

            while (rs.next()) {
                iVisit visit = (iVisit) c.newInstance();
                setVisitProperties(rs, visit);
                visits.add(visit);
            }
            return visits;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } finally {
            closeResultSetPrepStatmtFreeConn(rs);
        }
    }

    public ArrayList<iVisit> getAllVisitsByFirstLastName(String firstName, String
            lastName, String table, String visitType) {
        prepare();
        ResultSet rs = null;
        String query = "SELECT * FROM " + table + ", clients "
                + "WHERE clients.id=" + table + ".clientId "
                + "AND firstName LIKE ? AND lastName LIKE ?";

        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%"+firstName+"%");
            ps.setString(2, "%"+lastName+"%");
            rs = ps.executeQuery();

            Class c = Class.forName(visitType);

            while (rs.next()) {
                iVisit visit = (iVisit) c.newInstance();
                setVisitProperties(rs, visit);
                visits.add(visit);
            }
            return visits;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } finally {
            closeResultSetPrepStatmtFreeConn(rs);
        }
    }

    public ArrayList<iVisit> getAllVisitsByDateLastName(String date,
            String lastName, String table, String visitType) {
        prepare();
        ResultSet rs = null;
        String query = "SELECT * FROM " + table + ", clients "
                + "WHERE clients.id=" + table + ".clientId "
                + "AND dateCreated LIKE ? AND lastName LIKE ?";

        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, date+"%");
            ps.setString(2, "%"+lastName+"%");
            rs = ps.executeQuery();

            Class c = Class.forName(visitType);

            while (rs.next()) {
                iVisit visit = (iVisit) c.newInstance();
                setVisitProperties(rs, visit);
                visits.add(visit);
            }
            return visits;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } finally {
            closeResultSetPrepStatmtFreeConn(rs);
        }
    }

    public ArrayList<iVisit> getAllVisitsByDateFirstName(String date,
            String firstName, String table, String visitType) {
        prepare();
        ResultSet rs = null;
        String query = "SELECT * FROM " + table + ", clients "
                + "WHERE clients.id=" + table + ".clientId "
                + "AND dateCreated LIKE ? AND firstName LIKE ?";

        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, date+"%");
            ps.setString(2, "%"+firstName+"%");
            rs = ps.executeQuery();

            Class c = Class.forName(visitType);

            while (rs.next()) {
                iVisit visit = (iVisit) c.newInstance();
                setVisitProperties(rs, visit);
                visits.add(visit);
            }
            return visits;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } finally {
            closeResultSetPrepStatmtFreeConn(rs);
        }
    }

    public ArrayList<iVisit> getAllVisitsByDateFirstLastName(String date,
            String firstName, String lastName, String table, String visitType) {
        prepare();
        ResultSet rs = null;
        String query = "SELECT * FROM " + table + ", clients "
                + "WHERE clients.id=" + table + ".clientId "
                + "AND dateCreated LIKE ? AND firstName LIKE ? "
                + "AND lastName LIKE ?";

        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, date+"%");
            ps.setString(2, "%"+firstName+"%");
            ps.setString(3, "%"+lastName+"%");
            rs = ps.executeQuery();

            Class c = Class.forName(visitType);
            
            while (rs.next()) {
                iVisit visit = (iVisit) c.newInstance();
                setVisitProperties(rs, visit);
                visits.add(visit);
            }
            return visits;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(abstractVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } finally {
            closeResultSetPrepStatmtFreeConn(rs);
        }
    }
}
