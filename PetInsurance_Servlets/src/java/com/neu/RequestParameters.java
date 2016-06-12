/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Divyansh
 */
public class RequestParameters extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html>");
        out.println("    <head>");
        out.println("<title>View Submitted Pet Insurance Form</title>");
        out.println("<meta charset='utf-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>");
        out.println("<script src='./UIHelper.js'></script>");
        out.println("</head>");
        out.println("<body style='background-color: #6495ED'>");
        out.println("    <form action='form.do' method='post' >");
        out.println("            <div class='container'>");
        out.println("               <table class='table table-bordered'>");
        out.println("                   <thead>");
        out.println("                       <tr>");
        out.println("                           <th style='background-color: #000000;'>");
        out.println("                               <font style='color: #FFFFFF'>");
        out.println("                   <h1>ASPCA</h1>");
        out.println("<h3>Pet Health insurance</h3>");
        out.println("</font>");
        out.println("</th>");

        out.println("<th>_______________________________________________</th>");
        out.println("<th style='background-color: #000000;'>");
        out.println("<font style='color: #FFFFFF'> HAVE A QUESTION?");
        out.println("<br/>Call us at 1-866-204-6764");
        out.println("</font>");
        out.println("</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("</table>");

        out.println("<div class='panel panel-default' style='position: relative;'>");
        out.println("<div class='panel-body'><h3>CLAIM FORM</h3>");
        out.println("PLEASE INCLUDE YOUR PET'S MEDICAL RECORDS TO HELP EXPEDITE PROCESSING.");

        out.println("                    </div>");
        out.println("               </div>");
        out.println("<div class='panel-group' style='width: 100%; float: left;  background: whitesmoke;'>");

        out.println("   <div class='panel panel-default'>");
        out.println("       <div class='panel-heading' style='background-color:white; height: 50px;background: #000000; color: #FFFFFF'>");

        out.println("           <h2 class='panel-title' style='font-size: 20px; width: 60%; float: left;'>");
        out.println("               <b><a data-toggle='collapse' href='#collapse1'>1. General Information >></a></b>");
        out.println("           </h2>");
        out.println("<p style='font-size: 12px; width: 40%; float: right;   '>");
        out.println("Please fill out this form completely. Incomplete forms will delay processing.");
        out.println("</p>");
        out.println("</div>");
        out.println("<div id='collapse1' class='panel-collapse collapse in'>");
        out.println("<div class='panel-body'>");
        out.println("<table class='table' style='border: 1px;'>");

        out.println("   <tr>");
        out.println("       <th>");
        out.println("   <div class='form-group'>");
        out.println("       <b>Your Information</b>");
        out.println("       <div class='checkbox'>");
        out.println("           <label><input type='checkbox' name='newaddr' value=''>Check here if this is a new address</label>");
        out.println("       </div>                                       ");
        out.println("  </div>");
        out.println("  </th>");
        out.println("   <th>");
        out.println("      <b>Pet Information</b>");
        out.println("  </th>");
        out.println("  </tr>");
        out.println("  <tr>");
        out.println("      <td>");
        out.println("          <div class='form-group'>");
        out.println("              <label for='usr'>Name:</label>");
        out.println("             <input type='text' class='form-control' onBlur='check(this)' name='name' id='name' placeholder='Enter your name' required>");
        out.println("             <label for='pwd'>Address:</label>");
        out.println("             <input type='text' class='form-control' onBlur='check(this)' name='address' id='address' placeholder='Enter your address' required>");
        out.println("             <label for='pwd'>City, State, Zip:</label>");
        out.println("             <input type='text' class='form-control' onBlur='check(this)' name='city' id='city'  placeholder='Enter your city, state, zip' required>");
        out.println("             <label for='pwd'>Phone:</label>");
        out.println("             <input type='text' class='form-control' onBlur='check(this)' name='phone'  placeholder='Enter your phone number' required>");
        out.println("            <label for='pwd'>Email:</label>");
        out.println("            <input type='text' class='form-control' name='email' id='email'  placeholder='Enter your email' required>");
        out.println("        </div>");
        out.println("    </td>");
        out.println("     <td>");
        out.println("         <div class='form-group'>");
        out.println("             <label for='usr'>Account Number:</label>");
        out.println("             <input type='text' onBlur='check(this)' class='form-control' name='acct'   placeholder='Enter your account number'>");
        out.println("             <label for='pwd'>Name:</label>");
        out.println("             <input type='text' onBlur='check(this)' class='form-control' name='petname'  placeholder='Enter your pets name'>");
        out.println("             <label for='pwd'>Breed:</label>");
        out.println("             <input type='text' onBlur='check(this)' class='form-control' name='breed'  placeholder='Enter your pets breed'>");
        out.println("             <label for='pwd'>Age:</label>");
        out.println("             <input type='text' onBlur='check(this)' class='form-control' name='age'  placeholder='Enter your pets age'>");
        out.println("             <label for='pwd'>Gender:</label>");
        out.println("             <input type='text' onBlur='check(this)' class='form-control' name='gender'  placeholder='Enter your pets gender'>");
        out.println("         </div>");
        out.println("     </td>");
        out.println(" </tr>");
        out.println("</table>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");

        out.println("                   <div class='panel panel-default'>");
        out.println("<div class='panel-heading' style='background-color:white; height: 50px;background: #000000; color: #FFFFFF'>");

        out.println("<h2 class='panel-title' style='font-size: 20px; width: 60%; float: left;'>");
        out.println("                                <b> <a data-toggle='collapse' href='#collapse2'>2. Diagnosis/Symptom Information >></a></b>");
        out.println("                            </h2>");
        out.println("                           <p style='font-size: 12px; width: 40%; float: right;   '>");
        out.println("HELP US! By providing the 'Story of Occurrence/Diagnosis,' you will help");
        out.println("us avoid delays in processing your claim.");
        out.println("</p>");
        out.println("</div>");
        out.println("<div id='collapse2' class='panel-collapse collapse'>");
        out.println("<div class='panel-body'>");
        out.println("<div class='container inner-container'>");
        out.println("<b>Story of Occurrence/Diagnosis - Please describe this incident, including dates, details and symptoms leading up to it.");
        out.println("</b>   <br/>");
        out.println("<textarea class='form-control' rows='4' style='width: 60%;' name='description' placeholder='Describe here'></textarea>");
        out.println("</div>");
        out.println("<table  class='table'>");
        out.println("<tr>");
        out.println("    <td>");
        out.println("        <div class='form-group'>");
        out.println("            <label for='usr'>This claim is related to:</label>");
        out.println("                                                <div class='checkbox-inline'>");
        out.println("                                                    <label><input type='checkbox' name='claimtype' value=''>Accident</label>");
        out.println("                                  </div>");
        out.println("                                  <div class='checkbox-inline'>");
        out.println("                                      <label><input type='checkbox' name='claimtype' value=''>Illness</label>");
        out.println("                                  </div>");
        out.println("                                                <div class='checkbox-inline'>");
        out.println("                                                    <label><input type='checkbox' name='claimtype' value=''>Wellness</label>");
        out.println("                                                </div>");
        out.println("                                            </div>            ");
        out.println("                              <br>");
        out.println("                              <label for='pwd'>Is this claim an estimate for future treatment?</label>");
        out.println("                                            <input type='radio' name='estimate' value='Yes' checked> Yes");
        out.println("                                            <input type='radio' name='estimate' value='No'> No<br>");
        out.println("                                            <br>");
        out.println("                                            <label for='pwd'>Total amount claimed: </label>");
        out.println("                                            <input type='text' class='form-control' name='amount' id='amount' placeholder='Amoiunt claimed'>");
        out.println("                                            <label for='pwd'>Date illness/injury first occurred:</label>");
        out.println("                                            <input type='date' class='form-control-inline datepicker' name='illdate' value='2016-01-25'><br/>");
        out.println("                                            <label for='pwd'>Send payment to: </label>");
        out.println("                                            <input type='radio' name='payto' value='Yes' checked> Me");
        out.println("                                            <input type='radio' name='payto' value='Veterinarian'> Veterinarian<br>");
        out.println("                                            <br>");
        out.println("<br>");

        out.println("</td>");
        out.println("<td>");
        out.println("<div class='form-group'>");
        out.println("<label for='usr'>Veterinarian:</label>");
        out.println("<input type='text' class='form-control' name='veterinarian' placeholder='Veterinarian name'>");
        out.println("<label for='pwd'>Clinic Name:</label>");
        out.println("<input type='text' class='form-control' name='clinic' placeholder='Clinic name' >");
        out.println("<label for='pwd'>Phone:</label>");
        out.println("<input type='text' class='form-control' name='phone' placeholder='Phone' >");
        out.println("<label for='pwd'>Fax:</label>");
        out.println("<input type='text' class='form-control' name='fax' placeholder='Fax' >");
        out.println("<label for='pwd'>Did any other veterinarian treat your pet?:</label>");
        out.println("<input type='radio' name='pretreat' value='Yes' checked> Yes");
        out.println("<input type='radio' name='pretreat' value='No'> No<br>");
        out.println("<label for='pwd'>Is this a new condition?: </label>");
        out.println("<input type='radio' name='newcond' value='Yes' checked> Yes");
        out.println("<input type='radio' name='newcond' value='No'> No<br>");

        out.println("                                            </div>");
        out.println("                                        </td>");
        out.println("                                    </tr>");
        out.println("                                </table>");
        out.println("                            </div>");
        out.println("                            <div class='panel-footer'>HELP US! By providing the 'Story of Occurrence/Diagnosis,' you will help");
        out.println("                                us avoid delays in processing your claim.</div>");
        out.println("                        </div>");
        out.println("                    </div>");

        out.println("                    <div class='panel panel-default'>");
        out.println("                        <div class='panel-heading' style='background-color:white; height: 50px;background: #000000; color: #FFFFFF'>");
        out.println("                            <h2 class='panel-title' style='font-size: 20px;'>");
        out.println("                                <b>  <a data-toggle='collapse' href='#collapse3'>3. Pet Owner Declaration >></a> </b>");
        out.println("                            </h2>");
        out.println("                        </div>");
        out.println("                        <div id='collapse3' class='panel-collapse collapse'>");
        out.println("                            <div class='panel-body'>");
        out.println("                                <textarea class='form-control' rows='4' readonly>I confirm to the best of my knowledge the above statements are true in every respect. I understand that the fees listed may not be covered or may exceed my plan benefit. I understand that I am financially responsible to my veterinarian for the entire treatment. I understand that this claim");
        out.println("cannot be adjusted without itemized receipts. I also understand that the deliberate misrepresentation of the animal's condition or the omission of any material facts may result in the denial of the claim and/or the cancellation of coverage. I authorize United States Fire Insurance Company and");
        out.println("its business partners to review and obtain a copy of ALL RECORDS including the insurance claim records and medical records as to examination, history, diagnosis, treatment and prognosis with respect to any condition. I further authorize these entities to disclose identifying information about me and my pet, as well as information about my claim experience, to my veterinarian.");
        out.println("                                </textarea>");
        out.println("                                <div class='form-group'>");
        out.println("                                    <label for='usr'>Signature:</label>");
        out.println("                                    <input type='text' class='form-control-inline' name='sign' id='sign'>");
        out.println("                                    <label for='pwd'>Date:</label>");
        out.println("                                    <input type='date' class='form-control-inline datepicker' name='date' value='2016-01-25'>");
        out.println("                                    <div class='checkbox'>");
        out.println("                                        <label><input type='checkbox' name='petagree' value='' required>Click to confirm</label>");
        out.println("                                    </div>        ");

        out.println("                                </div>");
        out.println("                            </div>");
        out.println("                            <div class='panel-footer'>");
        out.println("                                Please read IMPORTANT NOTICE document that follows for additional information.");
        out.println("                            </div>");
        out.println("                        </div>");
        out.println("                    </div>");

        out.println("                    <div class='panel panel-default'>");
        out.println("                        <div class='panel-heading' style='background-color:white; height: 50px;background: #000000; color: #FFFFFF'>");
        out.println("                            <h2 class='panel-title' style='font-size: 20px;'>");
        out.println("                                <b>  <a data-toggle='collapse' href='#collapse4'>4. Easy Ways to Submit a Claim Form >></a> </b>");
        out.println("                            </h2>");

        out.println("                        </div>");
        out.println("                        <div id='collapse4' class='panel-collapse collapse'>");
        out.println("                            <div class='panel-body'>");
        out.println("                                <p>");
        out.println("                                    <input type='radio' name='submethod' value='email' class='form-control-inline' checked> E-Mail");
        out.println("                                    <label for='mail'>claims@aspcapetinsurance.com</label>");
        out.println("                                </p>");

        out.println("                                <p>");
        out.println("                                    <input type='radio' name='submethod' value='fax' class='form-control-inline'> Fax:");
        out.println("                                    <label for='pwd'>1-866-888-2495</label>");
        out.println("                                </p>");

        out.println("                                <p>");
        out.println("                                    <input type='radio' name='submethod' value='mail' class='form-control-inline'> Mail:");
        out.println("                                    <label for='pwd'>ASPCA Pet Health Insurance<br/>3840 Greentree Ave SW<br/>Canton, Ohio 4470: </label>");
        out.println("                                </p>");
        out.println("                                <br>");
        out.println("                            </div>");
        out.println("              <div class='panel-footer'>");
        out.println("                                * Please choose only one method. Duplicate claim submissions may delay processing");
        out.println("                            </div>");
        out.println("                        </div>");
        out.println("                    </div>");
        out.println("                </div>");

        out.println("            </div>");
        out.println("<div class='panel panel-default'>");
        out.println("<input type='submit' class='btn btn-default form-control' id='submit'/>");
        out.println("</div>");

        out.println("        </form>");

        out.println("    </body>");

        out.println("</html>  ");

        out.close();

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String newaddr = req.getParameter("newaddr");
        String city = req.getParameter("city");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String acct = req.getParameter("acct");

        String petname = req.getParameter("petname");
        String breed = req.getParameter("breed");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String description = req.getParameter("description");
        String estimate = req.getParameter("estimate");

        String[] claimtype = req.getParameterValues("claimtype");
        String amount = req.getParameter("amount");
        String illdate = req.getParameter("illdate");
        String payto = req.getParameter("payto");
        String veterinarian = req.getParameter("veterinarian");
        String clinic = req.getParameter("clinic");
        String phone2 = req.getParameter("phone2");

        String fax = req.getParameter("fax");
        String pretreat = req.getParameter("pretreat");
        String newcond = req.getParameter("newcond");
        String sign = req.getParameter("sign");
        String date = req.getParameter("date");
        String submethod = req.getParameter("submethod");
        
        
        
        petname=petname.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
        breed=breed.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
        age=age.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
        gender=gender.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
        description=description.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();

        out.println("<html>");
        out.println("    <head>");
        out.println("<title>View Submitted Pet Insurance Form</title>");
        out.println("<meta charset='utf-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>");
        out.println("</head>");
        out.println("<body style='background-color: #6495ED'>");
        out.println("            <div class='container'>");
        out.println("               <table class='table table-bordered'>");
        out.println("                   <thead>");
        out.println("                       <tr>");
        out.println("                           <th style='background-color: #000000;'>");
        out.println("                               <font style='color: #FFFFFF'>");
        out.println("                   <h1>ASPCA</h1>");
        out.println("<h3>Pet Health insurance</h3>");
        out.println("</font>");
        out.println("</th>");

        out.println("<th>_______________________________________________</th>");
        out.println("<th style='background-color: #000000;'>");
        out.println("<font style='color: #FFFFFF'> HAVE A QUESTION?");
        out.println("<br/>Call us at 1-866-204-6764");
        out.println("</font>");
        out.println("</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("</table>");

        out.println("<div class='panel panel-default' style='position: relative;'>");
        out.println("<div class='panel-body'><h3>CLAIM FORM DETAILS</h3>");
        out.println("                    </div>");
        out.println("               </div>");
        out.println("<div class='panel-group' style='width: 100%; float: left;  background: whitesmoke;'>");

        out.println("   <div class='panel panel-default'>");
        out.println("       <div class='panel-heading' style='background-color:white; height: 50px;background: #000000; color: #FFFFFF'>");

        out.println("           <h2 class='panel-title' style='font-size: 20px; width: 60%; float: left;'>");
        out.println("               <b><a data-toggle='collapse' href='#collapse1'>1. General Information >></a></b>");
        out.println("           </h2>");

        out.println("</div>");
        out.println("<div id='collapse1' class='panel-collapse collapse in'>");
        out.println("<div class='panel-body'>");
        out.println("<table class='table' style='border: 1px;'>");

        out.println("   <tr>");
        out.println("       <th>");
        out.println("   <div class='form-group'>");
        out.println("       <b>Your Information</b>");

        out.println("  </div>");
        out.println("  </th>");
        out.println("   <th>");
        out.println("      <b>Pet Information</b>");
        out.println("  </th>");
        out.println("  </tr>");
        out.println("  <tr>");
        out.println("      <td>");
        out.println("          <div class='form-group'>");
        out.println("              <label for='usr'>Name:</label>");
        out.println("            " + name + " <br/>");
        out.println("             <label for='pwd'>Address:</label>");
        out.println("             " + address + " <br/>");
        out.println("             <label for='pwd'>Is it new address:</label>");
        out.println("             " + newaddr + " <br/>");
        out.println("             <label for='pwd'>City, State, Zip:</label>");
        out.println("           " + city + " <br/>");
        out.println("             <label for='pwd'>Phone:</label>");
        out.println("      " + phone + " <br/>");
        out.println("            <label for='pwd'>Email:</label>");
        out.println("            " + email + " <br/>");
        out.println("        </div>");
        out.println("    </td>");
        out.println("     <td>");
        out.println("         <div class='form-group'>");
        out.println("             <label for='usr'>Account Number:</label>");
        out.println("             " + acct + " <br/>");
        out.println("             <label for='pwd'>Name:</label>");
        out.println("             " + petname + " <br/>");
        out.println("             <label for='pwd'>Breed:</label>");
        out.println("             " + breed + " <br/>");
        out.println("             <label for='pwd'>Age:</label>");
        out.println("             " + age + " <br/>");
        out.println("             <label for='pwd'>Gender:</label>");
        out.println("             " + gender + " <br/>");
        out.println("         </div>");
        out.println("     </td>");
        out.println(" </tr>");
        out.println("</table>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");

        out.println("                   <div class='panel panel-default'>");
        out.println("<div class='panel-heading' style='background-color:white; height: 50px;background: #000000; color: #FFFFFF'>");

        out.println("<h2 class='panel-title' style='font-size: 20px; width: 60%; float: left;'>");
        out.println("                                <b> <a data-toggle='collapse' href='#collapse2'>2. Diagnosis/Symptom Information >></a></b>");
        out.println("                            </h2>");
        out.println("</div>");
        out.println("<div id='collapse2' class='panel-collapse collapse in'>");
        out.println("<div class='panel-body'>");
        out.println("<div class='container inner-container'>");
        out.println("<b>Story of Occurrence/Diagnosis Report");
        out.println("</b>   <br/>");
        out.println("" + description + " <br/>");
        out.println("</div>");
        out.println("<table  class='table'>");
        out.println("<tr>");
        out.println("    <td>");

        out.println("            <label for='usr'>This claim is related to:</label>");
        for (int i = 0; i < claimtype.length; i++) {
            out.println("" + claimtype[i] + "<br/> ");
        }

        out.println("                              <label for='pwd'>Is this claim an estimate for future treatment?</label>");
        out.println("                                            " + estimate + "  <br/>");

        out.println("                                            <label for='pwd'>Total amount claimed: </label>");
        out.println("                                            " + amount + " <br/>");
        out.println("                                            <label for='pwd'>Date illness/injury first occurred:</label>");
        out.println("                                            " + illdate + " <br/>");
        out.println("                                            <label for='pwd'>Send payment to: </label>");
        out.println("                                            " + payto + " <br/>");
        out.println("                                            <br>");
        out.println("<br>");
        out.println("</td>");
        out.println("<td>");
        out.println("<label for='usr'>Veterinarian:</label>");
        out.println("" + veterinarian + " <br/>");
        out.println("<label for='pwd'>Clinic Name:</label>");
        out.println("" + clinic + " <br/>");
        out.println("<label for='pwd'>Phone:</label>");
        out.println("" + phone2 + " <br/>");
        out.println("<label for='pwd'>Fax:</label>");
        out.println("" + fax + " <br/>");
        out.println("<label for='pwd'>Did any other veterinarian treat your pet?:</label>");
        out.println("" + pretreat + " <br/>");
        out.println("<label for='pwd'>Is this a new condition?: </label>");
        out.println("" + newcond + " <br/>");

        out.println("                                        </td>");
        out.println("                                    </tr>");
        out.println("                                </table>");
        out.println("                            </div>");

        out.println("                    </div>");

        out.println("                    <div class='panel panel-default'>");
        out.println("                        <div class='panel-heading' style='background-color:white; height: 50px;background: #000000; color: #FFFFFF'>");
        out.println("                            <h2 class='panel-title' style='font-size: 20px;'>");
        out.println("                                <b>  <a data-toggle='collapse' href='#collapse3'>3. Pet Owner Declaration >></a> </b>");
        out.println("                            </h2>");
        out.println("                        </div>");

        out.println("                                    <label for='usr'>Signature:</label>");
        out.println("                                    " + sign + " <br/>");
        out.println("                                    <label for='pwd'>Date:</label>");
        out.println("                                    " + date + " <br/>");

        out.println("                    </div>");

        out.println("                    <div class='panel panel-default'>");
        out.println("                        <div class='panel-heading' style='background-color:white; height: 50px;background: #000000; color: #FFFFFF'>");
        out.println("                            <h2 class='panel-title' style='font-size: 20px;'>");
        out.println("                                <b>  <a data-toggle='collapse' href='#collapse4'>4. Way selected to Submit the Claim Form >></a> </b>");
        out.println("                            </h2>");

        out.println("                        </div>");
        out.println("                        <div id='collapse4' class='panel-collapse collapse in '>");
        out.println("                            <div class='panel-body'>");

        out.println("                               " + submethod + " <br>");
        out.println("                            </div>");
        out.println("                        </div>");
        out.println("                    </div>");
        out.println("                </div>");

        out.println("            </div>");

        out.println("    </body>");

        out.println("</html>  ");

        out.close();

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
