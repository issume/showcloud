package com.showcloud.exception;


/**
 * @author hym
 * 自定义runtime Exception
 */
public class ShowCloudException extends  RuntimeException {

    public ShowCloudException(){
        super("showCloudException");
    }
    
    public ShowCloudException(String msg){
        super(msg);
    }
    
    public ShowCloudException(Throwable err,String msg){
    	super(msg, err);
    }
}
