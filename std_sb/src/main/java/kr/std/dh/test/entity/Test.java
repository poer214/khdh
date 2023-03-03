package kr.std.dh.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Test {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// myName의 이름을 (DB컬럼 이름을)name으로 하겠다.
	// null값을 허용하지 않겠다.
	// 길이제한을 20으로 하겠다.
	@Column(name="name", nullable = false, length = 20)
	private String myName;
	private int age;
	private String info;
	
}
