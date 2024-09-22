package com.vibely.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.vibely.user", "com.vibely.common"})
public class CommandServiceApplication {

    public static void main(String[] args) {
		SpringApplication.run(CommandServiceApplication.class, args);
	}

}
