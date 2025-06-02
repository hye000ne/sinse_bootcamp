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
	// ���� ����
	JPanel p_west;
	JTextField t_id;
	JTextField t_name;
	JTextField t_tel;
	JButton bt;

	// ���� ����
	JPanel p_center;
	JTable table;
	JScrollPane scroll;
	
	TableModel model;
	
	Connection con;
	ResultSet rs = null;
	
	int idx=0;

	//ȸ�� ��� (model�� ������ ������ �迭�� �ֱ�)
	public void regist() {
		String sql = "insert into member4(id, name, tel) values ('"+t_id.getText()+"','"+t_name.getText()+"','"+t_tel.getText() +"')";
//		System.out.println(sql);
		
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			int result = pstmt.executeUpdate(); //DML(insert, update, delete)
			if(result > 0) {
				JOptionPane.showMessageDialog(this, "��� ����");
				selectAll();
			} else {
				JOptionPane.showMessageDialog(this, "��� ����");
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
			
			rs = pstmt.executeQuery();// select ���� ��� ���� ����� ǥ�� ��ȯ�ǹǷ� �ش� ǥ�� ������ ResultSet ��ü�� ��ȯ��
			
			rs.last(); //���ڵ��� ���������� �����͸� ������.
			int total = rs.getRow(); //���� ��ġ ������� ���´�.
			System.out.println("������� ������ �� ���� " + total);
			
			//rs ��ü�� MyModel�� �����ϰ� �ִ� 2���� �迭��ü�� �ƴϹǷ� rs�� �����͸� 2���� �迭�� ��ȯ�Ͽ� 
			//MyModel�� ������ �迭��� ����ؾ���
			((MyModel)model).rows = new String[total][3];
			
			//������ ��ġ�� ���´� rs�� Ŀ���� �ٽ� ó������ ���ͽ�Ų��. ���ڵ带 ó������ �����ϱ� ���ؼ�
			rs.beforeFirst(); //�� Ŀ���� �����ο��� pstmt������ �ο��� ��� �ɼ� �����̴�.

			int index=0;
			while(rs.next()) {
				String[] record = {rs.getString("id"),rs.getString("name"),rs.getString("tel")};
				((MyModel)model).rows[index++] = record;
			}
			
			// ���̺� ����
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
		bt = new JButton("����");
		model = new MyModel();
		con = null;

		p_center = new JPanel();
		// �����ڿ� �������迭�� ���� ����� ����
		// �����ϴ� �������� ������ �����Ͱ� �־���ϴ� ����������
		// ������ �μ��� �� ���̺� ��������� ������ �Ǵ� ������ó�� ��ü
		// JTable�� MVC������ ������� �ݿ��� ������Ʈ�̴�.(�Ϻ���������)
		table = new JTable(model);
		scroll = new JScrollPane(table);
		p_center.add(scroll);

		// style �ο�
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
		//DB ����
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
				this.setTitle("���� ����");
				
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
