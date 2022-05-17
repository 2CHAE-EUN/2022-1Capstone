package com.capstone.configuration;

// DB 연동을 위한 환경설정

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.yml") // /는 src/main/resources를 의미한다.
public class DBConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    // Hikari 설정 1
    // @Bean : 리턴되는 객체를 IoC 컨테이너에 등록
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig(){ // 환경 설정 객체
        return new HikariConfig();
    }

    // Hikari 설정 2 : Hikari 객체를 받아서 데이터 소스 객체 생성
    // Hikari DataSource : DBCP을 활용해 실제 데이터베이스에 연결하는 역할
    @Bean
    public DataSource dataSource(){ // 객체를 생성

        DataSource dataSource = new HikariDataSource( hikariConfig() );
        System.out.println(dataSource.toString());

        return dataSource;
    }

    // MyBatis 설정 1 : SqlSessionFactory 객체 생성 <-- SqlSessionFactoryBean
    //
    @Bean
    public SqlSessionFactory sqlSessionFactory( DataSource dataSource ) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean(); // factoryBean이 SqlSessionFactory 객체를 생성한다.

        factoryBean.setDataSource( dataSource );
        factoryBean.setMapperLocations( applicationContext.getResources("classpath:/**/*Mapper.xml"));
        // classpath는 src/main/resources이다.
        // 여러 개의 Mapper를 사용할 수 있기 때문에 *를 사용해서 모든 xml 파일로 설정할 수 있다. ( + 폴더 추가 가능 )
        factoryBean.setTypeAliasesPackage("com.capstone.DTO");

        return factoryBean.getObject();
    }

    // MyBatis 설정 2 : SqlSessionTemplate <-- SqlSessionFactory
    @Bean
    public SqlSessionTemplate sqlSessionTemplate( SqlSessionFactory sqlSessionFactory ) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
