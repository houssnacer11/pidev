package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the resourceSkills database table.
 * 
 */
@Entity
@NamedQuery(name="resourceSkills.findAll", query="SELECT r FROM resourceSkills r")
public class resourceSkills implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private resourceSkillsPK id;

	public resourceSkills() {
	}

	public resourceSkillsPK getId() {
		return this.id;
	}

	public void setId(resourceSkillsPK id) {
		this.id = id;
	}

}