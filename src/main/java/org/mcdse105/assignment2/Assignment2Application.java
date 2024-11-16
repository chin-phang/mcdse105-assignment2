package org.mcdse105.assignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "org.mcdse105.assignment2")
public class Assignment2Application extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Assignment2Application.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);
	}

}
