package com.pablousegreenhibernate.hibernate_demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

@Entity(name="laptop")
public class Laptop {
	
	@Id
	private int lid;
//	private String lname;
//	@ManyToOne
//	private Student student;
	private String brand;
	private int price;
	@Column(name = "rollno")
	private Integer rollno;
	@ManyToOne
	private Alien alien;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinColumn(name = "rollno", updatable = false, insertable = false, nullable = true)
	private List<Student> students = new ArrayList<Student>();	
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Alien getAlien() {
		return alien;
	}
	public void setAlien(Alien alien) {
		this.alien = alien;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	

}
