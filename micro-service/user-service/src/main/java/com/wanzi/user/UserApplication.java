package com.wanzi.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(UserApplication.class);
		application.setEnvironment(consulEnvironment());
		application.run(args);
	}

	private static StandardEnvironment consulEnvironment() {
		StandardEnvironment environment = new StandardEnvironment();
		environment.getSystemProperties().put("spring.cloud.consul.host", System.getenv("CONSUL_HOST"));
		return environment;
	}
}
