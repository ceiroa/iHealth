/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.db;

/**
 *
 * @author ceiroa
 */

import com.ceiroa.model.Status;
import com.ceiroa.model.User;
import com.ceiroa.model.UserType;
import java.sql.*;
import java.util.ArrayList;

public class UserDB {
    
    static ConnectionPool pool;
    static Connection connection;
    static PreparedStatement ps;

    public static void prepare() {
        pool = ConnectionPool.getInstance();
        connection = pool.getConnection();
        ps = null;
    }

    public static int insert(String firstName, String lastName,
            String username, String encPassword,
            String userType, String email, String status) {
        prepare();
        
        String query =
          "INSERT INTO users(firstName, lastName, "
          + "username, userType, email, password, status, "
          + "dateCreated, dateUpdated)"
          + " VALUES (?, ?, ?, ?, ?, ?, ?, NULL, NULL)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, username);
            ps.setString(4, userType);
            ps.setString(5, email);
            ps.setString(6, encPassword);
            ps.setString(7, status);
            return ps.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
            return 0;
        
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int update(User user) {
        prepare();

        String query = "UPDATE users SET " +
                "username = ?, " +
                "userType = ?, " +
                "password = ? " +
                "WHERE username = ?";
        try {
            ps = connection.prepareStatement(query);
            setPsStrings(user);
            return ps.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
            return 0;
        
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int deactivate(long id) {
        prepare();

        String query = "UPDATE users " +
                "SET status = 'inactive' WHERE id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(id));

            return ps.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
            return 0;
        
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int activate(long id) {
        prepare();

        String query = "UPDATE users " +
                "SET status = 'active' WHERE id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(id));

            return ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
            return 0;

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int updatePassword(long id, String encPassword) {
        prepare();

        String query = "UPDATE users " +
                "SET password = ? WHERE id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(encPassword));
            ps.setString(2, String.valueOf(id));

            return ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
            return 0;

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean usernameExists(String username) {
        prepare();
        ResultSet rs = null;

        String query = "SELECT username FROM users " +
                "WHERE username = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            return rs.next();
        
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static User selectUser(String username) {
        prepare();
        ResultSet rs = null;

        String query = "SELECT * FROM users " +
                       "WHERE username = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                setUserFields(rs, user);
            }
            return user;
        
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static User selectUserByID(String id) {
        prepare();
        ResultSet rs = null;

        String query = "SELECT * FROM users " +
                       "WHERE id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                setUserFields(rs, user);
            }
            return user;

        } catch (SQLException e){
            e.printStackTrace();
            return null;

        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<User> getUsers() {
        prepare();
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<User>();

        String query = "SELECT * FROM users";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            User user = null;
            while (rs.next()) {
                user = new User();
                setUserFields(rs, user);
                users.add(user);
            }
            return users;
        } catch (SQLException e){
            e.printStackTrace();
            return null;

        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    private static void setPsStrings(User user) throws SQLException {
         ps.setString(1, user.getUsername());
         ps.setString(2, user.getUserType().name());
         ps.setString(3, user.getPassword());
         ps.setString(4, user.getUsername());
         ps.setString(5, user.getStatus().name());
    }

    private static void setUserFields(ResultSet rs, User user) throws SQLException {
        user.setId(Integer.parseInt(rs.getString("id")));
        user.setUsername(rs.getString("username"));
        user.setUserType(UserType.valueOf(rs.getString("userType")));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setStatus(Status.valueOf(rs.getString("status")));
    }

}
