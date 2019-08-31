package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.DeptEntity;

/**1、概述
基于Netflix ribbon实现的一套 ==客户端、负载均衡的工具==

重要功能是提供==客户端的软件负载均衡算法==，Ribbon客户端组件提供一系列的配置项如链接超时、重试等
 * @author GongXings
 * @createTime 30 15:43
 * @description
 */
@RestController
public class controller {

	//private static final String url_prefix="http://localhost:8001";
	/**
	 * 注册再EurekaServer中的微服务名称
	 */
	private static final String url_prefix="http://study-springcloud-dept";
	/**
     * 配置RestTemplate
     * 通过RestTemplate调用提供者服务 ，发送rest请求
     * 提供了多种访问http服务的方法，
     * 针对于访问rest服务<strong>客户端</strong>的调用的模板类
     * @return (url,requestMap,ResponseBean.class)
     * 分别表示rest请求的地址  请求参数 http响应转换被转换的类型对象
     */
    @Autowired
    private RestTemplate template;
    
    @RequestMapping(value="/consumer/dept/add")
	public boolean add(DeptEntity dept){
		return template.postForObject(url_prefix+"/dept/add", dept, Boolean.class);
	}
    
    @RequestMapping(value="/consumer/dept/get/{id}")
   	public DeptEntity getByid(@PathVariable("id")Long id){
   		return template.getForObject(url_prefix+"/dept/findById/"+id, DeptEntity.class);
   	}
    @RequestMapping(value="/consumer/dept/findAll")
   	public List<DeptEntity> list(){
   		return template.getForObject(url_prefix+"/dept/findAll", List.class);
   	}
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return  template.getForObject(
        		url_prefix+"/dept/discovery",
                Object.class);
    }
}