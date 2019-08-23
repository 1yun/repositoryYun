
package com.yc.blog.vo;

//结果对象 ajax调用  返回结果对象
public class Result {

	private int Code;
	private String msg;
	private Object data;
	private resultEnum resultEnum;
	
	
	public Result(int code, String msg) {
		super();
		Code = code;
		this.msg = msg;
	}

	//失败  或者异常
	public Result(resultEnum resultEnum) {
		this.Code=resultEnum.getFlag();
		this.msg=resultEnum.getInfo();
	}
	
	//成功 
	public Result(resultEnum resultEnum,Object data) {
		this.Code=resultEnum.getFlag();
		this.msg=resultEnum.getInfo();
		this.data=data;
	}
	public int getCode() {
		return Code;
	}
	public void setCode(int code) {
		Code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public resultEnum getResultEnum() {
		return resultEnum;
	}
	public void setResultEnum(resultEnum resultEnum) {
		this.resultEnum = resultEnum;
	}
	
	
	
}
