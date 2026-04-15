package com.apitest.test;
import com.apitest.base.BaseTest;
import com.apitest.common.LogUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class CsvFileParamTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(
            resources = "/testdata/user_data.csv",  // 文件路径
            numLinesToSkip = 1,   // 跳过第一行表头
            encoding = "UTF-8"
    )
    @DisplayName("从 CSV 文件读取数据：name={0}, phone={1}, expect={2}")
    void testReadFrmomCsvFile(String name,String phone,String expectStatus){

        LogUtil.info("name = " + name +  " phone = " + phone + " expect = " + expectStatus);

        // 断言
        assertEquals("成功", expectStatus);

    }
    
}
