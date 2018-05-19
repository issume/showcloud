package com.showcloud.common;

import java.io.Serializable;
import java.util.List;


/**
 * @author hym
 * 分页对象的封装
 * @param <T>
 */
public class Page<T> implements Serializable{

    /**
     * 起始偏移量
     */
    private Integer offset;

    /**
     * 页大小
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Integer totalCount;

    /**
     * 数据
     */
    private List<T> datas;
    

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
