package com.yc.sale.BizTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.sale.bean.CusCustomer;
import com.yc.sale.bean.SaleOrder;
import com.yc.sale.bean.SaleOrderLine;
import com.yc.sale.dao.SaleOrderLineMapper;
import com.yc.saleBiz.saleBiz;

@RunWith(SpringRunner.class)
@ContextConfiguration("/beans.xml")
public class saleBizTest {

	@Autowired
	private saleBiz sb;
	@Autowired
	private SaleOrderLineMapper som;
	
	@Test
	public void testqueryAll(){
		List<CusCustomer> list = sb.queryAll();
		System.out.println(list.size());
	}
	
	@Test
	public void testInsert(){
		SaleOrder order=new SaleOrder();
		order.setOdrCustomerId(1);
		order.setOdrCustomerName("中国工业集团");
		order.setOdrDeliverAddr("北京兴华门32号");
		
		Date d=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.format(d));
		order.setOdrDeliverDate(format.format(d));
		order.setOdrOrderDate(format.format(d));
		order.setOdrStatus("fdds");
		System.out.println("---------------"+sb.insertOrder(order)+""+order.getOdrId());
	}
	
	//一对多查询
	@Test
	public void testmany(){
		//som.selectByOrderId(1);
		SaleOrder order = sb.queryManyByOid(1);
		System.out.println(order);
		
	}
	
	@Test
	public void testadd(){
		SaleOrderLine sol=new SaleOrderLine();
		sol.setOdlOrderId(2);
		sol.setOdlProductCount(1);
		sol.setOdlProductName("GPS");
		sol.setOdlProductPrice(Double.valueOf(3300+""));
		sb.addProduct(sol);
	}
}
