package com.shopOnline.NBAshop;

import static org.junit.Assert.*;

import org.junit.Test;

public class TravisClassTest {

	@Test
	public void test() {
		TravisClass t = new TravisClass();
		assertEquals("Travis", t.getStringTravis());
	}
	
	

}
