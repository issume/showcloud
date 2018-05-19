package com.showcloud.code.common;

import java.util.List;

public class Column {

	private Integer index;
	private String name;
	private String fieldName;
	private String methodName;
	private String desc;
	private Type type;
	private String default_;
	private String isPK = "no";
	private String allowNull = "no";
	private Boolean hasNext = true;

	/**
	 * 基本参数的构造
	 * 
	 * @author hym
	 * @time 2017年7月20日 下午7:37:27
	 * @param index
	 * @param fieldName
	 * @param type
	 */
	public Column(Integer index, String fieldName, Type type) {
		this.index = index;
		this.fieldName = fieldName;
		this.type = type;
	}

	/**
	 * 构造校验
	 * 
	 * @author hym
	 * @time 2017年7月22日 下午5:19:20
	 * @param tab
	 * @param index
	 * @param defs
	 * @param isColMap
	 */
	public Column(String tab, int index, List<Object> defs, Boolean isColMap) {
		int size = defs.size();
		this.index = index;
		if (size < 2) {
			throw new RuntimeException("表'" + tab + "'的第'" + index + "'字段没有定义字段名");
		}
		name = (String) defs.get(1);
		if (name == null || name.trim().length() == 0) {
			throw new RuntimeException("表'" + tab + "'的第'" + index + "'字段没有定义字段名");
		}
		desc = (String) defs.get(2);
		if (size < 4) {
			throw new RuntimeException("表'" + tab + "'的'" + name + "'字段没有定义类型");
		}
		String typeStr = (String) defs.get(3);
		if (typeStr == null || typeStr.trim().length() == 0) {
			throw new RuntimeException("表'" + tab + "'的'" + name + "'字段没有定义字类型");
		}
		typeStr = typeStr.trim().toLowerCase();
		type = Type.get(typeStr);
		if (type == null) {
			throw new RuntimeException("表'" + tab + "'的'" + name + "'字段类型定义错误");
		}
		fieldName = format();
		if (size >= 6) {
			default_ = defs.get(5).toString().trim();
			if (default_.length() == 0) {
				default_ = null;
			}
		}
		if (size >= 7) {
			isPK = defs.get(6).toString().trim().toLowerCase();
			if (isPK.length() == 0) {
				isPK = "no";
			}
		}
		if (size >= 8) {
			allowNull = defs.get(7).toString().trim().toLowerCase();
			if (allowNull.length() == 0) {
				allowNull = "no";
			}
		}

	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getName() {
		return new StringBuffer(name).toString();
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	private String format() {
		String _name = this.getName();
		int idx = -1;
		while ((idx = _name.indexOf("_")) != -1) {
			String pre = _name.substring(0, idx);
			String tmpSuf = _name.substring(idx + 1).trim();
			String suf_ = "";
			if (tmpSuf.length() > 0) {
				String suf = tmpSuf.substring(0, 1).toUpperCase();
				if (tmpSuf.length() > 1) {
					suf_ = suf + tmpSuf.substring(1);
				} else {
					suf_ = suf;
				}
			}
			_name = pre + suf_;
		}
		methodName = _name.substring(0, 1).toUpperCase() + _name.substring(1);
		return _name.substring(0, 1).toLowerCase() + _name.substring(1);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDefault() {
		return default_;
	}

	public void setDefault(String default_) {
		this.default_ = default_;
	}

	public String getIsPK() {
		return isPK;
	}

	public void setPK(String isPK) {
		this.isPK = isPK;
	}

	public String getIsAllowNull() {
		return allowNull;
	}

	public void setAllowNull(String allowNull) {
		this.allowNull = allowNull;
	}

	public Boolean getHasNext() {
		return hasNext;
	}

	public void setHasNext(Boolean hasNext) {
		this.hasNext = hasNext;
	}

}
