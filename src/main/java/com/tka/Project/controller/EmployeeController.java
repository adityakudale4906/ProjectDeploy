package com.tka.Project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.Project.entity.Employee;
import com.tka.Project.service.EmployeeService;

@RestController
@RequestMapping("Empapi")
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeService service;
	@PostMapping("addrecord")
	public String addRecord(@RequestBody Employee e)
	{
	String msg=	service.addRecord(e);
	return msg;
	}
	
	
	@PutMapping("updaterecord/{id}")
	public String updateData(@RequestBody Employee e, @PathVariable long id)
	{
	String msg=	service.updateData(e, id);
	return msg;
	}
	
	
	@DeleteMapping("deleterecord/{id}")
	public String deleteData(@PathVariable long id)
	{
	String msg=	service.deleteData(id);
	return msg;
	}
	
	@GetMapping("getallrecord")
	public List<Employee> getAllRecord()
	{
	List<Employee>list=	service.getAllRecord();
	return list;
	}
	
	
	@GetMapping("getbyid/{id}")
	public Employee getParticularId(@PathVariable long id)
	{
	Employee emp=	service.getParticularId(id);
	return emp;
	
	}
	
	
	
	//Login API
	
	@PostMapping("login")
	public ResponseEntity<Map> login(@RequestBody Employee e)
	{
	Map map=service.login(e);
	return ResponseEntity.ok(map);
	}
	
	@GetMapping("salaryrange/{startsal}/{endSal}")
	public ResponseEntity<List<Employee>> salaryRange(@PathVariable double startsal,@PathVariable double endSal)
	{
		
List <Employee>list=service.salaryRange(startsal,endSal);
return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("gettatus/{status}")
	public ResponseEntity<List<Employee>> getStatus(@PathVariable String status)
	{
	List<Employee>list=	service.getStatus(status);
		return ResponseEntity.ok(list);
		
	}
	
	
	@GetMapping("updatestatus/{id}")
	public ResponseEntity updateStatus(@PathVariable int id)
	{
	Employee emp=	service.updateStatus(id);
		return ResponseEntity.ok(emp);
	}
	
}
