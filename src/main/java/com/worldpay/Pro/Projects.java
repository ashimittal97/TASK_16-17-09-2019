package com.worldpay.Pro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.worldpay.Employee.Emp;


@Entity
public class Projects {
	@Id
	private String pcode;
	private String ptitle;
	private int cost;
	@ManyToMany(mappedBy = "projects")
	List<Emp> employees = new ArrayList<Emp>();

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public List<Emp> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Emp> employees) {
		this.employees = employees;
	}

	public Projects(String pcode, String ptitle, int cost) {

		this.pcode = pcode;
		this.ptitle = ptitle;
		this.cost = cost;
	}

	public Projects(String pcode, String ptitle, int cost, List<Emp> employees) {
		super();
		this.pcode = pcode;
		this.ptitle = ptitle;
		this.cost = cost;
		this.employees = employees;
	}

	public Projects() {
		super();
	}

	public Projects(String pcode) {
		super();
		this.pcode = pcode;
	}

	



}
