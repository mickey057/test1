package com.blive.test1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAdmin;
	
	@Column(name = "nom")
	private String name;
	
	private String username;
	private String password;
	
	
	
	public Admin() {}

	  public Admin(String name, String username, String password) {
	    this.name = name;
	    this.username = username;
	    this.password = password;
	  }


public Long getIdAdmin() {
	return idAdmin;
}

public void setIdAdmin(Long idAdmin) {
	this.idAdmin = idAdmin;
}
public String getname() {
	return name;
}
public void setname(String name) {
	this.name = name;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
	
}
