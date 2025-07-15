package springapp.school;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BellAspect {
	@Autowired // 자동 주입(Bell 빈을 아래 멤버변수에 자동으로 주입)
	private Bell bell; //공통 코드
	
	@Before("execution(* Student.*(..))")
	public void ringBell() {
		bell.sound();
	}
}
