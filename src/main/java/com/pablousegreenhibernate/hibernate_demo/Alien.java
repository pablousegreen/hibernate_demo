package com.pablousegreenhibernate.hibernate_demo;

import java.util.ArrayList;
import java.util.Collection;

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
	private String aname;
	@OneToMany(mappedBy="alien", fetch=FetchType.EAGER)
	private Collection<Laptop> laps = new ArrayList<Laptop>();
	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", laps=" + laps + "]";
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Collection<Laptop> getLaps() {
		return laps;
	}
	public void setLaps(Collection<Laptop> laps) {
		this.laps = laps;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
}
