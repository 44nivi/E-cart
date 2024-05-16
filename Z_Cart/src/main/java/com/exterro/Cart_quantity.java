package com.exterro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Cart_Quantity")
public class Cart_quantity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	private String gender;
	private String  path;
	private int prod_order;
	
	public int getOrder() {
		return prod_order;
	}


	public void setOrder(int prod_order) {
		this.prod_order = prod_order;
	}




	public Cart_quantity(String name, String gender, String path, String productid, String quantity, String price,
			int prod_order, int id) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.path = path;
		this.prod_order = prod_order;
		this.productid = productid;
		this.quantity = quantity;
		this.price = price;	}



	public Cart_quantity() {
		super();
		// TODO Auto-generated constructor stub
	}



	private String productid;
	public String getProductid() {
		return productid;
	}

	public void setProduct_id(String productid) {
		this.productid = productid;
	}

	private String quantity;
	private String price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public void setProductid(String productid) {
		this.productid = productid;
	}


	@Override
	public String toString() {
		return "Cart_quantity [id=" + id + ", name=" + name + ", gender=" + gender + ", path=" + path + ", order="
				+ prod_order + ", productid=" + productid + ", quantity=" + quantity + ", price=" + price + "]";
	}



	

}
