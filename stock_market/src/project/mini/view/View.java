package project.mini.view;

public class View {
	final String INPUT = "[입력]────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
	final int DISP_SIZE = 35;
	final int SELECT_SIZE = 10;
	private String[] disp;
	private String[] select;
	
	public View() {
		disp = new String[DISP_SIZE];
		select = new String[SELECT_SIZE];
	}
	
	public void drawMain() {
		disp[10] = "\t\t\t\t _   __ _   _   _____  _                 _     ___  ___              _           _   ";
		disp[11] = "\t\t\t\t| | / /| | | | /  ___|| |               | |    |  \\/  |             | |         | |  ";
		disp[12] = "\t\t\t\t| |/ / | |_| | \\ `--. | |_   ___    ___ | | __ | .  . |  __ _  _ __ | | __  ___ | |_ ";
		disp[13] = "\t\t\t\t|    \\ |  _  |  `--. \\| __| / _ \\  / __|| |/ / | |\\/| | / _` || '__|| |/ / / _ \\| __|";
		disp[14] = "\t\t\t\t| |\\  \\| | | | /\\__/ /| |_ | (_) || (__ |   <  | |  | || (_| || |   |   < |  __/| |_ ";
		disp[15] = "\t\t\t\t\\_| \\_/\\_| |_/ \\____/  \\__| \\___/  \\___||_|\\_\\ \\_|  |_/ \\__,_||_|   |_|\\_\\ \\___| \\__|";
		select[0] = "\t\t\t\t\t\t\t\t1. 게 임 시 작\n";
		select[1] = "\t\t\t\t\t\t\t\t2. 규 칙 설 명\n";
		select[2] = "\t\t\t\t\t\t\t\t3. 게 임 종 료\n";
		drawDisplay();
	}
	
	public void drawDisplay() {
		for (String s : this.disp) {
			System.out.println(s);
		}
		for (String s : this.select) {
			System.out.println(s);
		}
		System.out.println(INPUT);
		System.out.print(" ▶ ");
	}
	
	public void drawQuit() {
		selectClear();
		dispClear();
		titleClear();
		disp[22]="\t\t\t\t\t\t\t\t게임을 종료합니다.";
		drawDisplay();
	}
}
