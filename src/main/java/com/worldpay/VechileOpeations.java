package com.worldpay;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;

import com.ssi.Util;
import com.worldpay.operations.CrudOperations;

public class VechileOpeations implements CrudOperations {
	static SessionFactory sessionFactory = Util.getSF();
	static Session session = sessionFactory.openSession();
	Scanner sc;
	boolean exists;

	public void update() {
		sc = new Scanner(System.in);
		System.out.println("Chosse the coloumn you want the update the information of:");
		System.out.println("Chosse 1 for Vechicle name");
		System.out.println("Chosse 2 for Vechicle Brand");
		System.out.println("Chosse 3 for Vechicle Price");
		int choice = sc.nextInt();
		switch (choice) {

		case 1:

			sc = new Scanner(System.in);
			System.out.println("Enter the code of the vechile for which you want to update name...?");
			int code = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the name of the vechile");
			String name = sc.nextLine();
			exists = (Long) session.createQuery("select count(*) from Vechicle where vcode=" + code + "")
					.uniqueResult() > 0;

			if (exists == true) {
				Transaction tr = session.beginTransaction();

				String hql = "UPDATE Vechicle SET vname=:v_name where vcode=:vcode";
				Query query1 = session.createQuery(hql);

				query1.setParameter("vcode", code);
				query1.setParameter("v_name", name);
				int no = query1.executeUpdate();
				tr.commit();
				System.out.println("Total rows updated" + "=" + no);
				System.out.println(
						"---------------------------------------------------------------------------------------");
			} else {
				System.out.println("The entry for vechicle for respective code doesnt exists");
			}
			break;
		case 2:

			sc = new Scanner(System.in);
			System.out.println("Enter the code of the vechile for which you want to update name...?");
			int vcode = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Brand of the vechile");
			String Brand = sc.nextLine();
			exists = (Long) session.createQuery("select count(*) from Vechicle where vcode=" + vcode + "")
					.uniqueResult() > 0;
			if (exists == true) {
				Transaction tr1 = session.beginTransaction();
				String hql1 = "UPDATE  Vechicle set Brand=:v_Brand where vcode=:vcode ";
				Query query2 = session.createQuery(hql1);

				query2.setParameter("Brand", Brand);
				query2.setParameter("vcode", vcode);
				int no1 = query2.executeUpdate();
				tr1.commit();
				System.out.println("Total rows updated" + "=" + no1);
				System.out.println(
						"---------------------------------------------------------------------------------------");
			} else {
				System.out.println("The entry for vechicle for respective code doesnt exists");
			}
			break;
		case 3:

			sc = new Scanner(System.in);
			System.out.println("Enter the code of the vechile for which you want to update name...?");
			int vno = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Price of the vechile");
			int price = sc.nextInt();
			exists = (Long) session.createQuery("select count(*) from Vechicle where vcode=" + vno + "")
					.uniqueResult() > 0;
			if (exists == true) {
				String hql2 = "UPDATE  Vechicle set price=:v_price where vcode=:vcode ";
				Transaction tr2 = session.beginTransaction();
				Query query3 = session.createQuery(hql2);

				query3.setParameter("v_price", price);
				query3.setParameter("vcode", vno);
				int no2 = query3.executeUpdate();
				tr2.commit();
				System.out.println("Total rows updated" + "=" + no2);
				System.out.println(
						"---------------------------------------------------------------------------------------");
			} else {
				System.out.println("The entry for vechicle for respective code doesnt exists");
			}
			break;

		default:
			break;

		}

	}

	public void delete() {

		sc = new Scanner(System.in);
		System.out.println("Enter the code of the vechicle you want to delete");
		int vdelete = sc.nextInt();
		exists = (Long) session.createQuery("select count(*) from Vechicle where vcode=" + vdelete + "")
				.uniqueResult() > 0;
		if (exists == true) {
			Vechicle vechicle = session.get(Vechicle.class, vdelete);
			Transaction tr=session.beginTransaction();
			session.delete(vechicle);
			tr.commit();
			System.out.println("record has been deleted successfully...!");
		} else{
			System.out.println("record not found..!");
		}
		session.close();
	}
	public void viewAll() {
		String view="from Vechicle";
		
		Transaction tx = session.beginTransaction();
		Query query1 = session.createQuery(view);
		List<Vechicle> vechicle = query1.list();
		for (Vechicle v : vechicle) {
			System.out.println("List of Vechicles::" + v.getVname()+ "," + v.getVcode() + ","
					+ v.getPrice() + "," + v.getBrand() + "");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------");
		}
		
	}

	public static void main(String args[]) {
		CrudOperations c= new VechileOpeations();
		//c.update();
		//c.delete();
		c.viewAll();
	}

	

}
