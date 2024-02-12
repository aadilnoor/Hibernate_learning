package com.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Projects {
	@Id
	@Column(name = "project_id")
	private int pid;
	@Column(name = "project_name")
	private String projectname;
	
	@ManyToMany(mappedBy = "projects")
	private List<Employee> emps;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	public Projects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Projects(int pid, String projectname, List<Employee> emps) {
		super();
		this.pid = pid;
		this.projectname = projectname;
		this.emps = emps;
	}
	
	
}
