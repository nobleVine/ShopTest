package com.shoponline.nbashop;

public class Supporter {

	private String name;
	private String surname;
	private String nickname;
	private String password;
	private DBshop dbshop;

	public Supporter(String name, String surname, String nickname, String password) {
		this.name = name;
		this.surname = surname;
		this.nickname = nickname;
		this.password = password;
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

	public void request() {
		this.dbshop.login(this.getNickname(), this.getPassword());
	}

}
