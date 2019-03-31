package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Documents database table.
 * 
 */
@Entity
@Table(name="Documents")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DocumentsId")
	private int documentsId;

	@Column(name="Titre")
	private String titre;

	@Column(name="Type")
	private int type;

	//bi-directional many-to-one association to File
	@ManyToOne
	private File file;

	public Document() {
	}
    
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getDocumentsId() {
		return this.documentsId;
	}

	public void setDocumentsId(int documentsId) {
		this.documentsId = documentsId;
	}



	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}