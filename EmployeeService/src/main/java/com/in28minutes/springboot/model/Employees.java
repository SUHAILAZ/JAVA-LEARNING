package com.in28minutes.springboot.model;

import java.util.List;

public class Employees {
	private String empId;
	private String firstName;
	private String lastName;
	private String empAddress;
	private double grossSalary;
	
	public Employees()
	{
		
	}

	public Employees(String empId, String firstName,String lasttName,String empAddress,double grossSalary) {
		super();
		this.empId=empId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.empAddress=empAddress;
		this.grossSalary=grossSalary;
	}

	

	public String getEmpId() {
		return empId;
	}



	public void setEmpId(String empId) {
		this.empId = empId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmpAddress() {
		return empAddress;
	}



	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}




	public double getGrossSalary() {
		return grossSalary;
	}



	public void setGrossSalary(double grossSalary) {
		this.grossSalary=grossSalary;
	}



	@Override
	public String toString() {
		return String.format(
				"Employees [Empid=%s, Firstname=%s, Lastname=%s, EmpAddress=%s, Gross Salary=%s]", empId,firstName, lastName,empAddress,grossSalary);
	}
}
