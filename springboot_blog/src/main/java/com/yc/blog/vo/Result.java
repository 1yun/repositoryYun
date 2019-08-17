
package com.yc.blog.vo;

//结果对象 ajax调用  返回结果对象
public class Result {

	private int Code;
	private String msg;
	private Object data;
	public Result(int code, String msg) {
		super();
		Code = code;
		this.msg = msg;
	}
	public Result(int code, String msg, Object data) {
		super();
		Code = code;
		this.msg = msg;
		this.data = data;
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
	
}
