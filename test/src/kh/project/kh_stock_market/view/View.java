package kh.project.kh_stock_market.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kh.project.kh_stock_market.dto.User;
import kh.project.kh_stock_market.play.Play;
import kh.project.kh_stock_market.service.Service;

public class View {
	final String TITLE = "[KH STOCK MARKET]───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
	final String SELECT = "[선택지]──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
	final String INPUT = "[입력]────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
	final int DISP_SIZE = 35;
	final int SELECT_SIZE = 10;
	private String[] disp = new String[DISP_SIZE];
	private String[] select = new String[SELECT_SIZE];
	Play play;
	private static int dispPointer,selectPointer;
	Scanner sc = new Scanner(System.in);
	Service service = new Service();
	List<User> users=new ArrayList<>();
	int userNum;

	public View() {
		dispPointer=1;
		selectPointer=1;
		for (int i = 0; i < disp.length; i++)
			disp[i] = "";
		selectClear();
	}
	
	public View(Play play) {
		this();
		this.play = play;
		disp[0] = TITLE;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		select[0] = SELECT;
	}
	
	public void regist() {
		disp[dispPointer++] = "플레이어를 등록합니다.";
		select[selectPointer++] = "등록할 유저 수를 입력하세요. (2~5)";
		while(true) {
			this.drawDisplay();
			userNum = inputInt();
			if(userNum>1&&userNum<6) {
				selectClear();
				break;
			}
			if(selectPointer==2)
				select[selectPointer++] = "잘못 입력하셨습니다. 다시 입력하세요.";
		}
		for(int i=0; i < userNum ; i++) {
			select[1] = i+1+"번째 플레이어의 이름을 입력하세요.";
			drawDisplay();
			String user = inputString();
			users.add(new User(user));
			disp[dispPointer++] = users.get(i).getUserName()+"님 등록되었습니다.";
		}
		disp[dispPointer++] = "플레이어 등록이 완료되었습니다.";
		disp[dispPointer++] = "게임을 시작합니다.";
		select[1]="엔터키를 누르세요.";
		drawDisplay();
		dispClear();
	}
	
	public void dispClear(){
		for (int i = 1; i < disp.length; i++)
			disp[i] = "";
		dispPointer=1;
	}
	
	public void selectClear() {
		for (int i = 1; i < select.length; i++)
			select[i] = "";
		selectPointer=1;
	}
	
	public String inputString() {
		while(true) {
			try {
				String input = sc.nextLine();
				return input;
			}catch(Exception e){}
		}
	}
	
	public int inputInt() {
		while(true) {
			try {
				int input = sc.nextInt();
				sc.nextLine();
				return input;
			}catch(Exception e){}
		}
	}

	public void drawDisplay() {
//		clear();	// 화면 지우기
		for (String s : this.disp) {
			System.out.println(s);
		}
		for (String s : this.select) {
			System.out.println(s);
		}
		System.out.println(INPUT);
		System.out.print(" ▶ ");
		
	}

	public void drawMain() {
		disp[10] = "\t\t\t _   __ _   _   _____  _                 _     ___  ___              _           _   ";
		disp[11] = "\t\t\t| | / /| | | | /  ___|| |               | |    |  \\/  |             | |         | |  ";
		disp[12] = "\t\t\t| |/ / | |_| | \\ `--. | |_   ___    ___ | | __ | .  . |  __ _  _ __ | | __  ___ | |_ ";
		disp[13] = "\t\t\t|    \\ |  _  |  `--. \\| __| / _ \\  / __|| |/ / | |\\/| | / _` || '__|| |/ / / _ \\| __|";
		disp[14] = "\t\t\t| |\\  \\| | | | /\\__/ /| |_ | (_) || (__ |   <  | |  | || (_| || |   |   < |  __/| |_ ";
		disp[15] = "\t\t\t\\_| \\_/\\_| |_/ \\____/  \\__| \\___/  \\___||_|\\_\\ \\_|  |_/ \\__,_||_|   |_|\\_\\ \\___| \\__|";
		select[0] = "\t\t\t\t\t\t\t1. 게 임 시 작\n";
		select[1] = "\t\t\t\t\t\t\t2. 규 칙 설 명\n";
		select[2] = "\t\t\t\t\t\t\t3. 게 임 종 료\n";
		drawDisplay();
	}

	// 화면 지우기
	private static void clear() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (Exception e) {
		}
	}
}
