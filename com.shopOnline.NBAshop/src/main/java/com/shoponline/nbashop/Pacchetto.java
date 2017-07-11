package com.shoponline.nbashop;

import java.util.*;

public class Pacchetto {

	private String name;
	private double price;
	private String description;
	private List<SingleProduct> pack;

	public Pacchetto(String name, String des) {
		this.name = name;
		this.description = des;
		this.pack = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		for (int i = 0; i < this.sizeList(); i++) {
			this.price += this.getPrice();
		}
		return this.price;
	}

	public String getDescription() {
		return description;
	}

	public int sizeList() {
		return pack.size();
	}

	public void addSingleProductToPack(SingleProduct singleProduct) {
		this.pack.add(singleProduct);
	}

	public List<SingleProduct> getPack() {
		return this.pack;
	}

	public void removeItemToPack(SingleProduct singleProduct) {
		if (this.sizeList() == 0)
			throw new RuntimeException("Non posso rimuovere qualcosa che non c'è");
		this.pack.remove(singleProduct);
	}

}
