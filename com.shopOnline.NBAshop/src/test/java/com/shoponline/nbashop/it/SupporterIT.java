package com.shoponline.nbashop.it;

import org.junit.*;

import com.shoponline.nbashop.Supporter;
import com.shoponline.nbashop.database.DBshop;
import com.shoponline.nbashop.database.MongoDBwrapper;
import com.github.fakemongo.Fongo;
import com.mongodb.*;

public class SupporterIT {

	private DBshop dbshop;
	private Supporter supporter;

	@Before
	public void setUp() throws Exception {
		Fongo fongo = new Fongo("mongo server 1");
		MongoClient mongoClient = fongo.getMongo();
		this.dbshop = new MongoDBwrapper(mongoClient);
	}

	/*@Test
	public void testLoginSuccess() {
		this.supporter = new Supporter(null, null, "", "", this.dbshop);
		assertEquals("Autenticazioni senza credenziali di default", this.supporter.request());
		this.supporter.setAccess(true);
	}*/

}
