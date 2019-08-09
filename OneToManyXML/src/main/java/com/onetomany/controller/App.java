package com.onetomany.controller;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
       Configuration con = new Configuration().configure("hibernate.cfg.xml");
       SessionFactory sf = con.buildSessionFactory();
       Session ses = sf.openSession();
       Transaction tx = ses.beginTransaction();
       
       Answer ans1 = new Answer();
        ans1.setAnswername("java is programming language");
        ans1.setPostedBy("ramesh");
      
       Answer ans2 = new Answer();
        ans2.setAnswername("java is a plateform");
        ans2.setPostedBy("sri");
        
       Answer ans3 = new Answer();
        ans3.setAnswername("servlet is an interface");
        ans3.setPostedBy("arun");
        
       Answer ans4 = new Answer();
        ans4.setAnswername("servlet is an API ");
        ans4.setPostedBy("nari");
        
      ArrayList<Answer> list1 = new ArrayList<Answer>();
       list1.add(ans1);
       list1.add(ans2);
       
      ArrayList<Answer> list2 = new ArrayList<Answer>();
       list2.add(ans3);
       list2.add(ans4);
       
       Question q1 = new Question();
        q1.setQname("what is java");
        q1.setAnswers(list1);
        
       Question q2 = new Question();
        q2.setQname("what is servlet");
        q2.setAnswers(list2);
        
        ses.persist(q1);
        ses.persist(q2);
        
        tx.commit();
        ses.close();
        sf.close();
        System.out.println("success");
    }
}
