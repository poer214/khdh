package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {
	private EmpDAO dao = new EmpDAO();

	public List<Emp> selectEntN() throws SQLException {
		Connection conn = getConnection();
		
		List<Emp> results = dao.selectEntN(conn);
		
		close(conn);
		
		return results;
	}

	public List<Emp> selectEntY() throws SQLException {
		Connection conn = getConnection();
		
		List<Emp> results = dao.selectEntY(conn);
		
		close(conn);
		
		return results;
	}
	public Emp selectEmpId(int input) throws SQLException {
		Connection conn = getConnection();
		
		Emp result = dao.selectEmpId(conn, input);
		
		close(conn);
		
		return result;
	}
	// System.out.println("4. 사원 정보 추가(INSERT)");
	// 사번(EMP_ID) -> SEQ_EMP_ID SEQUENCE 사용
	// insertEmp();
	public int insertEmp(Emp emp) throws SQLException {
		Connection conn = getConnection();
		
		int result = dao.insertEmp(conn, emp);
		if(result > 0) // 삽입 성공 시
			commit(conn);
		else	// 삽입 실패시
			rollback(conn);
		close(conn);
		
		return result;
	}
	public int updateEmpId(Emp emp) throws SQLException {
		Connection conn = getConnection();
		int result = dao.updateEmpId(conn,emp);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
	}
	public int deleteEmpId(int input) throws SQLException {
		Connection conn = getConnection();
		int result = dao.deleteEmpId(conn,input);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	public int retireEmpId(int input) throws SQLException{
		Connection conn = getConnection();
		int result = dao.retireEmpId(conn, input);
		if (result > 0) commit(conn);
		else rollback(conn);
		close(conn);

		return result;
	}

	public List<Emp> selectFiveMostRecentlyHiredEmployees() throws SQLException{
		try (Connection conn = getConnection()){
			return dao.selectFiveMostRecentlyHiredEmployees(conn);
		}
	}

	public List<Map<String,Object>> selectStatisticsByDepartment() throws SQLException{
		try (Connection conn = getConnection()){
			return dao.selectStatisticsByDepartment(conn);
		}
	}
}