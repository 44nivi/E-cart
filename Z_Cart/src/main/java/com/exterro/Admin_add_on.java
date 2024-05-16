package com.exterro;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Admin_add_on_data")
public class Admin_add_on {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", path="
				+ path + ", gender=" + gender+"]";
	}

	public Admin_add_on() {
		super();
		
	}


	private String quantity;
	private String price;
	private String path;
	private String gender;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public Admin_add_on(String name, String quantity, String price, String path, String gender) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.path = path;
		this.gender = gender;
	}

}
