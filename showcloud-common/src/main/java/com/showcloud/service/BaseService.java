package com.showcloud.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.showcloud.common.Page;

public interface BaseService<T, PK extends Serializable> {

    /**
     * 
     * 保存实体
     * @param entity
     * @return
     */
    public T save(T entity);

    /**
     * 更新实体
     * @param entity
     * @return
     */
    public int update(T entity);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    public int deleteByPk(PK id);

    /**
     *  批量删除
     * @param ids
     * @return
     */
    public int batchDeleteByPks(List<PK> ids);

    /**
     * 根据主键查询
     * @return T
     */
    public T listByPK(PK id);

    /**
     * 根据唯一条件查询
     * @param identifier
     * @return List<T>
     */
    public T listOne(String identifier, Map<String, Object> params);

    /**
     * 根据唯一条件查询
     * @param entity
     * @return List<T>
     */
    public T listOne(T entity);


    /**
     * @Description: 分页查询列表
     * @param @param params
     * @param @param listView 查询list
     * @param @param countView 统计
     * @param @return
     * @return Page<T>
     * @date 2016年9月9日
     */
    public Page<T> listByPage(String listView, String countView,
                              Map<String, Object> params);
    
    /**根据主键更新实体中的部分内容
     * 2016年12月3日 下午10:55:26
     * TODO
     * @author hym
     */
    public int updateSelective(T entity);
    
    /**多主键选择性更新对象  in方法实现
     * 2016年12月28日 下午4:10:09
     * TODO
     * @author hym
     */
    public Integer updateselectByIds(Map<String, Object> params);

    /**
     * @Description: 批量保存
     * @param @param entityList 实体list
     * @param @return
     * @return Page<T>
     * @date 2017年2月16日
     */
    public Integer batchSave(List<T> entityList);
    
    /**批量删除， 物理删除
     * 2017年4月15日 下午6:16:02
     * TODO
     * @author hym
     */
    public int deleteByIds(String ids);
    
    /**统计
     * 2017年5月20日 下午5:32:45
     * TODO
     * @author hym
     */
    public int countView(Map<String, Object> params);
}
