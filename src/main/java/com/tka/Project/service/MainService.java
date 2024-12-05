package com.tka.Project.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Project.dao.MainDao;
import com.tka.Project.entity.Country;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	public String addRecord(Country c) {

		String msg=	dao.addRecord(c);

		if(Objects.isNull(msg))
		{
			msg="Country is not Added";
		}
		return msg;
	}
	public String updateRecord(Country c, int id) {
	
	String msg=	dao.updateRecord(c,id);

		return msg;
	}
	public String  deleteRecord(int id) {

	String msg=	dao.deleteRecord(id);
	return msg;
	}
	
	
	public List<Country> getAllRecord() {

	List<Country> list=dao.getAllRecord();
		return list;
	}
	
	
	public Country getbyId(int id) {

	Country country=	dao.getbyId(id);
	return country;
	}


}
