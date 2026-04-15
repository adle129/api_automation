package com.apitest.extension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.api.extension.ExtensionContext;
import com.apitest.common.LogUtil;

public class TestLogExtension implements TestWatcher{
    @Override
    public void testFailed(ExtensionContext context,Throwable cause){
            LogUtil.error("=======Test Failed =======");
            LogUtil.error("Test Case: " + context.getDisplayName());
            LogUtil.error("Failed Reasion: " + cause.getMessage(),cause);

    }

    @Override
    public void testSuccessful(ExtensionContext context){
        LogUtil.info("=======Test Successed =======");
        LogUtil.info("Test Case: " + context.getDisplayName());
    }

}
