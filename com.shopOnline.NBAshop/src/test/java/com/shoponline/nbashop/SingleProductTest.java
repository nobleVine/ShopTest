package com.shoponline.nbashop;

import static org.junit.Assert.*;
import org.junit.*;

public class SingleProductTest {

	SingleProduct singleProduct;

	@Before
	public void setUp() {
	}

	@Test
	public void testName() {
		singleProduct = this.createSingleProduct("Maglietta CupCake", 0, null);
		assertEquals("Maglietta CupCake", singleProduct.getName());
	}

	@Test
	public void testPrice60() {
		singleProduct = this.createSingleProduct(null, 60.0, null);
		assertTestPrice(60.0);
	}

	@Test
	public void testDescription() {
		singleProduct = this.createSingleProduct(null, 0, "Ti piace vincere facile?");
		assertEquals("Ti piace vincere facile?", singleProduct.getDescription());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeInput() {
		singleProduct = this.createSingleProduct("Maglietta CupCake", -5, "Ti piace vincere facile?");
		assertTestPrice(-5);
	}

	private void assertTestPrice(double input) {
		assertTrue(input == singleProduct.getPrice());
	}

	private SingleProduct createSingleProduct(String name, double price, String des){
		return new SingleProduct(name, price, des);
	}
}
