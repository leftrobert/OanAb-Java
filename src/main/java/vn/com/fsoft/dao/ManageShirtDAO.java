package vn.com.fsoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.com.fsoft.model.Category;
import vn.com.fsoft.model.Material;
import vn.com.fsoft.model.Shirt;
import vn.com.fsoft.model.User;
import vn.com.fsoft.util.HibernateUtil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ManageShirtDAO {
	Session session = null;
	
	@SuppressWarnings("unchecked")
	public ArrayList<Shirt> getShirtList(){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Shirt s";
        Query query = session.createQuery(sql);
        
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public Shirt getShirt(String sid){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Shirt s where s.id="+sid;
        Query query = session.createQuery(sql);
        
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        Shirt s = list.get(0);
        session.close();
        if (s != null) {
            return s;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public String getCatName(String cid){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Category c where c.id="+cid;
        Query query = session.createQuery(sql);
        
        ArrayList<Category> list =  (ArrayList<Category>)query.list();
        session.close();
        Category c = list.get(0);
        if (c != null) {
            return c.getCatName();
        }
        return null;
	}
	
	public String getGender(int gid){
		if (gid==0) return "Female";
		if (gid==1) return "Male";
		if (gid==2) return "Unisex";
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Category> getCatList(){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Category c";
        Query query = session.createQuery(sql);
        
        ArrayList<Category> list =  (ArrayList<Category>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Material> getMatList(){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Material m";
        Query query = session.createQuery(sql);
        
        ArrayList<Material> list =  (ArrayList<Material>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Shirt> getFilteredShirtList(String els, String cat, String gen, String size, String stt, String sor, String ord) {
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Shirt s";
        
        if (!els.equals("") || !cat.equals("0") || !gen.equals("3") || !size.equals("0") || !stt.equals("2")) {
        	sql = sql + " where";
        }
        if (!els.equals("")) {
        	sql = sql + " s.name like '%"+els+"%'";
        }
        if (!cat.equals("0")) {
        	if (!els.equals("")) sql += " and"; 
        	sql = sql + " s.catId = "+cat;
        }
        if (!gen.equals("3")) {
        	if (!els.equals("") || !cat.equals("0")) sql += " and"; 
        	sql = sql + " s.gender = "+gen;
        }
        if (!size.equals("0")) {
        	if (!els.equals("") || !cat.equals("0") || !gen.equals("3")) sql += " and"; 
        	sql = sql + " s.size like '%"+gen+"%'";
        }
        if (!stt.equals("2")) {
        	if (!els.equals("") || !cat.equals("0") || !gen.equals("3") || !size.equals("0")) sql += " and"; 
        	sql = sql + " s.status = "+stt;
        }
        sql = sql + " order by s." + sor + " " + ord;
        System.out.println(sql);
        Query query = session.createQuery(sql);

        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public User getUser(String uid){
		session = HibernateUtil.getSessionFactory().openSession();
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
	
	public int updateShirt(String sid, String sname, String scat, String sgen, String sdate, String scolor, String ssize, String sprice, String sstt) {
		session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "Update Shirt set name = '" + sname + "', catId = " + scat + ", gender = " + sgen + ", date = '" + sdate + "', colors = '" + scolor + "', sizes = '" + ssize + "', price = " + sprice + ", status = " + sstt;
        sql += " where id = '" + sid + "'";
        Query query = session.createQuery(sql);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        return result;
	}
	
	public void insertShirt(String sid, String sname, String scat, String sgen, String scolor, String ssize, String sprice, String sstt) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Date d = new Date();
        String start = new SimpleDateFormat("yyyy-MM-dd").format(d);
        Shirt s = new Shirt(sid, scat, sname, sgen, start, sprice, ssize, scolor, sstt);
        session.save(s);
        tx.commit();
        session.close();
	}
	
	public int deleteShirt(String sid) {
		session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "Delete from Shirt where id="+sid;
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
	public String nextID () {
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Shirt s";
        Query query = session.createQuery(sql);
        
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        session.close();
        if (list.size() > 0) {
        	Shirt s = list.get(list.size() - 1);
    		int next = Integer.parseInt(s.getId()) + 1;
            return String.valueOf(next);
        }
        return "";
	}
}
