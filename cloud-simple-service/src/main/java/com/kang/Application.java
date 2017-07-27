package com.kang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan
public class Application {
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
	}
}
