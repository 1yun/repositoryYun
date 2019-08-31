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
import com.atguigu.springcloud.services.DeptClientService;

/**1、概述
基于Netflix ribbon实现的一套 ==客户端、负载均衡的工具==

重要功能是提供==客户端的软件负载均衡算法==，Ribbon客户端组件提供一系列的配置项如链接超时、重试等
 * @author GongXings
 * @createTime 30 15:43
 * @description
 */
@RestController
public class controller {
	@Autowired
    private DeptClientService deptClientService;
    @RequestMapping(value = "/consumer/dept/add")
    public boolean add( DeptEntity deptEntity){
        //三个参数：url,requestMap ResponseBean.class
        return  deptClientService.add(deptEntity);
    }
    @RequestMapping("/consumer/dept/findById/{deptNo}")
    public DeptEntity findById(Long deptNo){
        //三个参数：url,requestMap ResponseBean.class
        return deptClientService.findById(deptNo);
    }
    @RequestMapping("/consumer/dept/findAll")
    public List findAll(){
        //三个参数：url,requestMap ResponseBean.class
        return  deptClientService.findAll();
    }
	
}