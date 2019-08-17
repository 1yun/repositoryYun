package com.yc.sale.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.sale.bean.CusCustomer;
import com.yc.sale.bean.SaleOrder;
import com.yc.sale.bean.SaleOrderLine;
import com.yc.sale.bean.SaleProduct;
import com.yc.saleBiz.ProductBiz;
import com.yc.saleBiz.saleBiz;


@Controller
public class saleOrderController {

	@Resource
	private saleBiz sb;
	@Resource
	private ProductBiz pb;
	
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
	public SaleOrder finOrderDetail(SaleOrder order){
		System.out.println(order.getOdrId()+"----------------------");
		//一对多查询
		SaleOrder saleOrder = sb.queryManyByOid(order.getOdrId());
		System.out.println(saleOrder);
		
		return   saleOrder;
	}
	
	//odlId 进行删除
	@RequestMapping("saleOrder_delOrderLine")
	@ResponseBody
	public String deleteOrderline(SaleOrderLine sol){
		sb.deleteOrderLine(sol.getOdlId());
		return "{\"flag\":true}";
	}
	
	
	//查出所有的商品saleProduct_findAll
	@RequestMapping("saleProduct_findAll")
	@ResponseBody
	public List<SaleProduct> Product_findAll(){
		return pb.queryProductAll();
	}
	
	//添加订单项 saleOrder_saveOrderLine
	@RequestMapping("saleOrder_saveOrderLine")
	@ResponseBody
	public String addOrderLine(SaleOrderLine sol){
		 sb.addProduct(sol);
		 return "{\"flag\":true}";
	}
}
