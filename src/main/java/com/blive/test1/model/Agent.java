package com.blive.test1.model;


import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "agent")
public class Agent {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idagent;
	@Column(name = "agent_firstname")
	private String firstname;
	@Column(name = "agent_lastname")
	private String lastname;
	private String numero;
	private int compte;
	private int montant;
//	@Column(name ="statut")
	private boolean status;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "date_creation")
	private Date date;
	private int level;
	
	@ManyToOne
	@JoinColumn(name="idoperateur")
	private Operateur operateur;
	
//	@OneToOne(mappedBy ="idagent",cascade = CascadeType.ALL)
//	private Agentprofile agentprofile;
	
	@OneToMany(mappedBy = "agent")
	public List<Operation> operations;
	
//recussive
	
	@ManyToOne
	@JoinColumn(name ="manager_id")
	public Agent managerid;
	
	@OneToMany(mappedBy = "managerid", cascade = CascadeType.ALL)
	public List<Agent> subAgent ;
	
//recussive
	@ManyToOne
	@JoinColumn(name ="superior_agent_id")
	private Agent superiorAgent;
	@ManyToOne
	@JoinColumn(name = "config_id")
	private Confoper conf;

	public Agent(){}

	public Agent(Long idagent, String firstname, String lastname, String numero, int compte, int montant, boolean status, Date date, int level, Operateur operateur, List<Operation> operations, Agent managerid, List<Agent> subAgent, Agent superiorAgent, Confoper conf) {
		this.idagent = idagent;
		this.firstname = firstname;
		this.lastname = lastname;
		this.numero = numero;
		this.compte = compte;
		this.montant = montant;
		this.status = status;
		this.date = date;
		this.level = level;
		this.operateur = operateur;
		this.operations = operations;
		this.managerid = managerid;
		this.subAgent = subAgent;
		this.superiorAgent = superiorAgent;
		this.conf = conf;
	}

	//	public Agentprofile getAgentprofile() {
//		return agentprofile;
//	}


	public Confoper getConf() {
		return conf;
	}

	public void setConf(Confoper conf) {
		this.conf = conf;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Agent getSuperiorAgent() {
		return superiorAgent;
	}

	public void setSuperiorAgent(Agent superiorAgent) {
		this.superiorAgent = superiorAgent;
	}

	public Operateur getOperateur() {
		return operateur;
	}


	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}


	public Agent getManagerid() {
		return managerid;
	}


	public void setManagerid(Agent managerid) {
		this.managerid = managerid;
	}


	public List<Agent> getSubAgent() {
		return subAgent;
	}


	public void setSubAgent(List<Agent> subAgent) {
		this.subAgent = subAgent;
	}


//	public void setAgentprofile(Agentprofile agentprofile) {
//		this.agentprofile = agentprofile;
//	}


	public List<Operation> getOperations() {
		return operations;
	}


	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}


	public Long getIdagent() {
		return idagent;
	}

	public void setIdagent(Long idagent) {
		this.idagent = idagent;
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


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public int getCompte() {
		return compte;
	}


	public void setCompte(int compte) {
		this.compte = compte;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
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


	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agent)) return false;
        return idagent != null && idagent.equals(((Agent) o).getIdagent());
    }
	
	@Override
    public int hashCode() {
        return getClass().hashCode();
    }


	@Override
	public String toString() {
		return "Agent [idagent=" + idagent + ", firstname=" + firstname + ", lastname=" + lastname + ", numero="
				+ numero + ", compte=" + compte + ", status=" + status + ", date=" + date + ", operateur=" + operateur
				//+ ", agentprofile=" + agentprofile  + ", managerid=" + managerid
				+ ", subAgent=" + subAgent + "]";
	}



	
}
