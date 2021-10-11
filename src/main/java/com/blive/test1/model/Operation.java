package com.blive.test1.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "operation")
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date;
	private int montant;
	private String type;
	
	@ManyToOne
    @JoinColumn(name = "idagent")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;
	
	
	
	public Operation() {
		super();
	}
	public Operation( Date date, int montant, String type, Agent agent, Client client) {
		super();
		this.date = date;
		this.montant = montant;
		this.type = type;
		this.agent = agent;
		this.client = client;
	}



	public Operation(Long id, Date date, int montant, String type, Agent agent, Client client) {
		super();
		this.id = id;
		this.date = date;
		this.montant = montant;
		this.type = type;
		this.agent = agent;
		this.client = client;
	}
	


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public int getMontant() {
		return montant;
	}



	public void setMontant(int montant) {
		this.montant = montant;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Agent getAgent() {
		return agent;
	}



	public void setAgent(Agent agent) {
		this.agent = agent;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", type=" + type + ", agent=" + agent
				+ ", client=" + client + "]";
	}







}
