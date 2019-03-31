package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HistoricalMandates database table.
 * 
 */
@Entity
@Table(name="HistoricalMandates")
@NamedQuery(name="HistoricalMandate.findAll", query="SELECT h FROM HistoricalMandate h")
public class HistoricalMandate implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HistoricalMandatePK id;

	@Column(name="Cost")
	private float cost;

	@Column(name="DateBegin")
	private String dateBegin;

	@Column(name="DateEnd")
	private String dateEnd;

	@Column(name="Duree")
	private int duree;

	private int mandat;

	public HistoricalMandate() {
	}

	public HistoricalMandatePK getId() {
		return this.id;
	}

	public void setId(HistoricalMandatePK id) {
		this.id = id;
	}

	public float getCost() {
		return this.cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getDateBegin() {
		return this.dateBegin;
	}

	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}

	public String getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getMandat() {
		return this.mandat;
	}

	public void setMandat(int mandat) {
		this.mandat = mandat;
	}

}