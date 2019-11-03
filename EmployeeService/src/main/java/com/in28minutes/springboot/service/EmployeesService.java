package com.in28minutes.springboot.service;

import java.math.BigInteger;
import java.util.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.in28minutes.springboot.model.Employees;
import com.in28minutes.springboot.model.Payroll;

 
@Component
public class EmployeesService {
	private static List<Employees> employees = new ArrayList<>();
	private static List<Payroll> payroll= new ArrayList<>();

	static {
		//Initialize Data
		Payroll p1 = new Payroll("1001","A1",3000.0,30,30,"November",2018);
		Payroll p2 = new Payroll("1002","A5",25000.0,30,30,"November",2018);
		Payroll p3 = new Payroll("1003","A6",55000.0,30,30,"November",2018);
		payroll.add(p1);
		payroll.add(p2);
		payroll.add(p3);
		
		Employees rohit= new Employees("1001","Rohit","Syam","South india",p1.getBasicPay()+p1.getDaysWorked()*100);

	Employees sujatha = new Employees("1002","Sujatha","reddy","North india",p2.getBasicPay()+p2.getDaysWorked()*100);
	Employees saran = new Employees("1003","Saran","reddy","North india",p3.getBasicPay()+p3.getDaysWorked()*100);

		employees.add(rohit);
		employees.add(sujatha);
		employees.add(saran);
;
	}

	public List<Employees> getAllEmployees() {
		return employees;
	}
	public List<Payroll> getAllPayroll() {
		return payroll;
	}
	
	public Employees getEmployeeById(String empId) {
		Employees emp=employees.stream().filter(e->e.getEmpId().equals(empId)).findAny().orElse(null);
		return emp;
	
		
		
		
	}
	public void insert (String empId)
	{   Payroll p=new Payroll(empId,"A2",4000.0,30,30,"November",2018);
	    payroll.add(p);
		Employees emp=new Employees(empId,"suhu","sa","nn",p.getBasicPay()+p.getDaysWorked()*100);
		employees.add(emp);
		
	}
  
	
	
     public double highestSalary()
     {
      List<Employees> employees=getAllEmployees();
      Employees emp=employees.stream().collect(Collectors
    		                          .maxBy(Comparator.comparingDouble(Employees::getGrossSalary))).get();
      return emp.getGrossSalary();
    }
     
     
     public List<Employees> salaryAbvTenThousand()
     {    
    	 List<Employees> employees=getAllEmployees();
    	 return employees.stream().filter(emp->emp.getGrossSalary()>10000).collect(Collectors.toList());
    	 
     }
     
     public List<Employees> setSal(String empId)
     {
    	 List<Employees> empList=getAllEmployees();
    	 empList.stream().filter(emp->emp.getEmpId().equals(1003)).forEach(emp->emp.setGrossSalary(25000));

    	 
    	 
    	 return empList;
     }
     
     
    public List<Employees> updateBasicPay()
    {
    for(Employees emp:employees) {
    	for(Payroll pay:payroll) {
    		if(emp.getEmpId().equals(pay.getEmpId()))
    		{
    			 double basicPay = pay.getBasicPay();
				 pay.setBasicPay(basicPay+(basicPay*.1));
				 double newGrossSalary = pay.getBasicPay()+pay.getDaysWorked()*100;
				 emp.setGrossSalary(newGrossSalary);
    		}
    	}
    	}
    		return employees;
    }
  
    
	

	public Employees addEmployee(String empId) {
		Employees employee = getEmployeeById(empId);

		if (employee != null) {
			System.out.println("Exists");
		}
		else
		{
			insert(empId);
			
		}

		
		return employee;
	}
}