package com.worldpay.Pro;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ssi.Util;

public class ProjectEntry {

	public static void main(String[] args) {
		Projects p1 = new Projects("p111", "PTS", 7390000);
		Projects p2 = new Projects("p112", "AWS", 8900000);
		Projects p3 = new Projects("p113", "CYUS", 880000);
		Session session = Util.getSF().openSession();
		Transaction tr = session.beginTransaction();
		session.save(p2);
		session.save(p1);
		session.save(p3);

		tr.commit();
		session.close();
		System.out.println("PROJECT STORED");
	}

}
