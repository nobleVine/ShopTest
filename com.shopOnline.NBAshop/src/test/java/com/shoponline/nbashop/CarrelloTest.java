package com.shoponline.nbashop;

import static org.junit.Assert.*;
import java.util.*;
import org.apache.log4j.Logger;
import org.junit.*;

import com.shoponline.nbashop.Carrello;
import com.shoponline.nbashop.Item;
import com.shoponline.nbashop.SingleProduct;

public class CarrelloTest {

	private static final Logger LOGGER = Logger.getLogger(CarrelloTest.class);
	private Carrello carrello;
	private List<Item> listaCarrello;

	@Before
	public void setUp() {
		this.listaCarrello = new ArrayList<Item>();
		this.carrello = new Carrello(this.listaCarrello);
	}

	@Test
	public void testNumberAddOneSingleItemToCart() {
		carrello.addItem(this.createSingleProduct("Roberto", 0, "prodotto umano LOL"));
		assertEquals(1, listaCarrello.size());
	}

	@Test
	public void testFiveAddFiveSingleItemCart() {
		this.assertNumberSingleProduct(5);
	}

	@Test
	public void testOneAddFiveSingleItemCart() {
		this.assertNumberSingleProduct(1);
	}

	@Test
	public void testNoProduct() {
		this.assertNumberSingleProduct(0);
	}

	@Test
	public void testSameTenSingleProduct() {
		for (int i = 0; i < 10; i++) {
			carrello.addItem(new SingleProduct("n" + i, i + 1, "des" + i));
			assertEquals("n" + i, this.listaCarrello.get(i).getName());
			assertTrue(this.listaCarrello.get(i).getPrice() == (i + 1));
			assertEquals("des" + i, this.listaCarrello.get(i).getDescription());
		}
	}

	@Test
	public void testRemoveSingleProduct() {
		SingleProduct singleProd = this.createSingleProduct("AAA", 34, "description");
		this.carrello.addItem(singleProd);
		this.carrello.removeItem(singleProd);
		assertEquals(0, this.carrello.cartSize());	
	}

	private void assertNumberSingleProduct(int numeroProdotti) {
		if (numeroProdotti == 0) {
			LOGGER.info("Si sta richiamando addItem() non passandogli nessun oggetto");
		}
		for (int i = 0; i < numeroProdotti; i++) {
			carrello.addItem(this.createSingleProduct("Roberto" + i, i, "prodotto umano LOL"));
		}
		assertEquals(numeroProdotti, listaCarrello.size());
	}

	private SingleProduct createSingleProduct(String name, double price, String description) {
		return new SingleProduct(name, price, description);
	}

}
