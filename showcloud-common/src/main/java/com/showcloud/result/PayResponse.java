package com.showcloud.result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WangIJia on 2016/12/7.
 * 支付响应
 */
public class PayResponse {

    /**
     * 微信支付返回消息给微信服务器
     * @throws IOException
     * */
    public void sendPayMsgToWx(HttpServletResponse response, String msg) throws IOException{

        StringBuffer sbf = new StringBuffer();

        sbf.append("<xml>");
        sbf.append("<return_code><![CDATA["+msg.toUpperCase()+"]]></return_code>");
        sbf.append("<return_msg><![CDATA[OK]]></return_msg>");

        sbf.append("</xml>");

        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(sbf.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }
}
