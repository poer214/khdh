package edu.kh.jdbc.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Department;
import edu.kh.jdbc.model.dto.Emp;
import edu.kh.jdbc.model.service.EmpService;

public class EmpView {
  
	private Scanner sc = new Scanner(System.in);
	private EmpService service = new EmpService();
	
	//** 모든 기능에는 예외상황에 따른 출력 구문 필수 작성 **
	//** 필요에 따라 DTO에 생성자 추가 **
	//** 메서드명, 출력 화면은 자유롭게 작성 **
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			
			try {
				System.out.println("\n*****************************\n");
				System.out.println("***** 사원 관리 프로그램*****");
				System.out.println("1. 재직중인 사원 전체 조회"); 
				// 현재 재직중인 사원의
				// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
				// 직급코드 오름차순으로 조회
				// selectEntN();
				
				
				System.out.println("2. 퇴직한 사원 전체 조회"); 
				// 현재 퇴직한 사원의
				// 사번, 이름, 전화번호, 이메일, 퇴사일을
				// 퇴사일 오름차순으로 조회
				// selectEntY();
				
				System.out.println("3. 사번이 일치하는 사원 조회"); 
				// 사번을 입력 받아 일치하는 사원의  
				// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
				// 단, 사번이 일치하는 사원이 없으면
				// "사번이 일치하는 사원이 없습니다" 출력
				// selectEmpId();
				
				System.out.println("4. 사원 정보 추가(INSERT)");
				// 사번(EMP_ID) -> SEQ_EMP_ID SEQUENCE 사용
				// insertEmp();
				
				System.out.println("5. 사번으로 사원 정보 수정(UPDATE)");
				// 이메일, 전화번호, 급여, 보너스 수정
				// 단, 사번이 일치하는 사원이 없으면
				// "사번이 일치하는 사원이 없습니다" 출력
				// updateEmpId();
				
				System.out.println("6. 사번으로 사원 정보 삭제(DELETE)");
				// 사번을 입력 받아 일치하는 사원 삭제
				// - 사번을 입력 받은 후 정말 삭제할 것인지 Y/N을 입력 받아 
				//   Y인 경우에만 삭제, N인 경우 취소
				// - 사번이 일치하는 사원이 없으면
				//   "사번이 일치하는 사원이 없습니다" 출력
				// deleteEmpId();
				
				
				System.out.println("7. 사번이 일치하는 사원 퇴직 처리");
				// - ENT_YN -> 'Y' , ENT_DATE -> SYSDATE로 수정
				
				// - 사번을 입력 받은 후 정말 퇴직 처리할 것인지 Y/N을 입력 받아 
				//   Y인 경우에만 퇴직 처리, N인 경우 취소
				
				// - 사번이 일치하지 않거나 이미 퇴직 처리된 사원이면
				//   "사번이 일치하는 않거나, 이미 퇴직된 사원입니다." 출력
				// retireEmpId();
				
				System.out.println("8. 가장 최근 입사한 사원 5명 조회");
				// 가장 최근(입사일이 늦은) 사원 5명의
				// 사번, 이름, 부서명, 입사일을
				// 입사일 내림차순으로 조회
				// selectFiveMostRecentlyHiredEmployees();
				
				
				System.out.println("9. 부서별 통계 조회"); 
				// 각 부서별
				// 부서명, 인원 수, 급여 평균
				// 부서코드 오름차순 조회
				
				// HINT.
				// - 별도의 DTO 작성 또는 
				//   Map(LinkedHashMap : key 순서가 유지되는 Map) 이용
				// selectStatisticsByDepartment();
				
				System.out.println("0. 프로그램 종료");
				
				
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				
				
				switch(input) {
				case 1:  selectEntN();break;
				case 2:  selectEntY();break;
				case 3:  selectEmpId();break;
				case 4:  insertEmp();break;
				case 5:  updateEmpId();break;
				case 6:  deleteEmpId();break;
				case 7:  retireEmpId();break;
				case 8:  selectFiveMostRecentlyHiredEmployees();break;
				case 9:  selectStatisticsByDepartment();break;
				case 0: System.out.println("\n[프로그램을 종료합니다...]\n"); break;
				
				default: System.out.println("\n[메뉴에 존재하는 번호를 입력하세요.]\n");
				}
				
				
			}catch (InputMismatchException e) {
				System.out.println("\n[잘못된 입력입니다.]\n");
				sc.nextLine(); // 입력 버퍼에 남아있는 문자열 제거
				input = -1; // while문이 종료되지 않게하기 위한 값 대입
			}
			
		}while(input != 0);
		
	}
	// System.out.println("1. 재직중인 사원 전체 조회"); 
	// 현재 재직중인 사원의
	// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
	// 직급코드 오름차순으로 조회
	// selectEntN();
	private void selectEntN() {
		System.out.println("\n----- 재직중인 사원 전체 조회 -----\n");
		List<Emp> emps;
		try {
			emps = service.selectEntN();
			if(emps.isEmpty()) {
				System.out.println("없음");
				return;
			}
			for(Emp e : emps) {
				System.out.println(e.toSelectEntN());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// System.out.println("2. 퇴직한 사원 전체 조회"); 
	// 현재 퇴직한 사원의
	// 사번, 이름, 전화번호, 이메일, 퇴사일을
	// 퇴사일 오름차순으로 조회
	// selectEntY();
	private void selectEntY() {
		System.out.println("\n----- 퇴직한 사원 전체 조회 -----\n");
		List<Emp> emps;
		try {
			emps = service.selectEntY();
			if(emps.isEmpty()) {
				System.out.println("없음");
				return;
			}
			for(Emp e : emps) {
				System.out.println(e.toSelectEntY());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// System.out.println("3. 사번이 일치하는 사원 조회"); 
	// 사번을 입력 받아 일치하는 사원의  
	// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
	// 단, 사번이 일치하는 사원이 없으면
	// "사번이 일치하는 사원이 없습니다" 출력
	// selectEmpId();
	private void selectEmpId() {
		System.out.println("\n----- 사번이 일치하는 사원 조회 -----\n");
		System.out.print("사번 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		try {
			Emp emp = service.selectEmpId(input);
			if(emp == null) {
				System.out.println("사번이 일치하는 사원이 없습니다.");
				return;
			}
			System.out.println(emp.toSelectEmpId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// System.out.println("4. 사원 정보 추가(INSERT)");
	// 사번(EMP_ID) -> SEQ_EMP_ID SEQUENCE 사용
	// insertEmp();
	private void insertEmp() {
		System.out.println("\n----- 사원 추가 -----\n");
		System.out.print("이름 : ");
		String empName = sc.next();

		System.out.print("주민등록번호 : ");
		String empNo = sc.next();

		System.out.print("이메일 : ");
		String email = sc.next();

		System.out.print("전화번호(-제외) : ");
		String phone = sc.next();

		System.out.print("부서코드(D1~D9) : ");
		String deptCode = sc.next();

		System.out.print("직급코드(J1~J7) : ");
		String jobCode = sc.next();

		System.out.print("급여등급(S1~S6) : ");
		String salLevel = sc.next();

		System.out.print("급여 : ");
		int salary = sc.nextInt();

		System.out.print("보너스 : ");
		double bonus = sc.nextDouble();

		System.out.print("사수번호 : ");
		int managerId = sc.nextInt();
	      
	    sc.nextLine();

	    Emp emp = new Emp(empName, empNo, email, phone, salary,
	    		  					deptCode, jobCode, salLevel, bonus, managerId);
	      
		try {
			int result = service.insertEmp(emp);

			if (result > 0) {
				System.out.println("[삽입 성공!!!]");
			} else {
				System.out.println("[삽입 실패...]");
			}

		} catch (SQLException e) {
			System.out.println("\n[사원 정보 삽입 중 예외 발생]\n");
			e.printStackTrace();
		}
	}

	// System.out.println("5. 사번으로 사원 정보 수정(UPDATE)");
	// 이메일, 전화번호, 급여, 보너스 수정
	// 단, 사번이 일치하는 사원이 없으면
	// "사번이 일치하는 사원이 없습니다" 출력
	// updateEmpId();
	private void updateEmpId() {
System.out.println("\n----- 사번으로 사원 정보 수정 -----\n");
		
		System.out.print("수정할 사원의 사번 : ");
		int empId = sc.nextInt();
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		System.out.print("급여 : ");
		int salary = sc.nextInt();
		
		System.out.print("보너스 : ");
		double bonus = sc.nextDouble();
		
		sc.nextLine();
		
		// 입력받은 값을 한 번에 전달하기 위한 Employee 객체 생성
		Emp emp = new Emp();
		emp.setEmpId(empId);
		emp.setEmail(email);
		emp.setPhone(phone);
		emp.setSalary(salary);
		emp.setBonus(bonus);
		
		// 회원 정보 수정 서비스 호출 후 결과 반환 받기
		try {
			int result = service.updateEmpId(emp);
			
			if(result > 0) { // 성공
				System.out.println("[수정 성공]");
			} else {
				System.out.println("[수정 실패]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// System.out.println("6. 사번으로 사원 정보 삭제(DELETE)");
	// 사번을 입력 받아 일치하는 사원 삭제
	// - 사번을 입력 받은 후 정말 삭제할 것인지 Y/N을 입력 받아 
	//   Y인 경우에만 삭제, N인 경우 취소
	// - 사번이 일치하는 사원이 없으면
	//   "사번이 일치하는 사원이 없습니다" 출력
	// deleteEmpId();
	private void deleteEmpId() {
		System.out.print("\n----- 사번으로 사원 정보 삭제 -----\n");
		System.out.print("삭제할 사원의 사번 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		System.out.print("정말 삭제 하시겠습니까?(Y/N)");
		char check = sc.next().toUpperCase().charAt(0);
		sc.nextLine();
		
		if(check == 'Y') {
			try {
				int result = service.deleteEmpId(input);
				if(result > 0) { // 성공
					System.out.println("[삭제 성공]");
				} else {
					System.out.println("[삭제 실패]");
				}
			} catch (SQLException e) {
				
			}
		}
		else System.out.println("[취소되었습니다.]");
	}

	// System.out.println("7. 사번이 일치하는 사원 퇴직 처리");
	// - ENT_YN -> 'Y' , ENT_DATE -> SYSDATE로 수정
	// - 사번을 입력 받은 후 정말 퇴직 처리할 것인지 Y/N을 입력 받아 
	//   Y인 경우에만 퇴직 처리, N인 경우 취소
	// - 사번이 일치하지 않거나 이미 퇴직 처리된 사원이면
	//   "사번이 일치하는 않거나, 이미 퇴직된 사원입니다." 출력
	// retireEmpId();
	private void retireEmpId() {
System.out.println("\n----- 사번으로 사원 퇴사 -----\n");
		
		System.out.print("퇴사 처리할 사원의 사번 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		System.out.print("정말 퇴사처리 하시겠습니까?(Y/N)");
		char check = sc.next().toUpperCase().charAt(0);
		sc.nextLine();
		
		if(check == 'N') {
			System.out.println("[취소되었습니다]");
			return;
		}
		if(check != 'Y') {
			System.out.println("[잘못 입력하셨습니다.]");
			return;
		}
		// 서비스 호출 후 결과 반환 받기
		try {
			int result = service.retireEmpId(input);
			String str = null;
			if(result > 0) str = "[퇴사 처리가 완료되었습니다]";
			else str = "[사번이 일치하는 사원이 없습니다]";
			System.out.println(str);
			// 성공 : [퇴사 처리가 완료되었습니다]
			// 실패 : [사번이 일치하는 사원이 없습니다]
			// 예외 : [퇴사 처리 중 예외 발생]
		} catch(SQLException e) {
			System.out.println("[퇴사 처리중 예외 발생]");
			e.printStackTrace();
		}
	}
	
	// System.out.println("8. 가장 최근 입사한 사원 5명 조회");
	// 가장 최근(입사일이 늦은) 사원 5명의
	// 사번, 이름, 부서명, 입사일을
	// 입사일 내림차순으로 조회
	// selectFiveMostRecentlyHiredEmployees();
	private void selectFiveMostRecentlyHiredEmployees() {
		System.out.println("\n----- 가장 최근 입사한 사원 5명 조회 -----\n");
		try {
			List<Emp> emps = service.selectFiveMostRecentlyHiredEmployees();
			if(emps.isEmpty()) System.out.println("\n[조회 실패]\n");
			for(Emp e : emps) System.out.println(e.toSelectFiveMostRecentlyHiredEmployees());
		} catch (SQLException e) {
			System.out.println("\n[가장 최근 입사한 사원 조회 중 예외 발생]\n");
			e.printStackTrace();
		}
		
	}

	// System.out.println("9. 부서별 통계 조회"); 
	// 각 부서별
	// 부서명, 인원 수, 급여 평균
	// 부서코드 오름차순 조회
	// HINT.
	// - 별도의 DTO 작성 또는 
	//   Map(LinkedHashMap : key 순서가 유지되는 Map) 이용
	// selectStatisticsByDepartment();
	private void selectStatisticsByDepartment() {
		System.out.println("\n----- 부서별 통계 조회 -----\n");
		try{
			List<Map<String,Object>> departments = service.selectStatisticsByDepartment();
			for (Map m : departments)
				System.out.printf("%s / %d / %.0f\n",m.get("deptTitle"),
						m.get("person"), m.get("avg"));
		} catch(SQLException e) {
			System.out.println("\n[부서별 통계 조회 중 예외 발생]\n");
			e.printStackTrace();
		}
	}
}