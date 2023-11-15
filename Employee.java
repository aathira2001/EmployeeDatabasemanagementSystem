package com.qs;

public class Employee {
             private int slno;
             private String id;
             private String name;
             private int age;
             private double salary;
             private String designation;
             static int count;
			public Employee(int slno, String name, int age, double salary, String designation) 
			{
				this.slno = slno;
				this.name = name;
				this.age = age;
				this.salary = salary;
				this.designation = designation;
				this.id="EMP" +(count++);
			}
			public int getSlno() {
				return slno;
			}
			public void setSlno(int slno) {
				this.slno = slno;
			}
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getAge() {
				return age;
			}
			public void setAge(int age) {
				this.age = age;
			}
			public double getSalary() {
				return salary;
			}
			public void setSalary(double salary) {
				this.salary = salary;
			}
			public String getDesignation() {
				return designation;
			}
			public void setDesignation(String designation) {
				this.designation = designation;
			}
			@Override
			public String toString() {
				return "Employee [slno=" + slno + ", id=" + id + ", name=" + name + ", age=" + age + ", salary="
						+ salary + ", designation=" + designation + "]";
			}
						
             
}
