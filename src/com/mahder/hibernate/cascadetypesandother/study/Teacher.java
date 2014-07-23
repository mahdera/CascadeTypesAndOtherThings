package com.mahder.hibernate.cascadetypesandother.study;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="TBL_TEACHER")
public class Teacher implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="TEACHER_ID")
	private int id;
	
	@Column(name="TEACHER_FULL_NAME")
	private String fullName;
	
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	@NotFound(action=NotFoundAction.IGNORE)//if the matching record from the many side is not found...
	private Department department;
	
	public Teacher(){
		
	}

	public Teacher(int id, String fullName, Department department) {		
		this.id = id;
		this.fullName = fullName;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}//end class
