package com.yc.blog.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.blog.bean.Category;
import com.yc.blog.dao.CategoryMapper;

@Service
public class CategoryBiz {

	@Resource
	private CategoryMapper cm;
	
	
	public List<Category> queryCategoryAll(){
		return cm.selectByExample(null);
	}
}
