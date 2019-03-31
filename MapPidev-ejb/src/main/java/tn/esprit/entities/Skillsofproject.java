package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Skillsofprojects database table.
 * 
 */
@Entity
@Table(name="Skillsofprojects")
@NamedQuery(name="Skillsofproject.findAll", query="SELECT s FROM Skillsofproject s")
public class Skillsofproject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int skillsofprojectId;

	private int numproj;

	private int numskill;

	public Skillsofproject() {
	}

	public int getSkillsofprojectId() {
		return this.skillsofprojectId;
	}

	public void setSkillsofprojectId(int skillsofprojectId) {
		this.skillsofprojectId = skillsofprojectId;
	}

	public int getNumproj() {
		return this.numproj;
	}

	public void setNumproj(int numproj) {
		this.numproj = numproj;
	}

	public int getNumskill() {
		return this.numskill;
	}

	public void setNumskill(int numskill) {
		this.numskill = numskill;
	}

}