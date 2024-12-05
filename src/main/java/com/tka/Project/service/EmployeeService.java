package com.tka.Project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.xml.crypto.dsig.XMLObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Project.dao.EmployeeDao;
import com.tka.Project.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public String addRecord(Employee e) {

	String msg=	dao.addRecord(e);
	return msg;
	}

	public String updateData(Employee e, long id) {

	String msg=	dao.updateData(e,id);
	return msg;
	}

	public String deleteData(long id) {

	String msg=	dao.deleteData(id);
	return msg;
	}

	public List<Employee> getAllRecord() {

	List<Employee>list=	dao.getAllRecord();
	return list;
	}

	public Employee getParticularId(long id) {

	Employee emp=	dao.getParticularId(id);
	return emp;
	}

	public Map login(Employee e) {

	Employee obj=	dao.login(e);
		
		Map map=new HashMap();
		if(Objects.isNull(obj))
			
		{
		map.put("msg", "Invalid User");
		map.put("user", obj);
		}
		
		else {
			map.put("msg","Valid User");
			map.put("user", obj);
		}
		return map;
	}

	public List<Employee> salaryRange(double startsal, double endSal) {

	List<Employee>list=	dao.salaryRange(startsal,endSal);
		
		return list;
	}

	public List<Employee> getStatus(String status) {

	List<Employee>list=	dao.getStatus(status);
		return list;
	}

	public Employee updateStatus(int id) {

	Employee emp=dao.updateStatus(id);
		return emp;
	}
	
	


}
