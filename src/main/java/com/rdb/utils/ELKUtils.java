package com.rdb.utils;

import com.rdb.enums.ConfigProperties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public final class ELKUtils {

    private static final String SENDLOGSTOELK = PropertyUtils.getValue(ConfigProperties.SENDLOGSTOELK);

    private ELKUtils() {
    }

    public static void sendDetailsToElk(String testname, String status) {
        if (SENDLOGSTOELK.equalsIgnoreCase("yes")) {
            HashMap<String, String> map = new HashMap<>();
            map.put("testName", testname);
            map.put("status", status);
            map.put("executionTime", LocalDateTime.now().toString());

            Response response = given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(map)
                    .post("http://localhost:9200/selenium-automation-logs/_doc");

            Assert.assertEquals(response.statusCode(), 201);
            response.prettyPrint();
        }
    }

    public static void deleteAllPreviousLogsFromIndex() {
        if (SENDLOGSTOELK.equalsIgnoreCase("yes")) {
            String payload = """
                    {
                        "query": {
                            "match_all": {}
                        }
                    }
                    """;

            Response response = given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .post("http://localhost:9200/selenium-automation-logs/_delete_by_query");

            Assert.assertEquals(response.statusCode(), 200);
            response.prettyPrint();
        }
    }

}
