package com.yc.springboot_blog;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
@MapperScan("com.yc")
public class Springboot814Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot814Application.class, args);
	}
	
	@GetMapping("hello")
	public String hello(){
		return "hello";
	}
}
