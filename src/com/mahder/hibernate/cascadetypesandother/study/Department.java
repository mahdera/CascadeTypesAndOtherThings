package com.mahder.hibernate.cascadetypesandother.study;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_DEPARTMENT")
public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="DEPARTMENT_ID")
	private int id;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name="DEPARTMENT_DESCRIPTION")
	private String description;
	
	@OneToMany(mappedBy="department",cascade=CascadeType.PERSIST)//When
	//Department is saved...save all unsaved teacherList object along with it...
	private List<Teacher> teacherList = new ArrayList<Teacher>();
	
	public Department(){
		
	}
	
	

	public Department(int id, String departmentName, String description,
			List<Teacher> teacherList) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.description = description;
		this.teacherList = teacherList;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	
}//end class
