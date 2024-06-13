package edu.sandau.b230111.b23011111;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class B23011111Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(B23011111Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(B23011111Application.class);
	}

}
