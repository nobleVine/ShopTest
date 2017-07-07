package com.shoponline.nbashop;

import java.util.List;

public interface DBshop {

	String login(String nickname, String password);

	List<Supporter> getSupporters();

}
