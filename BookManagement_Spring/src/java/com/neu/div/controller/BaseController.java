/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.div.controller;

import com.neu.div.DAO.BooksDAO;
import com.neu.div.pojo.Book;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Divyansh
 */
public class BaseController implements Controller {

    BooksDAO booksDAO;

    public BaseController(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        HttpSession session = hsr.getSession();
        String action = hsr.getParameter("work");
        String user = hsr.getParameter("user");
        session.setAttribute("user", user);
        ModelAndView mv = new ModelAndView();
        if (action.equals("generate")) {
            int number = Integer.parseInt(hsr.getParameter("bkcount"));
            mv.addObject("bkcount", number);
            mv.setViewName("AddBooksView");
        } else if (action.equals("insert")) {
            List<Book> booksList=resolveBooks(hsr);
            int rows=booksDAO.insertBooks(booksList);
            session.setAttribute("booksList",booksList);
            session.setAttribute("rows",rows);
            mv.setViewName("ViewNewBooks");
        }
        return mv;
    }

    private ArrayList<Book> resolveBooks(HttpServletRequest hsr) {
        int bkcount = Integer.parseInt(hsr.getParameter("bkcount"));
        Book[] books = new Book[bkcount];
        for (int i = 0; i < bkcount; i++) {
            books[i] = new Book();
        }
        Enumeration bookList = hsr.getParameterNames();
        while (bookList.hasMoreElements()) {
            String book = (String) bookList.nextElement();
            String s = hsr.getParameter(book);
            if (!(book.equalsIgnoreCase("user")) && !(book.equalsIgnoreCase("work"))) {
                if (book.equalsIgnoreCase("bkcount")) {
                    break;
                }
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
        ArrayList<Book> booksList = new ArrayList<>();
        for (int i = 0; i < bkcount; i++) {
            books[i].setIsbn(books[i].getIsbn().replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim());
            books[i].setTitle(books[i].getTitle().replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim());
            books[i].setAuthors(books[i].getAuthors().replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim());
            books[i].setPrice(books[i].getPrice());
            booksList.add(books[i]);
        }
        return booksList;
    }
}
