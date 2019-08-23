package com.yc.blog.web;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.yc.blog.Biz.ArticleBiz;
import com.yc.blog.Biz.CategoryBiz;
import com.yc.blog.bean.Article;
import com.yc.blog.bean.Category;
import com.yc.blog.bean.User;

@Controller
public class ArticleAction {

	@Resource
	private ArticleBiz abiz;
	
	@Resource
	private CategoryBiz cbiz;
	
	
	//从一个方法转到另外一个方法  forward:方法   但是不能携带参数
				//return 方法(arg1,arg2);

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
	public String queryArticle(@RequestParam(defaultValue="1")int page,int id,Model model){
		Article a = abiz.read(id);
		PageHelper.startPage(page,5);
		a.getComments();  //查询评论
		//查相关文章
		List<Article> relativeList=abiz.queryRelative(a.getCategoryid());
		model.addAttribute("relativeList",relativeList);
		//不设定model中的属性名称  则默认类名小写开头为该属性名称
		model.addAttribute(a);
	
		return "article";
	}

	@GetMapping("toedit")
	public String toedit(Model model){
		model.addAttribute("article", new Article());
		return "articleEdit";
	}
	
	
	@PostMapping("saveArticle")
	public String save(Article article,Model model,@SessionAttribute("loginedUser") User user){
		article.setAuthor(user.getName());
		article.setCreatetime(new Date());
		abiz.save(article);
		//返回方法跳转页面
		return queryArticle(1,article.getId(),model);
	}
	/**
	 * ckeditor 文件上传接口要求返回一段js代码
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * */
	@PostMapping("upload")
	@ResponseBody
	public String upload(@RequestParam("upload")MultipartFile file,
			String CKEditorFuncNum) throws IllegalStateException, IOException{
		String fname = file.getOriginalFilename();
		File desk = new File("f:/blog/images/" + fname);
		file.transferTo(desk);
		// 拼接 回调js代码
		String js = "<script type=\"text/javascript\">";
		js += "window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'images/"+fname+"','')";
		js += "</script>";
		
		return js;
	}
	
}
