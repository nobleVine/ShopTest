package com.shoponline.nbashop;

import java.util.*;

public class Carrello {

	private List<Item> listaCarrello;

	public Carrello(List<Item> listaCarello) {
		this.listaCarrello = listaCarello;
	}

	public void addItem(Item item) {
		listaCarrello.add(item);
	}

}
