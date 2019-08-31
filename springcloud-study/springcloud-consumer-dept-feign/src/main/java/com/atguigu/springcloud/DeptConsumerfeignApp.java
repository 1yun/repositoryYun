package com.atguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author GongXings
 * @createTime 30 16:11
 * @description
 */
@SpringBootApplication
/**
 * 在启动该微服务式是能去加载我们定义的Ribbon配置类
 */
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.atguigu.springcloud")
@ComponentScan("com.atguigu.springcloud")
public class DeptConsumerfeignApp {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerfeignApp.class,args);
    }
}