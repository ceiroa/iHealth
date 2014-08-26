/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.db;

import java.io.File;
import java.sql.*;

/**
 *
 * @author martca05
 */
public class FileDB {

    static ConnectionPool pool;
    static Connection connection;
    static PreparedStatement ps;

    public static void prepare() {
        pool = ConnectionPool.getInstance();
        connection = pool.getConnection();
        ps = null;
    }

    public static int insert(String clientId, File file) {
        prepare();

        String query =
          "INSERT INTO uploads(clientId, dateCreated, dateUpdated, filename, filePath)"
          + " VALUES (?, NULL, NULL, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, clientId);
            ps.setString(2, file.getName());
            ps.setString(3, file.getPath());

            return ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
            return 0;

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
