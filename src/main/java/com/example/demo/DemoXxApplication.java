package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
//@EnableJpaRepositories("com.example.demo.repository")
//@EntityScan("com.example.demo.entity")
//@EnableConfigurationProperties(JpaProperties.class)
public class DemoXxApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoXxApplication.class, args);
	}

}
