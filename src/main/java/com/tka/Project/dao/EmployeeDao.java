package com.tka.Project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.Project.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory factory;
	public String addRecord(Employee e) {

		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		
		try
		{
			session=factory.openSession();
			tx=session.beginTransaction();
			session.persist(e);
			tx.commit();
			
			msg="Employee Added Successfully";
			
		}
		
		catch(Exception e1)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e1.printStackTrace();
		}finally {
			if(session!=null)
			{
				session.close();
			}
		}
		return msg;
		
	}
	public String updateData(Employee e, long id) {

		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try
		{
			session=factory.openSession();
			tx=session.beginTransaction();
			Employee emp=session.get(Employee.class, id);
			emp.setSalary(e.getSalary());
			emp.setStatus(e.getStatus());
			emp.setEmailid(e.getEmailid());
			emp.setMobileno(e.getMobileno());
			emp.setCreatedBy(e.getCreatedBy());
			emp.setCreatedDate(e.getCreatedDate());
			emp.setUpdatedBy(e.getUpdatedBy());
			emp.setUpdatedDate(e.getUpdatedDate());
			emp.setDepartment(e.getDepartment());
			emp.setName(e.getName());
			
			session.merge(emp);
			tx.commit();
			
			msg ="Updated Data Successfully";
			
		}
		catch(Exception e1)
		{
			
			if(tx!=null)
			{
				tx.rollback();
			}
			e1.printStackTrace();
		}
		finally {
			if(session!=null)
			{
				session.close();
			}
		}
		return msg;
		
		
		
	}
	public String deleteData(long id) {

		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		
		try
		{
			session=factory.openSession();
			tx=session.beginTransaction();
			
		Employee e1=	session.get(Employee.class, id);
		session.remove(e1);
		tx.commit();
		
		msg="Delete data Successfully";
		
			
		}catch(Exception e1)
		{
		if(tx!=null)
		{
			tx.rollback();
		}
		
			
			e1.printStackTrace();
		}finally {
			if(session!=null)
				{
					session.close();
				}
		}
		return msg;
	}
	public List<Employee> getAllRecord() {

		Session session=null;
		Transaction tx=null;
		List<Employee>list=null;
		
		try
		{
			session=factory.openSession();
			tx=session.beginTransaction();
			
			String hql="from Employee";
		Query<Employee>query=	session.createQuery(hql,Employee.class);
		 list=query.list();	
		 
		tx.commit();
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
		}
		finally {
			if(session!=null)
			{
				session.close();
			}
		}
		return list;
	}
	public Employee getParticularId(long id) {

		Session session=null;
		Transaction tx=null;
		Employee emp=null;
		
		
		try
		{
		session=factory.openSession();
		tx=session.beginTransaction();
		
		emp=session.get(Employee.class, id);
		
		tx.commit();
		
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
			{
				session.close();
			}
			
		}
		return emp;
	}
	
	
	
	
	public Employee login(Employee e) {

		Session session=null;
		Transaction tx=null;
		Employee emp=null;
		String hquery="from Employee where emailid=:emailid and mobileno=:mobileno";
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
		Query<Employee>query=session.createQuery(hquery,Employee.class);
		query.setParameter("emailid", e.getEmailid());
		query.setParameter("mobileno", e.getMobileno());
		emp= query.uniqueResult();
		tx.commit();
		}
		catch(Exception e1)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e1.printStackTrace();
		}
		finally
		{
			if(session!=null)
			{
				session.close();
			}
			
		}
		

		return emp;
	}
	public List<Employee> salaryRange(double startsal, double endSal) {
			
		Session session=null;
		Transaction tx=null;
		List<Employee>list=null;
	String	hqlQuery="from Employee where salary between :startsal and :endSal";
		
		try
		{
			session=factory.openSession();
			tx=session.beginTransaction();
			
		Query<Employee>query=	session.createQuery(hqlQuery,Employee.class);
		query.setParameter("startsal", startsal);
		query.setParameter("endSal", endSal);
		
		 list=query.list();	
		 
		tx.commit();
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
		}
		finally {
			if(session!=null)
			{
				session.close();
			}
		}
		return list;
	
	}
	public List<Employee> getStatus(String status) {

		Session session=null;
		Transaction tx=null;
		List<Employee>list=null;
		
		try
		{
			session=factory.openSession();
			tx=session.beginTransaction();
			
			String hql="from Employee where status=:status";
		Query<Employee>query=	session.createQuery(hql,Employee.class);
		query.setParameter("status", status);
		 list=query.list();	
		 
		tx.commit();
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
		}
		finally {
			if(session!=null)
			{
				session.close();
			}
		}
		return list;
	}
	public Employee updateStatus(int id) {

		Session session=null;
		Transaction tx=null;
		Employee emp=null;
		
		
		try
		{
		session=factory.openSession();
		tx=session.beginTransaction();
		
		emp=session.get(Employee.class, id);
		
		
		
		
		
		if("active".equals(emp.getStatus()))
		{
			emp.setStatus("inactive");
			session.merge(emp);
			String msg="Update Data Sucessfully";
		}
		else if("inactive".equals(emp.getStatus()))
		{
			emp.setStatus("active");
			session.merge(emp);
		}
		
		else
		{
			
		
		String	msg="Suspend employee does not change status";	
		}
		
		
		
		
		
		tx.commit();
		
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
			{
				session.close();
			}
			
		}
		return emp;
	}

	
}
