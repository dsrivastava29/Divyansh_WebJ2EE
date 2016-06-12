/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.div.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author Divyansh
 */
public class CsvDAO {

    private String driver;
    private String dburl;
    private Connection conn = null;
    private static int rowsperpage = 100;

    public CsvDAO() {
        driver = "org.relique.jdbc.csv.CsvDriver";
        dburl = "jdbc:relique:csv:";
    }

    private Connection getConnection(String fileName) {
        dburl = dburl + fileName;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dburl);
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public List<Map<String, Object>> getFileData(String tableName, String filePath, int page) {
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        try {
            ResultSet result = readFile(tableName, filePath, page);
            ResultSetMetaData metaData = result.getMetaData();
            int columnCount = metaData.getColumnCount();
            String s;
            boolean brk = false;
            while (result.next()) {
                Map<String, Object> columns = new LinkedHashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    s = (String) result.getObject(i);
                    if (i == 1) {
                        if (s == null || s.equalsIgnoreCase("")) {
                            brk = true;
                            break;
                        }
                    }
                    columns.put(metaData.getColumnLabel(i), result.getObject(i));
                }
                if (brk) {
                    break;
                }
                rows.add(columns);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CsvDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return rows;
        }
    }

    private ResultSet readFile(String filename, String path, int pageindex) {
        ResultSet rs = null;
        try {
            if (conn == null) {
                conn = getConnection(path);
            }
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM " + filename + " ORDER BY 1 LIMIT " + rowsperpage + " OFFSET " + (rowsperpage * (pageindex - 1)) + ";";
            //SELECT [columns] FROM [table names] ORDER BY [column name] DESC LIMIT 10 OFFSET 10;
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(CsvDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getCause());
        } finally {
            close(null);
            return rs;
        }
    }

    public void close(Connection connection) {
        if (connection != null) {
            try {
                DbUtils.close(connection);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
