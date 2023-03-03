package kh.project.kh_stock_market.main;

import java.util.Scanner;

import kh.project.kh_stock_market.play.Play;
import kh.project.kh_stock_market.view.View;

public class Main {
	public Main(){
		Scanner sc = new Scanner(System.in);
		View draw = new View();
		while(true) {
			draw.drawMain();
			String input = sc.nextLine();
			
			if(input.equals("1")) {
				new Play();
			} else if(input.equals("2")) {
				continue;
			} else if(input.equals("3")) {
				break;
			} else {
				continue;
			}
		}
	}
}