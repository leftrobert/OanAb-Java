package vn.com.fsoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import vn.com.fsoft.model.Admin;
import vn.com.fsoft.model.User;
import vn.com.fsoft.util.HibernateUtil;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
	Session session = null;
	
	public boolean checkLogin(String phone, String pass){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
		String md5p = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(pass.getBytes());
			BigInteger bigInteger = new BigInteger(1, md.digest());
			md5p = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(md5p);
        String sql = "From User u where u.phone = '" + phone + "' and u.password = '" + md5p + "'";
		System.out.println(sql);
        Query query = session.createQuery(sql);
        ArrayList<User> list = (ArrayList<User>)query.list();
        session.close();
        if (list.size() > 0) {
            return true;
        }
        return false;
	}
	
	public boolean checkAdmin(String admin, String pass){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
		String md5p = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(pass.getBytes());
			BigInteger bigInteger = new BigInteger(1, md.digest());
			md5p = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(md5p);
        String sql = "From Admin a where a.id = '" + admin + "' and a.password = '" + md5p + "'";
		System.out.println(sql);
        Query query = session.createQuery(sql);
        ArrayList<Admin> list = (ArrayList<Admin>)query.list();
        session.close();
        if (list.size() > 0) {
            return true;
        }
        return false;
	}
	
	public User getUser(String phone) {
		session = HibernateUtil.getSessionFactory().openSession();
		String sql = "From User u where u.phone = '" + phone + "'";
        Query query = session.createQuery(sql);
        User lin = (User)query.list().get(0);
        session.close();
        if (lin != null) {
        	return lin;
        }
        return null;
	}
	
	public Admin getAdmin(String admin) {
		session = HibernateUtil.getSessionFactory().openSession();
		String sql = "From Admin a where a.id = '" + admin + "'";
        Query query = session.createQuery(sql);
        Admin lin = (Admin)query.list().get(0);
        session.close();
        if (lin != null) {
        	return lin;
        }
        return null;
	}
}
