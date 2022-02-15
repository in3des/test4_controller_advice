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
                "spring.datasource.url = jdbc:tc:postgresql:14-alpine://db_test_testing",
                "spring.datasource.driver-class-name = org.testcontainers.jdbc.ContainerDatabaseDriver")
                .applyTo(applicationContext.getEnvironment());
    }


}