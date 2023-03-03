package kh.project.kh_stock_market.play;

import java.util.Scanner;

import kh.project.kh_stock_market.view.View;

public class Play {
	
	public Play() {
		View draw = new View(this);
		Scanner sc = new Scanner(System.in);
		while(true) {
			draw.regist();
			String input = sc.nextLine();
			if(input.equals("0"))
				break;
		}
	}

	public void play() {
		Scanner sc = new Scanner(System.in);
	}
}
