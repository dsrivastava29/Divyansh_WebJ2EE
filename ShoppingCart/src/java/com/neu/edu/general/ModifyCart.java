/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.general;

import com.neu.edu.bean.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Divyansh
 */
public class ModifyCart extends HttpServlet {

    private List<Product> prodList;
    private Set<Product> myProducts;

    public ModifyCart() {
        prodList = LoadProducts.getProducts();
    }

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
        
        HttpSession session = request.getSession();
        if (null != session.getAttribute("myProducts")) {
            myProducts = (Set<Product>) session.getAttribute("myProducts");
        } else {
            myProducts = new HashSet<Product>();
        }
        PrintWriter out = response.getWriter();
        try {
            String actionValue = request.getParameter("action");
            if (actionValue.equalsIgnoreCase("add")) {
                String[] selectedPro = request.getParameterValues("prodName");
                               for (int i = 0; i < selectedPro.length; i++) {
                    for (Product pro : prodList) {
                        if (pro.getName().equals(selectedPro[i])) {
                            myProducts.add(pro);
                            System.out.print(pro.getName());
                        }
                    }
                }
            } else if (actionValue.equalsIgnoreCase("remove")) {
                boolean check = false;
                String removeProduct = request.getParameter("prodName");
                Iterator iterator = myProducts.iterator();
                while (iterator.hasNext()) {
                    if (check) {
                        break;
                    }
                    Product pro = (Product) iterator.next();
                    if (pro.getName().equals(removeProduct)) {
                        myProducts.remove(pro);
                        check = true;
                    }
                }
            }
            else if (actionValue.equalsIgnoreCase("cart")) {
                session.setAttribute("myProducts", myProducts);
            response.sendRedirect("ViewCart.jsp");
            }
            session.setAttribute("myProducts", myProducts);
            response.sendRedirect("ViewProducts.jsp");
        } catch (Exception e) {
            out.println("<a href='ViewCart.jsp'>View Cart</a> || ");
            out.println("<a href='LoadProducts'>HOME</a>");
        }
        response.setContentType("text/html;charset=UTF-8");
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModifyCart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifyCart at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            out.println("<a href='ViewCart.jsp'>View Cart</a>");
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
