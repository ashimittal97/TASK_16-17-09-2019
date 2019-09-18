package com.worldpay;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.ssi.Util;
import com.worldpay.Employee.Emp;

public class SearchEmpVech {

	public static void main(String[] args) {
		Session session = Util.getSF().openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee number you want information of ..?");
		int enumber = sc.nextInt();
		Emp emp = session.get(Emp.class, enumber);
		System.out.println("Employee Number :" + emp.getEno());
		System.out.println("Employee Name   :" + emp.getEname());
		System.out.println("Employee Salary :" + emp.getSal());
		System.out.println("_________________________________________________________");
		List<Vechicle> vechicles = emp.getVechicle();
		for (Vechicle vechicle : vechicles) {
			System.out.println(vechicle.getVcode());
			System.out.println(vechicle.getVname());
			System.out.println(vechicle.getPrice());
			System.out.println(vechicle.getBrand());
			System.out.println("_________________________________________________________");

		}

	}

}
