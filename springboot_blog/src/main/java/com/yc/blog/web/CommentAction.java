package com.yc.blog.web;

import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.blog.Biz.CommentBiz;
import com.yc.blog.bean.Comment;
import com.yc.blog.bean.User;
import com.yc.blog.vo.Result;
import com.yc.blog.vo.resultEnum;

@RestController
public class CommentAction {

	@Resource
	private CommentBiz cbiz;

	@PostMapping("comment")
	public Result comment(@Valid Comment comm,
			//required=false  并不是必须  如果不加 则认为是必须 如果session中没有则属性 会报错
			Errors errors,@SessionAttribute(name="loginedUser",required=false)User user){
		/*
		 * 评论数更新
		 * 运行期异常的捕获
		 * @SessionAttribute 从session中取出当前属性
		 * */
		
		//设置评论人的id
		comm.setCreateby(user.getId());
		//设置创建时间
		comm.setCreatetime(new Date());
		if(errors.hasErrors()){
			return new Result(resultEnum.FAILURE,errors.getAllErrors());
		}
		
		try{
			cbiz.comment(comm);
			return new Result(resultEnum.SUCCESS,comm);
		}catch(RuntimeException e){
			e.printStackTrace();
			return new Result(resultEnum.EXCEPTION);
		}
		
	
	}
	
}
