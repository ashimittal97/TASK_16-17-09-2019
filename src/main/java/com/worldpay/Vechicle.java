package com.worldpay;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.worldpay.Employee.Emp;
import com.worldpay.operations.CrudOperations;


@Entity

public class Vechicle {
	@Id
	@Column(name="vechilecode" ,nullable=false)
	private int vcode;
	@Column(name="vechilename")
	private String vname;
	private String Brand;
	private int price;
	
	@ManyToOne
	private Emp emp;
	
	 
	 
	
	

	@Override
	public String toString() {
		return "Vechicle [vcode=" + vcode + ", vname=" + vname + ", Brand=" + Brand + ", price=" + price + ", emp="
				+ emp + "]";
	}

	public int getVcode() {
		return vcode;
	}

	public void setVcode(int vcode) {
		this.vcode = vcode;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Vechicle(int vcode, String vname, String brand, int price, Emp emp) {
		super();
		this.vcode = vcode;
		this.vname = vname;
		Brand = brand;
		this.price = price;
		this.emp = emp;
	}

	public Vechicle() {
		super();
	}

	public Vechicle(int vcode, String vname, String brand, int price) {
		super();
		this.vcode = vcode;
		this.vname = vname;
		Brand = brand;
		this.price = price;
	}
	

}
