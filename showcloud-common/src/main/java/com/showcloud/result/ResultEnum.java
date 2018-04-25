package com.showcloud.result;

public enum ResultEnum {
	SUCCESS(1,"success"),AUTHFAIL(0,"auth fail");
	
	private int code;
	private String msg;
	
	private ResultEnum(int code,String msg){
		this.setCode(code);
		this.setMsg(msg);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
