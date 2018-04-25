package com.showcloud.kuaidi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class KuaiDi100Util {
	
	/**快递100的查询接口
	 * 2017年1月6日 上午11:51:37
	 * TODO
	 * @author hym
	 */
	public static String querybykd100(String key,String orderno,String com){    	
    	String kd100url="http://api.kuaidi100.com/api?id="+key+"&com="+com+"&nu="+orderno+"&show=0&muti=1&order=desc";
    	try{
    		URL url=new URL(kd100url);
    		URLConnection con=url.openConnection();
			 con.setAllowUserInteraction(false);
			   InputStream urlStream = url.openStream();
			   String type = con.guessContentTypeFromStream(urlStream);
			   String charSet=null;
			   if (type == null)
			    type = con.getContentType();
			   if (type == null || type.trim().length() == 0 || type.trim().indexOf("text/html") < 0)
			    return null;
			   if(type.indexOf("charset=") > 0)
			    charSet = type.substring(type.indexOf("charset=") + 8);
			   byte b[] = new byte[10000];
			   int numRead = urlStream.read(b);
			  String content = new String(b, 0, numRead);
			   while (numRead != -1) {
			    numRead = urlStream.read(b);
			    if (numRead != -1) {
			     //String newContent = new String(b, 0, numRead);
			     String newContent = new String(b, 0, numRead, charSet);
			     content += newContent;
			    }
			   }
			   //System.out.println("content:" + content);
			   urlStream.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally {
			
		}    	
    	return "";
    }
	
	/**快递100跳转接口  返回url，将url嵌入页面即可
	 * 2017年1月6日 上午11:51:47
	 * TODO
	 * @author hym
	 */
	public static String jumpkuaidi100(String key,String orderno,String com) throws IOException {
        java.net.URL url = new java.net.URL("http://www.kuaidi100.com/applyurl?key="+key+"&com="+com+"&nu="+orderno);  
        java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();  
        conn.setRequestMethod("POST");  
        conn.setConnectTimeout(5 * 1000);// 设置连接超时时间为5秒  
        conn.setReadTimeout(20 * 1000);// 设置读取超时时间为20秒  
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        String msg = "";// 保存调用http服务后的响应信息  
        // 如果请求响应码是200，则表示成功  
        if (conn.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));  
            msg = in.readLine();  
            in.close();  
        }  
        conn.disconnect();
        return msg;  
    }  
}
