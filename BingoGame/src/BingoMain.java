import java.util.Scanner;

public class BingoMain {
	public static void main(String[] args) {
//		Java Project : BingoGame
//
//		1. 빙고판 크기를 입력 받아, 그 크기 만큼의 행과 열을 가지는 2차원 배열(빙고판)을 생성하고
//		1부터 크기*크기 사이의 정수 난수를 무작위 배치.
//
//		2. 정수를 입력 받아 빙고판에서 일치하는 부분을 찾아 해당 부분의 숫자를 “★“로 변경하고
//		현재 빙고 카운트가 몇인지 출력.
//		단, 빙고판에 없는 정수를 입력한 경우 “다시 입력해주세요.“ 출력
//
//		3. 가로, 세로, 대각선 한 줄이 모두 “★“로 변경되어 있을 경우 빙고 카운트를 1 증가
//
//		4. 빙고카운트가 3이상이 되면 “***Bingo!***” 를 출력하고 프로그램 종료.
		Scanner sc = new Scanner(System.in);
		System.out.print("빙고판 크기 지정 : ");
		int size = sc.nextInt();
		
		//빙고판 초기화
		String[][] numbers = new String[size][size];
		for(int i=0;i<numbers.length;i++) {
			for(int j=0;j<numbers[i].length;j++) {
				numbers[i][j]=Integer.toString((int)(Math.random()*size*size+1));
				System.out.printf("%3s",numbers[i][j]); // 나중에 주석처리
			}
			System.out.println();
		}

		System.out.println("============빙고게임 시작=============");
		while(true) {
			break;
		}
		
		
	}
}