package Dependency_Demo;

import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_dependency {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
		Dependency_injection injection = context.getBean(Dependency_injection.class);
		System.out.println(injection.getId());
		System.out.println(injection.getEmp_name());
		System.out.println(injection.getEmp_email());
		System.out.println(injection.getPhone());
//		System.out.println(injection.getEmployee_id());
//		System.out.println(injection.getEmployee_email());

		for (int e : injection.getEmployee_id()) {
			System.out.println(e);
		}

		for (String e : injection.getEmployee_email().keySet()) {
			System.out.println(e + " : " + injection.getEmployee_email().get(e));
		}
	}
}
