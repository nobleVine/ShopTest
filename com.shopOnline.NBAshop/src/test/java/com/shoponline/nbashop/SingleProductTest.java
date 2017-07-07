package com.shoponline.nbashop;

import static org.junit.Assert.*;

import org.junit.*;

public class SingleProductTest {

	SingleProduct singleProduct;

	@Before
	public void setUp() {
		this.singleProduct = new SingleProduct("Maglietta CupCake", 60.0, "Ti piace vincere facile?");
	}

	@Test
	public void testName() {
		assertEquals("Maglietta CupCake", singleProduct.getName());
	}
	
	@Test
	public void testPrice() {
		assertTrue(60.0 == singleProduct.getPrice());
	}
	
	@Test
	public void testDescription() {
		assertEquals("Ti piace vincere facile?", singleProduct.getDescription());
	}
	
}
