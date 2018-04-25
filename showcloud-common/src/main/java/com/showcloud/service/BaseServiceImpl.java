package com.showcloud.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.showcloud.common.Page;
import com.showcloud.dao.BaseDao;

/**
 * Created by WangIJia on 2016/10/25.
 */
public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK>{

    @Autowired
    protected BaseDao<T, PK> baseDao;

    /**
     * 保存实体
     *
     * @param entity
     * @return
     */
    @Override
    public T save(T entity) {
        return baseDao.save(entity);
    }

    /**
     * 更新实体
     *
     * @param entity
     * @return
     */
    @Override
    public int update(T entity) {
        return baseDao.update(entity);
    }

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPk(PK id) {
        return baseDao.deleteByPk(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public int batchDeleteByPks(List<PK> ids) {
        return baseDao.batchDeleteByPks(ids);
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return T
     */
    @Override
    public T listByPK(PK id) {
        return baseDao.listByPK(id);
    }

    /**
     * 根据唯一条件查询
     *
     * @param identifier
     * @param params
     * @return List<T>
     */
    @Override
    public T listOne(String identifier, Map<String, Object> params) {
        return baseDao.listOne(identifier,params);
    }

    /**
     * 根据唯一条件查询
     *
     * @param entity
     * @return List<T>
     */
    @Override
    public T listOne(T entity) {
        return baseDao.listOne(entity);
    }


    /**
     * @param listView
     * @param countView
     * @param params    @return Page<T>
     * @throws
     * @Description: 分页查询列表
     * @Author: 王佳
     * @date 2016年9月9日
     */
    @Override
    public Page<T> listByPage(String listView, String countView, Map<String, Object> params) {
        return baseDao.listByPage(listView,countView,params);
    }

	@Override
	public int updateSelective(T entity) {
		return this.baseDao.updateSelective(entity);
	}

	@Override
	public Integer updateselectByIds(Map<String, Object> params) {
		
		return this.baseDao.updateselectByIds(params);
	}

    /**
     * @param entityList
     * @return Page<T>
     * @throws
     * @Description: 批量保存
     * @Author: 王佳
     * @date 2017年2月16日
     */
    @Override
    public Integer batchSave(List<T> entityList) {
        return baseDao.batchSave(entityList);
    }
    
    /**批量删除
     * 2017年4月15日 下午6:14:55
     * TODO
     * @author hym
     */
    @Override
    public int deleteByIds(String ids){
    	return baseDao.deleteByIds(ids);
    }    
    
    @Override
    public int countView(Map<String, Object> params){
    	return baseDao.countView(params);
    }
}
