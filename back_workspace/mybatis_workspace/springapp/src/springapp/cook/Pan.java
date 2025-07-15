package springapp.cook;

/**
 * 애플리케이션의 규모가 큰 엔터프라이즈급일 때는 유지보수성을 높이는 것이
 * 곧 비용이 직결됨
 * 따라서 유지보수성을 높이기 위해서는 has a 관계에 있어, 정확한 자료형을 보유하기 보다는
 * 상위 개녕의 자료형을 보유함으로써, 객체와 객체간의 관계를 느슨하게 하는게 좋다
 * 
 */
public interface Pan {
	public void boil();
}
