package com.showcloud.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class XMLUtil {

    private static Logger logger = Logger.getLogger(XMLUtil.class);

    /**
     * 从request中获取xml数据，以流的形式读取数据
     * */
    public static String processXmlParam(HttpServletRequest request) throws IOException {

            int dataLength = request.getContentLength();
            // 读取POST请求内容
            DataInputStream dataStream = new DataInputStream(request.getInputStream());
            byte datas[] = new byte[dataLength];

            int bytes = dataStream.read(datas, 0, dataLength);

            // 将数据译码
            String reqBody = new String(datas);

            reqBody = URLDecoder.decode(reqBody, "UTF8");
            logger.info("微信支付成功回调地址。参数:" + reqBody);

            return reqBody;
    }
}
