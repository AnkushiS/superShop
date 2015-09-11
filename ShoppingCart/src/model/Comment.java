package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COMMENTS database table.
 * 
 */
@Entity
@Table(name="COMMENTS", schema="testdb")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int commid;

	private String comments;

	private int prodid;

	private String reviews;

	private int userid;

	public Comment() {
	}

	public int getCommid() {
		return this.commid;
	}

	public void setCommid(int commid) {
		this.commid = commid;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getProdid() {
		return this.prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getReviews() {
		return this.reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}