package com.mbhyggfwpt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mbhyggfwpt.mapper")
public class MbhyggfwptApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbhyggfwptApplication.class, args);
	}

}
