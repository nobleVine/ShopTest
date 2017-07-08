package com.shoponline.nbashop;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.apache.log4j.Logger;

import java.net.UnknownHostException;
import java.util.*;

import org.junit.*;
import org.mockito.*;

import com.shoponline.nbashop.database.DBshop;

public class SupporterTest {

	private static final Logger LOGGER = Logger.getLogger(SupporterTest.class);
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
	}

	@Test
	public void testNickname() {
		supporter = new Supporter(null, null, "", null, dbshop);
		assertEquals("", this.supporter.getNickname());
	}

	@Test
	public void testPassword() {
		supporter = new Supporter(null, null, null, "", dbshop);
		assertEquals("", this.supporter.getPassword());
	}

	@Test
	public void testName() {
		supporter = new Supporter("Marco", null, null, null, dbshop);
		assertEquals("Marco", this.supporter.getName());
	}

	@Test
	public void testSurname() {
		supporter = new Supporter(null, "Vignini", null, null, dbshop);
		assertEquals("Vignini", this.supporter.getSurname());
	}

	@Test
	public void loginSuccess() throws UnknownHostException {
		this.supporter = spy(new Supporter(null, null, "", "", this.dbshop));
		assertEquals("Autenticazioni senza credenziali di default", this.supporter.request());
		LOGGER.info("Login effettuato con successo");
		verify(this.dbshop, times(1)).login("", "");
		this.supporter.setAccess(true);
		verify(this.supporter).setAccess(true);
	}

	@Test
	public void loginUnSuccess() throws UnknownHostException {
		this.supporter = spy(new Supporter(null, null, "nick", "pass", this.dbshop));
		assertNull("Autenticazioni senza credenziali di default", this.supporter.request());
		LOGGER.error("Errore nell'immissione delle credenziali");
		verify(this.dbshop, times(1)).login("nick", "pass");
		verifyNoMoreInteractions(this.dbshop);
	}

}
