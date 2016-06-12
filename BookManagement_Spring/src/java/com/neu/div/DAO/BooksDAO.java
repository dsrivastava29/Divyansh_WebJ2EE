/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.div.DAO;

import com.neu.div.pojo.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Divyansh
 */
public class BooksDAO extends DAO {
    
    Connection conn;
    PreparedStatement prepS;
    
    public int insertBooks(List<Book> books) {
        int rowsDone = 0;
        try {
            conn = getConnection();
            String queryInsert = "insert into books (isbn, title, authors, price) values(?,?,?,?)";
            prepS = conn.prepareStatement(queryInsert);
            for (Book b : books) {
                prepS.setString(1, b.getIsbn());
                prepS.setString(2, b.getTitle());
                prepS.setString(3, b.getAuthors());
                prepS.setFloat(4, b.getPrice());
                int rowEff = prepS.executeUpdate();
                rowsDone += rowEff;
            }
        } catch (SQLException ex) {
            System.err.print(ex.getCause());
        } finally {
            return rowsDone;            
        }
    }
    
}
