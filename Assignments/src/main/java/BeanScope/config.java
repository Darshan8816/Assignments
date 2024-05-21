package BeanScope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@ComponentScan(basePackages = "BeanScope")
@Configuration
public class config {

	@Bean
	@Scope("singleton")
	public Car getBean() {
		return new Car();
	}

	@Bean
	@Scope("prototype")
	public Bike getBean1() {
		return new Bike();
	}
}
