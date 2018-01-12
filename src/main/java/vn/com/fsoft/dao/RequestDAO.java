package vn.com.fsoft.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.com.fsoft.model.Request;
import vn.com.fsoft.util.HibernateUtil;

public class RequestDAO {
	Session session = null;
	
	public boolean saveRequetsDAO(Request request){
		int next = nextId();
		Date d = new Date();
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try{
			request.setId(next);
			request.setDate(new SimpleDateFormat("yyyy-MM-dd").format(d));
			request.setStatus(false);
			session.save(request);
			transaction.commit();
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public int nextId() {
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Request r";
        Query query = session.createQuery(sql);
        
        ArrayList<Request> list =  (ArrayList<Request>)query.list();
        session.close();
        if (list.size() > 0) {
        	Request r = list.get(list.size() - 1);
    		int next = r.getId() + 1;
            return next;
        }
        return 1;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Request> getFilteredList(String kw, String img, String stt, String ord) {
		session = HibernateUtil.getSessionFactory().openSession();
	    String sql = "From Request r";
	    if (!stt.equals("2") || !kw.equals("") || !img.equals("2")) sql+=" where";
	    if (!kw.equals("")) sql += " r.description like '%"+kw+"%'";
	    if (!stt.equals("2") && !kw.equals("")) sql += " and";
	    if (!stt.equals("2")) sql += " r.status="+stt;
	    if (!stt.equals("2") && !kw.equals("") && !img.equals("2")) sql += " and";
	    if (!img.equals("2")) sql += " r.imageFile "+(img.equals("1")?"like '%'":"= null");
	    sql += " order by r.date "+ord+", r.id "+ord;
	    Query query = session.createQuery(sql);
	    
	    ArrayList<Request> list =  (ArrayList<Request>)query.list();
	    session.close();
	    if (list.size() > 0) {
	        return list;
	    }
	    return null;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Request> getList() {
		session = HibernateUtil.getSessionFactory().openSession();
	    String sql = "From Request r";
	    Query query = session.createQuery(sql);
	    
	    ArrayList<Request> list =  (ArrayList<Request>)query.list();
	    session.close();
	    if (list.size() > 0) {
	        return list;
	    }
	    return null;
	}

	@SuppressWarnings("unchecked")
	public Request getRequest(String rid) {
		session = HibernateUtil.getSessionFactory().openSession();
	    String sql = "From Request r where r.id="+rid;
	    Query query = session.createQuery(sql);
	    
	    ArrayList<Request> list =  (ArrayList<Request>)query.list();
	    session.close();
	    if (list.size() > 0) {
	        return list.get(0);
	    }
	    return null;
	}

	public int deleteRequest(String rid) {
		session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();
	    String sql = "Delete from Request where id="+rid;
	    Query query = session.createQuery(sql);
	    int result = query.executeUpdate();
	    tx.commit();
	    session.close();
	    return result;
	}

	public int updateRequest(String rid, String rstt) {
		session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();
	    String sql = "Update Request set status = " + rstt;
	    sql += " where id = '" + rid + "'";
	    Query query = session.createQuery(sql);
	    int result = query.executeUpdate();
	    tx.commit();
	    session.close();
	    return result;
	}
}
