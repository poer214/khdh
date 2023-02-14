package edu.kh.array.ex;

public class ArrayEx2 {
	
	// 2차원 배열 사용법 1
	public void ex1() {
		
		// 2차원 배열 선언 및 할당 
		int[][] arr = new int[2][3]; // 2행 3열
		
		System.out.println("행의 길이 : " + arr.length);
		
		System.out.println("열의 길이 : " + arr[0].length);
		
		// 2차원 배열 초기화
		// 1) 인덱스를 이용한 초기화
		arr[0][0] = 7;
		arr[0][1] = 14;
		arr[0][2] = 21;
		arr[1][0] = 28;
		arr[1][1] = 35;
		arr[1][2] = 42;
		
		System.out.println();
		
		// 2) 2중 for문을 이용한 초기화 방법
		
		int number = 0;
		
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0 ; col < arr[0].length; col++) {
				
				arr[row][col] = number * 5;
				number++;
			}
		}
		System.out.println();
		
		// 3) 선언 및 초기화
		
		int[][] arr2 = {{1,2,3,4,5},{60,70,80,90,100},{11,22,33,44,55}};
		
		System.out.println(arr2[1][3]);
		
		// 0행 : 1 2 3 4 5
		// 1행 : 60 70 80 90 100
		// 2행 : 11 22 33 44 55
		
		for(int i = 0; i<arr2.length; i++) {
			System.out.print(i+"행 :");
			
			// 한 행에 있는 모든 열의 값 출력
			for(int j = 0 ; j<arr2[i].length; j++) {
				System.out.print(" "+arr2[i][j]);
			}
			System.out.println(); // 개행
		}
		
	}
	
	// 2차원 배열 응용 1
	public void ex2() {
		// 3행 3열짜리 int 2차원 배열에 난수(0~9)를 대입
		// 각 행의 합과 전체 합을 출력
		
		int[][] arr = new int[3][3];
		int[] arrSum = new int[3];
		int sum = 0;
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0; j<arr[i].length; j++) {
				arr[i][j] = (int)(Math.random()*10.0);
				System.out.printf("%3d", arr[i][j]);
				arrSum[i] += arr[i][j];
				}
			sum += arrSum[i];
			System.out.printf("\n%d행의 합 : %d\n",i,arrSum[i]);
			
		}
		System.out.print("전체 합 : "+sum);
		System.out.println();
		
		
		for(int row = 0; row<arr.length; row++) {
			int rowSum = 0;
			for(int col=0;col<arr[row].length;col++) {
				rowSum += arr[row][col];
			}
			System.out.printf("%d행의 합 : %d\n",row,rowSum);
		}
		System.out.print("전체 합 : "+sum);
		System.out.println();
	}

	// 가변배열
	public void ex3() {
		
		// 가변 배열
		// - 2차원 배열 할당 시
		// 마지막 차수(열)의 크기를 지정하지 않고
		// 추후에 각행에 새로운 1차원 배열의 주소를 대입하는 배열
		char[][] arr = new char[4][];
		 
		
		arr[0] = new char[3];
		arr[1] = new char[4];
		arr[2] = new char[5];
		arr[3] = new char[2];
		char ch = 'a';
		
		
		for(int i =0; i<arr.length;i++) {
			for(int j = 0 ;j<arr[i].length;j++) {
				 arr[i][j] = ch++;
				 System.out.print(arr[i][j]);
			}
		}
		
	}

	public void ex4() {

	}
}
