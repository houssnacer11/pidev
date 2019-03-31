package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Requests database table.
 * 
 */
@Entity
@Table(name="Requests")
@NamedQuery(name="Request.findAll", query="SELECT r FROM Request r")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RequestId")
	private int requestId;

	@Column(name="Client_Id")
	private int client_Id;

	private float coast;

	@Column(name="DateBegin")
	private String dateBegin;

	@Column(name="DateDeposit")
	private String dateDeposit;

	@Column(name="DateEnd")
	private String dateEnd;

	private int nbrResource;

	@Column(name="ReportedDate")
	private String reportedDate;

	private int state;

	private String subject;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="Project_ProjectId")
	private Project project;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="ClientId")
	private User user;

	//bi-directional many-to-one association to RequiredSkill
	@OneToMany(mappedBy="request")
	private List<RequiredSkill> requiredSkills;

	public Request() {
	}

	public int getRequestId() {
		return this.requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getClient_Id() {
		return this.client_Id;
	}

	public void setClient_Id(int client_Id) {
		this.client_Id = client_Id;
	}

	public float getCoast() {
		return this.coast;
	}

	public void setCoast(float coast) {
		this.coast = coast;
	}

	public String getDateBegin() {
		return this.dateBegin;
	}

	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}

	public String getDateDeposit() {
		return this.dateDeposit;
	}

	public void setDateDeposit(String dateDeposit) {
		this.dateDeposit = dateDeposit;
	}

	public String getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public int getNbrResource() {
		return this.nbrResource;
	}

	public void setNbrResource(int nbrResource) {
		this.nbrResource = nbrResource;
	}

	public String getReportedDate() {
		return this.reportedDate;
	}

	public void setReportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}


	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public List<RequiredSkill> getRequiredSkills() {
		return this.requiredSkills;
	}

	public void setRequiredSkills(List<RequiredSkill> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public RequiredSkill addRequiredSkill(RequiredSkill requiredSkill) {
		getRequiredSkills().add(requiredSkill);
		requiredSkill.setRequest(this);

		return requiredSkill;
	}

	public RequiredSkill removeRequiredSkill(RequiredSkill requiredSkill) {
		getRequiredSkills().remove(requiredSkill);
		requiredSkill.setRequest(null);

		return requiredSkill;
	}

}