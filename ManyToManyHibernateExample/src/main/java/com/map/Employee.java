package com.map;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	@Column(name = "employee_id")
	private int eid;

	@Column(name = "employee_name")
	private String ename;

	@ManyToMany
	@JoinTable
	(
	    name = "emp_learn",
	    joinColumns = { @JoinColumn(name ="eid") },
	    inverseJoinColumns = { @JoinColumn(name="pid")}
	    
	)
	private List<Projects> projects;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String ename, List<Projects> projects) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.projects = projects;
	}

}
