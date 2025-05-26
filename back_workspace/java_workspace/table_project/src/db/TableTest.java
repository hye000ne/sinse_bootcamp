package db;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableTest extends JFrame {
	JTable table;
	JScrollPane scroll;

	// �����Ϳ� ���� ������ �迭
	String[][] data = { { "java", "python", "c#", "js", "R" }, { "jsp", "servlet", "React", "Vue", "Node.js" },
			{ "oracle", "mysql", "mariadb", "db2", "mysql" } };

	// �÷��� ���� ������ �迭
	String[] columns = { "����1", "����2", "����3", "����4", "����5" };

	public TableTest() {
		table = new JTable(data, columns);
		scroll = new JScrollPane(table);
		setLayout(new FlowLayout());

		add(scroll);

		setSize(600, 550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TableTest();
	}
}
