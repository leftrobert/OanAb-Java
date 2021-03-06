package vn.com.fsoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import vn.com.fsoft.model.Category;
import vn.com.fsoft.util.HibernateUtil;

import java.util.ArrayList;

public class CategoryDAO {
	Session session = null;
	
	@SuppressWarnings("unchecked")
	public ArrayList<Category> getList(){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Category c ";
        Query query = session.createQuery(sql);
        
        ArrayList<Category> list =  (ArrayList<Category>)query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }
        session.close();
        return null;
	}
}
