package kh.project.kh_stock_market.dto;

import java.util.Map;

public class User {
	private final int START_CASH = 100000;
	private String userName;		// 초기설정이름
	private int cash;		// 현금보유량
	private Map<String,Integer> stocks;	// 보유주식<주식명,보유량>
	
	public User() {
		cash=START_CASH;
	}
	public User(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
}