package com.blive.test1.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name ="User")
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long iduser;
	@Column(name = "username")
	private String username;
	
	@Column(name ="nom")
	private String nom;
	
	@Column(name= "statut")
	private boolean statut;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name= "date_creation")
	@Temporal(TemporalType.DATE)
	private Date date_creation;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name= "date_lastactivity")
	@Temporal(TemporalType.DATE)
	private Date date_lastactivity;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE}
	)
	@JoinTable(name ="module_role",
	joinColumns = {@JoinColumn(name = "iduser")},
	inverseJoinColumns = { @JoinColumn(name ="idmodule")})
	public Set<Module> modules = new HashSet<>(); 

	public Set<Module> getModules() {
		return modules;
	}
	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}
	public User() {}
	public User(String username, String nom, boolean statut, Date date_creation, Date date_lastactivity) {
		super();
		this.username = username;
		this.nom = nom;
		this.statut = statut;
		this.date_creation = date_creation;
		this.date_lastactivity = date_lastactivity;
	}
	
	
	public Long getIduser() {
		return iduser;
	}
	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	public void addModule(Module module) {
		
		modules.add(module);
		//module.getUsers().add(this);
	}
	public void removeModule(Module module) {
		
		modules.remove(module);
		//module.getUsers().remove(this);
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        return iduser != null && iduser.equals(((User) o).getIduser());
    }
	
	@Override
    public int hashCode() {
        return getClass().hashCode();
    }
	
	
	@Override
	public String toString() {
		return this.nom;
	}
	public User(Set<Module> modules) {
		super();
		this.modules = modules;
	}
	
	
	
}


