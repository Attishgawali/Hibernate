package com.fetchTechnique.Eager;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	private int sid;
	private String sname;
	
	@OneToMany(mappedBy= "student",fetch= FetchType.EAGER)
	private List<Book> books;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String sname, List<Book> books) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.books = books;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", books=" + books + "]";
	}
	
	
	
	

}
