package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Tests database table.
 * 
 */
@Entity
@Table(name="Tests")
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TestId")
	private int testId;

	@Column(name="DateTest")
	private String dateTest;

	@Column(name="Difficulty")
	private String difficulty;

	@Column(name="Mark")
	private float mark;

	@Column(name="Nom")
	private String nom;

	//bi-directional many-to-one association to File
	@ManyToOne
	private File file;

	public Test() {
	}

	public int getTestId() {
		return this.testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getDateTest() {
		return this.dateTest;
	}

	public void setDateTest(String dateTest) {
		this.dateTest = dateTest;
	}

	
	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getMark() {
		return this.mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}


	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}