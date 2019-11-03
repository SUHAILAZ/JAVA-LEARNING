package com.in28minutes.springboot.demo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.in28minutes.springboot.model.Employees;
import com.in28minutes.springboot.model.Payroll;
import com.in28minutes.springboot.service.EmployeesService; 

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesServiceTest {

	@Autowired
	EmployeesService employeeservice;
	private static List<Employees> employees = new ArrayList<>();
	private static List<Payroll> payroll= new ArrayList<>();
	private static List<Employees> emp = new ArrayList<>();
	private static List<Employees> e = new ArrayList<>();

	static {
		//Initialize Data
		Payroll p1 = new Payroll("1001","A1",1000.0,30,30,"November",2018);
		Payroll p2 = new Payroll("1002","A5",25000.0,30,30,"November",2018);
		Payroll p3 = new Payroll("1003","A6",55000.0,30,30,"November",2018);
		payroll.add(p1);
		payroll.add(p2);
		payroll.add(p3);
		
		Employees rohit= new Employees("1001","Rohit","Syam","South india",p1.getBasicPay()+p1.getDaysWorked()*100);

	Employees sujatha = new Employees("1002","Sujatha","reddy","North india",p2.getBasicPay()+p2.getDaysWorked()*100);
	Employees saran = new Employees("1003","Saran","reddy","North india",p3.getBasicPay()+p3.getDaysWorked()*100);
    Employees rohitnew=new Employees("1001","Rohit","Syam","South india",7400.0);
		employees.add(rohit);
		employees.add(sujatha);
		employees.add(saran);
		emp.add(sujatha);
		emp.add(saran);
		e.add(rohitnew);
	}
		
	@Test
	public void getAllEmployeesTest() {
		
	
		assertEquals(employees,employeeservice.getAllEmployees());
	}
	
	@Test
	public void getAllPayrollTest() {
		
	
		assertEquals(payroll,employeeservice.getAllPayroll());
	}
	
	@Test
	public void getEmployeeByIdTest() {
		
	
		assertEquals(employees.get(0),employeeservice.getEmployeeById("1001"));
	}
	@Test
	public void getNoEmployeeByIdTest() {
		
	
		assertNotEquals(employees.get(1),employeeservice.getEmployeeById("1001"));
	}
	
	@Test
	public void highestSalaryTest() {
	
	
		assertEquals(58000.0,employeeservice.highestSalary(),0);
	}
	@Test
	public void HighestSalaryNegTest() {
	
	
		assertNotEquals(59000.0,employeeservice.highestSalary(),0);
	}
	
	@Test
	public void salaryAbvTenThousandTest() {
	
	
		assertEquals(emp,employeeservice.salaryAbvTenThousand());
	}
	
	@Test
	public void salaryAbvTenThousandNegTest() {
	
	
		assertNotEquals(employees.get(0),employeeservice.salaryAbvTenThousand());
	}
	@Test
	public void setSalTest() {
	
	
		assertEquals(25000,employeeservice.setSal("1003"));
	}
	@Test
	public void setSalNegTest() {
	
	
		assertEquals(26000,employeeservice.setSal("1003"));
	}
	
	@Test
	public void updateBasicPayTest() {
	
	
		assertEquals(e,employeeservice.updateBasicPay());
	}
	
	
}
