package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Messages database table.
 * 
 */
@Entity
@Table(name="Messages")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MessageId")
	private int messageId;

	@Column(name="Description")
	private String description;

	@Column(name="Titre")
	private String titre;

	private int typeMessage;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Resource_Id")
	private User user;


	
	public Message() {
	}

	public int getMessageId() {
		return this.messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getTypeMessage() {
		return this.typeMessage;
	}

	public void setTypeMessage(int typeMessage) {
		this.typeMessage = typeMessage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}