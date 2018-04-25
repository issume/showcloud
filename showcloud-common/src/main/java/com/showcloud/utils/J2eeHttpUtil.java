package com.showcloud.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hym
 * @Date: Create in 2016/11/7
 * @Description:
 */
public class J2eeHttpUtil {

    public static Map<String, Object> getParameterMap(HttpServletRequest request) {
        Enumeration<String> rnames = request.getParameterNames();
        Map<String, Object> map = null;
        if (rnames != null) {
            map = new HashMap<String, Object>();
            for (Enumeration<String> e = rnames; e.hasMoreElements();) {
                String thisName = e.nextElement().toString();               
                String thisValue = request.getParameter(thisName);
                if (StringUtils.isNotEmpty(thisValue)) {
                    map.put(thisName, thisValue);
                }
            }
        }
        return map;
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
    }

    public static HttpServletResponse getResponse() {
        return ((ServletWebRequest)(ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
    }

}
