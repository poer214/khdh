import java.util.Scanner;

public class BingoGame {
	private final static String CHECKED="★";
	private final static int WIN_CONDITION=3;
	private static Scanner sc;
	
	// 빙고판 초기화
	private static String[][] init(int size) {
		//빙고판 크기 입력받아 배열 생성
		String[][] numbers = new String[size][size];
		
		// 배열에 난수 대입 및 출력
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				numbers[i][j] = Integer.toString((int)(Math.random() * size * size + 1));
				System.out.printf("%3s", numbers[i][j]);
			}
			System.out.println(); // 한 줄 출력 후 개행
		}
		// 초기화된 배열 반환
		return numbers;
	}
	
	// 게임 시작
	private static void start(String[][] numbers) {
		System.out.println("============빙고게임 시작=============");
		boolean gameOver=false;
		while (!gameOver) {
			// 체크할 숫자 입력받기
			System.out.print("정수를 입력하시오 : ");
			// 입력받은 숫자와 일치하는 숫자 찾아서 CHECKED(★)로 바꾼 후 출력 후 빙고 체크한 뒤 빙고줄 수 넘겨받아 게임오버체크
			gameOver=gameOverCheck(bingoCheck(print(searchAndChange(numbers,sc.nextInt()))));
		}
	}
	
	// 입력한 숫자 찾아서 별로 바꾸기
	private static String[][] searchAndChange(String[][] numbers,int input) {
		for (int i = 0; i < numbers.length; i++)
			for (int j = 0; j < numbers[i].length; j++)
				if (numbers[i][j].equals(Integer.toString(input)))
					numbers[i][j] = CHECKED;
		return numbers;
	}

	// 빙고판 출력
	private static String[][] print(String[][] numbers) {
		for(int i=0; i<numbers.length;i++) {
			for(int j=0;j<numbers[i].length;j++)
				System.out.printf("%3s",numbers[i][j]);
			System.out.println();
		}
		return numbers;
	}
	
	// 빙고 판별
	private static int bingoCheck(String[][] numbers) {
		return rowBingoCheck(numbers)+colBingoCheck(numbers)+leftDiagBingoCheck(numbers)+rightDiagBingoCheck(numbers);
	}
	
	private static int rowBingoCheck(String[][] numbers) {
		int bingo = 0;
		for(int i=0;i<numbers.length;i++) {
		int checked=0;
		for(int j=0;j<numbers.length;j++) 
			if(numbers[i][j].equals(CHECKED))
				checked++;
		if(checked==numbers.length)
			bingo++;
		}
		return bingo;		
	}
	
	private static int colBingoCheck(String[][] numbers) {
		int bingo = 0;
		for(int i=0;i<numbers.length;i++) {
			int checked=0;
			for(int j=0;j<numbers.length;j++) 
				if(numbers[j][i].equals(CHECKED))
					checked++;
			if(checked==numbers.length)
				bingo++;
		}
		return bingo;		
	}
	
	private static int leftDiagBingoCheck(String[][] numbers) {
		int checked=0;
		for(int i=0;i<numbers.length;i++) 
			if(numbers[i][i].equals(CHECKED))
				checked++;
		return checked==numbers.length?1:0;		
	}
	
	private static int rightDiagBingoCheck(String[][] numbers) {
		int checked=0;
		for(int i=0;i<numbers.length;i++) 
			if(numbers[i][numbers.length-i-1].equals(CHECKED))
				checked++;
		return checked==numbers.length?1:0;
	}
	
	// 승리체크
	private static boolean gameOverCheck(int bingo) {
		// 현재 빙고 출력
		System.out.printf("현재 %d 빙고\n",bingo);
		// 현재 빙고가 승리조건(3)이상이라면 false 반환
		if(bingo>=WIN_CONDITION) {
			System.out.println("***** BINGO!!! *****");
			return true;
		}
		System.out.println("\n"); // 2줄 개행
		return false;
	}
	
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
		// 빙고판 초기화하고 게임 시작
		System.out.print("빙고판 크기 지정 : ");
		sc = new Scanner(System.in);
		start(init(sc.nextInt()));
	}
}