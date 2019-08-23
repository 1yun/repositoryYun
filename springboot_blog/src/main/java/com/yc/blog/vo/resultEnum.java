package com.yc.blog.vo;


public enum resultEnum {
	
	LOGIN(-2,"请先登录"),
	FAILURE(-1,"评论失败"),
	EXCEPTION(0,"系统异常"),
	SUCCESS(1,"发送成功"),
	LOGIN_SUCCESS(2,"登录成功"),
	LOGIN_FAILURE(-3,"登录失败");
	private int flag;
    private String info;
    
	private resultEnum(int flag, String info) {
		this.flag = flag;
		this.info = info;
	}
	
	public int  getFlag(){
		return flag;
	}
	public String getInfo(){
		return info;
	}
	
	public static resultEnum stateOf(int index)
    {
        for (resultEnum state : values())
        {
            if (state.getFlag()==index)
            {
                return state;
            }
        }
        return null;
    }
	
}
