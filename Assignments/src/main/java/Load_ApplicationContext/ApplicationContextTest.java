package Load_ApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(config.class);
		Car c = context.getBean(Car.class);
		c.setCar_brand("TATA");
		c.setCar_Name("Punch.ev");
		c.setCar_price(1500000.00);
		System.out.println(c);
	}
}
