package com.global.config.user;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 用户数据库配置
 *
 * @author troy
 * @date 2018/03/31
 */
@Configuration
public class DruidUserDataSourceConfig {
    static final String MAPPER_LOCATION = "/mybatis/user/*Mapper.xml";

    @Bean(name = "userDataSource" )
    @ConfigurationProperties(prefix = "spring.user-datasource")
    public DataSource BlogDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "userTransactionManager")
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(BlogDataSource());
    }

    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("userDataSource") DataSource masterDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}
