package com.rdb.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public final class ELKUtils {

    private ELKUtils() {
    }

    public static void sendDetailsToElk(String testname, String status) {
        HashMap<String, String> map = new HashMap<>();
        map.put("testName", testname);
        map.put("status", status);
        map.put("executionTime", LocalDateTime.now().toString());

        Response response = given()
                .contentType(ContentType.JSON)
                .body(map)
                .post("http://localhost:9200/automation-results/_doc");

        Assert.assertEquals(response.statusCode(), 201);
        response.prettyPrint();
    }

}
