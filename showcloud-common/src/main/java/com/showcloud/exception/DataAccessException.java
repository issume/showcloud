package com.showcloud.exception;

/**
 * @author hym
 *  数据层数据异常
 */
public class DataAccessException extends RuntimeException {

	public DataAccessException(){
		
	}
	
	public DataAccessException(String msg){
		super(msg);
	}	
	
}
