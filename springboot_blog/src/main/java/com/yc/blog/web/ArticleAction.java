package com.yc.blog.web;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.blog.Biz.ArticleBiz;
import com.yc.blog.Biz.CategoryBiz;
import com.yc.blog.bean.Article;
import com.yc.blog.bean.Category;

@Controller
public class ArticleAction {

	@Resource
	private ArticleBiz abiz;
	
	@Resource
	private CategoryBiz cbiz;
	
	@ModelAttribute("cList")  //modelattribute 放在方法上是初始化  返回值会自动放到model中
	public List<Category> init(){
		return cbiz.queryCategoryAll();
	}
	
	//查询首页
	@GetMapping("index")
	public String index(@RequestParam(defaultValue="1")int page,Model model){
		//最新文章
		model.addAttribute("aList", abiz.queryNewArticle(page));		
		return "index";
	}
	//分类文章
	@GetMapping("category")
	public String category(@RequestParam(defaultValue="1")int page,
			int id,Model model){
		model.addAttribute("aList", abiz.queryByCategory(id, page));
		return "category";
	}
	
	/**
	 * 通过id查询文章
	 * */
	@GetMapping("article")
	public String queryArticle(int id,Model model){
		Article a = abiz.read(id);
		
		//查相关文章
		List<Article> relativeList=abiz.queryRelative(a.getCategoryid());
		model.addAttribute("relativeList",relativeList);
		//不设定model中的属性名称  则默认类名小写开头为该属性名称
		model.addAttribute(a);
		
		
		
		
		return "article";
	}
	
	
	
}
