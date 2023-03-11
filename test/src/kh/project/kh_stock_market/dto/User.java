package kh.project.kh_stock_market.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
	private final int START_CASH = 100000;
	private String userName;		// 초기설정이름
	private int cash;		// 현금보유량
	private List<Stock> stocks;	// 보유주식<주식명,보유량>
	private int totalHoldings;
	private double totalHoldingsRate;
	
	
	public void updateUsersStocks(List<Stock> stocks) {
		
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	public int getTotalHoldings() {
		return totalHoldings;
	}
	public void setTotalHoldings(int totalHoldings) {
		this.totalHoldings = totalHoldings;
	}
	public int getSTART_CASH() {
		return START_CASH;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public User() {
		cash=START_CASH;
		totalHoldings = cash;
		totalHoldingsRate = 0;
		stocks = new ArrayList<>();
	}
	public double getTotalHoldingsRate() {
		return totalHoldingsRate;
	}
	public void setTotalHoldingsRate(double totalHoldingsRate) {
		this.totalHoldingsRate = totalHoldingsRate;
	}
	public User(String userName) {
		this();
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
//	임시
	public void addStocks() {
		this.stocks.add(new Stock("한미약품", 9000, 3));
		this.stocks.add(new Stock("한미약품", 11000, 4));
		
		this.stocks.add(new Stock("대한항공", 8000, 5));
		this.stocks.add(new Stock("대한항공", 9000, 3));
		this.stocks.add(new Stock("대한항공", 10000, 2));
		this.stocks.add(new Stock("대한항공", 11000, 1));
		
		this.stocks.add(new Stock("테슬라", 13000, 6));
		this.stocks.add(new Stock("테슬라", 11500, 1));
		this.stocks.add(new Stock("테슬라", 11000, 2));
	}
}