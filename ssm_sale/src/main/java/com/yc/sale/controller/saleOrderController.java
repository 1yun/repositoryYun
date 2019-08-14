package com.yc.sale.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.sale.bean.CusCustomer;
import com.yc.sale.bean.SaleOrder;
import com.yc.saleBiz.saleBiz;

import flexjson.JSONSerializer;

@Controller
public class saleOrderController {

	@Resource
	private saleBiz sb;
	
	
	//点击保存 订单
	@PostMapping("saleOrder_save")
	@ResponseBody
	public String saleOrder(SaleOrder order){
		int i = sb.insertOrder(order);
		
		if(i>=1)
			return "{\"flag\":\""+order.getOdrId()+"\"}";
		return "{\"flag\":\"0\"}";
	}
	
	
	//查询所有的用户 进行ajax数据返回
	@RequestMapping("cusCustomer_findAll")
	@ResponseBody
	public List<CusCustomer> Customer_findAll(){
		
		return sb.queryAll();
	}
	
	//odr_id=8
	@RequestMapping("saleOrder_findOrderWithDetail")
	@ResponseBody
	public String finOrderDetail(SaleOrder order){
		System.out.println(order.getOdrId()+"----------------------");
		//一对多查询
		SaleOrder saleOrder = sb.queryManyByOid(1);
		System.out.println(saleOrder);
		
		return   "";
	}
	
}
