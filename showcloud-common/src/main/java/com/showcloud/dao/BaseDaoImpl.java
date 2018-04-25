package com.showcloud.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.showcloud.common.Page;
import com.showcloud.result.CommonParam;
import com.showcloud.utils.StringUtil;

public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T,PK> {

    @Autowired
    protected SqlSession sqlSession;

    /**
     * 当前T的类型
     */
    private Class<T> entityClass;

    public BaseDaoImpl() {
        this.entityClass = null;
        Class c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type)
                    .getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }

    /**
     * 保存实体
     *
     * @param entity
     * @return
     */
    @Override
    public T save(T entity) {    
        sqlSession.insert(MessageFormat.format("{0}.insertSelective", entityClass.getName()),entity);
        return entity;
    }

    /**
     * 更新实体
     *
     * @param entity
     * @return
     */
    @Override
    public int update(T entity) {
        return sqlSession.update(MessageFormat.format("{0}.updateByPrimaryKey", entityClass.getName()),entity);
    }

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPk(PK id) {
        return sqlSession.delete(MessageFormat.format("{0}.deleteByPrimaryKey", entityClass.getName()),id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public int batchDeleteByPks(List<PK> ids) {
        return sqlSession.delete(MessageFormat.format("{0}.batchDeleteByPks", entityClass.getName()),ids);
    }
    

    @Override
    public int deleteByIds(String ids) {
        return sqlSession.delete(MessageFormat.format("{0}.deleteByIds", entityClass.getName()),ids);
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return T
     */
    @Override
    public T listByPK(PK id) {
        return sqlSession.selectOne(MessageFormat.format("{0}.selectByPrimaryKey", entityClass.getName()),id);
    }

    /**
     * 根据唯一条件查询
     * @param identifier
     * @param params
     * @return List<T>
     */
    @Override
    public T listOne(String identifier, Map<String, Object> params) {
        return sqlSession.selectOne(MessageFormat.format("{0}."+identifier, entityClass.getName()), params);
    }

    /**
     * 根据唯一条件查询
     *
     * @param entity
     * @return List<T>
     */
    @Override
    public T listOne(T entity) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(StringUtil.firstLower(entityClass.getSimpleName()),entity);

        return  sqlSession.selectOne(MessageFormat.format("{0}.list"+entityClass.getSimpleName(), entityClass.getName()), params);
    }
    /**
     * 查询所有
     *
     * @param identifier
     * @param params
     * @return List<T>
     */
    @Override
    public List<T> listAllByParam(String identifier, Map<String, Object> params) {
        return this.sqlSession.selectList(MessageFormat.format("{0}."+identifier, entityClass.getName()), params);
    }


    @Override
    public Page<T> listByPage(String listView, String countView,
                              Map<String, Object> params) {
        Page<T> page = new Page<T>();

        List<T> datas = this.sqlSession.selectList(MessageFormat.format("{0}."+listView, entityClass.getName()), params);
        page.setDatas(datas);
        page.setOffset(CommonParam.getOffSet());
        page.setPageSize(CommonParam.getPageSize());

        Integer totalRecord =  this.sqlSession.selectOne(MessageFormat.format("{0}."+countView, entityClass.getName()), params);
        page.setTotalCount(totalRecord);

        return page;
    }
    
    

    /**
     * 根据主键更新实体中部分字段
     */
	@Override
	public int updateSelective(T entity) {
		return sqlSession.update(MessageFormat.format("{0}.updateByPrimaryKeySelective", entityClass.getName()),entity);
	}

	@Override
	public Integer updateselectByIds(Map<String, Object> params) {
		
		return sqlSession.update(MessageFormat.format("{0}.updateselectByIds", entityClass.getName()),params);
	}


    @Override
    public Integer batchSave(List<T> entityList) {

        return sqlSession.insert(MessageFormat.format("{0}.insertBatch", entityClass.getName()), entityList);
    }
    
    @Override
    public int countView(Map<String, Object> params){
    	 Integer totalRecord =  this.sqlSession.selectOne(MessageFormat.format("{0}.countView", entityClass.getName()), params);
    	 return totalRecord;
    }

}
