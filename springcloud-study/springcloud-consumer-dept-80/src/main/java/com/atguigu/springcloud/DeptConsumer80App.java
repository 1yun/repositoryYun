package com.atguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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
public class DeptConsumer80App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80App.class,args);
    }
}