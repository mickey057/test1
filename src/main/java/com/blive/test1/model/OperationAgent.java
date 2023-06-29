package com.blive.test1.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Entity
@Table(name = "operation_agent")
public class OperationAgent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	//@Column(name = "date")
	private Date date;

	private int montant;
	private String type;
//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//	public DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//	public LocalDateTime now = LocalDateTime.now();

	@ManyToOne
    @JoinColumn(name = "idsender")
    private Agent agent1;

	@ManyToOne
	@JoinColumn(name = "idreceiver")
	private Agent agent2;


	@Transient
	public String showSystemDates() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now).toString();
		System.out.println("Date: " + date);
		return date;
	}
//	@Transient
//	public Date getSystemDates() {
//		LocalDateTime now = LocalDateTime.now();
//		return Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
//	}




	public OperationAgent() {
		super();
	}
	public OperationAgent(Date date, int montant, String type, Agent agent1, Agent agent2) {
		super();
		this.date = date;
		this.montant = montant;
		this.type = type;
		this.agent1 = agent1;
		this.agent2 = agent2;
	}



	public OperationAgent(Long id, Date date, int montant, String type, Agent agent1, Agent agent2) {
		super();
		this.id = id;
		this.date = date;
		this.montant = montant;
		this.type = type;
		this.agent1 = agent1;
		this.agent2 = agent2;
	}

//	public DateTimeFormatter getDtf() {
//		return dtf;
//	}
//
//	public void setDtf(DateTimeFormatter dtf) {
//		this.dtf = dtf;
//	}
//
//	public LocalDateTime getNow() {
//		return now;
//	}
//
//	public void setNow(LocalDateTime now) {
//		this.now = now;
//	}

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


	public Agent getAgent1() {
		return agent1;
	}

	public void setAgent1(Agent agent1) {
		this.agent1 = agent1;
	}

	public Agent getAgent2() {
		return agent2;
	}

	public void setAgent2(Agent agent2) {
		this.agent2 = agent2;
	}

	@Override
	public String toString() {
		return "OperationAgent{" +
				"id=" + id +
				", date=" + date +
				", montant=" + montant +
				", type='" + type + '\'' +
				", agent1=" + agent1 +
				", agent2=" + agent2 +
				'}';
	}
}
