package edu.kh.array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayPractice {
	public void practice1() {
//		길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
//		순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//		짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		int[] arr = new int[9];
		int sum=0;
		for(int i=0;i<9;i++) {
			arr[i] = i+1;
			if(i%2==0)
				sum+=arr[i];
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n"+sum);

	}

	public void practice2() {
//		길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
//		순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//		홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		int[] arr = new int[9];
		int sum=0;
		for(int i=0, j=9;i<9;i++,j--) {
			arr[i] = j;
			if(i%2!=0)
				sum+=arr[i];
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n"+sum);
	}

	public void practice3() {
//		사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
//		1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
		
//		[실행 화면]
//		양의 정수 : 5
//		1 2 3 4 5
//
//		[실행 화면]
//		양의 정수 : 8
//		1 2 3 4 5 6 7 8
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=i+1;
			System.out.print(arr[i]+" ");
		}

	}

	public void practice4() {
//		정수 5개를 입력 받아 배열을 초기화 하고
//		검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
//		배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
//
//		[실행 화면 1]
//		입력 0 : 5
//		입력 1 : 8
//		입력 2 : 9
//		입력 3 : 10
//		입력 4 : 4
//		검색할 값 : 8
//		인덱스 : 1
//
//		[실행 화면 2]
//		입력 0 : 5
//		입력 1 : 8
//		입력 2 : 9
//		입력 3 : 10
//		입력 4 : 4
//		검색할 값 : 1
//		일치하는 값이 존재하지 않습니다.
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		for(int i=0;i<arr.length;i++) {
			System.out.print("입력 "+i+" : ");
			arr[i]=sc.nextInt();
		}
		System.out.print("검색할 값 : ");
		int search = sc.nextInt();
		int index = -1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==search) {
				index = i;
				break;
			}
		}
		if(index<0)
			System.out.println("일치하는 값이 존재하지 않습니다.");
		else
			System.out.printf("인덱스 : %d",index);
		
	}

	public void practice5() {
//		문자열을 입력 받아 문자 하나 하나를 char배열에 대입하고
//		검색할 문자가 문자열에 몇 개 들어가 있는지, 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.
//
//		[실행 화면]
//		문자열 : application
//		문자 : i
//		application에 i가 존재하는 위치(인덱스) : 4 8
//		i 개수 : 2
//
//		* 문자열.length() : 문자열의 길이
//		ex) String str = “abcd”;
//		System.out.println(str.length()); // 4 출력
//
//		* 문자열.charAt(인덱스번호) :
//		문자열에서 해당 인덱스 번째 문자 하나를 얻어옴(char 자료형)
//		ex) String str = “abcd”;
//		char ch = str.charAt(3); // ‘d’
//		System.out.println(ch); // ‘d’ 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.next();
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		char[] arr = str.toCharArray();
		String index="";
		int count = 0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==ch) {
				index+=i+" ";
				count++;
			}
		}
		System.out.printf("%s에 %c가 존재하는 위치 (인덱스) : %s\n%c 개수 : %d",str,ch,index,ch,count);
	}

	public void practice6() {
//	사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
//	배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
//	그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
//
//	[실행 화면]
//	정수 : 5
//	배열 0번째 인덱스에 넣을 값 : 4
//	배열 1번째 인덱스에 넣을 값 : -4
//	배열 2번째 인덱스에 넣을 값 : 3
//	배열 3번째 인덱스에 넣을 값 : -3
//	배열 4번째 인덱스에 넣을 값 : 2
//	4 -4 3 -3 2
//	총 합 : 2
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		for(int i = 0; i<arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ",i);
			arr[i] = sc.nextInt();
		}
		int sum=0;
		for(int i =0 ; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
			sum+=arr[i];
		}
		System.out.println("\n총 합 : "+sum);
	}

	public void practice7() {
//		주민등록번호를 입력 받아 char 배열에 저장한 후 출력하세요.
//		단, char 배열 저장 시 성별을 나타내는 숫자 이후부터 *로 저장하세요.
//
//		[실행 화면]
//		주민등록번호(-포함) : 123456-1234567
//		123456-1******
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호(-포함) : ");
		String str = sc.next();
		char[] arr = new char[str.length()];
		
		for(int i = 0; i<arr.length;i++) {

			if(i>=8)
				arr[i]='*';
			else
				arr[i] = str.charAt(i);
			System.out.print(arr[i]);
		}
	}

	public void practice8() {
//		3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
//		중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
//		단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
//		다시 정수를 받도록 하세요.
//
//		[실행 화면]
//		정수 : 4
//		다시 입력하세요.
//		정수 : -6
//		다시 입력하세요.
//		정수 : 5
//		1, 2, 3, 2, 1
		Scanner sc = new Scanner(System.in);
		int input;
		while(true) {
			System.out.print("정수 : ");
			input = sc.nextInt();
			if(input >=3&&input%2==1)
				break;
			System.out.println("다시 입력하세요.");
		}
		int[] arr=new int[input];
		for(int i = 0,j=arr.length; i<arr.length;i++,j--) {
			if(i>arr.length/2) {
				arr[i] = j;
			}
			else arr[i]=i+1;
		}
		System.out.println(Arrays.toString(arr).replaceAll("[\\[-\\]]", ""));
		
		

	}

	public void practice9() {
//		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
//		1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
//
//		[실행 화면]
//		발생한 난수 : 9 7 6 2 5 10 7 2 9 6
		int[] arr = new int[10];
		System.out.print("발생한 난수 : ");
		for(int i =0; i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10+1);
			System.out.print(arr[i]+" ");
		}
	}

	public void practice10() {
//		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
//		1~10 사이의 난수를 발생시켜 배열에 초기화 후
//		배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.
//
//		[실행 화면]
//		발생한 난수 : 5 3 2 7 4 8 6 10 9 10
//		최대값 : 10
//		최소값 : 2
		int[] arr = new int[10];
		int max = 0;
		int min = 10;
		System.out.print("발생한 난수 : ");
		for(int i =0; i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10+1);
			System.out.print(arr[i]+" ");
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		System.out.printf("\n최대값 : %d\n최소값 : %d",max,min);
	}

	public void practice11() {
//		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
//		1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.
//
//		[실행 화면]
//		4 1 3 6 9 5 8 10 7 2
		
		int[] arr = new int[10];
		System.out.print("발생한 난수 : ");
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10+1);
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j])
					i--;
			}
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}

	public void practice12() {
//		로또 번호 자동 생성기 프로그램을 만들기.
//		(중복 값 없이 오름차순으로 정렬하여 출력하세요.)
//
//		[실행 화면]
//		3 4 15 17 28 40
		int[] arr = new int[6];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*46+1);
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j])
					i--;
			}
		}
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public void practice13() {
//		문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
//		문자의 개수와 함께 출력하세요. (중복 제거)
//
//		[실행 화면]
//		문자열 : application
//		문자열에 있는 문자 : a, p, l, i, c, t, o, n
//		문자 개수 : 8
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String input = sc.next();
		char[] arr = input.toCharArray();
		String ans = "";
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(ans.indexOf(arr[i])==-1) {
				//문자열 ans에 arr[i]와 중복 문자가 없으면 ans에 추가하고 카운트 증감
				ans+=arr[i]+", ";
				count++;
			}
		}
		System.out.println("문자열에 있는 문자 : "+ans.substring(0, ans.length()-2));
		// String.substring(0, ans.length()-2) = 문자열 앞의 0글자, 뒤의 2글자를 지운 값을 String으로 반환
		System.out.println("문자 개수 : "+count);
	}

	public void practice14() {
//		사용자가 입력한 배열의 길이만큼의 String 배열을 선언 및 할당하고
//		배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화 하세요.
//		단, 사용자에게 배열에 값을 더 넣을지 물어보고 몇 개를 더 입력할 건지,
//		늘린 곳에 어떤 데이터를 넣을 것인지 받으세요.
//		사용자가 더 이상 입력하지 않겠다고 하면 배열 전체 값을 출력하세요.
//		(배열의 얕은 복사, 깊은 복사를 이용하는 문제)
//
//		얕은 복사 : 배열의 시작 주소만을 복사하여 두 참조 변수가 하나의 배열을 참조.
//		깊은 복사 : 원본 배열이 가지고 있는 데이터를 그대로 복사한 새로운 배열 (복제)
//
//		→ tip : 깊은 복사를 위한 새로운 배열은 꼭 원본 배열과 같은 크기일 필요는 없다!
//		[실행 화면]
//				배열의 크기를 입력하세요 : 3
//				1번째 문자열 : 자바의 정석
//				2번째 문자열 : 알고리즘
//				3번째 문자열 : C프로그래밍
//				더 값을 입력하시겠습니까?(Y/N) : y
//				더 입력하고 싶은 개수 : 2
//				4번째 문자열 : 인간관계
//				5번째 문자열 : 자기계발
//				더 값을 입력하시겠습니까?(Y/N) : y
//				더 입력하고 싶은 개수 : 1
//				6번째 문자열 : 영단어600
//				더 값을 입력하시겠습니까?(Y/N) : n
//				[자바의 정석, 알고리즘, C프로그래밍, 인간관계, 자기계발, 영단어600]
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		String[] arr = new String[size];

		for(int i=0;i<arr.length;i++) {
			System.out.printf("%d번째 문자열 : ",i+1);
			arr[i] = sc.next();
		}
		
		while(true) {
			System.out.print("더 값을 입력하시겠습니까?(Y/N): ");
			String sel = sc.next();
			if (sel.equals("y")||sel.equals("Y")) {
				System.out.print("더 입력하고 싶은 개수 : ");
				int input = sc.nextInt();
				size += input;
				String[] copy = new String[size];
				for (int i = 0; i < copy.length; i++) {
					if (arr.length > i)
						copy[i] = arr[i];
					else {
						System.out.printf("%d번째 문자열 : ", i + 1);
						copy[i] = sc.next();
					}
				}
				arr=copy;
			} else if(sel.equals("n")||sel.equals("N")){
				break;
			} else {
				System.err.println("Y/N으로 대답해라");
				return;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public void practice15() {
//		3행 3열짜리 문자열 배열을 선언 및 할당하고
//		인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 “(0, 0)”과 같은 형식으로 저장 후 출력하세요.
//
//		[실행 화면]
//		(0, 0)(0, 1)(0, 2)
//		(1, 0)(1, 1)(1, 2)
//		(2, 0)(2, 1)(2, 2)
		String[][] arr = new String[3][3];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]="("+i+","+j+")";
			}
			System.out.println(Arrays.toString(arr[i]).replaceAll("[\\[-\\]]", ""));
		}
	}

	public void practice16() {
//		4행 4열짜리 정수형 배열을 선언 및 할당하고
//		1) 1 ~ 16까지 값을 차례대로 저장하세요.
//		2) 저장된 값들을 차례대로 출력하세요.
//
//		[실행 화면]
//		1 2 3 4
//		5 6 7 8
//		9 10 11 12
//		13 14 15 16
		int[][] arr = new int[4][4];
		int val = 1;
		for(int i=0;i<arr.length;i++) 
			for(int j=0;j<arr[i].length;j++) 
				arr[i][j] = val++;
		for(int i=0;i<arr.length;i++) { 
			for(int j=0;j<arr[i].length;j++) 
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}

	public void practice17() {
//		4행 4열짜리 정수형 배열을 선언 및 할당하고
//		1) 16 ~ 1과 같이 값을 거꾸로 저장하세요.
//		2) 저장된 값들을 차례대로 출력하세요.
//
//		[실행 화면]
//		16 15 14 13
//		12 11 10 9
//		8 7 6 5
//		4 3 2 1
		int[][] arr = new int[4][4];
		int val = arr.length*arr[0].length;
		for(int i=0;i<arr.length;i++) 
			for(int j=0;j<arr[i].length;j++) 
				arr[i][j] = val--;
		for(int i=0;i<arr.length;i++) { 
			for(int j=0;j<arr[i].length;j++) 
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}

	public void practice18() {
//		4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
//		아래의 내용처럼 처리하세요.
//			0열			1열			2열			3열
//		0행	값			값			값			0행 값들의 합
//		1행	값			값			값			1행 값들의 합
//		2행	값			값			값			2행 값들의 합
//		3행	0열 값들의 합	1열 값들의 합	2열 값들의 합	총합
//
//		[실행 화면]
//		9 3 7 19
//		3 6 9 18
//		6 10 10 26
//		18 19 26 63
		int[][] arr=new int[4][4];
		for(int i=0;i<arr.length-1;i++)
			for(int j=0;j<arr[i].length-1;j++) 
				arr[i][j]=(int)(Math.random()*10+1);
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1;j++) {
				arr[i][arr.length-1] += arr[i][j];
			}
		}
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1;j++) {
				arr[arr.length-1][i] += arr[j][i];
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	public void practice19() {
//		2차원 배열의 행과 열의 크기를 사용자에게 직접 입력받되, 1~10사이 숫자가 아니면
//		“반드시 1~10 사이의 정수를 입력해야 합니다.” 출력 후 다시 정수를 받게 하세요.
//		크기가 정해진 이차원 배열 안에는 영어 대문자가 랜덤으로 들어가게 한 뒤 출력하세요.
//		(char형은 숫자를 더해서 문자를 표현할 수 있고 65는 A를 나타냄, 알파벳은 총 26글자)
//
//		[실행 화면]
//		행 크기 : 5
//		열 크기 : 4
//		T P M B
//		U I H S
//		Q M B H
//		H B I X
//		G F X I

	}

	public void practice20() {
//		사용자에게 행의 크기를 입력 받고 그 수만큼의 반복을 통해 열의 크기도 받아
//		문자형 가변 배열을 선언 및 할당하세요.
//		그리고 각 인덱스에 ‘a’부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.
//
//		[실행 화면]
//		행의 크기 : 4
//		0열의 크기 : 2
//		1열의 크기 : 6
//		2열의 크기 : 3
//		3열의 크기 : 5
//		a b
//		c d e f g h
//		i j k
//		l m n o p
	}

	public void practice21() {
//		1차원 문자열 배열에 학생 이름 초기화되어 있다.
//		3행 2열 짜리 2차원 문자열 배열 2개를 새로 선언 및 할당하여
//		학생 이름을 2차원 배열에 순서대로 저장하고 아래와 같이 출력하시오.
//		(첫 번째 2차원 배열이 모두 저장된 경우 두 번째 2차원 배열에 저장 진행)
//		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
//		"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
//		[실행 화면]
//		== 1분단 ==
//		강건강 남나나
//		도대담 류라라
//		문미미 박보배
//		== 2분단 ==
//		송성실 윤예의
//		진재주 차천축
//		피풍표 홍하하
	}

	public void practice22() {
//		위 문제에서 자리 배치한 것을 가지고 학생 이름을 검색하여
//		해당 학생이 어느 자리에 앉았는지 출력하세요.
//
//		[실행 화면]
//		== 1분단 ==
//		강건강 남나나
//		도대담 류라라
//		문미미 박보배
//		== 2분단 ==
//		송성실 윤예의
//		진재주 차천축
//		피풍표 홍하하
//		============================
//		검색할 학생 이름을 입력하세요 : 차천축
//		검색하신 차천축 학생은 2분단 2번째 줄 오른쪽에 있습니다.
	}

	public void practice23() {
//		String 2차원 배열 6행 6열을 만들고 행의 맨 위와 제일 앞 열은 각 인덱스를 저장하세요.
//		그리고 사용자에게 행과 열을 입력 받아 해당 좌표의 값을 “X”로 변환해 2차원 배열을 출력하세요.
//
//		[실행 화면]
//		행 인덱스 입력 : 4
//		열 인덱스 입력 : 2
//		  0 1 2 3 4
//		0
//		1
//		2
//		3
//		4 X
	}

	public void practice24() {
//		실습문제9와 내용은 같으나 행 입력 시 99가 입력되지 않으면 무한 반복이 되도록 구현하세요.
//
//		[실행 화면]
//		행 인덱스 입력 : 2		행 인덱스 입력 : 3
//		열 인덱스 입력 : 2		열 인덱스 입력 : 1
//		  0 1 2 3 4			  0 1 2 3 4
//		0 					0
//		1					1
//		2 X					2 X
//		3					3 X
//		4					4
//
//							행 인덱스 입력 >> 99
//							프로그램 종료

	}
	
	public void bingoGame() {
		
	}
}
