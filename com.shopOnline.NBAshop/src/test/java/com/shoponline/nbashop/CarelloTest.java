package com.shoponline.nbashop;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import com.shoponline.nbashop.Carrello;
import com.shoponline.nbashop.Item;
import com.shoponline.nbashop.SingleProduct;

public class CarelloTest {

	private Carrello carrello;
	private List<Item>listaCarrello;

	@Before
	public void setUp() {
		this.listaCarrello = new ArrayList<Item>();
		this.carrello = new Carrello(this.listaCarrello);
	}
	
	@Test
	public void addOneSingleItemToCart(){
		Item item = new SingleProduct();
		carrello.addItem(item);
		assertEquals(1, listaCarrello.size());
	}

}
