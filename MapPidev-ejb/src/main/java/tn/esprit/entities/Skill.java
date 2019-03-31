package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Skills database table.
 * 
 */
@Entity
@Table(name="Skills")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SkillsId")
	private int skillsId;

	@Column(name="Difficulity")
	private int difficulity;

	private String name;

	private String speciality;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="skills")
	private List<User> users;

	public Skill() {
	}

	public int getSkillsId() {
		return this.skillsId;
	}

	public void setSkillsId(int skillsId) {
		this.skillsId = skillsId;
	}

	public int getDifficulity() {
		return this.difficulity;
	}

	public void setDifficulity(int difficulity) {
		this.difficulity = difficulity;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}