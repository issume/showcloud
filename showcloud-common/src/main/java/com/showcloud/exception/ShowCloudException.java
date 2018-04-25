package com.showcloud.exception;

/**
 * @Author hym
 * @Date: Create in 2016/11/4
 * @Description:
 */
public class ShowCloudException extends  Exception {

    public ShowCloudException(){
        super("weidianException");
    }
    public ShowCloudException(String msg){
        super(msg);
    }
}
