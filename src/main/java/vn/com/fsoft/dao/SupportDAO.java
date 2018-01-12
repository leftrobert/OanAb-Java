package vn.com.fsoft.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.com.fsoft.model.Support;
import vn.com.fsoft.util.HibernateUtil;

public class SupportDAO {
	Session session = null;
	
	@SuppressWarnings("unchecked")
	public ArrayList<Support> getList() {
		session = HibernateUtil.getSessionFactory().openSession();
	    String sql = "From Support s";
	    Query query = session.createQuery(sql);
	    
	    ArrayList<Support> list =  (ArrayList<Support>)query.list();
	    session.close();
	    if (list.size() > 0) {
	        return list;
	    }
	    return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Support> getFilteredList(String kw, String stt, String ord) {
		session = HibernateUtil.getSessionFactory().openSession();
	    String sql = "From Support s";
	    if (!stt.equals("2") || !kw.equals("")) sql+=" where";
	    if (!kw.equals("")) sql += " s.description like '%"+kw+"%'";
	    if (!stt.equals("2") && !kw.equals("")) sql += " and";
	    if (!stt.equals("2")) sql += " s.status="+stt;
	    sql += " order by s.date "+ord+", s.id "+ord;
	    Query query = session.createQuery(sql);
	    
	    ArrayList<Support> list =  (ArrayList<Support>)query.list();
	    session.close();
	    if (list.size() > 0) {
	        return list;
	    }
	    return null;
	}
	
	@SuppressWarnings("unchecked")
	public Support getSupport(String sid) {
		session = HibernateUtil.getSessionFactory().openSession();
	    String sql = "From Support s where s.id="+sid;
	    Query query = session.createQuery(sql);
	    
	    ArrayList<Support> list =  (ArrayList<Support>)query.list();
	    session.close();
	    if (list.size() > 0) {
	        return list.get(0);
	    }
	    return null;
	}
	
	public void saveSupport(Support support){
		int next = nextId();
		Date d = new Date();
		support.setId(next);
		support.setStatus(false);
		support.setDate(new SimpleDateFormat("yyyy-MM-dd").format(d));
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(support);
		session.getTransaction().commit();
		session.close();
	}
	
	public int updateSupport(String sid, String sstt) {
		session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "Update Support set status = " + sstt;
        sql += " where id = '" + sid + "'";
        Query query = session.createQuery(sql);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        return result;
	}

	public int deleteSupport(String sid) {
		session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();
	    String sql = "Delete from Support where id="+sid;
	    Query query = session.createQuery(sql);
	    int result = query.executeUpdate();
	    tx.commit();
	    session.close();
	    return result;
	}

	@SuppressWarnings("unchecked")
	public int nextId() {
		session = HibernateUtil.getSessionFactory().openSession();
	    String sql = "From Support s";
	    Query query = session.createQuery(sql);
	    
	    ArrayList<Support> list =  (ArrayList<Support>)query.list();
	    session.close();
	    if (list.size() > 0) {
	    	Support s = list.get(list.size() - 1);
			int next = s.getId() + 1;
	        return next;
	    }
	    return 1;
	}
}
