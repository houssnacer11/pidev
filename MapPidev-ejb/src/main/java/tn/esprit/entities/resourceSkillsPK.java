package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the resourceSkills database table.
 * 
 */
@Embeddable
public class resourceSkillsPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int userId;

	@Column(name="SkillsId", insertable=false, updatable=false)
	private int skillsId;

	public resourceSkillsPK() {
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSkillsId() {
		return this.skillsId;
	}
	public void setSkillsId(int skillsId) {
		this.skillsId = skillsId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof resourceSkillsPK)) {
			return false;
		}
		resourceSkillsPK castOther = (resourceSkillsPK)other;
		return 
			(this.userId == castOther.userId)
			&& (this.skillsId == castOther.skillsId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId;
		hash = hash * prime + this.skillsId;
		
		return hash;
	}
}