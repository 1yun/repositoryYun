package com.yc.saleBiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.sale.bean.CusCustomer;
import com.yc.sale.bean.SaleOrder;
import com.yc.sale.bean.SaleOrderLine;
import com.yc.sale.bean.SaleOrderLineExample;
import com.yc.sale.dao.CusCustomerMapper;
import com.yc.sale.dao.SaleOrderLineMapper;
import com.yc.sale.dao.SaleOrderMapper;

@Service
@Transactional
public class saleBiz {
	
	@Autowired
	private CusCustomerMapper ccm;
	
	@Autowired
	private SaleOrderMapper som;
	@Autowired
	private SaleOrderLineMapper solm;
	
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
		//首先根据所要插入的商品进行查询 如果 当前订单  中有此商品 则进行更新此订单中商品数量
			//否则直接插入即可
		System.out.println(orderLine);
		SaleOrderLineExample sole=new SaleOrderLineExample();
		sole.createCriteria().andOdlOrderIdEqualTo(orderLine.getOdlOrderId()).andOdlProductNameEqualTo(orderLine.getOdlProductName());
		List<SaleOrderLine> list=solm.selectByExample(sole);
		//如果有 一定是一条 否则没有
		if(list==null||list.size()<=0){
			//如果没有直接插入
			solm.insert(orderLine);
		}else
		{
			int increase=list.get(0).getOdlProductCount();
			orderLine.setOdlProductCount(orderLine.getOdlProductCount()+increase);
			solm.updateByExampleSelective(orderLine, sole);
		}
		
		
	}
	
	
	
	
	//删除订单详细信息
	public int deleteOrderLine(int id){
		int i = solm.deleteByPrimaryKey(id);
		return i;
	}
}	
