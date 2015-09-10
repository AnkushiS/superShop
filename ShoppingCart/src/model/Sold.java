package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SOLD database table.
 * 
 */
@Entity
@NamedQuery(name="Sold.findAll", query="SELECT s FROM Sold s")
public class Sold implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ORDER_ID")
	private int orderId;

	@Column(name="CHECK_ID")
	private int checkId;

	@Column(name="PROD_ID")
	private int prodId;

	private int quantity;

	private Double totalprice;

	public Sold() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCheckId() {
		return this.checkId;
	}

	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}

	public int getProdId() {
		return this.prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

}