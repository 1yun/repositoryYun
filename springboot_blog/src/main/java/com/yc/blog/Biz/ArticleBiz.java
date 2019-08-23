package com.yc.blog.Biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.yc.blog.bean.Article;
import com.yc.blog.bean.ArticleExample;
import com.yc.blog.dao.ArticleMapper;

@Service
public class ArticleBiz {
	
	@Autowired
	public ArticleMapper am;
	
	/**
	 * 查询最新发布的文章
	 * page 页数
	 * */
	public List<Article> queryNewArticle(int page){
		ArticleExample example=new ArticleExample();
		//通过条件语句进行排序
		example.setOrderByClause("createtime desc");
		PageHelper.startPage(page, 5);
		//数据库中有个字段是longtext 数据内容太长 一般方法查不出来  所以需要用blob方法
		return am.selectByExampleWithBLOBs(example);
	}
	
	//根据分类id进行分页查询文章
	public List<Article> queryByCategory(int id,int page){
		ArticleExample example=new ArticleExample();
		example.createCriteria().andCategoryidEqualTo(id);
		example.setOrderByClause("createTime desc");
		PageHelper.startPage(page, 5);
		//数据库中有个字段是longtext 数据内容太长 一般方法查不出来  所以需要用blob方法
		return am.selectByExampleWithBLOBs(example);
	}
		
	//查询阅读的博文
	@Transactional   //加入事务注解
	public Article read(int id) {
		ArticleExample example=new ArticleExample();
		example.createCriteria().andIdEqualTo(id);
		Article a=am.selectByPrimaryKey(id);
		//更新阅读次数  可能一开始为null   +号的优先级高于三元运算符
		a.setReadcnt((a.getReadcnt() == null ? 0 : a.getReadcnt()) + 1);
		am.updateByPrimaryKey(a);   //因为之前在xml中BaseResultMap设置的关联查询   所以所有的方法有默认的有关联查询
		return a;
		
	}
	
	public List<Article> queryRelative(Integer categoryid){
		ArticleExample example=new ArticleExample();
		example.setOrderByClause("createTime desc");
		//查询相关类别的文章 前10个记录
		example.createCriteria().andCategoryidEqualTo(categoryid);
		//用分页查10个记录
		PageHelper.startPage(1,10);
		return am.selectByExample(example);
	}

	public void save(Article article) {
			am.insert(article);
	}


	
	

}
