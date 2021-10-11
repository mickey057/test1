package com.blive.test1.model;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name ="Module")
@Table(name = "module")
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idmodule;
	@Column(name = "module_name")
	private String modulename;
	@Column(name = "write_enabled")
	private boolean write;
	@Column(name = "read_enabled")
	private boolean read;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE},
			mappedBy = "modules")
	 public Set<User> users = new HashSet<>(); 

	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public Module() {
		super();
	}
	public Module(String modulename, boolean write, boolean read) {
		super();
		this.modulename = modulename;
		this.write = write;
		this.read = read;
	}
	public Long getIdmodule() {
		return idmodule;
	}
	public void setIdmodule(Long idmodule) {
		this.idmodule = idmodule;
	}
	public String getModulename() {
		return modulename;
	}
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	public boolean isWrite() {
		return write;
	}
	public void setWrite(boolean write) {
		this.write = write;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	 public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Module module = (Module) o;
	        return Objects.equals(modulename, module.modulename);
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(modulename);
	    }
		@Override
		public String toString() {
			return modulename;
		}

}
