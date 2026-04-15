package com.apitest.suites;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;
import com.apitest.test.ParamDemoTest;
import com.apitest.test.CsvFileParamTest;

@Suite
@SelectClasses({
    ParamDemoTest.class,
    CsvFileParamTest.class
})
public class RegressionTestSuite {
}
