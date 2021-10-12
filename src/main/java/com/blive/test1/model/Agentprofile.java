package com.blive.test1.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity(name ="Agentprofile")
@Table(name = "agent_profile")
public class Agentprofile {
	
	@Id
	@Column(name = "idagent_profile")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idagentprofile;
	
	private String name;
	private String	agent_profilecol;
 
	@OneToOne(cascade =CascadeType.ALL, mappedBy = "agentprofile")
	private Agent agent;
	
	@OneToOne(cascade =CascadeType.ALL,mappedBy = "agentprofilesd")
	private Confoper confoperS;
	
	@OneToOne(cascade =CascadeType.ALL,mappedBy = "agentprofilerv")
	private Confoper confoperR;
	
	public Agentprofile() {
		super();
	}


	public Agentprofile(String name, String agent_profilecol) {
		super();
		this.name = name;
		this.agent_profilecol = agent_profilecol;
	}
	
	

	
	public Confoper getConfoperS() {
		return confoperS;
	}


	public void setConfoperS(Confoper confoperS) {
		this.confoperS = confoperS;
	}


	public Confoper getConfoperR() {
		return confoperR;
	}


	public void setConfoperR(Confoper confoperR) {
		this.confoperR = confoperR;
	}


	public Agent getAgent() {
		return agent;
	}


	public void setAgent(Agent agent) {
		this.agent = agent;
	}


	
	public Long getIdagentprofile() {
		return idagentprofile;
	}


	public void setIdagentprofile(Long idagentprofile) {
		this.idagentprofile = idagentprofile;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAgent_profilecol() {
		return agent_profilecol;
	}
	public void setAgent_profilecol(String agent_profilecol) {
		this.agent_profilecol = agent_profilecol;
	}


	@Override
	public String toString() {
		return "Agentprofile [name=" + name + ", agent_profilecol=" + agent_profilecol + "]";
	}

	

}
