package com.myform.test.configuration;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;


public class TestProfileJPAConfig implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static PostgreSQLContainer postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:14-alpine")
                    .withDatabaseName("db_test_testing")
                    .withUsername("postgres")
                    .withPassword("root");

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        TestPropertyValues.of(
                "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                "spring.datasource.password=" + postgreSQLContainer.getPassword()
        ).applyTo(applicationContext.getEnvironment());
    }


}