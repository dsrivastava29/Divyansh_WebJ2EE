/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.controller;

import com.neu.edu.beans.MovieBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MovieController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            con = DBConnection.getConnectionJDBC();
            HttpSession session = request.getSession();

            if (null == request.getParameter("searchby")) {
                String title = (String) request.getAttribute("title");
                String lactor = (String) request.getAttribute("lactor");
                String lactress = (String) request.getAttribute("lactress");
                String genre = (String) request.getAttribute("genre");
                int year = (int)(request.getAttribute("year"));

                MovieBean mb = new MovieBean();
                mb.setTitle(title);
                mb.setActor(lactor);
                mb.setActress(lactress);
                mb.setGenre(genre);
                mb.setYear(year);
                String queryInsert = "insert into movies (title, actor, actress, genre,year) values('" + title + "', '" + lactor + "', '" + lactress + "', '" + genre + "', '" + year + "')";
                stmt = con.createStatement();
                int result = stmt.executeUpdate(queryInsert);
                if (result > 0) {
                    session.setAttribute("newmovie", mb);
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/ViewNewMovie.jsp");
                    rd.forward(request, response);
                }
            } else {
                ArrayList<MovieBean> mbList = new ArrayList<>();
                String keyword = (String) request.getAttribute("keyword");
                String searchby = (String) request.getParameter("searchby");
                String selectQuery ="";
                if(searchby.equalsIgnoreCase("all")){
                     selectQuery = "select DISTINCT * from movies;";
                }
                else{
                     selectQuery = "select DISTINCT * from movies where " + searchby + " = '" + keyword + "';";
                }
                
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(selectQuery);
                while (rs.next()) {
                    MovieBean mb = new MovieBean();
                    mb.setTitle(rs.getString("title"));
                    mb.setActor(rs.getString("actor"));
                    mb.setActress(rs.getString("actress"));
                    mb.setGenre(rs.getString("genre"));
                    mb.setYear(rs.getInt("year"));
                    mbList.add(mb);
                }
                session.setAttribute("movieList", mbList);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/ViewSearchMovies.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            ArrayList<MovieBean> mbList = new ArrayList<>();
            request.getSession().setAttribute("movieList", mbList);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/ViewSearchMovies.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
