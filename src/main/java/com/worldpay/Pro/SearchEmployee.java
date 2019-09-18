package com.worldpay.Pro;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.ssi.Util;
import com.worldpay.Employee.Emp;

public class SearchEmployee {

	public static void main(String[] args) {
		Session session = Util.getSF().openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee number of employee you want to search details of..?");
		int en = sc.nextInt();
		Emp emp = session.get(Emp.class, en);
		System.out.println("Employee Number :" + emp.getEno());
		System.out.println("Employee Name   :" + emp.getEname());
		System.out.println("Employee Salary :" + emp.getSal());
		System.out.println("_____________________________________________________________________");
		List<Projects> projects = emp.getProjects();
		for(Projects project:projects){
			System.out.println(project.getPcode()+","+project.getPtitle());
		}
		session.close();
	}

}
