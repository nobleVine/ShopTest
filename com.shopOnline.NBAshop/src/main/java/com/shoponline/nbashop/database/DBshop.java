package com.shoponline.nbashop.database;

import java.net.UnknownHostException;

public interface DBshop {

	String login(String nickname, String password) throws UnknownHostException;

}
