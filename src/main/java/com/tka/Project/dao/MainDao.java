package com.tka.Project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.Project.entity.Country;
@Repository
public class MainDao {

	@Autowired
	SessionFactory factory; 
	public String addRecord(Country c) {

		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try
		{
			session=factory.openSession();
			tx=session.beginTransaction();
			session.persist(c);
			tx.commit();
			
			msg="Country Added Successfully";
			
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null)
			{
				session.close();
			}
		}
		
		return msg;
	}
	
	public String updateRecord(Country c, int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try
		{
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Country country=session.get(Country.class, id);
			country.setCname(c.getCname());
			
			session.merge(country);
			tx.commit();
			
			msg="Update data successfully";
			
			
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null)
			{
				session.close();
			}
		}
		
		
		return msg;		
	}

	public String deleteRecord(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try
		{
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Country country=session.get(Country.class, id);
			session.remove(country);
			tx.commit();

			msg="Delete Data Successfully";
			
			
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null)
			{
				session.close();
			}
		}
		return msg;
		
		
	}

	public List<Country> getAllRecord() {

		Session session=null;
		Transaction tx=null;
		String msg=null;
		List<Country>list=null;
		
		try
		{
		session=factory.openSession();
		tx=session.beginTransaction();
		
		
		String hql="from Country";
	Query<Country>query=	session.createQuery(hql,Country.class);
	
	list=query.list();
	
	tx.commit();
	
	msg="Display All Record";
		}catch(Exception e)
		{
			
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally
		{
			if(session!=null)
			{
				session.close();
			}
		}
		
		return list;
	}

	public Country getbyId(int id) {
		
		Session session=null;
		Transaction tx=null;

		Country country=null;
		
		try
		{
		session=factory.openSession();
		tx=session.beginTransaction();
		
		country=session.get(Country.class, id);
		tx.commit();
		
		
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null)
			{
				session.close();
			}
		}
		return country;
	}

}
