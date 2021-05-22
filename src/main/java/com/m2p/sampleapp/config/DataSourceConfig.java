package com.m2p.sampleapp.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "postgres-datasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "h2-datasource")
    @ConfigurationProperties(prefix = "spring.datasource-h2")
    public DataSource h2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("h2-db")
    public NamedParameterJdbcTemplate h2jdbcTemplate(@Qualifier("h2-datasource") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }



}
