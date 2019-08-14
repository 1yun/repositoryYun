package com.yc.saleBiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.sale.bean.CusCustomer;
import com.yc.sale.bean.SaleOrder;
import com.yc.sale.bean.SaleOrderLine;
import com.yc.sale.dao.CusCustomerMapper;
import com.yc.sale.dao.SaleOrderMapper;

@Service
@Transactional
public class saleBiz {
	
	@Autowired
	private CusCustomerMapper ccm;
	
	@Autowired
	private SaleOrderMapper som;
	
	//查询所有的用户
	public List<CusCustomer> queryAll(){
		return  ccm.selectByExample(null);
	}
	//插入订单
	public int insertOrder(SaleOrder order){
		//对于非空字段 不做更新     可以获得自增长的id号
		return som.insertSelective(order);
	}
	
	//进行一对多查询
	public  SaleOrder queryManyByOid(int orderId){
		SaleOrder order = som.queryManyByOid(orderId);
		return order;
	}
	//增加商品到订单中
	public void addProduct(SaleOrderLine orderLine){
		
		
	}
}	
