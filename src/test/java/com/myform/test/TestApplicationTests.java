package com.myform.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@AutoConfigureMockMvc
@Sql(scripts = "/scripts/cleanup_data.sql",
    executionPhase = BEFORE_TEST_METHOD)
@SpringBootTest
class TestApplicationTests{

    @Test
    void contextLoads() {
    }

}
