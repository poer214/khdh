package kh.project.kh_stock_market.main;

import java.util.Scanner;

import kh.project.kh_stock_market.play.Play;
import kh.project.kh_stock_market.view.View;

public class Main {
	public Main(){
		Scanner sc = new Scanner(System.in);
		View view = new View();
		while(true) {
			view.drawMain();
			String input = sc.nextLine();
			
			switch(input) {
			case "1":new Play();break;	// Play 객체 생성
			case "2":break;				// 규칙설명
			case "3":view.drawQuit();return;			// 종료
			}
		}
	}
}