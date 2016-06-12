/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.controller;

import com.neu.edu.beans.BookBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Divyansh
 */
public class BookAction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = null;
        Connection con = null;
        PreparedStatement pStmt = null;
        ResultSet res = null;
        PrintWriter out = response.getWriter();
        try {

            String work = request.getParameter("work");

            if (work.equalsIgnoreCase("generate")) {
                int bkcount = Integer.parseInt(request.getParameter("bkcount"));
                String user = (String) request.getAttribute("user");
                String setName = "Guest";
                if (user != null && (!user.trim().equals(""))) {
                    setName = user;
                }
                session = request.getSession();
                session.setAttribute("user", setName);
                session.setAttribute("numberbk", bkcount);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/AddBooksView.jsp");
                rd.forward(request, response);
            } else if (work.equalsIgnoreCase("insert")) {
                session = request.getSession();
                con = DBConnection.getConnectionJDBC();
                ArrayList<BookBean> bList = new ArrayList<>();
                bList = (ArrayList<BookBean>) request.getAttribute("booksList");
                String queryInsert = "insert into books (isbn, title, authors, price) values(?,?,?,?)";
                pStmt = con.prepareStatement(queryInsert);
                int rowsDone = 0;
                for (BookBean b : bList) {
                    pStmt.setString(1, b.getIsbn());
                    pStmt.setString(2, b.getTitle());
                    pStmt.setString(3, b.getAuthors());
                    pStmt.setFloat(4, b.getPrice());
                    int rowEff = pStmt.executeUpdate();
                    rowsDone += rowEff;
                }
                if (rowsDone > 0) {
                    session.setAttribute("rows", rowsDone);
                    session.setAttribute("booksList", bList);
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/ViewNewBooks.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (Exception e) {
            session.setAttribute("rows", 0);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/ViewNewBooks.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
