package Load_ApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "Load_ApplicationContext")
@Configuration
public class config {

	@Bean
	public Car getCar() {
		return new Car();
	}
}
