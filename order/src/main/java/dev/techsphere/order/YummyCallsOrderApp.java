package dev.techsphere.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class YummyCallsOrderApp {

	public static void main(String[] args) {
		SpringApplication.run(YummyCallsOrderApp.class, args);
	}

}
