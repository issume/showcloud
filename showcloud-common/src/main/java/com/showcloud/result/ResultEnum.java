package com.showcloud.result;

public enum ResultEnum {
    SUCCESS("0000", "success"),
    AUTHFAIL("0001", "auth fail"),
    ERROR("0002", "ERROR");
    private String code;
    private String msg;

    private ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
