package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DayOffs database table.
 * 
 */
@Entity
@Table(name="DayOffs")
@NamedQuery(name="DayOff.findAll", query="SELECT d FROM DayOff d")
public class DayOff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DayOffId")
	private Integer dayOffId;

	@Column(name="DateBegin")
	private String dateBegin;

	@Column(name="DateEnd")
	private String dateEnd;

	@Column(name="state")
	private Integer state;
	
	private String nameState;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="ResourceId")
	private User user;

	public DayOff() {
	}

	public int getDayOffId() {
		return this.dayOffId;
	}

	public void setDayOffId(int dayOffId) {
		this.dayOffId = dayOffId;
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

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
	public String getNameState() {
		return nameState;
	}

	public void setNameState(String nameState) {
		this.nameState = nameState;
	}

	public DayOff(String dateBegin, String dateEnd, Integer state, User user, String ns) {
		super();
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.state = state;
		this.user = user;
		this.nameState=ns;
	}
	
	
	
	
	

}