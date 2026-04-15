package com.apitest.common;
import java.lang.RuntimeException;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
        LogUtil.error("【接口异常】" + message);
    }


}
