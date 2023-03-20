package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice {
	Scanner sc = new Scanner(System.in);
	public void practice1(){
//	사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
//	단, 입력한 수는 1보다 크거나 같아야 합니다.
//	만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
//
//	ex.
//	1이상의 숫자를 입력하세요 : 4	1이상의 숫자를 입력하세요 : 0
//	1 2 3 4					1 이상의 숫자를 입력해주세요.
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if(input>=1)
			for(int i=1;i<=input;i++)
				System.out.print(i+" ");
		else
			System.out.println("1 이상의 숫자를 입력해주세요.");
	}
	public void practice2() {
//		사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
//		단, 입력한 수는 1보다 크거나 같아야 합니다.
		
//		ex.
//		1이상의 숫자를 입력하세요 : 4		1이상의 숫자를 입력하세요 : 0
//		4 3 2 1						1 이상의 숫자를 입력해주세요.
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if(input>=1)
			for(int i=input;i>=1;i--)
				System.out.print(i+" ");
		else
			System.out.println("1 이상의 숫자를 입력해주세요.");
	}
	public void practice3() {
//		1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요.
//
//		ex.
//		정수를 하나 입력하세요 : 8
//		1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		int sum=0;
		for(int i = 1; i<input;i++) {
			System.out.print(i+" + ");
			sum+=i;
		}
		System.out.printf("%d = %d",input,sum+input);
		
	}
	public void practice4() {
//		사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
//		만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
//
//		ex.
//		첫 번째 숫자 : 8	첫 번째 숫자 : 4	첫 번째 숫자 : 9
//		두 번째 숫자 : 4	두 번째 숫자 : 8	두 번째 숫자 : 0
//		4 5 6 7 8		4 5 6 7 8		1 이상의 숫자를 입력해주세요.
		System.out.print("첫 번째 숫자 : ");
		int a = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int b = sc.nextInt();
		if(a<=0 || b<=0)
			System.out.println("1 이상의 숫자를 입력해주세요.");
		else
			pr4(Math.max(a, b),Math.min(a, b));
	}
	public void pr4(int a,int b) {
		for(;a>=b;b++)
			System.out.print(b+" ");
	}
	
	public void practice5() {
//		사용자로부터 입력 받은 숫자의 단을 출력하세요.
//
//		ex.
//		숫자 : 4
//		===== 4단 =====
//		4 * 1 = 4
//		4 * 2 = 8
//		4 * 3 = 12
//		4 * 4 = 16
//		4 * 5 = 20
//		4 * 6 = 24
//		4 * 7 = 28
//		4 * 8 = 32
//		4 * 9 = 36
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		System.out.printf("===== %d단 =====",dan);
		for(int i = 1;i<=9;i++)
			System.out.printf("\n%d * %d = %d",dan,i,dan*i);
	}
	public void practice6() {
//		사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
//		단, 2~9를 사이가 아닌 수를 입력하면 “2~9 사이 숫자만 입력해주세요”를 출력하세요.
//
//		숫자 : 4 			숫자 : 10
//		===== 4단 ===== 	2~9 사이 숫자만 입력해주세요.
//		===== 5단 =====
//		===== 6단 =====
//		===== 7단 =====
//		===== 8단 =====
//		===== 9단 =====
//		(해당 단의 내용들은 길이 상 생략)
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		if(dan<2||dan>9) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
			return;
		}
		for(;dan<=9;dan++) {
			System.out.printf("===== %d단 =====\n",dan);
			for(int i = 1; i<=9;i++) {
				System.out.printf("%d * %d = %d\n",dan,i,dan*i);
			}
		}
	}
	public void practice7() {
//		다음과 같은 실행 예제를 구현하세요.
//
//		ex.
//		정수 입력 : 4
//		*
//		**
//		***
//		****
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();
		for(int i = 0; i<a;i++) {
			for(int j = 0;i>=j;j++) 
				System.out.print("*");
			System.out.println();
		}
	}
	public void practice8() {
//		다음과 같은 실행 예제를 구현하세요.
//
//		ex.
//		정수 입력 : 4
//		****
//		***
//		**
//		*
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();
		for(int i = 0; i<a;i++) {
			for(int j = i;j<a;j++)
				System.out.print("*");
			System.out.println();
		}
	}
	public void practice9() {
//		다음과 같은 실행 예제를 구현하세요.
//
//		ex.
//		정수 입력 : 4
//		   *
//		  **
//		 ***
//		****
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();
		for (int i = 1; i <= a; i++) {
			for (int j = i; j < a; j++)
				System.out.print(" ");
			for (int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	public void practice10() {
//		다음과 같은 실행 예제를 구현하세요.
//
//		ex.
//		정수 입력 : 3
//		*
//		**
//		***
//		**
//		*
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();
		for(int i=0; i<(a*2-1); i++) {
			for(int j=i<a?0:i;j<=(i<a?i:a*2-2);j++)
				System.out.print("*");
			System.out.println();
		}
	}
	public void practice11() {
//		다음과 같은 실행 예제를 구현하세요.
//
//		ex.
//		정수 입력 : 4
//		    *
//		   ***
//		  *****
//		 *******
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();
		for(int i=0;i<a;i++) {
			for(int j=i;j<a;j++)
				System.out.print(" ");
			for(int j=0;j<=i*2;j++)
				System.out.print("*");
			System.out.println();
		}
	}
	public void practice12() {
//		다음과 같은 실행 예제를 구현하세요.
//
//		ex.
//		정수 입력 : 5
//		*****
//		*   *
//		*   *
//		*   *
//		*****
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();
		for(int i=1;i<=a;i++) {
			for(int j=1;j<=a;j++)
				System.out.print(i==1||i==a||j==1||j==a?"*":" ");
			System.out.println();
		}
	}
	public void practice13() {
//		1부터 사용자에게 입력 받은 수까지 중에서
//		1) 2와 3의 배수를 모두 출력하고
//		2) 2와 3의 공배수의 개수를 출력하세요.
//
//		* ‘공배수’는 둘 이상의 수의 공통인 배수라는 뜻으로 어떤 수를 해당 수들로 나눴을 때
//		모두 나머지가 0이 나오는 수
//
//		ex.
//		자연수 하나를 입력하세요 : 15
//		2 3 4 6 8 9 10 12 14 15
//		count : 2
		System.out.print("자연수 하나를 입력하세요 : ");
		int a = sc.nextInt();
		int cnt=0;
		for(int i=2;i<=a;i++) {
			System.out.print(i%2==0||i%3==0?i+" ":"");
			if(i%2==0&&i%3==0)
				cnt++;
		}
		System.out.println("\ncount : "+cnt);
	}
}