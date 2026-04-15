package com.apitest.base;

import com.apitest.config.ConfigManager;
import org.junit.jupiter.api.*;
import com.apitest.extension.TestLogExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertAll;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestLogExtension.class)
public class BaseTest {
    @BeforeAll
    public void beforeAll(){
        ConfigManager.loadEnv();
    }

    @BeforeEach
    public void beforeEach(){

    }

    @AfterEach
    public void afterEach(){

    }

    @AfterAll
    public void afterAll(){

    }

    public void assertPolicyResponse(String status, String policyNo) {
        assertAll("保单信息校验",
                () -> Assertions.assertEquals("INSURED", status),
                () -> Assertions.assertNotNull(policyNo),
                () -> Assertions.assertTrue(policyNo.startsWith("POL"))
        );
    }







}
