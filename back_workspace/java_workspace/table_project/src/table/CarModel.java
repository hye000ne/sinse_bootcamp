package table;

import javax.swing.table.AbstractTableModel;

/*
 * JTable ���ߺо߿��� ���س������� ���� �˷��� ���� ���(=����) �� �ϳ��� MVC ������ ������ ������Ʈ�̴�.
 * MC ������ ���ÿ� �����ϹǷ� �Ϻ��� MVC�� �ƴϴ�.
 * ������ ����, �� �����͸� ������ ������ �ݿ��Ǵ� �ڵ嵵 ����.
 * ���)�߿��� ���� JTable�� �����͸� �и����ѳ��� �����
 * 
 * */
public class CarModel extends AbstractTableModel{
	
	//���̺� ������ �� ���ڵ� ��
	@Override
	public int getRowCount() {
		return 3;
	}
	
	//���̺��� �����ϴ� �÷� ��
	@Override
	public int getColumnCount() {
		return 5;
	}
	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return "audi";
	}


}
