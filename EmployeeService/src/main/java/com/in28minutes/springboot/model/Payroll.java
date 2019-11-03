package com.in28minutes.springboot.model;



public class Payroll {
	private String empId;
	private String jobLevel;
	private double basicPay;
	private int daysWorked;
	private int totalWorkingDays;
	private String month;
	private int year;
	
	
	public Payroll( String empId,String jobLevel,double basicPay, int daysWorked,int totalWorkingDays, String month,int year) 
	{this.empId=empId;
	this.jobLevel=jobLevel;
	this.basicPay=basicPay;
	this.daysWorked=daysWorked;
	this.totalWorkingDays=totalWorkingDays;
	this.month=month;
	this.year=year;

	}

	public Payroll() {
		super();
		this.empId=empId;
		this.jobLevel=jobLevel;
		this.basicPay=basicPay;
		this.daysWorked=daysWorked;
		this.totalWorkingDays=totalWorkingDays;
		this.month=month;
		this.year=year;
	}

	

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	public double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}

	public int getDaysWorked() {
		return daysWorked;
	}

	public void setDaysWorked(int daysWorked) {
		this.daysWorked = daysWorked;
	}

	public int getTotalWorkingDays() {
		return totalWorkingDays;
	}

	public void setTotalWorkingDays(int totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return String.format(
				"Payroll  [Empid=%s,JobLevel=%s,basicpay=%s,totalWorkinDays=%s,daysWorked=%s,month=%s,year=%s ]",empId, jobLevel,basicPay,totalWorkingDays,daysWorked,month,year);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payroll other = (Payroll) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}

}