/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crazydrt.DAO;

import com.crazydrt.pojo.Books;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Divyansh
 */
public class BooksDAO {

    Configuration cfg = new Configuration();
    SessionFactory sf = cfg.configure().buildSessionFactory();

    public int insertBooks(List<Books> books) {
        Session hibsession = sf.openSession();
        Transaction tx = null;
        try {
            tx = hibsession.beginTransaction();
            for (Books bk : books) {
                hibsession.save(bk);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return 0;
        } finally {
            hibsession.close();
            return 1;
        }

    }
}
