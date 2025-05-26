package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*Emp ���̺� �ִ� ���ڵ带 ��� �����ͼ� JTable�� ���*/
public class EmpLoad extends JFrame {
	JTable table;
	JScrollPane scroll;
	String[][] data;
	String[] cols = { "empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno" };

	public void loadData() {
		String url = "jdbc:mysql://localhost:3306/dev";
		String user = "java";
		String pass = "1234";

		Connection conn = null; // ���� �õ��� �ƴ� ���� �� �� ������ ���� ��ü ���� �̰�ü�� �̿��Ͽ� ������ ���� �� �ֵ�.
		PreparedStatement pstmt = null; // �������� �����ϴ� ��ü
		ResultSet rs = null; // ǥ ������ ��ȯ

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Load Success!!");
			conn = DriverManager.getConnection(url, user, pass);
			if (conn != null) {
				System.out.println("���� ����");
				String sql = "select * from emp order by empno";
				// TYPE_SCROLL_INSENSITIVE : Ŀ���� ������, �Ĺ��� �� �ǳʶٱ� ������ �� Ŀ���� ��ġ�� ��������� ���� ������ �ɼ�
				// CONCUR_READ_ONLY : ResultSet�� ���� ���ڵ带 �б� �������θ� ���ڴ�.
				pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // ���� ���� ��ü ����
				rs = pstmt.executeQuery();

				rs.last(); // ��Ŀ��� ������ ������ ������ ���� �̵�
				// �ڹٻӸ� �ƴ϶� ��κ��� ������ �迭�� ����� �ݵ�� �� ũ�⸦ �����ؾ���
				// rs.beforFirst() �޼���� Ŀ���� ��ġ�� �ٽ� ���󺹱� ��Ų �� �ں���
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
		// mysql���� ��������� �����;���
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
