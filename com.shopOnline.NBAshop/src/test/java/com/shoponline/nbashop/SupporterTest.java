package com.shoponline.nbashop;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.*;
import org.mockito.*;

public class SupporterTest {

	@InjectMocks
	private Supporter supporter;
	@Mock
	private DBshop dbshop;

	List<Supporter> supporters;

	@Before
	public void setUp() throws Exception {
		this.supporters = new ArrayList<Supporter>();
		MockitoAnnotations.initMocks(this);
		when(this.dbshop.login("", "")).thenReturn("Autenticazioni senza credenziali di default");
		when(this.dbshop.getSupporters()).thenReturn(this.supporters);
	}

	@Test
	public void testNickname() {
		supporter = new Supporter(null, null, "", null);
		assertEquals("", this.supporter.getNickname());
	}

	@Test
	public void testPassword() {
		supporter = new Supporter(null, null, null, "");
		assertEquals("", this.supporter.getPassword());
	}

	@Test
	public void testName() {
		supporter = new Supporter("Marco", null, null, null);
		assertEquals("Marco", this.supporter.getName());
	}

	@Test
	public void testSurname() {
		supporter = new Supporter(null, "Vignini", null, null);
		assertEquals("Vignini", this.supporter.getSurname());
	}

	@Test
	public void loginSuccess() {
		assertEquals("Autenticazioni senza credenziali di default", this.dbshop.login("", ""));
	}

}
