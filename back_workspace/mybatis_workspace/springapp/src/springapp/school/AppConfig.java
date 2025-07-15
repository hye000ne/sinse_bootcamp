package springapp.school;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("springapp.school")
public class AppConfig {
	@Bean
	public Bell bell() { 
		return new Bell();
	}
	
	@Bean
	public Student student() { 
		return new Student();
	}
}
