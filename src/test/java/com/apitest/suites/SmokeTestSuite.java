package com.apitest.suites;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;
import com.apitest.test.UserTest;

@Suite
@SelectClasses({UserTest.class})
@IncludeTags("smoke")
public class SmokeTestSuite {
}
