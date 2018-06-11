package com.bfs.water;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
//@MapperScan("com.bfs.mapper")
@ComponentScan(basePackages = {"com.bfs.*"})
public class WaterApplication{
	public static void main(String[] args) {
		SpringApplication.run(WaterApplication.class, args);
	}
}
