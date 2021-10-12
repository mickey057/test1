package com.blive.test1.model;


import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idclient;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "compte")
	private int compte;
	
	@Column(name = "statut")
	private boolean statut;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "date_creation")
	private Date date_creation;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "date_lastactivity")
	private Date date_lastactivity;

	
	@OneToMany(mappedBy = "client")
    Set<Operation> operations ;
	
	public Client() {}
	
	
	
	public Client(Long idclient, String firstname, String lastname, int compte, boolean statut, Date date_creation,
			Date date_lastactivity, Set<Operation> operations) {
		super();
		this.idclient = idclient;
		this.firstname = firstname;
		this.lastname = lastname;
		this.compte = compte;
		this.statut = statut;
		this.date_creation = date_creation;
		this.date_lastactivity = date_lastactivity;
		this.operations = operations;
	}



	public Long getIdclient() {
		return idclient;
	}
	public void setIdclient(Long idclient) {
		this.idclient = idclient;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getCompte() {
		return compte;
	}
	public void setCompte(int compte) {
		this.compte = compte;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public Date getDate_lastactivity() {
		return date_lastactivity;
	}
	public void setDate_lastactivity(Date date_lastactivity) {
		this.date_lastactivity = date_lastactivity;
	}

	 public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Client client = (Client) o;
	        return Objects.equals(firstname, client.firstname);
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(firstname);}



		@Override
		public String toString() {
			return "Client [idclient=" + idclient + ", firstname=" + firstname + ", lastname=" + lastname + ", compte="
					+ compte + ", statut=" + statut + ", date_creation=" + date_creation + ", date_lastactivity="
					+ date_lastactivity + "]";
		}



	    
}
