/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.general;

import com.neu.edu.bean.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Divyansh
 */
public class LoadProducts extends HttpServlet {

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
        
        List<Product> listOfProducts=new ArrayList<>();
        listOfProducts=getProducts();
        System.out.println(""+listOfProducts);
        List<Product> outputPro=new ArrayList<>();
        String productType=request.getParameter("prodType");
        if(null==productType){
            productType=Product.BOOKS;
            System.out.println(""+"hre");
        }
        
        
        for(Product prod:listOfProducts){
            if(prod.getType().equals(productType)){
                outputPro.add(prod);
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Available Courses are:</title>");            
             out.println("<meta charset='utf-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>");
		out.println("<script>function checkform(){");
out.println("var chks = document.getElementsByTagName('input');");
out.println("for (var i=0;i<chks.length;i++)");
out.println("{");
   out.println("if (chks[i].getAttribute('type') == 'checkbox')");
   out.println("{");
      out.println("if (chks[i].checked){	"); 
         out.println("return true;		"); 
		 out.println("}		 		 ");
   out.println("}  ");
out.println("}");
out.println("return false;");
out.println("}</script>");
                    out.println("</head>");
            out.println("<body><div class='container' align='center'><form  onsubmit='return checkform()' method='post'  action='AddToCart.do' >");
            out.println("<div class='panel panel-default' style='position: relative;'>");
out.println("<div class='panel-body' style='background-color: lightblue;' ><h3>Welcome to CrazyDiv Web Shopping Mall</h3>");
out.println("</div>");
out.println("</div>");
out.println("<nav class='navbar navbar-inverse'>");
out.println("<div class='container-fluid'>");
out.println("<ul class='nav navbar-nav'>");
out.println("<li><a href='LoadProducts?prodType="+Product.BOOKS+"'>Books</a></li>");
out.println("<li><a href='LoadProducts?prodType="+Product.MUSIC+"'>Music</a></li> ");
out.println("<li><a href='LoadProducts?prodType="+Product.COMP+"'>Computers</a></li>"); 
out.println("</ul>");
out.println("<ul class='nav navbar-nav navbar-right'>");
out.println("<li><a href='ModifyCart?action=cart' vlink=#FFFFFF><span class='glyphicon glyphicon-shopping-cart'></span> View Cart</a></li>");
out.println("</ul>");
out.println("</div>");
out.println("</nav>");
            out.println("<table class='table table-bordered'>");
            out.println("<thead><th>Select</th><th>Product</th><th>Price</th></thead>");
            for(Product pro:outputPro){
                out.println("<tr>");
                float price=pro.getPrice();
                String name=pro.getName();
                out.println("<td><input type='checkbox' name='prodName' value='"+name+"'/></td><td>"+name+"</td><td>"+price+"</td>");
                
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<input type='hidden' name='action' value='add' />");
            out.println("<input type='hidden' name='prodType' value='"+Product.BOOKS+"' />");
            out.println("<br/><p><button type='submit' class='btn btn-default' >Add to cart >></button></p>");
            out.println("</form>");
            
            out.println("</body>");
            out.println("</html>");
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

    public static List<Product>getProducts(){
        List<Product>productList=new ArrayList<>();
        
        Product p1=new Product();
        p1.setType(Product.BOOKS);
        p1.setName("Java Programming");
        p1.setPrice(50.00f);
        productList.add(p1);
        
        Product p2=new Product();
        p2.setType(Product.BOOKS);
        p2.setName("Database design");
        p2.setPrice(60.00f);
        productList.add(p2);
        
        Product p3=new Product();
        p3.setType(Product.BOOKS);
        p3.setName("Web Design made easy");
        p3.setPrice(70.00f);
        productList.add(p3);
        
        Product p4=new Product();
        p4.setType(Product.MUSIC);
        p4.setName("Hell is well");
        p4.setPrice(20.00f);
        productList.add(p4);
        
        Product p5=new Product();
        p5.setType(Product.MUSIC);
        p5.setName("Instrumentals");
        p5.setPrice(15.00f);
        productList.add(p5);
        
        Product p6=new Product();
        p6.setType(Product.MUSIC);
        p6.setName("Alifaa");
        p6.setPrice(35.00f);
        productList.add(p6);
        
        Product p7=new Product();
        p7.setType(Product.MUSIC);
        p7.setName("Rock on");
        p7.setPrice(66.00f);
        productList.add(p7);
        
        Product p8=new Product();
        p8.setType(Product.COMP);
        p8.setName("Apple Macbook Pro");
        p8.setPrice(890.00f);
        productList.add(p8);
        
        Product p9=new Product();
        p9.setType(Product.COMP);
        p9.setName("Dell inspiron");
        p9.setPrice(650.00f);
        productList.add(p9);
        
        Product p10=new Product();
        p10.setType(Product.COMP);
        p10.setName("TOSHIBA satellite laptop");
        p10.setPrice(540.00f);
        productList.add(p10);
        
        return productList;
    }
}
