package com.shoponline.nbashop;

import static org.junit.Assert.*;
import org.junit.*;

public class SingleProductTest {

	SingleProduct singleProduct;

	@Test
	public void testName() {
		this.singleProduct = this.createSingleProduct("Maglietta CupCake", 0, null);
		assertEquals("Maglietta CupCake", singleProduct.getName());
	}

	@Test
	public void testPrice60() {
		this.singleProduct = this.createSingleProduct(null, 60.0, null);
		assertTestPrice(60.0);
	}

	@Test
	public void testDescription() {
		this.singleProduct = this.createSingleProduct(null, 0, "Ti piace vincere facile?");
		assertEquals("Ti piace vincere facile?", singleProduct.getDescription());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeInput() {
		this.singleProduct = this.createSingleProduct("Maglietta CupCake", -9, "Ti piace vincere facile?");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyName() {
		this.singleProduct = this.createSingleProduct("", 4, "des");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyDes() {
		this.singleProduct = this.createSingleProduct("Marco", 0, "");
	}

	@Test
	public void testTipoName() {
		this.singleProduct = this.createSingleProduct("Vigna", 4, "des");
		String test = "Vigna";
		assertTrue(this.singleProduct.getName().equals(test));
	}
	
	@Test
	public void testTipoDes() {
		this.singleProduct = this.createSingleProduct("Vigna", 4, "des");
		String test = "des";
		assertTrue(this.singleProduct.getDescription().equals(test));
	}

	private void assertTestPrice(double input) {
		assertTrue(input == this.singleProduct.getPrice());
	}

	private SingleProduct createSingleProduct(String name, double price, String des) {
		return new SingleProduct(name, price, des);
	}

}
