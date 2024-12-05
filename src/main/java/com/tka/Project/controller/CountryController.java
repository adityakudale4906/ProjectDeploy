package com.tka.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.Project.entity.Country;
import com.tka.Project.service.MainService;

@RestController
@RequestMapping("api")
public class CountryController {

	@Autowired
	MainService service;
	
	@PostMapping("addrecord")
	public ResponseEntity<String> addRecord(@RequestBody Country c)
	{
	String msg=	service.addRecord(c);
	return ResponseEntity.ok(msg);
	}
	
	
	@PutMapping("updaterecord/{id}")
	public ResponseEntity<String>  updateRecord(@RequestBody Country c, @PathVariable int id)
	{
	String msg=	service.updateRecord(c,id);
	return ResponseEntity.ok(msg);
	}
	
	
	@DeleteMapping("deleterecord/{id}")
	public ResponseEntity<String> deleteRecord(@PathVariable int id)
	{
	String msg=	service.deleteRecord(id);
	return ResponseEntity.ok(msg);
	}
	
	
	@GetMapping("getallrecord")
	public List<Country> getAllRecord()
	{
	List<Country> list=	service.getAllRecord();
	return list;
	}
	
	
	
	@GetMapping("getrecordid/{id}")
	public ResponseEntity<Country> getbyId(@PathVariable int id)
	{
	Country country=	service.getbyId(id);
	return ResponseEntity.ok(country);
	}
}
