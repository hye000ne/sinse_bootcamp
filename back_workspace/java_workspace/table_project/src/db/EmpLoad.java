package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*Emp 테이블에 있는 레코드를 모두 가져와서 JTable에 출력*/
public class EmpLoad extends JFrame {
	JTable table;
	JScrollPane scroll;
	String[][] data;
	String[] cols = { "empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno" };

	public void loadData() {
		String url = "jdbc:mysql://localhost:3306/dev";
		String user = "java";
		String pass = "1234";

		Connection conn = null; // 접속 시도가 아닌 접속 후 그 정보를 가진 객체 따라서 이객체를 이용하여 접속을 끊을 수 있따.
		PreparedStatement pstmt = null; // 쿼리문을 수행하는 객체
		ResultSet rs = null; // 표 데이터 반환

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Load Success!!");
			conn = DriverManager.getConnection(url, user, pass);
			if (conn != null) {
				System.out.println("접속 성공");
				String sql = "select * from emp order by empno";
				// TYPE_SCROLL_INSENSITIVE : 커서가 전방향, 후방향 및 건너뛰기 가능한 즉 커서의 위치를 자유자재로 조절 가능한 옵션
				// CONCUR_READ_ONLY : ResultSet에 담은 레코드를 읽기 전용으로만 쓰겠다.
				pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // 쿼리 수행 객체 생성
				rs = pstmt.executeQuery();

				rs.last(); // 레커노드 내에서 마지막 행으로 강제 이동
				// 자바뿐만 아니라 대부분의 언어에서의 배열은 선언시 반드시 그 크기를 결정해야함
				// rs.beforFirst() 메서드로 커서의 위치를 다시 원상복귀 시킨 후 박복문
				int total = rs.getRow();
				data = new String[total][8];

				data[0][0] = rs.getString("empno");
				data[0][1] = rs.getString("ename");
				data[0][2] = rs.getString("job");
				data[0][3] = rs.getString("mgr");
				data[0][4] = rs.getString("hiredate");
				data[0][5] = rs.getString("sal");
				data[0][6] = rs.getString("comm");
				data[0][7] = rs.getString("deptno");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public EmpLoad() {
		// mysql에서 사원정보를 가져와야함
		loadData();

		table = new JTable(data, cols);
		scroll = new JScrollPane(table);

		add(scroll);
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new EmpLoad();
	}
}
