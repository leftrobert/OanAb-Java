package vn.com.fsoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import vn.com.fsoft.model.Shirt;
//import vn.com.fsoft.model.User;
import vn.com.fsoft.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ShirtDAO {
	Session session = null;
	
	public ArrayList<Shirt> getList(){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = "From Shirt s ";
        Query query = session.createQuery(sql);
        
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }
        session.close();
        return null;
	}
	
	public ArrayList<Shirt> getHotList(){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = "From Shirt s order by s.date desc";
        Query query = session.createQuery(sql).setMaxResults(8);
        
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }
        session.close();
        return null;
	}
	
	public ArrayList<Shirt> getTrendingList(){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = "From Shirt s order by s.sold desc";
        Query query = session.createQuery(sql).setMaxResults(4);
        
        ArrayList<Shirt> list = (ArrayList<Shirt>)query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }
        session.close();
        return null;
	}
	
	public Shirt getShirt(String sid){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
		String sql = " From Shirt s where s.id='" + sid + "'";
        Query query = session.createQuery(sql);
//        query.setParameter("sid", sid);
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        Shirt shirt = list.get(0);
        if (list.size() > 0) {
            session.close();
            return shirt;
        }
        session.close();
        return null;
	}
	
	public ArrayList<Shirt> searchByName(String name){
		System.out.println("search = "+name);
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
		String sql = "From Shirt s where s.name like '%" + name + "%'";
        Query query = session.createQuery(sql);
        System.out.println(query.toString());
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }
        session.close();
        return null;
	}
	
	public ArrayList<Shirt> getFilteredList(String cat, String gen, String mat, String siz, String low, String hig, String sor){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = "From Shirt s where";
        
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
//        if (!cat.equals("0")) {
//            query.setParameter("cat", cat);
//        }
//        query.setParameter("gen", gen);
//        if (!siz.equals("0")) {
//            query.setParameter("siz", siz);
//        }
//        query.setParameter("low", low);
//        if (!hig.equals("0")) {
//            query.setParameter("hig", hig);
//        }

        System.out.println(query.toString());
        ArrayList<Shirt> list =  (ArrayList<Shirt>)query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }
        session.close();
        return null;
	}
}
