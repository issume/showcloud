package com.showcloud.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.showcloud.common.Page;

/**
 * @author hym
 *
 * @param <T>
 * @param <PK>
 */
public interface BaseDao<T, PK extends Serializable> {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @return
	 */
	public T save(T entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 * @return
	 */
	public int update(T entity);

	/**
	 * 根据主键更新实体中部分字段 2016年12月3日 下午10:31:48 
	 * 
	 * @author hym
	 */
	public int updateSelective(T entity);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteByPk(PK id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	public int batchDeleteByPks(List<PK> ids);

	/**
	 * 根据主键查询
	 * 
	 * @return T
	 */
	public T listByPK(PK id);

	/**
	 * 根据唯一条件查询
	 * 
	 * @param identifier
	 * @param params
	 * @return List<T>
	 */
	public T listOne(String identifier, Map<String, Object> params);
	

	/**
	 * 根据唯一条件查询
	 * 
	 * @param entity
	 * @return List<T>
	 */
	public T listOne(T entity);
	

	/**
	 * 查询所有
	 * 
	 * @return List<T>
	 */
	public List<T> listAllByParam(String identifier, Map<String, Object> params);

	/**
	 * 分頁查詢
	 * @param listView
	 * @param countView
	 * @param params
	 * @return
	 * @author hym
	 * @time 2018年4月24日 下午5:29:10
	 * @return Page<T>
	 */
	public Page<T> listByPage(String listView, String countView, Map<String, Object> params);

	/**
	 * 多主键选择性更新对象 in方法实现,需要注意sql 注入問題 2016年12月28日 下午4:10:09 TODO
	 * 
	 * @author hym
	 */
	public Integer updateselectByIds(Map<String, Object> params);

	/**
	 * 批量保存
	 * 
	 * @author hym
	 * @time 2018年4月24日 下午5:27:03
	 * @return Integer
	 */
	public Integer batchSave(List<T> entityList);

	/**
	 * 批量删除用ids 2017年4月15日 下午6:14:27 TODO
	 * 
	 * @author hym
	 */
	public int deleteByIds(String ids);

	/**
	 * 统计 2017年5月20日 下午5:28:20 TODO
	 * 
	 * @author hym
	 */
	public int countView(Map<String, Object> params);

}
