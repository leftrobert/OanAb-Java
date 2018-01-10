package vn.com.fsoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.com.fsoft.model.User;
import vn.com.fsoft.util.HibernateUtil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ManageUserDAO {
	Session session = null;
	
	@SuppressWarnings("unchecked")
	public ArrayList<User> getUserList(){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = "From User u";
        Query query = session.createQuery(sql);
        
        ArrayList<User> list =  (ArrayList<User>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<User> getFilteredUserList(String els, String gen, String stt, String sor, String ord) {
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From User u";
        
        if (!els.equals("") || !gen.equals("2") || !stt.equals("2")) {
        	sql = sql + " where";
        }
        if (!els.equals("")) {
        	sql = sql + " (u.name like '%"+els+"%' or u.phone like '%"+els+"%')";
        }
        if (!gen.equals("2")) {
        	if (!els.equals("")) sql += " and"; 
        	sql = sql + " u.gender = "+gen;
        }
        if (!stt.equals("2")) {
        	if (!els.equals("") || !gen.equals("2")) sql += " and"; 
        	sql = sql + " u.status = "+stt;
        }
        sql = sql + " order by u." + sor + " " + ord;
        System.out.println(sql);
        Query query = session.createQuery(sql);

        ArrayList<User> list =  (ArrayList<User>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public User getUser(String uid){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = "From User u where u.id=" + uid;
        Query query = session.createQuery(sql);
        
        ArrayList<User> ulist = (ArrayList<User>)query.list();
        User u = ulist.get(0);
        session.close();
        if (u != null) {
            return u;
        }
        return null;
	}
	
	public int updateUser(String uid, String uname, String ugen, String udob, String uphone, String uadd, String upass, String ustt) {
		session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "Update User set name = '" + uname + "', gender = " + ugen + ", dob = '" + udob + "', phone = '" + uphone + "', address = '" + uadd + "', status = '" + ustt +"'";
        if (!upass.equals("")) sql += ", password = '" + md5p(upass) + "'";
        sql += " where id = '" + uid + "'";
        Query query = session.createQuery(sql);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        return result;
	}
	
	public void insertUser(int uid, String uname, String ugen, String udob, String uphone, String uadd, String upass, String ustt) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Date d = new Date();
        String start = new SimpleDateFormat("yyyy-MM-dd").format(d);
        User u = new User(uid, md5p(upass), uname, uphone, ugen, udob, uadd, start, ustt);
        System.out.println(u.toString());
        session.save(u);
        tx.commit();
        session.close();
	}
	
	public int deleteUser(String uid) {
		session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "Delete from User where id="+uid;
        Query query = session.createQuery(sql);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        return result;
	}
	
	public String md5p(String s) {
		String p = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			BigInteger bigInteger = new BigInteger(1, md.digest());
			p = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public int nextID () {
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From User u";
        Query query = session.createQuery(sql);
        
        ArrayList<User> list =  (ArrayList<User>)query.list();
        session.close();
        if (list.size() > 0) {
        	User u = list.get(list.size() - 1);
    		int next = u.getId() + 1;
            return next;
        }
        return -1;
	}
}
