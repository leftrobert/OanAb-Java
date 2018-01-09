package vn.com.fsoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import vn.com.fsoft.model.User;
import vn.com.fsoft.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	Session session = null;
	
	public ArrayList<User> getList(){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = "From User u ";
        Query query = session.createQuery(sql);
        
        ArrayList<User> list =  (ArrayList<User>)query.list();
        if (list.size() > 0) {
            return list;
        }
        session.close();
        return null;
	}
}
