package com.qs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import exception.EmployeeNotFoundException;

public class EmployeeDataBaseImplementation implements EmployeeDataBase{
	
	Scanner sc = new Scanner(System.in);

	@Override
		public void AddEmployee() {
		System.out.println("Eneter the Employee slno");
		int slno =sc.nextInt();
		System.out.println("Eneter the Employee name");
		String name =sc.next();
		System.out.println("Eneter the Employee age");
		int age = sc.nextInt();
		System.out.println("Eneter the Employee salary");
		double salary = sc.nextDouble();
		System.out.println("Eneter the Employee designation");
		String designation=sc.next();
		Employee employee = new Employee(slno,name,age,salary,designation);
		String id = employee.getId();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
			PreparedStatement preparedStatement =connection.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, slno);
			preparedStatement.setString(2, id);
			preparedStatement.setString(3, name);
			preparedStatement.setInt(4, age);
			preparedStatement.setDouble(5, salary);
			preparedStatement.setString(6, designation);
			preparedStatement.execute();
			System.out.println("Employee Record Inserted" + "/n Your Id is " + employee.getId());
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
@Override
	public void DisplayEmployee() {
		System.out.println("Enter employeeID");
		String id = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
			PreparedStatement preparedStatement =connection.prepareStatement("select * from employee where id = ?");
			preparedStatement.setString(1, id);
			ResultSet resultSet =preparedStatement.executeQuery();
			if(resultSet.next()) {
				
					System.out.println("the emp slno is : " +resultSet.getInt(1));
					System.out.println("the emp id is : " +resultSet.getString(2));
					System.out.println("the emp name is : " +resultSet.getString(3));
					System.out.println("the emp age is : " +resultSet.getInt(4));
					System.out.println("the emp salary is : " +resultSet.getDouble(5));
					System.out.println("the emp designation is : " +resultSet.getString(6));
					
			}
			else {
				try {
				throw new EmployeeNotFoundException("employee not found");
				}
				catch(Exception e1){
					System.out.println(e1.getMessage());
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public  void DisplayAllEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
			PreparedStatement preparedStatement =connection.prepareStatement("select * from employee");
			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("the emp slno is : " +resultSet.getInt(1));
				System.out.println("the emp id is : " +resultSet.getString(2));
				System.out.println("the emp name is : " +resultSet.getString(3));
				System.out.println("the emp age is : " +resultSet.getInt(4));
				System.out.println("the emp salary is : " +resultSet.getDouble(5));
				System.out.println("the emp designation is : " +resultSet.getString(6));
				System.out.println("______________________________________________________");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}



	public void RemoveEmployee() {
		System.out.println("Enter employeeID");
		String id = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
			PreparedStatement preparedStatement =connection.prepareStatement("Delete from employee where id =?");
			preparedStatement.setString(1, id);
			preparedStatement.execute();
			System.out.println("employee removed");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void UpdateEmployee() {

		System.out.println("Enter the employeeid");
		String id=sc.next();		
		
		System.out.println("press a: Update age");
		System.out.println("press b: Update name");
		System.out.println("press c: Update salary");
		
		char ch=sc.next().charAt(0);
		switch(ch) {
		case 'a':
			System.out.println("Enter the new age:");
			int newage=sc.nextInt();
		
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
			PreparedStatement preparedStatement =connection.prepareStatement("update employee set age=? where id =?");
			preparedStatement.setDouble(1, newage);
			preparedStatement.setString(2, id);
			preparedStatement.execute();
			System.out.println("age updated successfully");

			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
				
		}
			break;
			
		case 'b':
			System.out.println("Enter the new name:");
			String newname=sc.next();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
				PreparedStatement preparedStatement =connection.prepareStatement("update employee set name=? where id =?");
				preparedStatement.setString(1, newname);
				preparedStatement.setString(2, id);
				preparedStatement.execute();
				System.out.println("name updated successfully");

				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
					
			}
				break;
		case 'c':
			System.out.println("Enter the new salary:");
			double newsalary=sc.nextDouble();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
				PreparedStatement preparedStatement =connection.prepareStatement("update employee set salary=? where id =?");
				preparedStatement.setDouble(1, newsalary);
				preparedStatement.setString(2, id);
				preparedStatement.execute();
				System.out.println("salary updated successfully");

				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
					
			}
		}
	}
	@Override
	public void CountNoEmployee() {
		int a=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
			PreparedStatement preparedStatement =connection.prepareStatement("select count(*) from employee");
			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()) {
				a=resultSet.getInt(1);
			}
			System.out.println("The no of employees "+a);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void GetEmployeeHighestSalary() {
		Double salary=0.0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
			PreparedStatement preparedStatement =connection.prepareStatement("select max(salary) from employee");
			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()) {
				salary=resultSet.getDouble(1);
			}
			System.out.println("The highest salary is "+salary);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void GetEmployeeLowestSalary() {
		Double salary=0.0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
			PreparedStatement preparedStatement =connection.prepareStatement("select min(salary) from employee");
			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()) {
				salary=resultSet.getDouble(1);
			}
			System.out.println("The lowest salary is "+salary);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void RemoveAllEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
			PreparedStatement preparedStatement =connection.prepareStatement("truncate table employee");
			preparedStatement.execute();
			System.out.println("data deleted");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}


