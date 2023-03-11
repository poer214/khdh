package project.mini.main;

import java.util.Scanner;

import project.mini.play.Play;
import project.mini.view.View;


public class Main {
	public Main() {
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