package com.showcloud.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
@EnableTransactionManagement(proxyTargetClass=true)
public class DataSourceConfig {
	
	@Autowired
	private DbProperties configurationProperties;
	
	@Bean
	@Primary
	public DataSource dataSource() throws SQLException {		
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl(configurationProperties.getUrl());
		druidDataSource.setUsername(configurationProperties.getUsername());
		druidDataSource.setPassword(configurationProperties.getPassword());
		druidDataSource.setInitialSize(configurationProperties.getInitialSize());
		druidDataSource.setMinIdle(configurationProperties.getMinIdle());
		druidDataSource.setMaxActive(configurationProperties.getMaxActive());
		druidDataSource.setMaxWait(configurationProperties.getMaxWait());
		druidDataSource.setTimeBetweenEvictionRunsMillis(configurationProperties.getTimeBetweenEvictionRunsMillis());
		druidDataSource.setMinEvictableIdleTimeMillis(configurationProperties.getMinEvictableIdleTimeMillis());
		druidDataSource.setValidationQuery(configurationProperties.getValidationQuery());
		druidDataSource.setTestWhileIdle(configurationProperties.isTestWhileIdle());
		druidDataSource.setTestOnBorrow(configurationProperties.isTestOnBorrow());
		druidDataSource.setTestOnReturn(configurationProperties.isTestOnReturn());
		druidDataSource.setPoolPreparedStatements(configurationProperties.isPoolPreparedStatements());
		druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(
				configurationProperties.getMaxPoolPreparedStatementPerConnectionSize());
		try{
			druidDataSource.setFilters(configurationProperties.getFilters());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return druidDataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		//sqlSessionFactoryBean.setTypeAliasesPackage("com.showcloud.api");

		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("/config/mybatis-config.xml"));
		PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		//多服务单数据源或者多服务多数据源的时候这里注意配置
		sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath*:com/showcloud/dao/mapper/*Mapper.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	/**
	 * 使用SqlSessionTemplate代替官方提供的mapper接口方式
	 */
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		
		return new SqlSessionTemplate(sqlSessionFactory(),ExecutorType.BATCH);
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws SQLException {
		
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("loginUsername", "issume");
        reg.addInitParameter("loginPassword", "123@issume");
       reg.addInitParameter("allow", "127.0.0.1");
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }

}