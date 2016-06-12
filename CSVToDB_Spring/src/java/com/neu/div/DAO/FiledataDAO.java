/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.div.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Divyansh
 */
public class FiledataDAO extends DAO {

    Connection conn;
    Statement stmt;
    PreparedStatement prepS;

    public int createTable(ArrayList<String> columns, String attribute) {
        int created = 0;
        try {
            String create = "CREATE TABLE IF NOT EXISTS " + attribute + " (";
            int i = 0;
            while (i < columns.size() - 1) {
                create += (" " + columns.get(i) + " varchar(50) DEFAULT NULL, ");
                i++;
            }
            create += (" " + columns.get(i) + " varchar(50) DEFAULT NULL ) ");
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(create);
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
            Logger.getLogger(FiledataDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return created;
        }
    }

    public int insertData(int size, Map<String, Object> dataToSave, String table) {
        int batchDone = 0;
        try {
            conn = getConnection();
            String queryInsert = "insert into " + table + " values(";
            int i = 0;
            while (i < size - 1) {
                queryInsert += ("?,");
                i++;
            }
            queryInsert += ("?)");
            prepS = conn.prepareStatement(queryInsert);
            int rowNo = 1;
            for (Map.Entry<String, Object> entry : dataToSave.entrySet()) {
                prepS.setString(rowNo, String.valueOf(entry.getValue()));
                rowNo++;
            }
            batchDone = prepS.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FiledataDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return batchDone;
        }
    }

}
