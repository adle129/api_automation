package com.apitest.test;

import com.apitest.common.LogUtil;
import com.apitest.base.BaseTest;
import com.apitest.wrapper.UserWrapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest extends BaseTest {
    @Test
    @Order(1)
    @Tag("smoke")
    public void test_getUserList(){
        LogUtil.info("用例： 获取用户列表");
        Response resp = UserWrapper.getUserList();
        assertEquals(resp.statusCode(),200);
        assertTrue(resp.jsonPath().getList("$").size() > 0);

    }

    @Test
    @Order(2)
    public void test_getUserList2(){
        LogUtil.info("用例： 获取用户列表");
        Response resp = UserWrapper.getUserById(0);
        assertEquals(resp.statusCode(),200);
        assertTrue(resp.jsonPath().getList("$").size() > 0);

    }




}
