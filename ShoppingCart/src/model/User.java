package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private int userId;

	@Temporal(TemporalType.DATE)
	private Date joindate;

	@Column(name="ORDER_ID")
	private int orderId;

	private String password;

	private double storecredit;

	@Column(name="USER_MOTTO")
	private String userMotto;

	@Column(name="USER_NAME")
	private String userName;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getJoindate() {
		return this.joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getStorecredit() {
		return this.storecredit;
	}

	public void setStorecredit(double storecredit) {
		this.storecredit = storecredit;
	}

	public String getUserMotto() {
		return this.userMotto;
	}

	public void setUserMotto(String userMotto) {
		this.userMotto = userMotto;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}