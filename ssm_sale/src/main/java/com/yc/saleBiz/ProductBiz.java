package com.yc.saleBiz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.sale.bean.SaleProduct;
import com.yc.sale.dao.SaleProductMapper;

@Service
@Transactional
public class ProductBiz {
	@Resource
	private SaleProductMapper spm;
	
	//查询所有的商品
	public List<SaleProduct> queryProductAll(){
		return spm.selectByExample(null);
	}
}
