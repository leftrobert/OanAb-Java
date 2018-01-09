package vn.com.fsoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.com.fsoft.model.Admin;
import vn.com.fsoft.util.HibernateUtil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
	Session session = null;
	
	public int updateAdmin(String aid, String aname, String arol, String agen, String adob, String aphone, String amail, String apass, String astt) {
		session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "Update Admin set name = '" + aname + "', roleId = '" + arol + "', gender = " + agen + ", dob = '" + adob + "', phone = '" + aphone + "', email = '" + amail + "', status = '" + astt +"'";
        if (!apass.equals("")) sql += ", password = '" + md5p(apass) + "'";
        sql += " where id = '" + aid + "'";
        Query query = session.createQuery(sql);
        int result = query.executeUpdate();
        session.close();
        tx.commit();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}
