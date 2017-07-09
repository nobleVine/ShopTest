package com.shoponline.nbashop;

import java.net.UnknownHostException;

import com.shoponline.nbashop.database.DBshop;

public class Supporter {

	private String name;
	private String surname;
	private String nickname;
	private String password;
	private DBshop dbshop;
	private boolean access;

	public Supporter(String name, String surname, String nickname, String password, DBshop dbshop) {
		this.name = name;
		this.surname = surname;
		this.nickname = nickname;
		this.password = password;
		this.dbshop = dbshop;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPassword() {
		return password;
	}

	public String request() throws UnknownHostException {
		return this.dbshop.login(this.getNickname(), this.getPassword());
	}

	public void setAccess(boolean b) {
		this.access = b;
	}
	
	public boolean isAccess() {
		return access;
	}

}
