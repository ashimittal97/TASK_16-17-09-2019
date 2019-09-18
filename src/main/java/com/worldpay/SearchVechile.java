package com.worldpay;

import java.util.Scanner;

import org.hibernate.Session;

import com.ssi.Util;

public class SearchVechile {
	public static void main(String args[]){
		Session session=Util.getSF().openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the vechicle code of the vechicle you wannna search information of?");
		int id=sc.nextInt();
		  Vechicle vechicle= session.get(Vechicle.class, id);
		  System.out.println("Vechicle code :"+vechicle.getVcode());
		  System.out.println("Vechicle name :"+vechicle.getVname());
		  System.out.println("Vechicle Brand:"+vechicle.getBrand());
		  System.out.println("Vechicle Price:"+vechicle.getPrice());
		  System.out.println("Employee Number:"+vechicle.getEmp().getEno());
		  System.out.println("Employee Name:"+vechicle.getEmp().getEname());
		  System.out.println("Employee Sal:"+vechicle.getEmp().getSal());
		  session.close();
	}

}
