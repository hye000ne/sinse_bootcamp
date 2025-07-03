package table;

import javax.swing.table.AbstractTableModel;

/*
 * JTable 개발분야에서 전해내려오는 많이 알려진 개발 방법(=패턴) 중 하나인 MVC 패턴을 구현한 컴포넌트이다.
 * MC 역할을 동시에 수행하므로 완벽한 MVC는 아니다.
 * 데이터 보유, 그 데이터를 디자인 영역에 반영되는 코드도 포함.
 * 결론)중요한 것은 JTable과 데이터를 분리시켜놓은 기술임
 * 
 * */
public class CarModel extends AbstractTableModel{
	
	//테이블에 보여질 총 레코드 수
	@Override
	public int getRowCount() {
		return 3;
	}
	
	//테이블을 구성하는 컬럼 수
	@Override
	public int getColumnCount() {
		return 5;
	}
	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return "audi";
	}


}
