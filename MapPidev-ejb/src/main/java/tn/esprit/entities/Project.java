package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Projects database table.
 * 
 */
@Entity
@Table(name="Projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ProjectId")
	private int projectId;

	@Column(name="Address")
	private String address_Address;
/*
	@Column(name="Address_Country")
	private String address_Country;
*/
	@Column(name="Latitude")
	private String address_Latitude;

	@Column(name="Longitude")
	private String address_Longitude;

	/*@Column(name="Address_ZipCode")
	private int address_ZipCode;*/

/*	@Column(name="ClientFK")
	private int clientFK;*/

	@Column(name="DateBegin")
	private String dateBegin;

	@Column(name="DateEnd")
	private String dateEnd;
/*
	@Column(name="Description")
	private String description;*/

/*	@Column(name="Etat")
	private int etat;
*/

	@Column(name="Name")
	private String name;

	@Column(name="Picture")
	private String picture;

	@Column(name="TauxDavancement")
	private double tauxDavancement;

	@Column(name="TotalNbrRessources")
	private int totalNbrRessources;

	@Column(name="TotalNbrRessourcesLevio")
	private int totalNbrRessourcesLevio;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="client_Id")
	private User user;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="project", fetch=FetchType.EAGER)
	private List<Request> requests;


	public Project() {
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	


	public String getAddress_Address() {
		return address_Address;
	}

	public String getAddress_Latitude() {
		return this.address_Latitude;
	}

	public void setAddress_Latitude(String address_Latitude) {
		this.address_Latitude = address_Latitude;
	}

	public String getAddress_Longitude() {
		return this.address_Longitude;
	}

	public void setAddress_Longitude(String address_Longitude) {
		this.address_Longitude = address_Longitude;
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


	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setAddress_Address(String address_Address) {
		this.address_Address = address_Address;
	}




	public double getTauxDavancement() {
		return this.tauxDavancement;
	}

	public void setTauxDavancement(double tauxDavancement) {
		this.tauxDavancement = tauxDavancement;
	}

	public int getTotalNbrRessources() {
		return this.totalNbrRessources;
	}

	public void setTotalNbrRessources(int totalNbrRessources) {
		this.totalNbrRessources = totalNbrRessources;
	}

	public int getTotalNbrRessourcesLevio() {
		return this.totalNbrRessourcesLevio;
	}

	public void setTotalNbrRessourcesLevio(int totalNbrRessourcesLevio) {
		this.totalNbrRessourcesLevio = totalNbrRessourcesLevio;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Request> getRequests() {
		return this.requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Request addRequest(Request request) {
		getRequests().add(request);
		request.setProject(this);

		return request;
	}

	public Request removeRequest(Request request) {
		getRequests().remove(request);
		request.setProject(null);

		return request;
	}

	public Project(int projectId, String name, String address_Address, String address_Longitude, String address_Latitude, double tauxDavancement,String dateBegin,String dateEnd,int nbR, int nbRLevio ) {
		super();
		this.projectId = projectId;
		this.address_Address = address_Address;
		this.address_Latitude = address_Latitude;
		this.address_Longitude = address_Longitude;
		this.name = name;
		this.tauxDavancement = tauxDavancement;
		this.dateBegin= dateBegin;
		this.dateEnd= dateEnd;
		this.totalNbrRessources=nbR;
		this.totalNbrRessourcesLevio=nbRLevio;
	}


	
	

	

}