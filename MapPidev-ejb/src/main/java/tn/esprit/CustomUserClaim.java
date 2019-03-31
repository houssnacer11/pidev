package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CustomUserClaims database table.
 * 
 */
@Entity
@Table(name="CustomUserClaims")
@NamedQuery(name="CustomUserClaim.findAll", query="SELECT c FROM CustomUserClaim c")
public class CustomUserClaim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private int id;

	@Column(name="ClaimType")
	private String claimType;

	@Column(name="ClaimValue")
	private String claimValue;

	@Column(name="UserId")
	private int userId;

	public CustomUserClaim() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getClaimValue() {
		return claimValue;
	}

	public void setClaimValue(String claimValue) {
		this.claimValue = claimValue;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}