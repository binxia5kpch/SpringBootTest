package com.zhongsou.springboot.test

import com.zhongsou.core.conf.SYPropertyPlaceholderConfigurer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com")
class SpringBootTestApplication {

	static void main(String[] args) {
		SYPropertyPlaceholderConfigurer.toSys();
		SpringApplication.run SpringBootTestApplication, args
	}
}
