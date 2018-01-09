package vn.com.fsoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import vn.com.fsoft.model.Material;
import vn.com.fsoft.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {
	Session session = null;
	
	public ArrayList<Material> getList(){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = "From Material m";
        Query query = session.createQuery(sql);
        
        ArrayList<Material> list =  (ArrayList<Material>)query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }
        session.close();
        return null;
	}
}
