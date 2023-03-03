package kh.project.kh_stock_market.service;

import java.util.Scanner;

public class Service {
	Scanner sc = new Scanner(System.in);

	public void setSelect() {

	}

	public String input() {
		String input;
		while (true) {
			try {
				input = sc.nextLine();
				break;
			} catch (Exception e) {
			}
		}
		return input;
	}
}