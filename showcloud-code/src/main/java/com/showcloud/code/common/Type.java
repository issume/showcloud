package com.showcloud.code.common;

import java.util.HashMap;

import com.alibaba.druid.util.StringUtils;

public class Type {

	private String sqlType;
	private String javaType;
	private static HashMap<String, String> typeMap = new HashMap<String, String>();

	static {
		// 基本的sql数据类型
		typeMap.put("VARCHAR", "String");
		typeMap.put("CHAR", "String");
		typeMap.put("BLOB", "byte[]");
		typeMap.put("TEXT", "String");
		typeMap.put("INT", "Integer");
		typeMap.put("INT UNSIGNED", "Integer");
		typeMap.put("INTEGER", "Long");
		typeMap.put("INTEGER UNSIGNED", "Long");
		typeMap.put("TINYINT", "Integer");
		typeMap.put("TINYINT UNSIGNED", "Integer");
		typeMap.put("SMALLINT", "Integer");
		typeMap.put("SMALLINT UNSIGNED", "Integer");
		typeMap.put("MEDIUMINT", "Integer");
		typeMap.put("MEDIUMINT UNSIGNED", "Integer");
		typeMap.put("FLOAT", "Float");
		typeMap.put("FLOAT UNSIGNED", "Float");
		typeMap.put("DOUBLE", "Double");
		typeMap.put("BIT", "Boolean");
		typeMap.put("BIGINT", "java.math.BigInteger");
		typeMap.put("DECIMAL", "java.math.BigDecimal");
		typeMap.put("BOOLEAN", "Long");
		typeMap.put("DATE", "java.sql.Date");
		typeMap.put("TIME", "java.sql.Time");
		typeMap.put("DATETIME", "java.sql.Timestamp");
		typeMap.put("TIMESTAMP", "java.sql.Timestamp");
		typeMap.put("YEAR", "java.sql.Date");
		typeMap.put("OTHER", "String");
	}

	/**
	 * @author hym
	 * @time 2017年7月20日 下午5:21:52
	 * @param sqlType
	 * @param javaType
	 */
	public Type(String sqlType, String javaType) {
		this.sqlType = sqlType.toLowerCase();
		this.javaType = javaType;
	}

	public String getSqlType() {
		return sqlType;
	}

	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	/**
	 * 当返回值找不到的时候，直接返回other-string
	 * 
	 * @author hym
	 * @time 2017年7月20日下午5:22:09
	 * @param sqlType
	 * @return
	 */
	public static Type get(String sqlType) {
		String javaType = typeMap.get(sqlType.toUpperCase());
		if (StringUtils.isEmpty(javaType)) {
			javaType = typeMap.get("OTHER");
		}
		Type result = new Type(sqlType, javaType);
		return result;
	}

}
