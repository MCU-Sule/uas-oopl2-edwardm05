package com.example.uas_1872003.Utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//1872003 - Edward Michael S
public class HibernateUtil {

    public static Session getSession() {
        SessionFactory sf;

        sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session s;
        s = sf.openSession();
        return s;
    }
}
