package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Demands database table.
 * 
 */
@Entity
@Table(name="Demands")
@NamedQuery(name="Demand.findAll", query="SELECT d FROM Demand d")
public class Demand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DemandId")
	private int demandId;

	private String date;

	@Column(name="Nomapp")
	private String nomapp;

	@Column(name="State")
	private int state;

	public Demand() {
	}

	public int getDemandId() {
		return this.demandId;
	}

	public void setDemandId(int demandId) {
		this.demandId = demandId;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Object getNomapp() {
		return this.nomapp;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setNomapp(String nomapp) {
		this.nomapp = nomapp;
	}




}