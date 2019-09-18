package com.worldpay;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ssi.Util;
import com.worldpay.Employee.Emp;
import com.worldpay.operations.CrudOperations;

public class VechicleEntry {

	public static void main(String[] args) {
		CrudOperations cd;
		SessionFactory sf=Util.getSF();
		Session session=sf.openSession();
		//book entry
		Vechicle vechicle1=new Vechicle(1,"BMW","BMW",2000000,new Emp(111));
		Vechicle vechicle2=new Vechicle(2,"HONDA-CITY","MARUTI",1800000,new Emp(111));
		Vechicle vechicle3=new Vechicle(3,"LAMBOGINI","LEMBOGINI",20000000,new Emp(112));
		Transaction tr=session.beginTransaction();
		session.save(vechicle1); session.save(vechicle2);
		session.save(vechicle3); 
		tr.commit();
		session.close();
		System.out.println("RECORD ADDED");
		
	}

	}


