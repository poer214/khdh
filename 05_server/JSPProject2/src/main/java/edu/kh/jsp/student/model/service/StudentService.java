package edu.kh.jsp.student.model.service;

import static edu.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.dto.Student;

public class StudentService {
	// DAO 필드에 생성 (기본 생성자 사용)
	private StudentDAO dao = new StudentDAO();

	
	/** 학생 전체 조회
	 * @return dao.selectAll(conn)
	 * @throws Exception
	 */
	public List<Student> selectAll() throws Exception {
		try(Connection conn = getConnection()){return dao.selectAll(conn);}
	}
}