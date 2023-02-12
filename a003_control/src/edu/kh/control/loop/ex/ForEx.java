package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForEx {
	/*	for문
	 * 	- 끝이 정해져 있는 경우에 사용하는 반복문
	 * 	 (== 반복 횟수가 지정되어 있는 경우 사용)
	 * 
	 *  - 작성법
	 * 
	 * 	for(초기식[1] ; 조건식[2][5][8] ; 증감식[4][7]){
	 * 		조건식이 true일 때 반복 수행할 코드[3][6]
	 * 	}
	 * 
	 *	// 1 ~ 4번 수행 후 조건식이 false가 나올 때까지 5~7 반복
	 * 
	 * 	- 초기식 : for문을 제어하는 용도의 변수를 선언 및 초기화
	 * 
	 * 	- 조건식 : for문의 반복 여부를 지정하는 식
	 * 			 조건식이 true인 경우에만 반복 수행을 함.
	 * 			 보통 초기식에 사용된 변수를 이용해서
	 * 			 조건식을 작성함.
	 * 
	 *  - 증감식 : for문이 한 번 반복을 수행할 때 마다
	 *  		 마지막에 특정 값을 증가 또는 감소 시키는 식
	 * 			 보통 초기식에 사용된 변수를 증가/감소 시켜
	 * 			 조건식의 결과를 변화하게 만드는 용도
	 */
	
	
	// for문 기초 사용법 1
	public void ex1() {
		// 1~10까지 반복 출력
		for(int i=1; i<=10;i++)
			System.out.println(i);
	}
	
	// for문 기초 사용법 2
	public void ex2() {
		// 5부터 12까지 1씩 증가하며 출력
		for(int i = 5 ; i <=12 ; i++)
			System.out.print(i+" ");
	}
	
	// for문 기초 사용법 3
	public void ex3() {
		// 3 부터 20까지 2씩 증가하며 출력
		for(int i = 3; i <=20 ; i+=2)
			System.out.print(i+" ");
	}
	
	// for문 기초 사용법 4
	public void ex4() {
		// 1부터 100까지의 모든 정수의 합
		int sum = 0;
		for(int i = 1; i<=100 ; i++)
			sum +=i;
		System.out.println("합계 : " + sum);
	}
	
	// for문 기초 사용법 5
	public void ex5() {
		// 두 정수를 입력 받아
		// 두 정수 사이의 모든 정수의 합 출력하기
		// (단, 첫 번째 입력 받는 정수가 무조건 작다고 가정)
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1 입력 : ");
		int a = sc.nextInt();
		System.out.print("정수 2 입력 : ");
		int b = sc.nextInt();
		int sum=0;
		
		for (int i = a; i <= b; i++)
			sum += i;
		System.out.printf("%d부터 %d까지 모든 정수의 합 : %d", a, b, sum);
	}
	
	// for문 기초 사용법 6
	public void ex6() {
		// 다른 자료형으로 for문 사용하기
		
		// 10부터 20까지 0.5씩 증가하며 출력

		for (double i = 10; i <= 20; i+=0.5)
			//초기식을 int형으로 지정하게 되는 경우 무한루프에 빠지게 된다.
			//왜? i+= 0.5 수행 시 10.5가 아닌
			//	 10으로 (int형으로) 형변환되어 i에 대입되기 때문에
			//	 i가 계속 10을 유지한다.
			//해결방법 : 초기식을 double 자료형으로 변경
			System.out.println(i);
		
		System.out.println("---------------------------------");
		
		// A-Z까지 모든 알파벳 출력하기
		// 1) A(65), Z(90)의 유니코드 번호를 이용하기
		
		for(int i=65;i<=90;i++)
			System.out.print((char)i);
		System.out.println();
		// 2) 유니코드 번호를 모를 때
		
		for(int i='A';i<='Z';i++)
			System.out.print((char)i);
		System.out.println();
		// 3) char 자료형은 문자형이지만 실제로는 정수를 저장한다!
		for(char i='A';i<='Z'; i++)
			System.out.print(i);
		
		
		
	}
	
	//for문 응용 사용법 1
	public void ex7() {
		// 감소하기
		
		// 10부터 1까지 1씩 감소하며 출력
		
		for(int i = 10; i>=1; i--)
			System.out.print(i+" ");
	}
	
	//for문 응용 사용법2
	public void ex8() {
		// 입력, 합계(sum), for
		
		// 정수 5개를 입력 받아 합계 출력하기
		Scanner sc = new Scanner(System.in);
		int sum=0;
		for(int i = 1; i<=5; i++) {
			System.out.printf("정수 입력 %d : ",i);
			sum+=sc.nextInt();
		}
		System.out.println(sum);
	}
	
	//for문 응용 사용법3
	public void ex9() {
		// ex8번 응용
		
		// 정수를 몇 번 입력 받을 지 먼저 입력하고
		// 입력된 정수의 합계를 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 받을 정수의 개수 : ");
		int input = sc.nextInt();
		int sum=0;
		for(int i = 1; i<=input; i++) {
			System.out.printf("정수 입력 %d : ",i);
			sum+=sc.nextInt();
		}
		System.out.println("합계 : "+sum);
	}
	
	//for문 응용 사용법 4
	public void ex10() {
		// for + if 동시 사용
		
		// 1부터 10까지 반복하며 출력
		// 단, 짝수일 경우 ()로 숫자를 감싸서 출력
		
		for(int i = 1; i<=10; i++)
			if(i%2==0) System.out.printf("(%d) ",i);
			else System.out.print(i+" ");
	}
	
	// for문 응용 사용법 5
	public void ex11() {
		// 1부터 10까지 1씩 증가하며 출력
		// 단, 3의 배수인 경우 숫자를 []감싸서 출력
		// 5의 배수인 경우 숫자 대신 @ 출력
		for(int i = 1; i<=10; i++) 
			if(i%3==0) System.out.printf("[%d] ",i);
			else if(i%5==0) System.out.print("@ ");
			else System.out.print(i+" ");	
	}
	
	// for문 응용 사용법 6
	public void ex12() {
		// for, if, printf
		int dan = 2;
		for(int i = 1; i<=9; i++) {
			System.out.printf("%d x %d = %d\n",dan,i,dan*i);
		}
	}
	
	// for문 응용 사용법 7
		public void ex13() {
			// 원하는 단을 입력 받아서 역순으로 출력
			Scanner sc = new Scanner(System.in);
			System.out.print("단 입력 : ");
			int dan = sc.nextInt();
			for (int i = 9; i >= 1; i--) {
				System.out.printf("%d x %d = %2d\n", dan, i, dan * i);
			}
		}

		// for문 응용 사용법 8
		public void ex14() {
			// 입력 받은 단 출력하기
			// 단, 입력받은 단이 2~9사이가 아니라면
			// "잘못 입력 하셨습니다." 출력
			Scanner sc = new Scanner(System.in);
			System.out.print("단 입력 : ");
			int dan = sc.nextInt();
			if(dan >=2 && dan<=9) {
				for(int i = 1; i<=9;i++) {
					System.out.printf("%d x %d = %2d\n", dan, i, dan * i);
				}
			} else System.out.println("잘못 입력 하셨습니다.");
		}

		// 중첩 반복문 기본 사용법 1
		public void ex15() {
			
			for(int i = 1; i<=4; i++) {
				for(int j = 1; j<=5; j++) {
					System.out.print(j);
				}
				System.out.println();
			}
		}

		// 중첩 반복문 기본 사용법 2
		public void ex16() {
			
			for (int i = 1; i <= 5; i++) {
				for (int j = 1; j <= 5; j++) {
					System.out.printf("%3d",j*i);
				}
				System.out.println();
			}
		}
		
		// 중첩 반복문 응용 사용법1
		public void ex17() {
			for(int i = 2; i<=9; i++) {
				System.out.printf("[%d단] ",i);
				for (int j = 1; j<=9; j++)
					System.out.printf("%dx%d=%d ",i,j,i*j);
				System.out.println();
			}
		}
		
		// 중첩 반복문 응용 사용법2
//		public void ex18() {
//			for(int i = 0; i<=9 ; i++) {
//				for(int j = 2;j<=9;j++) {
//					if(i>0)
//					System.out.printf("%dx%d=%2d\t",j,i,j*i);
//					else
//						System.out.printf("[ %d%s ]\t",j,"단");
//				}
//				System.out.println();
//			}
//		}
		
		// 중첩 반복문 응용 사용법2
		public void ex18() {
			for(int i=1;i<=4;i++) {
				for(int j=1;j<=i;j++) {
					System.out.print(j);
				}
				System.out.println();
			}
		}
		
		// 중첩 반복문 응용 사용법3
		public void ex19() {
			for(int i = 4;i>=1;i--) {
				for(int j=4 ;j>=i;j--) {
					System.out.print(j);
				}
				System.out.println();
			}
		}
		
		public void ex20() {
			Scanner sc = new Scanner(System.in);
			System.out.print("입력된 정수 : ");
			int input = sc.nextInt();
			
			for(int i = input;i>=1;i--) {
				for(int j = i;j>=1;j--) {
					System.out.print(j);
				}
				System.out.println();
			}
		}
		
		// 카운트(개수 세기)
		public void ex21() {
			int ct = 0;
			int sum = 0;
			for (int i = 1; i <= 20; i++) {
				if (i % 3 == 0) {
					ct++;
					sum += i;
					System.out.println(i);
				}
			}
			System.out.printf("sum : %d\nctr : %d",sum,ct);

		}
		
		public void ex22() {
			// 1  2  3  4
			// 5  6  7  8
			// 9 10 11 12
			for (int row = 1, n = 1; row <= 3; row++) {
				for (int col = 1; col <= 4; col++)
					System.out.printf("%3d", n++);
				System.out.println();
			}

		}
}