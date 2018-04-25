package com.showcloud.kuaidi;

public enum CompanyCode {
   
	bshd("huitongkuaidi","百世汇通"),
	ytkd("yuantong","圆通快递"),
	stkd("shentong","申通快递"),
	sfkd("shunfeng","顺丰快递"),
	qfkd("quanfengkuaidi","全峰快递"),
	ems("ems","ems快递");
	
	
	
	private String code;	
	private String name;
	
	private CompanyCode(String code,String name){
		this.setCode(code);
		this.setName(name);
	}
	
	public static String getcodebyname(String name){
		for(CompanyCode c:CompanyCode.values()){
			if (name.equals(c.getName())) {
				return c.getCode();
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
