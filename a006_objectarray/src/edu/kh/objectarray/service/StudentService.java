package edu.kh.objectarray.service;

import java.util.Random;

import edu.kh.objectarray.dto.Student;

// 기능 제공용 클래스(비즈니스 로직 처리)
public class StudentService {
	// Student 객체 참조 변수 5개짜리 배열을 생성해서 studentArr 참조
	private Student[] studentArr = new Student[5];
	
	// StudentService 기본 생성자
//	public StudentService() {
//		// studentArr 배열의 각 요소는 Student 참조 변수
//		studentArr[0] = new Student(3, 5, 17, "홍길동");
//		studentArr[1] = new Student(2, 3, 11, "김철수");
//		studentArr[2] = new Student(1, 7, 3, "최미영");
//	}
	public StudentService() {
		// studentArr 배열의 각 요소는 Student 참조 변수
		studentArr[0] = new Student(3, 5, 17, "홍길동",10,20,30);
		studentArr[1] = new Student(2, 3, 11, "김철수",10,10,10);
		studentArr[2] = new Student(1, 7, 3, "최미영",90,80,70);
		studentArr[3] = new Student(4, 5, 6, "가나다",50,60,75);
		
		// 학생 랜덤 점수 추가
	      Random random = new Random();
	      for(Student s : studentArr) {
	         
	         if(s == null) break;
	         
	         s.setKor(random.nextInt(101));
	         s.setEng(random.nextInt(101));
	         s.setMath(random.nextInt(101));
	      }
	}
	
	// param(parameter) : 매개변수
	
	/** 1. 학생 추가 서비스
	 * @param grade : int
	 * @param classRoom : int
	 * @param number : int
	 * @param name : String
	 * 
	 * @return result : boolean
	 * */
	
	public boolean addStudent(int grade, int classRoom, int number, String name) {
		// studentArr의 비어있는 인덱스를 찾아
		// 해당 인덱스에 매개변수를 이용해서 생성된 Student 객체 주소를 대입
		// -> true 반환
		for(int i=0; i<studentArr.length;i++) {
			// 배열 요소가 참조하는 주소가 없을 경우 == 비어있다고 판단
			if(studentArr[i] == null) {
				// 비어있는 배열 요소에
				// 매개변수를 이용해서 새 학생 객체를 만들어 주소 대입
				studentArr[i] = new Student(grade,classRoom,number,name);
				return true;
			}
		}
		// 만약 비어있는 인덱스가 없을 경우
		// -> false 반환
		return false;
	}
	
	/** 2. 학생 전체 조회 서비스
	 * @return studentArr : Student[]
	 */
	public Student[] selectAll() {
		// studentArr를 반환
		return studentArr;
	}
	
	/** 3. 학생 정보 조회(인덱스)
	 * @param index : int
	 * 
	 * @return studentArr[index] : Student 참조 변수
	 */
	public Student selectIndex(int index) {
		
		// index 값이 0~4 사이가 아니면
		// 배열 범위를 초과 했다는 ArrayIndexOutOfBoundsException 발생
		
		// 해결 방법 : 배열 범위가 넘어선 경우에 대한 별도 처리
		
//		if( !(index >=0 && index <=4))
		if(index < 0 || index >= studentArr.length)
			return null;
		return studentArr[index];
	}
	
	/** 4. 학생 정보 조회(이름)
	 * @param inputName : String
	 * 
	 * @return resultArr : Student[] (조회된 학생이 없을 경우 null)
	 */
	
	public Student[] selectName(String inputName) {
		// 이름이 일치하는 학생 모두를 저장할 객체 배열 선언 및 초기화
		Student[] resultArr = new Student[studentArr.length];
		int index=0;
		for(int i=0;i<studentArr.length;i++) 
			if(studentArr[i]==null)
				break;
			else if(studentArr[i].getName().equals(inputName))
				// resultArr에 studentArr[i]의 값(주소)를 대입 (얕은 복사)
				resultArr[index++]=studentArr[i];
				// -> studentArr[i] 값 대입 후 index 값 증가(후위 연산)
		if(index==0)
			return null;
		return resultArr;
	}
	
	/** 5. 학생 정보 수정(인덱스)
	 * @param index : int
	 * @param kor : int
	 * @param eng : int
	 * @param math : int
	 * 
	 * @return 수정 성공 시 true / 실패 시 false
	 * 
	 */
	
	public boolean updateStudent(int index, int kor, int eng, int math){
		
		// 예상 가능한 문제
		// 1) index 범위를 초과한 입력
		// 2) index 번째 요소가 null인 경우
		
		if(index<0 || studentArr.length<=index ||studentArr[index]==null)
			return false;
		
		//문제가 없을 경우 index번째 학생의 점수를 수정 후 true 반환
		studentArr[index].setKor(kor);
		studentArr[index].setEng(eng);
		studentArr[index].setMath(math);
		return true;
	}
	
	/** 6. 학생 총점 점수 합계, 평균, 최고점, 최저점
	 * @return arr : int[] (인덱스 순서대로 합계, 평균, 최고점, 최저점)
	 */
	
	public int[] sumAvgMaxMin() {
		int[] arr = new int[4];
		arr[2] = Integer.MIN_VALUE;
		arr[3] = Integer.MAX_VALUE;
		
		for(int i = 0; i<studentArr.length; i++) {
			if(studentArr[i]==null) {
				arr[1]=i;
				break;
			}
			arr[0] += studentArr[i].getKor()+studentArr[i].getEng()+studentArr[i].getMath();
			arr[2] = Math.max(arr[2], studentArr[i].getKor()+studentArr[i].getEng()+studentArr[i].getMath());
			arr[3] = Math.min(arr[3], studentArr[i].getKor()+studentArr[i].getEng()+studentArr[i].getMath());
		}
		
		return arr;
	}
}