package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RequiredSkills database table.
 * 
 */
@Entity
@Table(name="RequiredSkills")
@NamedQuery(name="RequiredSkill.findAll", query="SELECT r FROM RequiredSkill r")
public class RequiredSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RequiredSkillsId")
	private int requiredSkillsId;

	private String education;

	private int experience;

	private String nomSkill;

	private String profil;

	//bi-directional many-to-one association to Request
	@ManyToOne
	@JoinColumn(name="requestId")
	private Request request;

	public RequiredSkill() {
	}

	public int getRequiredSkillsId() {
		return this.requiredSkillsId;
	}

	public void setRequiredSkillsId(int requiredSkillsId) {
		this.requiredSkillsId = requiredSkillsId;
	}



	
	
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getNomSkill() {
		return nomSkill;
	}

	public void setNomSkill(String nomSkill) {
		this.nomSkill = nomSkill;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public Request getRequest() {
		return this.request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

}