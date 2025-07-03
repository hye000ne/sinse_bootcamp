package table;

import javax.swing.table.AbstractTableModel;

/*
 * JTable 개발분야에서 전해내려오는 많이 알려진 개발 방법(=패턴) 중 하나인 MVC 패턴을 구현한 컴포넌트이다.
 * MC 역할을 동시에 수행하므로 완벽한 MVC는 아니다.
 * 데이터 보유, 그 데이터를 디자인 영역에 반영되는 코드도 포함.
 * 결론)중요한 것은 JTable과 데이터를 분리시켜놓은 기술임
 * 
 * */
public class MyModel extends AbstractTableModel{
	//회원정보
	String[][] rows = new String[0][3];
	String[] cols = {"ID", "Name", "Tel"};
	
	//테이블에 보여질 총 레코드 수
	@Override
	public int getRowCount() {
		return rows.length;
	}
	
	//테이블을 구성하는 컬럼 수
	@Override
	public int getColumnCount() {
		return cols.length;
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		return rows[row][col];
	}
	
	// 컬럼의 이름 반환해주는 메서드
	// 아래의 메서드는 컬럼 수만큼 반복하면서 호출되는데 이때 매개변수로 넘겨받는 col의 값을 증가하면서 전달.
	public String getColumnName(int column) {
		return cols[column];
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		System.out.println(row+"행,"+ col+"열은 수정가능합니다.");
		return true;
	}
}
