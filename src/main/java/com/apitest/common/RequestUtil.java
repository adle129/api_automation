package com.apitest.common;

import com.apitest.config.ConfigManager;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class RequestUtil {
    public static Response get(String path, Map<String, String> headers) {
        String url = ConfigManager.getBaseUrl() + path;
        LogUtil.info("GET ==> " + url);

        Response resp = given()
                .headers(headers)
                .when()
                .get(url)
                .then()
                .extract().response();

        LogUtil.info("Response Code: " + resp.statusCode());
        LogUtil.debug("Response Body: " + resp.asString());
        return resp;
    }

    public static Response post(String path, Object body, Map<String, String> headers){
        String url = ConfigManager.getBaseUrl() + path;
        LogUtil.info("POST => " + url);
        LogUtil.debug("Request Body: " + body);

        Response resp = given()
                .headers(headers)
                .body(body)
                .log().all()
                .when()
                .post(url)
                .then()
                .log().all()
                .extract().response();

        LogUtil.info("Response Code: " + resp.statusCode());
        return resp;

    }
    
    public static Response delete(String path, Object body, Map<String,String> headers) {
        String url = ConfigManager.getBaseUrl() + path;
        LogUtil.info("DELETE => " + url);
        LogUtil.debug("Request Body: " + body);
        
        Response resp = given()
                .headers(headers)
                .body(body)
                .when()
                .delete(url)
                .then()
                .extract().response();
        
        LogUtil.info("Response Code: " + resp.statusCode());
        return resp;
    }





}
