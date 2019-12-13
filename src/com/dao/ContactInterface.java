
package com.dao;

import com.pojo.Contact;
import java.util.List;


public interface ContactInterface {
    public void doAdd(Contact con);
    public void doUp(Contact con);
    public void doDel(Contact con);
    public List <Contact> allContact();
    public List <Integer> allId();
    public List <Contact> allContactById(int id);
}
