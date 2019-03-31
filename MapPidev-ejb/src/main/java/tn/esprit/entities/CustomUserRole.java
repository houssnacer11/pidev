package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CustomUserRoles database table.
 * 
 */
@Entity
@Table(name="CustomUserRoles")
@NamedQuery(name="CustomUserRole.findAll", query="SELECT c FROM CustomUserRole c")
public class CustomUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private int id;

	@Column(name="RoleId")
	private int roleId;

	@Column(name="UserId")
	private int userId;

	//bi-directional many-to-one association to CustomRole
	@ManyToOne
	@JoinColumn(name="CustomRole_Id")
	private CustomRole customRole;

	public CustomUserRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public CustomRole getCustomRole() {
		return this.customRole;
	}

	public void setCustomRole(CustomRole customRole) {
		this.customRole = customRole;
	}

}