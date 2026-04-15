package com.apitest.wrapper;

import com.apitest.common.RequestUtil;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class UserWrapper {
    private static final Map<String,String> HEADERS = new HashMap<>();
    static {
        HEADERS.put("Content-Type","application/json");
    }

    public static Response getUserList(){
        return RequestUtil.get("/users", HEADERS);
    }

    public static Response getUserById(int id) {
        return RequestUtil.get("/users/" + id, HEADERS);

    }

    public static Response createUser(Object body){
        return RequestUtil.post("/users",body,HEADERS);
    }


}
