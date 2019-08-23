package com.yc.blog;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yc.blog.web.LoginInterceptor;

/**
 * 在某个类上使用@Component注解，表明当需要创建类时，这个被注解的类是一个候选类。就像是举手。
	@ComponentScan 用于扫描指定包下的类。就像看都有哪些举手了。
 * @ComponentScan是组件扫描注解，用来扫描@Controller  @Service  @Repository这类,主要就是定义扫描的路径从中找出标志了需要装配的类到Spring容器中
 *  	1 ComponentScan做的事情就是告诉Spring从哪里找到bean
 *  	2 如果你的其他包都在使用了@SpringBootApplication注解的main app所在的包及其下级包，则你什么都不用做，SpringBoot会自动帮你把其他包都扫描了
 *  	3 如果你有一些bean所在的包，不在main app的包及其下级包，那么你需要手动加上@ComponentScan注解并指定那个bean所在的包
 * @MapperScan 是扫描mapper类的注解,就不用在每个mapper类上加@MapperScan了
 *  
 *  1在接口类上添加了@Mapper，在编译之后会生成相应的接口实现类
 *  		如果想要每个接口都要变成实现类，那么需要在每个接口类上加上@Mapper注解，比较麻烦，解决这个问题用@MapperScan
 *  2 指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
 *  		添加位置：是在Springboot启动类上面添加，
 * */
@SpringBootApplication
@Controller
@MapperScan("com.yc")
public class Springboot814Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(Springboot814Application.class, args);
	}

	@GetMapping("hello")
	public String hello(){
		return "hello";
	}

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/toedit","/comment");
	}
	
}
