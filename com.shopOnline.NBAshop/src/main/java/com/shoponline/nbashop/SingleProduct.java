package com.shoponline.nbashop;

public class SingleProduct implements Item {

	private String name;
	private double price;
	private String description;

	public SingleProduct(String name, double price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

}
