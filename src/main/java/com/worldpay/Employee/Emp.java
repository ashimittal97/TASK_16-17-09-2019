package com.worldpay.Employee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.worldpay.Vechicle;
import com.worldpay.Laptop.Laptop;
import com.worldpay.Pro.Projects;

@Entity
public class Emp {
	@Id
	private int eno;
	private String ename;
	private int sal;

	@OneToOne  (fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Laptop laptop;

	@OneToMany(mappedBy = "emp")
	private List<Vechicle> vechicle;

	@ManyToMany
	private List<Projects> projects = new ArrayList<Projects>();

	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

	public Emp(int eno) {
		super();
		this.eno = eno;
	}

	public List<Vechicle> getVechicle() {
		return vechicle;
	}

	public void setVechicle(List<Vechicle> vechicle) {
		this.vechicle = vechicle;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Emp(int eno, String ename, int sal) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.sal = sal;
	}

	public Emp() {
		super();
	}


	@Override
	public String toString() {
		return "Emp [eno=" + eno + ", ename=" + ename + ", sal=" + sal + ", laptop=" + laptop + ", vechicle=" + vechicle
				+ ", projects=" + projects + "]";
	}

	public Emp(int eno, String ename, int sal, Laptop laptop) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.sal = sal;
		this.laptop = laptop;
	}

	public Emp(int eno, String ename, int sal, Laptop laptop, List<Vechicle> vechicle) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.sal = sal;
		this.laptop = laptop;
		this.vechicle = vechicle;
	}

	public Emp(int eno, String ename, int sal, List<Projects> projects) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.sal = sal;
		this.projects = projects;
	}



}
