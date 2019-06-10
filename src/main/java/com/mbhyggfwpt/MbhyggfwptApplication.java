package com.mbhyggfwpt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.mbhyggfwpt.mapper")
@EnableSwagger2
public class MbhyggfwptApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbhyggfwptApplication.class, args);
	}

}
