package com.anurag.DemoHibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Alien {
	
	@Id	
	private int aid;
	private String aname;
	
//	@Transient	// transient field wont get stored in database
//	private AlienName aname;
//	@OneToMany(mappedBy="alien", fetch=FetchType.EAGER) // making fetchtype to eager will run sql query for collection even if we dont fetching it
//	private Collection<Laptop> laptop = new ArrayList<Laptop>();
	
	@Column(name="alien_color")    // to change the column name
	private String color;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
//	public AlienName getAname() {
//		return aname;
//	}
	public String getAname() {
		return aname;
	}
//	public void setAname(AlienName aname) {
//		this.aname = aname;
//	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	@Override
	public String toString() {  // when we try to print an object this methods helps
		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
