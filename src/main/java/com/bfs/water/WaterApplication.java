package com.bfs.water;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.bfs.mapper")
@ComponentScan(basePackages = {"com.bfs.*"})
public class WaterApplication {
	public static void main(String[] args) {
		SpringApplication.run(WaterApplication.class, args);
	}
}
