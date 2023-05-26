package edu.kh.project.member.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service // Service Layer
		 // 비즈니스 로직(데이터 가공, DAO 호출, 트랜잭션 제어)
		 // + Bean 등록하는 어노테이션 
public class MemberServiceImpl implements MemberService{
	
	// org.slf4j.Logger : 로그를 작성할 수 있는 객체
	// org.slf4j.LoggerFactory
	private Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
													// 현재 클래스명.class
	
	// @Autowired : 작성된 필드와
	// Bean으로 등록된 객체 중  타입이 일치하는 Bean을
	// 해당 필드에 주입(Injection)하는 어노테이션
	// == DI(Dependency Injection, 의존성 주입)
	//		-> 객체를 직접 만들지 않고 Spring이 만든걸 주입함(Spring에 의존)
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Override
	public Member login(Member inputMember) {
		
		// 로그 출력
		logger.info("memberService.login() 실행"); // 정보 출력
		logger.debug("memberId : "+inputMember.getMemberEmail());
		logger.warn("이건 경고 용도");
		logger.error("이건 오류 발생 시");
		
		// 암호화 추가 예정
		 System.out.println("암호화 확인 : " + bcrypt.encode(inputMember.getMemberPw()));
		
		// bcrypt 암호화는 salt가 추가되기 때문에
		// 계속 비밀번호가 바뀌게 되어 DB에서 비교불가능!!
		
		
		// dao 메서드 호출
		Member loginMember = dao.login(inputMember);
		System.out.println(inputMember.getMemberPw());
		System.out.println(loginMember.getMemberPw());
		System.out.println(bcrypt.matches(inputMember.getMemberPw(), "$2a$10$nxEfdIGsSboDg.32irKM/uj3AwlaQqpFasc0T.xSAW2JkTIdO7Uhe"));
		
		if(loginMember != null) { // 아이디가 일치하는 회원이 조회된 경우
			
			// 입력한 pw, 암호화된 pw 같은 지 확인
			if(bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw()))
				// 비밀번호를 유지하지 않기 위해서 로그인 정보에서 제거
				loginMember.setMemberPw(null);
			else // 다를 경우
				loginMember = null;
		}
		return loginMember;
	}
	
	
	// @Transactional(rollbackFor = {Exception.class})
	// 예외가 발생하면 rollback
	// 발생 안하면 Service종료 시 commit
	
	
	// 회원 가입 서비스
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int signUp(Member inputMember) {
		
		// 비밀번호를 BCrypt를 이용하여 암호화 후 다시 inputMember에 세팅
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);
		
		// DAO 호출
		int result = dao.signUp(inputMember);
		
		return result;
	}
}