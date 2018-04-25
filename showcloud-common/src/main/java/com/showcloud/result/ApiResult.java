package com.showcloud.result;


/**
 * @author hym
 * 封装Api返回的结果
 */
public class ApiResult {

    /**
     * 全局返回码
     * -1：系统繁忙，此时请开发者稍候再试
     * 0：请求成功
     * 非0：请求失败
     * */
    private int errcode;

    /**
     * 返回消息内容
     * */
    private String errmsg;

    /**
     * api返回的数据
     * */
    private Object result;

    /**
     * api接口版本号
     * */
    private String version;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ApiResult(int errcode, String errmsg, Object result, String version) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.result = result;
        this.version = version;
    }

    public ApiResult(int errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public ApiResult(int errcode, Object result) {
        this.errcode = errcode;
        this.result = result;
    }

    public ApiResult(int errcode, String errmsg,Object result){
        this.errcode=errcode;
        this.errmsg=errmsg;
        this.result=result;
    }

    public ApiResult() {
    }
}
