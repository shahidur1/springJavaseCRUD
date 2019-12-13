/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Contact;
import com.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author apcl
 */
public class ContactDao implements ContactInterface {

    @Override
    public void doAdd(Contact con) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(con);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void doUp(Contact con) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(con);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void doDel(Contact con) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(con);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public List<Contact> allContact() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q=s.createQuery("from Contact");
        List <Contact> list=q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }

    @Override
    public List<Integer> allId() {
      Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q=s.createQuery("select id from Contact");
        List <Integer> list=q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }
    @Override
    public List<Contact> allContactById(int id) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q=s.createQuery("from Contact where id="+id);
        List <Contact> list=q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }

}
