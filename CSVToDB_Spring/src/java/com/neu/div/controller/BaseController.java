/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.div.controller;

import com.neu.div.DAO.CsvDAO;
import com.neu.div.DAO.FiledataDAO;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Divyansh
 */
public class BaseController implements Controller, ServletContextAware {

    FiledataDAO filedataDAO;
    CsvDAO CsvDAO;
    @Autowired
    ServletContext context;

    public BaseController(FiledataDAO filedataDAO, CsvDAO CsvDAO) {
        this.filedataDAO = filedataDAO;
        this.CsvDAO = CsvDAO;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        HttpSession session = hsr.getSession();
        String action = hsr.getParameter("action");

        ModelAndView mv = new ModelAndView();
        try {

            if (action.equals("load")) {
                String filename = hsr.getParameter("filename");
                int page = Integer.parseInt(hsr.getParameter("pgindex"));
                File file;

                String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
                String path = null;
                if (check.equalsIgnoreCase("\\")) {
                    path = context.getRealPath("").replace("build\\", ""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
                }
                if (check.equalsIgnoreCase("/")) {
                    path = context.getRealPath("").replace("build/", "");
                    path += "/"; //Adding trailing slash for Mac systems.
                }
                String filePath = path;
                String[] str = filename.split("\\.");
                String tableName = str[0];

                List<Map<String, Object>> mydata = CsvDAO.getFileData(tableName, filePath, page);
                session.setAttribute("tableName", tableName);
                mv.addObject("mydata", mydata);
                if (!(mydata.size() > 0)) {
                    mv.addObject("nodata", 1);
                }
                mv.addObject("action", "load");
                mv.addObject("filename", filename);
                mv.addObject("pgindex", page);
                mv.setViewName("index");

            } else if (action.equals("saverow")) {
                System.out.println(hsr.getParameter("items"));
                Map<String, Object> column = new LinkedHashMap<String, Object>();
                ArrayList<String> cols = new ArrayList<>();
                String save = hsr.getParameter("items");
                save = save.replace("{", "");
                save = save.replace("}", "");
                String arr[] = save.split(",");
                for (String s : arr) {
                    String[] pair = s.split("=");
                    column.put(pair[0], pair[1]);
                    cols.add(pair[0]);
                }
                String tbl = hsr.getParameter("tablename");
                String[] str = tbl.split("\\.");
                tbl = str[0];
                filedataDAO.createTable(cols, tbl);
                int done = filedataDAO.insertData(cols.size(), column, tbl);
                if (done > 0) {
                    hsr1.getWriter().print("done");
                    hsr1.getWriter().flush();
                }
            }
        } catch (Exception e) {
            mv.addObject("nodata", 1);
        } finally {
            return mv;
        }
    }

    @Override
    public void setServletContext(ServletContext sc) {
        this.context = sc;
    }
}
