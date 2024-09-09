package com.gilasw.notification.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@EnableTransactionManagement
@EnableMBeanExport(registration= RegistrationPolicy.IGNORE_EXISTING)
public class PostgresDataSourceConfig extends HikariConfig {

    public static final String DATASOURCE_TX_MANAGER = "transactionManager";
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(this);
    }

    @Bean
    @Qualifier(DATASOURCE_TX_MANAGER)
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
