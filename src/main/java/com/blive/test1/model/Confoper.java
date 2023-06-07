package com.blive.test1.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name ="config_operation")
public class Confoper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idconf;
	@Column(name = "name_conf_oper")
	private String name_conf_oper;
	@Column(name = "max_recharge_amount")
	private int max_recharge_amount;
	@Column(name = "commision_value")
	private int commision_value;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name ="idagentprofileSd")
//	private Agentprofile agentprofilesd;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name ="idagentprofileRv")
//	private Agentprofile agentprofilerv;
	
	
	public Confoper() {
		super();
	}

	public Confoper(String name_conf_oper, int max_recharge_amount, int commision_value) {
		super();
		this.name_conf_oper = name_conf_oper;
		this.max_recharge_amount = max_recharge_amount;
		this.commision_value = commision_value;
	}
	
//	public Agentprofile getAgentprofilesd() {
//		return agentprofilesd;
//	}
//
//	public void setAgentprofilesd(Agentprofile agentprofilesd) {
//		this.agentprofilesd = agentprofilesd;
//	}
//
//	public Agentprofile getAgentprofilerv() {
//		return agentprofilerv;
//	}
//
//	public void setAgentprofilerv(Agentprofile agentprofilerv) {
//		this.agentprofilerv = agentprofilerv;
//	}

	public Long getIdconf() {
		return idconf;
	}
	public void setIdconf(Long idconf) {
		this.idconf = idconf;
	}
	public String getName_conf_oper() {
		return name_conf_oper;
	}
	public void setName_conf_oper(String name_conf_oper) {
		this.name_conf_oper = name_conf_oper;
	}
	public int getMax_recharge_amount() {
		return max_recharge_amount;
	}
	public void setMax_recharge_amount(int max_recharge_amount) {
		this.max_recharge_amount = max_recharge_amount;
	}
	public int getCommision_value() {
		return commision_value;
	}
	public void setCommision_value(int commision_value) {
		this.commision_value = commision_value;
	}
	

}
