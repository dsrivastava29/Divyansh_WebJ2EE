/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Divyansh
 */
public class CheckMovie implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public CheckMovie() {
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
            log("CheckMovie:doFilter()");
        }
        Throwable problem = null;
        try {
            if(null!=request.getParameter("user")){
                String user = request.getParameter("user");
                user=user.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim();
                request.setAttribute("user", user);
            }
            if (null != request.getParameter("keyword")) {
                String keyword = (String) request.getParameter("keyword");

                keyword = keyword.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim();
                request.setAttribute("keyword", keyword);
            } else if (null != request.getParameter("action")) {
                if (request.getParameter("action").equals("add")) {
                    String title = (String) request.getParameter("title");
                    String lactor = (String) request.getParameter("lactor");
                    String lactress = (String) request.getParameter("lactress");
                    String genre = (String) request.getParameter("genre");
                    int year = Integer.parseInt(request.getParameter("year"));

                    title = title.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", " ").trim();
                    lactor = lactor.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", " ").trim();
                    lactress = lactress.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", " ").trim();
                    genre = genre.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", " ").trim();

                    request.setAttribute("title", title);
                    request.setAttribute("lactor", lactor);
                    request.setAttribute("lactress", lactress);
                    request.setAttribute("genre", genre);
                    request.setAttribute("year", year);
                    
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
                log("CheckMovie:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("CheckMovie()");
        }
        StringBuffer sb = new StringBuffer("CheckMovie(");
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
