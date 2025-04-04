package edu.ithaca.dragon.coursesupportserver.hidden;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import edu.ithaca.dragon.coursesupportserver.CoursesupportserverApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CoursesupportserverApplication.class);
	}

}
