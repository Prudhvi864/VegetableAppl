package com.cg.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "veg_details")  //Mapping with sql table.
public class VegetableDTO {
	@Id
	@Column(name = "veg_id")
	private int vegId;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	@Column(name = "category")
	private String category;
	@Column(name = "price")
	private double price;
	@Column(name = "quantity")
	private int quantity;

	public VegetableDTO() {
		super();
	}

	public VegetableDTO(int vegId, String name, String type, String category, double price, int quantity) {
		super();
		this.vegId = vegId;
		this.name = name;
		this.type = type;
		this.category = category;                   //constructor
		this.price = price;
		this.quantity = quantity;
	}

	public int getVegId() {
		return vegId;
	}

	public void setVegId(int vegId) {
		this.vegId = vegId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}                                              //getters & setters for VegetableDTO.

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Vegetable [vegId=" + vegId + ", name=" + name + ", type=" + type + ", category=" + category + ", price="
				+ price + ", quantity=" + quantity + "]";
	}

}

