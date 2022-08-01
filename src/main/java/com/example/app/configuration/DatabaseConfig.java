package com.example.app.configuration;

import com.example.app.common.enums.DbType;
import com.example.app.configuration.database.DynamicRoutingDataSource;
import com.example.app.configuration.properties.DabangDatabaseProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaAuditing
@Slf4j
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
    @Bean(name = "dabangHikariConfig")
    public HikariConfig dabangHikariConfig(DabangDatabaseProperties properties) {
        log.info("Register Bean : dabangHikariConfig");
        return createHikariConfig(
                properties.getDriverClassName(),
                properties.getJdbcUrl(),
                properties.getUsername(),
                properties.getPassword(),
                properties.getPoolSize());
    }

    @Bean(name = "dabangDataSource", destroyMethod = "close")
    public DataSource dabangDataSource(@Qualifier("dabangHikariConfig") HikariConfig config) {
        log.info("Register Bean : dabangDataSource (url ={})", config.getJdbcUrl());
        return new HikariDataSource(config);
    }

    @Bean(name = "routingDataSource")
    @Primary
    public DataSource routingDataSource(@Qualifier("dabangDataSource") DataSource dabangDataSrouce) {
        log.info("Register Bean : routingDataSource");

        DynamicRoutingDataSource routingDataSource = new DynamicRoutingDataSource();

        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DbType.DABANG, dabangDataSrouce);

        routingDataSource.setTargetDataSources(dataSourceMap);
        routingDataSource.setDefaultTargetDataSource(dabangDataSrouce);

        return routingDataSource;
    }

    @Bean(name = "lazyConnectionDataSourceProxy")
    public DataSource lazyConnectionDataSourceProxy(@Qualifier("routingDataSource") DataSource routingDataSource) {
        log.info("Register Bean : lazyConnectionDataSourceProxy");
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("lazyConnectionDataSourceProxy") DataSource lazyConnectionDataSourceProxy) {
        log.info("Register Bean : transactionManager");

        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(lazyConnectionDataSourceProxy);
        transactionManager.setGlobalRollbackOnParticipationFailure(false);

        return transactionManager;
    }

    private HikariConfig createHikariConfig(
            String driverClassName,
            String jdbcUrl,
            String userName,
            String password,
            int poolSize) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setUsername(userName);
        hikariConfig.setPassword(password);
        hikariConfig.setMaximumPoolSize(poolSize);

        return hikariConfig;
    }
}
