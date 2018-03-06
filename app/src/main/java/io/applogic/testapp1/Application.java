package io.applogic.testapp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}
	
}
