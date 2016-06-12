/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.controller;

import com.neu.edu.beans.BookBean;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Divyansh
 */
public class BooksCheckFilter implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public BooksCheckFilter() {
    }    
      /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        if (debug) {
            log("BooksCheckFilter:doFilter()");
        }
        Throwable problem = null;
        try {
            HttpSession session=null;
            if(null!=request.getParameter("user")){
                String user = request.getParameter("user");
                user=user.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim();
                request.setAttribute("user", user);
            }
            String work = request.getParameter("work");
            if(null!=work){
            if (work.equalsIgnoreCase("insert")) {
                int bkcount = Integer.parseInt(request.getParameter("bkcount"));
                BookBean[] books = new BookBean[bkcount];
                for (int i = 0; i < bkcount; i++) {
                    books[i] = new BookBean();
                }
                Enumeration bookList = request.getParameterNames();
                while (bookList.hasMoreElements()) {
                    String book = (String) bookList.nextElement();
                    String s = request.getParameter(book);
                    if (!(book.equalsIgnoreCase("user")) && !(book.equalsIgnoreCase("work"))) {
                        if(book.equalsIgnoreCase("bkcount"))
                            break;
                        String[] numBook = book.split("-");
                        int no = Integer.parseInt(numBook[0]);
                        String name = numBook[1];
                        switch (name) {
                            case "isbn":
                                books[no - 1].setIsbn(s);
                                break;
                            case "title":
                                books[no - 1].setTitle(s);
                                break;
                            case "authors":
                                books[no - 1].setAuthors(s);
                                break;
                            case "price":
                                books[no - 1].setPrice(Float.parseFloat(s));
                                break;
                        }
                    }
                }
                ArrayList<BookBean> booksList=new ArrayList<>();
                 for (int i = 0; i < bkcount; i++) {
                    books[i].setIsbn(books[i].getIsbn().replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim());
                    books[i].setTitle(books[i].getTitle().replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim());
                    books[i].setAuthors(books[i].getAuthors().replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim());
                    books[i].setPrice(books[i].getPrice());
                    booksList.add(books[i]);
                }
                request.setAttribute("booksList", booksList);
                
            }
            }
            chain.doFilter(request, response);
        } catch (Throwable t) {
	    // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }
        

	// If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("BooksCheckFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("BooksCheckFilter()");
        }
        StringBuffer sb = new StringBuffer("BooksCheckFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
