package com.worldpay;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ssi.Util;
import com.worldpay.Employee.Emp;
import com.worldpay.Laptop.Laptop;
import com.worldpay.operations.CrudOperations;

public class EmployeeOperations implements CrudOperations {

	SessionFactory sessionFactory = Util.getSF();
	Session session = sessionFactory.openSession();
	Scanner sc;
	boolean exists;

	public void update() {
		sc = new Scanner(System.in);
		System.out.println("Chosse the coloumn you want the update the information of:");
		System.out.println("Chosse 1 for Employee Name");
		System.out.println("Chosse 2 for Employee Salary");
		System.out.println("Chosse 3 for Laptop Code");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			sc = new Scanner(System.in);
			System.out.println("Enter the code of the Employee you want to change name of");
			int eno = sc.nextInt();
			sc.nextLine();
			System.out.println("enter new employee name");
			String name = sc.nextLine();
			exists = (Long) session.createQuery("select count(*) from Emp where eno=" + eno + "").uniqueResult() > 0;
			if (exists == true) {
				Emp emp = session.get(Emp.class, eno);
				emp.setEname(name);
				Transaction tr = session.beginTransaction();
				session.update(emp);
				tr.commit();
				System.out.println("record has been  successfully updated...!");

			} else {
				System.out.println("record is not found");
			}
			break;

		case 2:
			sc = new Scanner(System.in);
			System.out.println("Enter the code of the Employee you want to change name of");
			int ecode = sc.nextInt();
			sc.nextLine();
			System.out.println("enter new salary of employee");
			int salary = sc.nextInt();
			exists = (Long) session.createQuery("select count(*) from Emp where eno=" + ecode + "").uniqueResult() > 0;
			if (exists == true) {
				Emp emp = session.get(Emp.class, ecode);
				emp.setSal(salary);
				Transaction tr = session.beginTransaction();
				session.update(emp);
				tr.commit();
				System.out.println("record has been  successfully updated...!");

			} else {
				System.out.println("record is not found");
			}
			break;

		case 3:
			sc = new Scanner(System.in);
			System.out.println("Enter the code of the employee ");
			int en = sc.nextInt();
			sc.nextLine();
			System.out.println("enter new laptop code");
			String lcode = sc.nextLine();
			exists = (Long) session.createQuery("select count(*) from Emp where eno=" + en + "").uniqueResult() > 0;
			if (exists == true) {
				Emp e = session.get(Emp.class, en);
				e.setLaptop(new Laptop(lcode));

				Transaction tr = session.beginTransaction();
				session.update(e);
				tr.commit();
				System.out.println("record has been  successfully updated...!");

			} else {
				System.out.println("record is not found");
			}
		}

	}

	public void delete() {
		sc = new Scanner(System.in);
		System.out.println("Enter the code of the Employee you want to delete information of");
		int empcode = sc.nextInt();
		exists = (Long) session.createQuery("select count(*) from Emp where eno=" + empcode + "")
				.uniqueResult() > 0;
		if (exists == true) {
			Emp e=session.get(Emp.class, empcode);
			Transaction tr=session.beginTransaction();
			session.delete(e);
			tr.commit();
			System.out.println("record has been deleted successfully...!");
		} else {
			System.out.println("record not found..!");
		}
		session.close();
	}

	public void viewAll() {
        String view="from Emp";
		
		Transaction tx = session.beginTransaction();
		Query query1 = session.createQuery(view);
		List<Emp> employees = query1.list();
		for (Emp e : employees) {
			System.out.println("List of Employees::" + e.getEno()+ "," +e.getEname()+ ","
					+e.getSal() + "");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------");
		}
	}

	public static void main(String[] args) {
		CrudOperations c = new EmployeeOperations();
		//c.update();
		c.delete();

	}
}
