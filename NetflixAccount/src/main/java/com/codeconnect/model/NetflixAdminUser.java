package com.codeconnect.model;

import java.time.LocalDate;

import org.hibernate.annotations.BatchSize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="netflixadminuser")
public class NetflixAdminUser {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	
	private String uname;
	
	private LocalDate dop;

	public NetflixAdminUser() {
		super();
		
	}

	public NetflixAdminUser(Integer uid, String uname, LocalDate dop) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.dop = dop;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public LocalDate getDop() {
		return dop;
	}

	public void setDop(LocalDate dop) {
		this.dop = dop;
	}

	@Override
	public String toString() {
		return "NetFlixAdminUser [uid=" + uid + ", uname=" + uname + ", dop=" + dop + "]";
	}
	
	
	

}
