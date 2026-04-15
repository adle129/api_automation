package com.apitest.test;

import com.apitest.base.BaseTest;
import io.qameta.allure.*;
import com.apitest.common.LogUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("参数化测试演示")
public class ParamDemoTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "张三, 13800138000",
            "李四, 13900139000",
            "王五, 13700137000"
    })
    @DisplayName("参数化测试：姓名={0}, 手机号={1}")
    @Feature("用户模块")
    @Story("批量注册")
    @Severity(SeverityLevel.NORMAL)
    void testWithParameters(String name, String phone) {
        LogUtil.info("姓名：" + name + "，手机号：" + phone);

        // 简单断言
        assertNotNull(name);
        assertNotNull(phone);
    }




}
