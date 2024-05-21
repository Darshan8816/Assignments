package BeanScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(config.class);
		Car s = ac.getBean(Car.class);
		Car s1 = ac.getBean(Car.class);
		System.out.println(s.equals(s1) ? "Car single object returned" : "Car different object returned");

		Bike b = ac.getBean(Bike.class);
		Bike b1 = ac.getBean(Bike.class);
		System.out.println(b.equals(b1) ? "Bike single object returned" : "Bike different object returned");
	}
}
