package mvc_crud_operations;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.h2.server.web.WebServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class ApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

		ServletRegistration.Dynamic h2ServletRegistration = servletContext.addServlet("h2-console", new WebServlet());
		h2ServletRegistration.setLoadOnStartup(1);
		h2ServletRegistration.addMapping("/console/*");
	}
}
