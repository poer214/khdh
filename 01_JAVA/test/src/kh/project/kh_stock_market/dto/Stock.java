package kh.project.kh_stock_market.dto;

public class Stock {
	private String stockType;
	private String stockName;	// 주식 이름
	private int stockValue;			// 현재 가치
	private int stockPrevValue;		// 이전 가치
	private int stockBuyValue;		// 구매 가치
	private int stockQuantity;		// 주식 수량
	private double stockRate;			// 등락률
	
	public Stock(String stockName,int stockValue, int stockBuyValue, double stockRate){
		this.stockName = stockName;
		this.stockValue = stockBuyValue;
		this.stockBuyValue = stockBuyValue;
		this.stockRate = stockRate;
	}
	public int getStockBuyValue() {
		return stockBuyValue;
	}
	public void setStockBuyValue(int stockBuyValue) {
		this.stockBuyValue = stockBuyValue;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getStockValue() {
		return stockValue;
	}
	public void setStockValue(int stockValue) {
		this.stockValue = stockValue;
	}
	public int getStockPrevValue() {
		return stockPrevValue;
	}
	public void setStockPrevValue(int stockPrevValue) {
		this.stockPrevValue = stockPrevValue;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public double getStockRate() {
		return stockRate;
	}
	public void setStockRate(double stockRate) {
		this.stockRate = stockRate;
	}
	public Stock() {
		stockPrevValue=0;
		stockQuantity=10;
		stockRate = 0;
	}
	public Stock(String stockType, String stockName, int stockValue) {
		this();
		this.stockType=stockType;
		this.stockName=stockName;
		this.stockValue=stockValue;
	}
	
	
	public Stock(String stockName, int stockBuyValue, int stockQuantity) {
		super();
		this.stockName = stockName;
		this.stockBuyValue = stockBuyValue;
		this.stockQuantity = stockQuantity;
	}
	
	public void setStockBuyValueAndStockQuantity(Stock s) {
		this.stockBuyValue =
				(this.stockBuyValue * this.stockQuantity + s.stockBuyValue * s.stockQuantity)
				/ (this.stockQuantity + s.stockQuantity);
		this.stockQuantity += s.stockQuantity;
	}
}