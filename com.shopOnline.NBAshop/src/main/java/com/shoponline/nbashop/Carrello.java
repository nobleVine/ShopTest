package com.shoponline.nbashop;

import java.util.*;

public class Carrello {

	private List<Item> listaCarrello;

	public Carrello(List<Item> listaCarello) {
		this.listaCarrello = listaCarello;
	}

	public void addItem(Item item) {
		this.listaCarrello.add(item);
	}

	public void removeItem(Item item) {
		this.listaCarrello.remove(item);
	}

	public int cartSize() {
		return this.listaCarrello.size();
	}

}
