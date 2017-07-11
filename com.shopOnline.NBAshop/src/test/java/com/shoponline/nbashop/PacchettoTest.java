package com.shoponline.nbashop;

import static org.junit.Assert.*;

import org.junit.*;

public class PacchettoTest {

	private Pacchetto pacchetto;
	private SingleProduct singleProduct;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPacchettoEmpty() {
		this.pacchetto = this.createPackage("Maglietta CupCake", "edizione limitata");
		assertEquals(0, this.pacchetto.sizeList());
	}

	@Test
	public void testName() {
		this.pacchetto = this.createPackage("Maglietta CupCake", "descrizione");
		assertEquals("Maglietta CupCake", this.pacchetto.getName());
	}

	@Test
	public void testDescription() {
		this.pacchetto = this.createPackage("pacchettone", "Ti piace vincere facile?");
		assertEquals("Ti piace vincere facile?", pacchetto.getDescription());
	}

	@Test
	public void testNumberOneaddSingleProductToPack() {
		this.singleProduct = createSingleProduct("single", 500, "d");
		this.pacchetto = this.createPackage("dddd", "sssss");
		this.pacchetto.addSingleProductToPack(this.singleProduct);
		assertEquals(1, this.pacchetto.sizeList());
		assertEquals("single", this.pacchetto.getPack().get(0).getName());
		assertTrue(500 == this.pacchetto.getPack().get(0).getPrice());
		assertEquals("d", this.pacchetto.getPack().get(0).getDescription());
	}

	@Test
	public void removeSingleProductToPack() {
		this.singleProduct = createSingleProduct("single", 500, "d");
		this.pacchetto = this.createPackage("dddd", "sssss");
		this.pacchetto.addSingleProductToPack(this.singleProduct);
		this.pacchetto.removeItemToPack(this.singleProduct);
		assertEquals(0, this.pacchetto.sizeList());
	}

	@Test
	public void testGetPriceWithMoreSingleProduct() {
		this.singleProduct = createSingleProduct("single", 500, "d");
		SingleProduct singleProduct2 = createSingleProduct("single2", 500, "de");
		this.pacchetto = this.createPackage("dddd", "sssss");
		this.pacchetto.addSingleProductToPack(this.singleProduct);
		this.pacchetto.addSingleProductToPack(singleProduct2);
		assertTrue(1000 == this.pacchetto.getPrice());
	}
	
	

	private Pacchetto createPackage(String name, String description) {
		return new Pacchetto(name, description);
	}

	private SingleProduct createSingleProduct(String name, double price, String description) {
		return new SingleProduct(name, price, description);
	}

}
