<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">  
  
<mapper namespace="${packageName}.entity.${className}">  
    <resultMap id="BaseResultMap" type="${packageName}.entity.${className}">  
        <#list columns as column>  
            <#if column.isPK="yes">             
            <id property="id" column="${column.name}" />  
            <#else>     
            <result property="${column.fieldName}" column="${column.name}" />  
            </#if>  
        </#list>  
    </resultMap>  
      
    <sql id="Base_Column_List">  
        <#list columns as column>  
            <#if column.isPK="yes">  
            ${column.name}<#if column.hasNext>,</#if>  
            <#else>  
            ${column.name}<#if column.hasNext>,</#if>  
            </#if>  
        </#list>  
    </sql>  
      
    <sql id="Where_Clause_Id">  
        <#list columns as column>  
        <#if column.isPK="yes">                     
        and ${column.name} = ${r"#{"}${column.fieldName}${r"}"}       
        </#if>  
        </#list>  
    </sql>  
      
    <sql id="Where_Clause_Normal">  
        <#list columns as column>  
            <#if column.isPK="no">  
            <if test="${column.fieldName} !=  null">  
                and ${column.name}=${r"#{"}${column.fieldName}${r"}"}   
            </if>  
            </#if>  
        </#list>  
    </sql>  
    <!--根据主键查询 -->  
    <select id="selectByPrimaryKey" parameterType="java.lang.String" resultMap="BaseResultMap">        
        select   
        <include refid="Base_Column_List" />  
        from ${tableName}  
        <where>  
            <include refid="Where_Clause_Id" />  
        </where>  
   </select>  
   <!--根据主键删除 -->  
   <delete id="deleteByPrimaryKey" parameterType="java.lang.String">     
    delete from ${tableName}  
    <where>  
        <include refid="Where_Clause_Id" />  
    </where>  
  </delete>  
  <!--新增保存 -->  
  <insert id="insert" parameterType="${packageName}.entity.${className}" keyProperty="id">  
        INSERT INTO ${tableName}  
        (  
        <include refid="Base_Column_List" />  
        )  
        VALUES(  
            <#list columns as column>               
            ${r"#{"}${column.fieldName}${r"}"}<#if column.hasNext>,</#if>         
            </#list>  
        )  
   </insert>  
   <!--选择性保存-->  
  <insert id="insertSelective" parameterType="${packageName}.entity.${className}">  
    INSERT INTO ${tableName}  
    <trim prefix="(" suffix=")" suffixOverrides=",">  
        <#list columns as column>  
        <if test="${column.fieldName} !=null">  
          ${column.name}<#if column.hasNext>,</#if>  
        </if>  
        </#list>  
    </trim>  
    <trim prefix="values (" suffix=")" suffixOverrides=",">  
        <#list columns as column>  
        <if test="${column.fieldName} !=null">  
          ${r"#{"}${column.fieldName}${r"}"}<#if column.hasNext>,</#if>  
        </if>  
        </#list>  
    </trim>    
  </insert>  
  <!--根据主键选择性更新部分字段 -->  
  <update id="updateByPrimaryKeySelective" parameterType="${packageName}.entity.${className}">      
    update ${tableName}  
    <set>  
      <#list columns as column>  
        <if test="${column.fieldName} !=null">  
          ${column.name} = ${r"#{"}${column.fieldName}${r"}"}<#if column.hasNext>,</#if>  
        </if>  
       </#list>  
    </set>  
    <where>  
        <include refid="Where_Clause_Id" />  
    </where>  
  </update>  
    
  <select id="listAllByParam" parameterType="java.util.Map" resultMap="BaseResultMap">  
    select   
    <include refid="Base_Column_List" />  
    from ${tableName}  
    <where>  
        <#list columns as column>  
        <if test="${column.fieldName} !=null">  
        and ${column.name} = ${r"#{"}${column.fieldName}${r"}"}  
        </if>  
        </#list>  
    </where>  
  </select>  
    
  <update id="updateselectByIds" parameterType="java.util.Map" >  
  update   
   <set>  
    <#list columns as column>  
    <if test="${column.fieldName} !=null">  
     ${column.name}=${r"#{"}${column.fieldName}${r"}"}<#if column.hasNext>,</#if>  
    </if>  
    </#list>  
   </set>  
    where <![CDATA[ id in (${r"#{"}idsIn${r"}"}) ]]>  
  </update>  
    
  <select id="listDatas" parameterType="java.util.Map" resultMap="BaseResultMap">  
    select   
    <include refid="Base_Column_List" />  
    from ${tableName}  
    <where>  
        <include refid="Where_Clause_Normal" />  
    </where>  
    <if test="orderCondition != null" >  
      order by ${r"#{"}orderCondition${r"}"},${r"#{"}orderDirection${r"}"}  
    </if>  
    <if test="offSet!=null" >  
      limit ${r"#{"}offSet${r"}"},${r"#{"}pageSize${r"}"}  
    </if>  
  </select>  
    
   <select id="countDatas"  resultType="java.lang.Integer">  
    select count(id)  
    from ${tableName}  
    <where>  
        <include refid="Where_Clause_Normal" />  
    </where>  
   </select>  
</mapper>  