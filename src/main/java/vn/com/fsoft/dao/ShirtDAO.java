package vn.com.fsoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import vn.com.fsoft.model.Category;
import vn.com.fsoft.model.Shirt;
import vn.com.fsoft.util.HibernateUtil;

import java.util.ArrayList;

public class ShirtDAO {
	Session session = null;
	
	@SuppressWarnings("unchecked")
	public ArrayList<Shirt> getList(){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Shirt s where s.status = true";
        Query query = session.createQuery(sql);
        
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Shirt> getHotList(){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Shirt s where s.status = true order by s.date desc";
        Query query = session.createQuery(sql).setMaxResults(8);
        
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Shirt> getTrendingList(){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = "From Shirt s where s.status = true order by s.sold desc";
        Query query = session.createQuery(sql).setMaxResults(4);
        
        ArrayList<Shirt> list = (ArrayList<Shirt>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public Shirt getShirt(String sid){
		session = HibernateUtil.getSessionFactory().openSession();
		String sql = " From Shirt s where s.id='" + sid + "'";
        Query query = session.createQuery(sql);
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        session.close();
        Shirt shirt = null;
        if (list.size() > 0) {
            shirt = list.get(0);
            return shirt;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Shirt> searchByName(String name){
		session = HibernateUtil.getSessionFactory().openSession();
		String sql = "From Shirt s where s.name like '%" + name + "%' and s.status = true";
        Query query = session.createQuery(sql);
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Shirt> getFilteredList(String cat, String gen, String mat, String siz, String low, String hig, String sor){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Shirt s where s.status = true and";
        
        if (!cat.equals("0")) {
        	sql = sql + " s.catId = "+cat+" and";
        }
        if (!gen.equals("3")) {
        	sql = sql + " s.gender = "+gen+" and";
        }
        if (!siz.equals("0")) {
        	sql = sql + " s.sizes like '%"+siz+"%' and";
        }
        sql = sql + " s.price >= "+low;
        if (!hig.equals("0")) {
        	sql = sql + " and s.price <= "+hig;
        }
        sql = sql + " order by ";
        int sort = Integer.parseInt(sor);
        switch (sort) {
		case 2: 
			sql = sql + "s.date asc";
			break;
		case 3: 
			sql = sql + "s.sold desc";
			break;
		case 4: 
			sql = sql + "s.sold asc";
			break;
		case 5: 
			sql = sql + "s.price asc";
			break;
		case 6: 
			sql = sql + "s.price desc";
			break;
		default:
			sql = sql + "s.date desc";
			break;
		}
        Query query = session.createQuery(sql);

        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        session.close();
        if (list.size() > 0) {
            return list;
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public String getCatName(String cid){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
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
}
