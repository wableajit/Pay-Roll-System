package com.Ajit.Oops;

import java.util.ArrayList;

abstract class Employee{
	private String name;
	private int id;
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	
  public abstract	double calculateSalary();
  
  @Override
  public String toString() {
	  return "Employee [ name = " + name + ", Id = " + id + " Salary = "+ calculateSalary()+" ]";
  	}
}

//--------------------------------------------------------------------------------------------------------------------------------------

class FullTimeEmployee extends Employee{
	private double monthlySalary;
	
	public FullTimeEmployee(String name, int id, double monthlySalary) {
		super(name, id);
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double calculateSalary() {
		return monthlySalary;
	}
}

//---------------------------------------------------------------------------------------------------------------------------------------


class PartTimeEmployee extends Employee{
	
	private int hoursWorked;
	private double hourSalary;
	
	public PartTimeEmployee(String name, int id, int hoursWorked,double hourSalary) {
		super(name, id);
		this.hoursWorked = hoursWorked;
		this.hourSalary = hourSalary;
	}

	@Override
	public double calculateSalary() {

		return (double)hourSalary * hourSalary;
	}
}
//--------------------------------------------------------------------------------------------------------------------------------------

class PayRoll{
	private ArrayList<Employee> employeeList;
	public PayRoll() {
		employeeList = new ArrayList<>();
	}
	
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	public void removeEmployee(int id) {
		Employee employeeToRemove = null;
		
		for(Employee employee: employeeList) {
			if(employee.getId()== id) {
				employeeToRemove = employee;
				break;
			}
		}
		
		if(employeeToRemove!= null) {
			employeeList.remove(employeeToRemove);
		}
	}
	
	public void displayEmployee() {
		for(Employee employee : employeeList) {
			System.out.println(employee);
		}
	}
	
}

public class Main {
public static void main(String[] args) {
	
	PayRoll payroll = new PayRoll();
		
	
	FullTimeEmployee ftp1 = new FullTimeEmployee("Rohan", 1, 90000 );
	PartTimeEmployee ptp1 = new PartTimeEmployee("Yash",  2, 40, 100);
	
	payroll.addEmployee(ftp1);
	payroll.addEmployee(ptp1);
	payroll.displayEmployee();
	System.out.println("Intitial Employess");
	payroll.removeEmployee(2);
	
	System.out.println("Remaining Epmloyees");
	payroll.displayEmployee();
}
}
