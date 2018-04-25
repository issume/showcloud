package com.showcloud.result;

/**
 * Created by WangIJia on 2016/10/26.
 * 共用参数封装、简化查询
 * 线程
 */
public class CommonParam {

    /**
     * 分页偏移量
     */
    private static ThreadLocal<Integer> offSet = new ThreadLocal<Integer>();

    /**
     * 分页页大小
     */
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

    /**
     * 排序条件
     */
    private static ThreadLocal<String> orderCondition = new ThreadLocal<String>();

    /**
     * 排序方向
     */
    private static ThreadLocal<String> orderDirection = new ThreadLocal<String>();

    /**
     * accessToken
     */
    private static ThreadLocal<String> accessToken = new ThreadLocal<String>();

    /**
     * 集团code
     */
    private static ThreadLocal<String> shopGroupCode = new ThreadLocal<String>();

    public static Integer getOffSet() {
        return offSet.get();
    }

    public static void setOffSet(Integer offSet) {
        CommonParam.offSet.set(offSet);
    }

    public static Integer getPageSize() {
        return pageSize.get();
    }

    public static void setPageSize(Integer pageSize) {
        CommonParam.pageSize .set(pageSize);
    }

    public static String getOrderCondition() {
        return orderCondition.get();
    }

    public static void setOrderCondition(String orderCondition) {
        CommonParam.orderCondition.set(orderCondition);
    }

    public static String getOrderDirection() {
        return orderDirection.get();
    }

    public static void setOrderDirection(String orderDirection) {
        CommonParam.orderDirection.set(orderDirection);
    }

    public static String getAccessToken() {
        return accessToken.get();
    }

    public static void setAccessToken(String accessToken) {
        CommonParam.accessToken.set(accessToken);
    }


    public static String getShopGroupCode() {
        return shopGroupCode.get();
    }

    public static void setShopGroupCode(String shopGroupCode) {
        CommonParam.shopGroupCode.set(shopGroupCode);
    }


    public static void removeOffSet() {
        CommonParam.offSet.remove();
    }

    public static void removePageSize() {
        CommonParam.pageSize.remove();
    }

    public static void removeOrderCondition() {
        CommonParam.orderCondition.remove();
    }

    public static void removeOrderDirection() {
        CommonParam.orderDirection.remove();
    }

    public static void removeAccessToken() {
        CommonParam.accessToken.remove();
    }

    public static void removeShopGroupCode() {
        CommonParam.shopGroupCode.remove();
    }
}
