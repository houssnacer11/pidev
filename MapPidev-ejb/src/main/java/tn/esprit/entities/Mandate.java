package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Mandates database table.
 * 
 */
@Entity
@Table(name="Mandates")
@NamedQuery(name="Mandate.findAll", query="SELECT m FROM Mandate m")
public class Mandate implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MandatePK id;

	@Column(name="Cost")
	private float cost;

	@Column(name="DateBegin")
	private String dateBegin;

	@Column(name="DateEnd")
	private String dateEnd;

	@Column(name="Duree")
	private int duree;

	private int mandat;

	//bi-directional many-to-one association to Project
		@ManyToOne
		@JoinColumn(name="ProjectId", insertable=false, updatable=false)
		private Project project;

		//bi-directional many-to-one association to User
		@ManyToOne
		@JoinColumn(name="userId", insertable=false, updatable=false)
		private User user;


	public Mandate() {
	}

	public MandatePK getId() {
		return this.id;
	}

	public void setId(MandatePK id) {
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

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}