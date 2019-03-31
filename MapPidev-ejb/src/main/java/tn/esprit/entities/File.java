package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Files database table.
 * 
 */
@Entity
@Table(name="Files")
@NamedQuery(name="File.findAll", query="SELECT f FROM File f")
public class File implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FileId")
	private int fileId;

	@Column(name="DateBegin")
	private String dateBegin;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="file", fetch=FetchType.EAGER)
	private List<Test> tests;

	public File() {
	}

	public int getFileId() {
		return this.fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getDateBegin() {
		return this.dateBegin;
	}

	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setFile(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setFile(null);

		return test;
	}

}