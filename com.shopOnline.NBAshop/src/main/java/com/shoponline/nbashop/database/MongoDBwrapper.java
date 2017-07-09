package com.shoponline.nbashop.database;

import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.shoponline.nbashop.Supporter;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class MongoDBwrapper implements DBshop {

	private DB db;
	private MongoCollection users;
	
	public MongoDBwrapper(MongoClient mongoClient) throws UnknownHostException {
		this.db = mongoClient.getDB("shopDB");
		Jongo jongo = new Jongo(this.db);
		jongo = new Jongo(db);
		this.users = jongo.getCollection("user");
	}

	@Override
	public String login(String nickname, String password) throws UnknownHostException {
		this.users.insert(new Supporter("Marco", "Vignini", nickname, password, null));
		return "Inserimento";
	}

	public List<Supporter> getAllSupporters() {
		Iterable<Supporter> iterable = this.users.find().as(Supporter.class);
		return StreamSupport.stream(iterable.spliterator(), false).
				collect(Collectors.toList());
	}
	
}
