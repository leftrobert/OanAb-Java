package vn.com.fsoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.com.fsoft.model.Admin;
import vn.com.fsoft.model.Role;
import vn.com.fsoft.util.HibernateUtil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ManageAdminDAO {
	Session session = null;
	
	@SuppressWarnings("unchecked")
	public ArrayList<Role> getRoleList(){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Role r";
        Query query = session.createQuery(sql);
        
        ArrayList<Role> list =  (ArrayList<Role>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Admin> getAdminList(){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Admin a";
        Query query = session.createQuery(sql);
        
        ArrayList<Admin> list =  (ArrayList<Admin>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Admin> getFilteredAdminList(String els, String rol, String gen, String stt, String sor, String ord) {
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Admin a";
        
        if (!els.equals("") || !rol.equals("0") || !gen.equals("2") || !stt.equals("2")) {
        	sql = sql + " where";
        }
        if (!els.equals("")) {
        	sql = sql + " (a.name like '%"+els+"%' or a.email like '%"+els+"%' or a.id like '%"+els+"%')";
        }
        if (!rol.equals("0")) {
        	if (!els.equals("")) sql += " and"; 
        	sql = sql + " a.roleId = '"+rol+"'";
        }
        if (!gen.equals("2")) {
        	if (!els.equals("") || !rol.equals("0")) sql += " and"; 
        	sql = sql + " a.gender = "+gen;
        }
        if (!stt.equals("2")) {
        	if (!els.equals("") || !rol.equals("0") || !gen.equals("2")) sql += " and"; 
        	sql = sql + " a.status = "+stt;
        }
        sql = sql + " order by a." + sor + " " + ord;
        System.out.println(sql);
        Query query = session.createQuery(sql);

        ArrayList<Admin> list =  (ArrayList<Admin>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public Admin getAdmin(String aid){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Admin a where a.id = '" + aid + "'";
        Query query = session.createQuery(sql);
        
        ArrayList<Admin> alist = (ArrayList<Admin>)query.list();
        Admin ad = alist.get(0);
        session.close();
        if (ad != null) {
            return ad;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public String getRole(String rid){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Role r where r.id = '" + rid + "'";
        Query query = session.createQuery(sql);
        
        ArrayList<Role> rlist = (ArrayList<Role>)query.list();
        Role role = rlist.get(0);
        session.close();
        if (role != null) {
            return role.getRoleComment();
        }
        return "Cant get";
	}
	
	public int updateAdmin(String aid, String aname, String arol, String agen, String adob, String aphone, String amail, String apass, String astt) {
		session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "Update Admin set name = '" + aname + "', roleId = '" + arol + "', gender = " + agen + ", dob = '" + adob + "', phone = '" + aphone + "', email = '" + amail + "', status = '" + astt +"'";
        if (!apass.equals("")) sql += ", password = '" + md5p(apass) + "'";
        sql += " where id = '" + aid + "'";
        Query query = session.createQuery(sql);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        return result;
	}
	
	public int updateAdminPersonal(String aid, String aname, String agen, String adob, String aphone) {
		session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "Update Admin set name = '" + aname + "', gender = " + agen + ", dob = '" + adob + "', phone = '" + aphone + "'";
        sql += " where id = '" + aid + "'";
        Query query = session.createQuery(sql);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        return result;
	}
	
	public int updateAdminPass(String aid, String apass) {
		session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "Update Admin set password = '" + md5p(apass) + "'";
        sql += " where id = '" + aid + "'";
        Query query = session.createQuery(sql);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        return result;
	}
	
	public void insertAdmin(String aid, String aname, String arol, String agen, String adob, String aphone, String amail, String apass, String astt) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Date d = new Date();
        String start = new SimpleDateFormat("yyyy-MM-dd").format(d);
        System.out.println("md5 pass = " + md5p(apass));
        Admin a = new Admin(aid, arol, md5p(apass), aname, adob, agen, aphone, amail, start, astt);
        session.save(a);
        tx.commit();
        session.close();
	}
	
	public int deleteAdmin(String aid) {
		session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "Delete from Admin where id = '" + aid + "'";
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
        String sql = "From Admin a";
        Query query = session.createQuery(sql);
        
        ArrayList<Admin> list =  (ArrayList<Admin>)query.list();
        session.close();
        if (list.size() > 0) {
    		Admin a = list.get(list.size() - 1);
    		int next = Integer.parseInt(a.getId().substring(1)) + 1;
            return "a" + String.format("%03d", next);
        }
        return null;
	}
}
