package com.example.pizzaproject;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Sql(config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
@TestPropertySource(locations = "classpath:applicationTest.properties")
@Transactional
public abstract class InMemoryTest {
}
