package table;

import javax.swing.table.AbstractTableModel;

/*
 * JTable ���ߺо߿��� ���س������� ���� �˷��� ���� ���(=����) �� �ϳ��� MVC ������ ������ ������Ʈ�̴�.
 * MC ������ ���ÿ� �����ϹǷ� �Ϻ��� MVC�� �ƴϴ�.
 * ������ ����, �� �����͸� ������ ������ �ݿ��Ǵ� �ڵ嵵 ����.
 * ���)�߿��� ���� JTable�� �����͸� �и����ѳ��� �����
 * 
 * */
public class MyModel extends AbstractTableModel{
	//ȸ������
	String[][] rows = new String[0][3];
	String[] cols = {"ID", "Name", "Tel"};
	
	//���̺� ������ �� ���ڵ� ��
	@Override
	public int getRowCount() {
		return rows.length;
	}
	
	//���̺��� �����ϴ� �÷� ��
	@Override
	public int getColumnCount() {
		return cols.length;
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		return rows[row][col];
	}
	
	// �÷��� �̸� ��ȯ���ִ� �޼���
	// �Ʒ��� �޼���� �÷� ����ŭ �ݺ��ϸ鼭 ȣ��Ǵµ� �̶� �Ű������� �Ѱܹ޴� col�� ���� �����ϸ鼭 ����.
	public String getColumnName(int column) {
		return cols[column];
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		System.out.println(row+"��,"+ col+"���� ���������մϴ�.");
		return true;
	}
}
