/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.db;

import com.ceiroa.model.Client;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ceiroa
 */
public class ClientDB {

    static ConnectionPool pool;
    static Connection connection;
    static PreparedStatement ps;

    public static void prepare() {
        pool = ConnectionPool.getInstance();
        connection = pool.getConnection();
        ps = null;
    }

    public static int insert(Client client) {
        prepare();

        String query =
          "INSERT INTO clients"
          + "(firstname, "
          + "middleInitial, "
          + "lastname, "
          + "gender, "
          + "address, "
          + "city, "
          + "usState, "
          + "zipcode, "
          + "email, "
          + "referrer, "
          + "homePhone, "
          + "cellPhone, "
          + "workPhone, "
          + "dob, "
          + "ssn, "
          + "driverLicense,"
          + "employer, "
          + "occupation, "
          + "employerAddress, "
          + "employerPhoneNum, "
          + "contactName, "
          + "contactRelation, "
          + "contactPhone, "
          + "insurance, "
          + "insuranceAddress, "
          + "policyHolderName, "
          + "policyHolderAddress, "
          + "policyHolderDob, "
          + "policyHolderSsn, "
          + "policyNumber, "
          + "groupNumber, "
          + "policyHolderRelation, "
          + "insurance2, "
          + "insuranceAddress2, "
          + "policyHolderName2, "
          + "policyHolderAddress2, "
          + "policyHolderDob2, "
          + "policyHolderSsn2, "
          + "policyNumber2, "
          + "groupNumber2, "
          + "policyHolderRelation2, "
          + "accidentInfo, "
          + "compInfo)"
          + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                  + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                  + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            setPsStrings(client);
            return ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
            return 0;

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int update(Client client) {
        prepare();

        String query = "UPDATE clients SET "
                + "firstName = ?, "
                + "middleInitial = ?, "
                + "lastName = ?, "
                + "gender = ?, "
                + "address = ?, "
                + "city = ?, "
                + "usState = ?, "
                + "zipcode = ?, "
                + "email = ?, "
                + "referrer = ?, "
                + "homePhone = ?, "
                + "cellPhone = ?, "
                + "workPhone = ?, "
                + "dob = ?, "
                + "ssn = ?, "
                + "driverLicense = ?,"
                + "employer = ?, "
                + "occupation = ?, "
                + "employerAddress = ?, "
                + "employerPhoneNum = ?, "
                + "contactName = ?, "
                + "contactRelation = ?, "
                + "contactPhone = ?, "
                + "insurance = ?, "
                + "insuranceAddress = ?, "
                + "policyHolderName = ?, "
                + "policyHolderAddress = ?, "
                + "policyHolderDob = ?, "
                + "policyHolderSsn = ?, "
                + "policyNumber = ?, "
                + "groupNumber = ?, "
                + "policyHolderRelation = ?, "
                + "insurance2 = ?, "
                + "insuranceAddress2 = ?, "
                + "policyHolderName2 = ?, "
                + "policyHolderAddress2 = ?, "
                + "policyHolderDob2 = ?, "
                + "policyHolderSsn2 = ?, "
                + "policyNumber2 = ?, "
                + "groupNumber2 = ?, "
                + "policyHolderRelation2 = ?, "
                + "accidentInfo = ?, "
                + "compInfo  = ?"
                + "WHERE id = ?";

        try {
            ps = connection.prepareStatement(query);
            setPsStrings(client);
            ps.setString(44, String.valueOf(client.getId()));
            return ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
            return 0;

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(String id) {
        prepare();

        String query = "DELETE FROM clients "
                + "WHERE id = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            return ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
            return 0;

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean ssnExists(String ssn) {
        prepare();
        ResultSet rs = null;

        String query = "SELECT ssn FROM clients " +
                "WHERE ssn = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ssn);
            rs = ps.executeQuery();
            return rs.next();

        } catch(SQLException e) {
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static Client selectClientByID(String id) {
        prepare();
        ResultSet rs = null;

        String query = "SELECT * FROM clients " +
                       "WHERE id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            Client client = null;
            if (rs.next()) {
                client = new Client();
                setClientFields(rs, client);
            }
            return client;

        } catch (SQLException e){
            e.printStackTrace();
            return null;

        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Client> getClients() {
        prepare();
        ResultSet rs = null;
        ArrayList<Client> clients = new ArrayList<Client>();

        String query = "SELECT * FROM clients";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Client client = null;
            while (rs.next()) {
                client = new Client();
                setClientFields(rs, client);
                clients.add(client);
            }
            return clients;
        } catch (SQLException e){
            e.printStackTrace();
            return null;

        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Client> getClientsByLastName(String lastName) {
        prepare();
        ResultSet rs = null;
        ArrayList<Client> clients = new ArrayList<Client>();

        String query = "SELECT * FROM clients WHERE lastName LIKE ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%"+lastName+"%");
            rs = ps.executeQuery();
            Client client = null;
            while (rs.next()) {
                client = new Client();
                setClientFields(rs, client);
                clients.add(client);
            }
            return clients;
        } catch (SQLException e){
            e.printStackTrace();
            return null;

        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Client> getClientsByFirstName(String firstName) {
        prepare();
        ResultSet rs = null;
        ArrayList<Client> clients = new ArrayList<Client>();

        String query = "SELECT * FROM clients WHERE firstName LIKE ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%"+firstName+"%");
            rs = ps.executeQuery();
            Client client = null;
            while (rs.next()) {
                client = new Client();
                setClientFields(rs, client);
                clients.add(client);
            }
            return clients;
        } catch (SQLException e){
            e.printStackTrace();
            return null;

        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Client> getClientsByFirstAndLastName(String firstName, String lastName) {
        prepare();
        ResultSet rs = null;
        ArrayList<Client> clients = new ArrayList<Client>();

        String query = "SELECT * FROM clients WHERE firstName LIKE ? AND "
                + "lastName LIKE ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%"+firstName+"%");
            ps.setString(2, "%"+lastName+"%");
            rs = ps.executeQuery();
            Client client = null;
            while (rs.next()) {
                client = new Client();
                setClientFields(rs, client);
                clients.add(client);
            }
            return clients;
        } catch (SQLException e){
            e.printStackTrace();
            return null;

        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    private static void setPsStrings(Client client) throws SQLException {
        ps.setString(1, client.getFirstName());
        ps.setString(2, client.getMiddleInitial());
        ps.setString(3, client.getLastName());
        ps.setString(4, client.getGender());
        ps.setString(5, client.getAddress());
        ps.setString(6, client.getCity());
        ps.setString(7, client.getState());
        ps.setString(8, client.getZipcode());
        ps.setString(9, client.getEmail());
        ps.setString(10, client.getReferrer());
        ps.setString(11, client.getHomePhone());
        ps.setString(12, client.getCellPhone());
        ps.setString(13, client.getWorkPhone());
        ps.setString(14, client.getDob());
        ps.setString(15, client.getSsn());
        ps.setString(16, client.getDriverLicense());
        ps.setString(17, client.getEmployer());
        ps.setString(18, client.getOccupation());
        ps.setString(19, client.getEmployerAddress());
        ps.setString(20, client.getEmployerPhoneNum());
        ps.setString(21, client.getContactName());
        ps.setString(22, client.getContactRelation());
        ps.setString(23, client.getContactPhone());
        ps.setString(24, client.getInsurance());
        ps.setString(25, client.getInsuranceAddress());
        ps.setString(26, client.getPolicyHolderName());
        ps.setString(27, client.getPolicyHolderAddress());
        ps.setString(28, client.getPolicyHolderDob());
        ps.setString(29, client.getPolicyHolderSsn());
        ps.setString(30, client.getPolicyNumber());
        ps.setString(31, client.getGroupNumber());
        ps.setString(32, client.getPolicyHolderRelation());
        ps.setString(33, client.getInsurance2());
        ps.setString(34, client.getInsuranceAddress2());
        ps.setString(35, client.getPolicyHolderName2());
        ps.setString(36, client.getPolicyHolderAddress2());
        ps.setString(37, client.getPolicyHolderDob2());
        ps.setString(38, client.getPolicyHolderSsn2());
        ps.setString(39, client.getPolicyNumber2());
        ps.setString(40, client.getGroupNumber2());
        ps.setString(41, client.getPolicyHolderRelation2());
        ps.setString(42, client.getAccidentInfo());
        ps.setString(43, client.getCompInfo());
    }

    private static void setClientFields(ResultSet rs, Client client) throws SQLException {
        client.setId(Long.parseLong(rs.getString("id")));
        client.setFirstName(rs.getString("firstName"));
        client.setMiddleInitial(rs.getString("middleInitial"));
        client.setLastName(rs.getString("lastName"));
        client.setGender(rs.getString("gender"));
        client.setAddress(rs.getString("address"));
        client.setCity(rs.getString("city"));
        client.setState(rs.getString("usState"));
        client.setZipcode(rs.getString("zipcode"));
        client.setEmail(rs.getString("email"));
        client.setReferrer(rs.getString("referrer"));
        client.setHomePhone(rs.getString("homePhone"));
        client.setCellPhone(rs.getString("cellPhone"));
        client.setWorkPhone(rs.getString("workPhone"));
        client.setDob(rs.getString("dob"));
        client.setSsn(rs.getString("ssn"));
        client.setDriverLicense(rs.getString("driverLicense"));
        client.setEmployer(rs.getString("employer"));
        client.setOccupation(rs.getString("occupation"));
        client.setEmployerAddress(rs.getString("employerAddress"));
        client.setEmployerPhoneNum(rs.getString("employerPhoneNum"));
        client.setContactName(rs.getString("contactName"));
        client.setContactRelation(rs.getString("contactRelation"));
        client.setContactPhone(rs.getString("contactPhone"));
        client.setInsurance(rs.getString("insurance"));
        client.setInsuranceAddress(rs.getString("insuranceAddress"));
        client.setPolicyHolderName(rs.getString("policyHolderName"));
        client.setPolicyHolderAddress(rs.getString("policyHolderAddress"));
        client.setPolicyHolderDob(rs.getString("policyHolderDob"));
        client.setPolicyHolderSsn(rs.getString("policyHolderSsn"));
        client.setPolicyNumber(rs.getString("policyNumber"));
        client.setGroupNumber(rs.getString("groupNumber"));
        client.setPolicyHolderRelation(rs.getString("policyHolderRelation"));
        client.setInsurance2(rs.getString("insurance2"));
        client.setInsuranceAddress2(rs.getString("insuranceAddress2"));
        client.setPolicyHolderName2(rs.getString("policyHolderName2"));
        client.setPolicyHolderAddress2(rs.getString("policyHolderAddress2"));
        client.setPolicyHolderDob2(rs.getString("policyHolderDob2"));
        client.setPolicyHolderSsn2(rs.getString("policyHolderSsn2"));
        client.setPolicyNumber2(rs.getString("policyNumber2"));
        client.setGroupNumber2(rs.getString("groupNumber2"));
        client.setPolicyHolderRelation2(rs.getString("policyHolderRelation2"));
        client.setAccidentInfo(rs.getString("accidentInfo"));
        client.setCompInfo(rs.getString("compInfo"));
    }
}
