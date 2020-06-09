package com.pablousegreenhibernate.hibernate_demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="alien")
//@Table(name="alien")
public class Alien {
	
	@Id
	@Column(name="aid")
	private int aid;
//	@Column(name="aname")
//	private AlienName aname;
//	@Column(name="color")
//	private String color;
	@Column(name="aname")
	private AlienName aname;
	@OneToMany(mappedBy="alien", fetch=FetchType.EAGER)
	private List<Laptop> laps = new ArrayList<Laptop>();
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public AlienName getAname() {
		return aname;
	}
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]";
	}
	public List<Laptop> getLaps() {
		return laps;
	}
	public void setLaps(List<Laptop> laps) {
		this.laps = laps;
	}	
	
}
