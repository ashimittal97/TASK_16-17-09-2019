package com.worldpay.Pro;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.ssi.Util;
import com.worldpay.Employee.Emp;

public class SearchProjects {

	public static void main(String[] args) {
		Session session=Util.getSF().openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Project code for which you want to fetch details..");
		String pcode=sc.nextLine();
		Projects project=session.get(Projects.class,pcode);
		System.out.println(project.getPcode());
		System.out.println(project.getPtitle());
		System.out.println(project.getCost());
		
		List<Emp> employees=project.getEmployees();
		for(Emp emp:employees){
			System.out.println("Employee Number :" + emp.getEno());
			System.out.println("Employee Name   :" + emp.getEname());
			System.out.println("Employee Salary :" + emp.getSal());
		}
		
		
		session.close();

	}

}
