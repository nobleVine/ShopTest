package com.shoponline.nbashop;

public class SingleProduct implements Item {

	private String name;
	private double price;
	private String description;

	public SingleProduct(String name, double price, String description) {
		controlloParametriDiInizializzazioneProdottoSingolo(name, price, description);
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	public String getDescription() {
		return this.description;
	}

	private void controlloParametriDiInizializzazioneProdottoSingolo(String name, double price, String description) {
		if (name != "") {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Il nome del prodotto non può essere vuoto");
		}

		if (price >= 0) {
			this.price = price;
		} else {
			throw new IllegalArgumentException("Il prezzo minimo è 0: GRATIS");
		}

		if (description != "") {
			this.description = description;
		} else {
			throw new IllegalArgumentException("Il nome della descrizione non può essere vuoto");
		}
	}

}
