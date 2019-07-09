package com.mbhyggfwpt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.mbhyggfwpt.mapper")
@EnableSwagger2
@EnableScheduling
public class MbhyggfwptApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbhyggfwptApplication.class, args);
	}

}
