package com.apitest.config;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.apitest.common.LogUtil;

public class ConfigManager {
    // 全局环境变量
    public static String baseUrl;
    public static String env;
    public static final Properties props = new Properties();

    static {

        try (InputStream is = ConfigManager.class.getClassLoader()
                .getResourceAsStream("config/application.properties")){

            if (is == null) {
                LogUtil.error("配置文件 application.properties 未找到！");
                throw new RuntimeException("配置文件不存在");
            }
            props.load(is);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String getBaseUrl() {
        return props.getProperty("api.base.url");
    }
    public static int getTimeout() {
        return Integer.parseInt(props.getProperty("api.timeout"));
    }

    public static void loadEnv() {
        // 这里你以后可以改成读取 properties 文件
        env = System.getProperty("env");
        baseUrl = getBaseUrl();
        LogUtil.info("==================== 环境信息 ====================");
        LogUtil.info("当前运行环境：" + env);
        LogUtil.info("接口地址：" + baseUrl);
        LogUtil.info("超时时间：" + getTimeout() + "ms");
    }
    
    
}
