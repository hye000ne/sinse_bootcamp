package table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class MemberRegist extends JFrame implements ActionListener, WindowListener {
	// 서쪽 영역
	JPanel p_west;
	JTextField t_id;
	JTextField t_name;
	JTextField t_tel;
	JButton bt;

	// 센터 영역
	JPanel p_center;
	JTable table;
	JScrollPane scroll;
	
	TableModel model;
	
	Connection con;
	ResultSet rs = null;
	
	int idx=0;

	//회원 등록 (model이 보유한 이차원 배열에 넣기)
	public void regist() {
		String sql = "insert into member4(id, name, tel) values ('"+t_id.getText()+"','"+t_name.getText()+"','"+t_tel.getText() +"')";
//		System.out.println(sql);
		
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			int result = pstmt.executeUpdate(); //DML(insert, update, delete)
			if(result > 0) {
				JOptionPane.showMessageDialog(this, "등록 성공");
				selectAll();
			} else {
				JOptionPane.showMessageDialog(this, "등록 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void selectAll() {
		String sql = "select * from member4";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			rs = pstmt.executeQuery();// select 문일 경우 쿼리 수행시 표가 반환되므로 해당 표를 제어할 ResultSet 객체가 반환됨
			
			rs.last(); //레코드의 마지막으로 포인터를 보낸다.
			int total = rs.getRow(); //현재 위치 어디인지 묻는다.
			System.out.println("현재까지 가입한 총 수는 " + total);
			
			//rs 자체는 MyModel이 보유하고 있는 2차원 배열자체가 아니므로 rs의 데이터를 2차원 배열로 변환하여 
			//MyModel이 보유한 배열대신 사용해야함
			((MyModel)model).rows = new String[total][3];
			
			//마지막 위치로 보냈던 rs의 커서를 다시 처음으로 복귀시킨다. 레코드를 처음부터 접근하기 위해서
			rs.beforeFirst(); //이 커서의 자유로움은 pstmt생성시 부여한 상수 옵션 때문이다.

			int index=0;
			while(rs.next()) {
				String[] record = {rs.getString("id"),rs.getString("name"),rs.getString("tel")};
				((MyModel)model).rows[index++] = record;
			}
			
			// 테이블 갱신
			table.updateUI();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		regist();
	}
	
	public MemberRegist() {
		p_west = new JPanel();
		t_id = new JTextField();
		t_name = new JTextField();
		t_tel = new JTextField();
		bt = new JButton("가입");
		model = new MyModel();
		con = null;

		p_center = new JPanel();
		// 생성자에 이차원배열을 대입 방식은 불편
		// 생성하는 시점부터 언제나 데이터가 있어야하는 전제조건이
		// 생성자 인수에 이 테이블에 보여줘야할 데이터 또는 데이터처리 객체
		// JTable은 MVC패턴을 어느정도 반영한 컴포넌트이다.(완벽하진않음)
		table = new JTable(model);
		scroll = new JScrollPane(table);
		p_center.add(scroll);

		// style 부여
		p_west.setPreferredSize(new Dimension(150, 500));
		p_west.setBackground(Color.ORANGE);
		Dimension d = new Dimension(146, 35);
		t_id.setPreferredSize(d);
		t_name.setPreferredSize(d);
		t_tel.setPreferredSize(d);
		
		scroll.setPreferredSize(new Dimension(420, 450));
		
		p_west.add(t_id);
		p_west.add(t_name);
		p_west.add(t_tel);
		p_west.add(bt);
		p_center.add(scroll);

		add(p_west, BorderLayout.WEST);
		add(p_center);
		
		bt.addActionListener(this);
		this.addWindowListener(this);
		
		setVisible(true);
		setBounds(100, 100, 600, 500);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//DB 접속
		connect();
		selectAll();
	}
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/dev";
			String id="java";
			String pwd="1234";
			con = DriverManager.getConnection(url,id,pwd);
			if(con != null) {
				this.setTitle("접속 성공");
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MemberRegist();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
}
