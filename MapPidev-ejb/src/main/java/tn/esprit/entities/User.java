package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private int id;

	@Column(name="AccessFailedCount")
	private int accessFailedCount;

	@Column(name="Age")
	private Integer age;

	//private boolean archive;

	@Column(name="Availability")
	private Integer availability;

	@Column(name="BuissnesSector")
	private String buissnesSector;

	private Integer categorieClient;

	@Column(name="Contrat")
	private Integer contrat;

	@Column(name="Country")
	private String country;

	@Column(name="Cv")
	private String cv;

	@Column(name="Email")
	private String email;

	@Column(name="EmailConfirmed")
	private boolean emailConfirmed;

	@Column(name="EmployementLetter")
	private String employementLetter;

	@Column(name="FirstName")
	private String firstName;

	@Column(name="LastName")
	private String lastName;

	@Column(name="LockoutEnabled")
	private boolean lockoutEnabled;

	@Column(name="LockoutEndDateUtc")
	private String lockoutEndDateUtc;

	@Column(name="Logo")
	private String logo;

	@Column(name="NbrProjectActif")
	private Integer nbrProjectActif;

	@Column(name="NbrRessource")
	private Integer nbrRessource;

	@Column(name="Password")
	private String password;

	@Column(name="PasswordHash")
	private String passwordHash;

	@Column(name="PhoneNumber")
	private String phoneNumber;

	@Column(name="PhoneNumberConfirmed")
	private boolean phoneNumberConfirmed;

	@Column(name="Picture")
	private String picture;

	@Column(name="PictureResource")
	private String pictureResource;

	@Column(name="Project_ProjectId")
	private Integer project_ProjectId;

	@Column(name="SecurityStamp")
	private String securityStamp;

	@Column(name="Seniority")
	private String seniority;

	@Column(name="TwoFactorEnabled")
	private boolean twoFactorEnabled;

	@Column(name="Type")
	private Integer type;

	private Integer typeClient;

	@Column(name="UserName")
	private String userName;

	//bi-directional many-to-one association to DayOff
	@OneToMany(mappedBy="user")
	private List<DayOff> dayOffs;

	//bi-directional many-to-one association to Mandate
	@OneToMany(mappedBy="user")
	private List<Mandate> mandates;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user")
	private List<Message> messages;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="user")
	private List<Project> projects;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="user")
	private List<Request> requests;

	//bi-directional many-to-many association to Skill
	@ManyToMany
	@JoinTable(
		name="resourceSkills"
		, joinColumns={
			@JoinColumn(name="userId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="SkillsId")
			}
		)
	private List<Skill> skills;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	

	public int getAvailability() {
		return this.availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	

	public int getCategorieClient() {
		return this.categorieClient;
	}

	public void setCategorieClient(int categorieClient) {
		this.categorieClient = categorieClient;
	}

	public int getContrat() {
		return this.contrat;
	}

	public void setContrat(int contrat) {
		this.contrat = contrat;
	}





	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	


	public boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public String getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(String lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	

	public int getNbrProjectActif() {
		return this.nbrProjectActif;
	}

	public void setNbrProjectActif(int nbrProjectActif) {
		this.nbrProjectActif = nbrProjectActif;
	}

	public int getNbrRessource() {
		return this.nbrRessource;
	}

	public void setNbrRessource(int nbrRessource) {
		this.nbrRessource = nbrRessource;
	}


	

	public boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}





	public int getProject_ProjectId() {
		return this.project_ProjectId;
	}

	public void setProject_ProjectId(int project_ProjectId) {
		this.project_ProjectId = project_ProjectId;
	}

	

	
	

	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getTypeClient() {
		return this.typeClient;
	}

	public void setTypeClient(int typeClient) {
		this.typeClient = typeClient;
	}

	
	public List<DayOff> getDayOffs() {
		return this.dayOffs;
	}

	public void setDayOffs(List<DayOff> dayOffs) {
		this.dayOffs = dayOffs;
	}

	public DayOff addDayOff(DayOff dayOff) {
		getDayOffs().add(dayOff);
		dayOff.setUser(this);

		return dayOff;
	}

	public DayOff removeDayOff(DayOff dayOff) {
		getDayOffs().remove(dayOff);
		dayOff.setUser(null);

		return dayOff;
	}

	public List<Mandate> getMandates() {
		return this.mandates;
	}

	public void setMandates(List<Mandate> mandates) {
		this.mandates = mandates;
	}

	public Mandate addMandate(Mandate mandate) {
		getMandates().add(mandate);
		mandate.setUser(this);

		return mandate;
	}

	public Mandate removeMandate(Mandate mandate) {
		getMandates().remove(mandate);
		mandate.setUser(null);

		return mandate;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setUser(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setUser(null);

		return message;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setUser(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setUser(null);

		return project;
	}

	public List<Request> getRequests() {
		return this.requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Request addRequest(Request request) {
		getRequests().add(request);
		request.setUser(this);

		return request;
	}

	public Request removeRequest(Request request) {
		getRequests().remove(request);
		request.setUser(null);

		return request;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String getBuissnesSector() {
		return buissnesSector;
	}

	public void setBuissnesSector(String buissnesSector) {
		this.buissnesSector = buissnesSector;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployementLetter() {
		return employementLetter;
	}

	public void setEmployementLetter(String employementLetter) {
		this.employementLetter = employementLetter;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPictureResource() {
		return pictureResource;
	}

	public void setPictureResource(String pictureResource) {
		this.pictureResource = pictureResource;
	}

	public String getSecurityStamp() {
		return securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}