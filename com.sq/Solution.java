package com.qs;

import java.util.Scanner;

import exception.InvalidChoiceException;

public class Solution {
		
		public static void main(String[] args) {
			
		Scanner sc =new Scanner(System.in);
		EmployeeDataBase e = new EmployeeDataBaseImplementation();
		while(true) {
			System.out.println("_______________________Welcome to EmployeeDataBase_________________________");
			System.out.println("press 1: AddEmployee");
			System.out.println("press 2: DisplayEmployee");
			System.out.println("press 3: DisplayAllEmployee");
			System.out.println("press 4: RemoveEmployee");
			System.out.println("press 5: UpdateEmployee");
			System.out.println("press 6: CountNoEmployee");
			System.out.println("press 7: GetEmployeeWithHighestSalary");
			System.out.println("press 8: GetEmployeeWithLowestSalary");
			System.out.println("press 9: RemoveAllEmployee");
			System.out.println("press 10: Exit");
			
			
			System.out.println("Enter Your Choice");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				e.AddEmployee();
				break;
				
			case 2:
				e.DisplayEmployee();
				break;
				
			case 3:
				e.DisplayAllEmployee();
				break;
				
			case 4:
				e.RemoveEmployee();
				break;
				
			case 5:
				e.UpdateEmployee();
				break;
					
			case 6:
				e.CountNoEmployee();
				break;
				
			case 7:
				e.GetEmployeeHighestSalary();
				break;
				
			case 8:
				e.GetEmployeeLowestSalary();
				break;
				
			case 9:
				e.RemoveAllEmployee();
				break;
				
			case 10:
				System.out.println("Thank you");
				System.exit(0);
				break;
				
			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}catch(Exception e2) {
					System.err.println(e2.getMessage());
				}
				
			}
			
		}
		}
	}


