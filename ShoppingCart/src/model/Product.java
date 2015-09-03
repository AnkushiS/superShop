package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PRODUCTS database table.
 * 
 */
@Entity
@Table(name="PRODUCTS")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROD_ID")
	private int prodId;

	private String description;

	private Double price;

	@Column(name="PROD_NAME")
	private String prodName;

	@Column(name="PROD_PIC")
	private String prodPic;

	public Product() {
	}

	public int getProdId() {
		return this.prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdPic() {
		return this.prodPic;
	}

	public void setProdPic(String prodPic) {
		this.prodPic = prodPic;
	}

}