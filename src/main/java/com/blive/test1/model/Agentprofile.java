package com.blive.test1.model;

import javax.persistence.*;

@Entity(name ="Agentprofile")
@Table(name = "agent_profile")
public class Agentprofile {
	
	@Id
	@Column(name = "idagent_profile")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idagentprofile;
	
	private String name;
	private String	niveau;
 
//	@OneToOne
//	@JoinColumn(name = "idagent")
//	private Agent idagent;
	
//	@OneToOne(cascade =CascadeType.ALL,mappedBy = "agentprofilesd")
//	private Confoper confoperS;
//
//	@OneToOne(cascade =CascadeType.ALL,mappedBy = "agentprofilerv")
//	private Confoper confoperR;
	
	public Agentprofile() {
		super();
	}


	public Agentprofile(String name, String niveau) {
		super();
		this.name = name;
		this.niveau = niveau;
	}
	
	

	
//	public Confoper getConfoperS() {
//		return confoperS;
//	}
//
//
//	public void setConfoperS(Confoper confoperS) {
//		this.confoperS = confoperS;
//	}
//
//
//	public Confoper getConfoperR() {
//		return confoperR;
//	}
//
//
//	public void setConfoperR(Confoper confoperR) {
//		this.confoperR = confoperR;
//	}
//



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
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


	@Override
	public String toString() {
		return "Agentprofile{" +
				"idagentprofile=" + idagentprofile +
				", name='" + name + '\'' +
				", niveau='" + niveau + '\'' +
//				", confoperS=" + confoperS +
//				", confoperR=" + confoperR +
				'}';
	}
}
