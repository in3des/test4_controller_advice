package com.myform.test;

import com.myform.test.configuration.TestProfileJPAConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@AutoConfigureMockMvc
@Sql(scripts = "/scripts/cleanup_data.sql",
    executionPhase = BEFORE_TEST_METHOD)
@SpringBootTest
@ContextConfiguration(initializers = {TestProfileJPAConfig.class})
class TestApplicationTests {

    @Test
    void contextLoads() {
    }

}
