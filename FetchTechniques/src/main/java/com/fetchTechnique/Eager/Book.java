package com.fetchTechnique.Eager;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	private int bid;
	private String bname;
	
	@ManyToOne
	private Student  student;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Book(int bid, String bname, Student student) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.student = student;
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}
	
	
	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", student=" + student + "]";
	}

	
	
	
}
