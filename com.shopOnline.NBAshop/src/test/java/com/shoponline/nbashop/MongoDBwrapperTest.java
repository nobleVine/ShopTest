package com.shoponline.nbashop;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;

import com.github.fakemongo.Fongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.shoponline.nbashop.database.DBshop;
import com.shoponline.nbashop.database.MongoDBwrapper;

public class MongoDBwrapperTest {

	private MongoDBwrapper mongoDBwrapper;
	private DBCollection supporters;
	private BasicDBObject document;

	@Before
	public void initDB() throws UnknownHostException {
		Fongo fongo = new Fongo("mongo server 1");
		MongoClient mongoClient = fongo.getMongo();
		DB db = mongoClient.getDB("DBshop");
		db.getCollection("supporter").drop();
		mongoDBwrapper = new MongoDBwrapper(mongoClient);
		this.supporters = db.getCollection("user");
	}

	@Test
	public void testGetAllSupportersEmpty() {
		assertTrue(this.mongoDBwrapper.getAllSupporters().isEmpty());
	}

	@Test
	public void testGetAllSupportersNotEmpty() {
		addSupporter("Marco", "Vignini", "nick", "Lebron", null);
		addSupporter("Marco2", "Vignini2", "nick2", "Lebron2", null);
		assertEquals(2, this.mongoDBwrapper.getAllSupporters().size());
	}
	
	//remove
	//save
	//... Vedi jongo documentation http://jongo.org/

	private void addSupporter(String name, String surname, String nickname, String password, DBshop DBshop) {
		this.document = new BasicDBObject();
		this.document.put("name", name);
		this.document.put("surname", surname);
		this.document.put("nickname", nickname);
		this.document.put("password", password);
		this.document.put("DBshop", DBshop);
		this.supporters.insert(document);
	}

}
