package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PAY database table.
 * 
 */
@Entity
@NamedQuery(name="Pay.findAll", query="SELECT p FROM Pay p")
public class Pay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PAY_ID")
	private int payId;

	private String billadr1;

	private String billadr2;

	private String billcode;

	private String cardname;

	@Column(name="FULL_NAME")
	private String fullName;

	@Column(name="PAY_AMOUNT")
	private double payAmount;

	private String shipadr1;

	private String shipadr2;

	private String shipcode;

	@Column(name="USER_ID")
	private int userId;

	public Pay() {
	}

	public int getPayId() {
		return this.payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getBilladr1() {
		return this.billadr1;
	}

	public void setBilladr1(String billadr1) {
		this.billadr1 = billadr1;
	}

	public String getBilladr2() {
		return this.billadr2;
	}

	public void setBilladr2(String billadr2) {
		this.billadr2 = billadr2;
	}

	public String getBillcode() {
		return this.billcode;
	}

	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}

	public String getCardname() {
		return this.cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getPayAmount() {
		return this.payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public String getShipadr1() {
		return this.shipadr1;
	}

	public void setShipadr1(String shipadr1) {
		this.shipadr1 = shipadr1;
	}

	public String getShipadr2() {
		return this.shipadr2;
	}

	public void setShipadr2(String shipadr2) {
		this.shipadr2 = shipadr2;
	}

	public String getShipcode() {
		return this.shipcode;
	}

	public void setShipcode(String shipcode) {
		this.shipcode = shipcode;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}