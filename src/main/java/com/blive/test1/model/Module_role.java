package com.blive.test1.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "module_role")
public class Module_role {
	
	@Column(name ="iduser")
	private  Long iduser;
	
	@Column(name ="idmodule")
	private Long idmodule;
	
	public Long getIduser() {
		return iduser;
	}
	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}
	public Long getIdmodule() {
		return idmodule;
	}
	public void setIdmodule(Long idmodule) {
		this.idmodule = idmodule;
	}

}
