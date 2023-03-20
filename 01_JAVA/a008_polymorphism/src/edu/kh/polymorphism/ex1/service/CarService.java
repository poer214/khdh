package edu.kh.polymorphism.ex1.service;

import java.util.Scanner;

import edu.kh.polymorphism.ex1.dto.Car;
import edu.kh.polymorphism.ex1.dto.LightCar;
import edu.kh.polymorphism.ex1.dto.Truck;

public class CarService {

	// 다형성 : 객체가 다양한 형태로 지님
	// - 상속을 이용한 기술로
	//   부모 타입의 참조 변수 하나로
	//   여러 타입의 자식 객체를 참조할 수 있다.
	
	
	public void ex() {
		
		//부모 참조 변수 = 부모 객체
		Car c1 = new Car();
		
		/* 업캐스팅 */
		// 부모 참조 변수 = 자식 객체
		Car c2 = new Truck();
		
		Car c3 = new LightCar();
		
		//Truck 객체가 Car로 부터 상속 받은 메서드 사용
		c2.setWheel(10);
		c2.setSeat(3);
		c2.setFuel("경유");
		// c2의 자료형이 Car
		// -> Truck 객체를 참조하더라도 Car 부분만 볼 수 있음!
		
		// c2.setWeight(2.5); // c2로 접근 불가능하여 에러
		
		//
		
	}
	
	public void ex2() {
		/* 업캐스팅 : 자식 객체 -> 부모 객체로 변함 -***/
		
		// 부모 참조 변수 (
		Car c1 = new LightCar();
		((LightCar)c1).print();
		((LightCar)c1).setDiscountOffer(0.7);
		System.out.println(((LightCar)c1).getDiscountOffer());
		
		LightCar light1 = (LightCar)c1;
		light1.print();
	}
	public void ex3() {
		// 다형성(업캐스팅, 다운캐스팅) + 객체 배열
		Car[] carList = new Car[3];
		
		// carList[i] == Car 참조변수
		carList[0] = new Truck(6,4,"경유",1);
		carList[1] = new LightCar(4,4,"휘발유",0.3);
		carList[2] = new Car(4,2,"전기");
		
		for(Car c : carList) {
			System.out.println("바퀴 수 : "+ c.getWheel());
			System.out.println("좌석 수 : " + c.getSeat());
			System.out.println("연료 형식 : " + c.getFuel());
			// Truck일 경우 -> 최대 적재 하중 : 2.5t
			// LightCar 일 경우 -> 할인율 : 30%
			// Car일 경우 -> 차종이 등록되어있지 않습니다. 
			if( c instanceof Truck) {
				//c가 참조하는 객체가 Truck인 경우
				System.out.println("최대 적재 하중 : "+((Truck)c).getWeight());
			}
			else if(c instanceof LightCar) {
				System.out.println("할인율 : "+((LightCar)c).getDiscountOffer()*100+"%");
			} else {
				System.out.println("차종이 등록되어 있지 않습니다.");
			}
			
			// 만약 다운 캐스팅이 잘못될 경우
			// ClassCastException이 발생한다!
			// ex) LightCar 객체를 Truck 참조 변수가 참조하려고 할 때
		}
		System.out.println("---------------------------------------");
				
		
	}
	
	public void ex4() {
		
		// 객체배열 + 다형성(업캐스팅)
		// + 매개변수 다향성 +
		// 다형성(업캐스팅, 다운캐스팅) + 객체 배열
				Car[] carList = new Car[3];
				
				// carList[i] == Car 참조변수
				carList[0] = new Truck(6,4,"경유",1);
				carList[1] = new LightCar(4,4,"휘발유",0.3);
				carList[2] = new Car(4,2,"전기");
	}
	
	public void printCar(Car c) {
		String type = null;
		if(c instanceof Truck) type="[truck]";
		else if(c instanceof LightCar) type="[LightCar]";
		else type="[Car]";
		
		System.out.println("[Car]에 대한 정보입니다.");
		System.out.println(c.toString());
		
		// 동적 바인딩
		// - "프로그램 실행 중"
		// 실행할 당시의 객체의 자료형을 기준으로
		// 메서드를 호출부와 수행될 메서드를 묶는 것
		
		// - 참조하는 객체의 자료형을 기준으로 연결
		
		// 출력화면 예상
		/**[Truck]에 대한 정보입니다.
		/**[LightCar]에 대한 정보입니다.
		/**[Car]에 대한 정보입니다.*/
		System.out.println(type + "에 대한 정보입니다.");
		System.out.println(c.toString());
	}
	
	public void ex5() {
		//반환형의 다형성
		
		Scanner sc = new Scanner(System.in);
		System.out.println("생성할 자동차 종류를 선택하세요");
		System.out.println("1. 트럭");
		System.out.println("2. 경차");
		System.out.println("3. 자동차");
		
		Car c = createCar(sc.nextInt());
		System.out.println("차가 생성되었습니다.");
	}
	//
	public Car createCar(int num) {
		switch(num) {
		case 1: return new Truck();
		case 2: return new LightCar();
		case 3: return new Car();
				
		}
		return null;
	}
}
	