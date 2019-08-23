package com.yc.blog.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.blog.vo.Result;
import com.yc.blog.vo.resultEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class enumTest {

	@Test
	public void test(){
		Result r=new Result(resultEnum.SUCCESS);
		System.out.println(resultEnum.stateOf(1).getInfo());
		System.out.println(r.getCode());
		System.out.println(r.getMsg());
		System.out.println(r.getResultEnum());
	}
}
