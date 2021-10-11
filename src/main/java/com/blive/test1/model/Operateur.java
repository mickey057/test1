package com.blive.test1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name ="operateur")
public class Operateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idoperateur;
	@Column(name = "operateur_name")
	private String operateurname;
	
	@Column(name ="compte_principal")
	private Long compteprincipal;
	
	@Column(name ="address")
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="idoperateur", referencedColumnName = "idoperateur")
	private List<Agent> agents = new ArrayList<>();
	
	
	
	public Operateur() {
		super();
	}


	public Operateur(Long idoperateur, String operateurname, Long compteprincipal, String address) {
		super();
		this.idoperateur = idoperateur;
		this.operateurname = operateurname;
		this.compteprincipal = compteprincipal;
		this.address = address;
	}

	
	public List<Agent> getAgents() {
		return agents;
	}
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	public Long getIdoperateur() {
		return idoperateur;
	}
	public void setIdoperateur(Long idoperateur) {
		this.idoperateur = idoperateur;
	}
	public String getOperateurname() {
		return operateurname;
	}
	public void setOperateurname(String operateurname) {
		this.operateurname = operateurname;
	}
	public Long getCompteprincipal() {
		return compteprincipal;
	}
	public void setCompteprincipal(Long compteprincipal) {
		this.compteprincipal = compteprincipal;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return operateurname;
	}
	

}
