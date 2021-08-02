package com.anurag.DemoHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
	private int lid;
	private String lname;
	
//	
//	@ManyToOne
//	private Student student;
	public int getLid() {
		return lid;
	}
//	@ManyToOne
//	private Alien alien;
	
	
//
//	public Student getStudent() {
//		return student;
//	}

//	public void setStudent(Student student) {
//		this.student = student;
//	}

//	public Alien getAlien() {
//		return alien;
//	}

//	public void setAlien(Alien alien) {
//		this.alien = alien;
//	}

	public String getLname() {
		return lname;
	}

	public void setLname(String Lname) {
		this.lname = Lname;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}
}
