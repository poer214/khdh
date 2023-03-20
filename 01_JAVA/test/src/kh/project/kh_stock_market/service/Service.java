package kh.project.kh_stock_market.service;

import java.util.ArrayList;
import java.util.List;

import kh.project.kh_stock_market.dto.Stock;

public class Service {
	List<Stock> stocks;
	public List<Stock> initStock() {
		stocks = new ArrayList<>();
		stocks.add(new Stock("바이오","한미약품",11000));
		stocks.add(new Stock("여행/항공","대한항공",12000));
		stocks.add(new Stock("자율주행","테슬라",13000));
		stocks.add(new Stock("자동차","현대모비스",14000));
		stocks.add(new Stock("엔터테인먼트","하이브",15000));
		stocks.add(new Stock("반도체","DB하이텍",16000));
		stocks.add(new Stock("IT","삼성전자",17000));
		stocks.add(new Stock("금융","KB금융",18000));
		stocks.add(new Stock("건설","현대건설",19000));
		stocks.add(new Stock("보험","DB손해보험",20000));
		stocks.add(new Stock("화학","코스모화학",21000));
		stocks.add(new Stock("식품","CJ제일제당",22000));
		stocks.add(new Stock("뷰티","아모레퍼시픽",23000));
		
		return stocks;
	}
}