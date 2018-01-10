package vn.com.fsoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import vn.com.fsoft.model.Bill;
import vn.com.fsoft.model.Cart;
import vn.com.fsoft.model.Shirt;
import vn.com.fsoft.util.HibernateUtil;

import java.util.ArrayList;

public class BillDAO {
	Session session = null;
	
	@SuppressWarnings("unchecked")
	public ArrayList<Bill> getList(String uid){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Bill b where b.userId='"+uid+"'";
        Query query = session.createQuery(sql);
        
        ArrayList<Bill> list =  (ArrayList<Bill>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Bill> getFilteredBillList(String uid, String els, String stt, String sor, String ord) {
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Bill b where b.userId = '"+uid+"'";
        if (!els.equals("")) {
        	sql = sql + " and b.receiverName like '%"+els+"%'";
        }
        if (!stt.equals("2")) {
        	sql = sql + " and b.paymentStatus = "+stt;
        }
        sql = sql + " order by b." + sor + " " + ord;
        System.out.println(sql);
        Query query = session.createQuery(sql);

        ArrayList<Bill> list =  (ArrayList<Bill>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cart> getSelectedCartList(String bid){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Cart c where c.billId='"+bid+"'";
        Query query = session.createQuery(sql);
        
        ArrayList<Cart> list =  (ArrayList<Cart>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public String getShirtName(String sid){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Shirt s where s.id='"+sid+"'";
        Query query = session.createQuery(sql);
        
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        Shirt s = list.get(0);
        session.close();
        if (s != null) {
            return s.getName();
        }
        return null;
	}
}
