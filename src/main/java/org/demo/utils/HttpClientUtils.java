package org.demo.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class HttpClientUtils {


    public static Response sendGetRequest(String base_uri, String end_point, Map<String, String> headers, Map<String, String> queryParams, Map<String, String> pathParams){
        RequestSpecification requestSpecification = RestAssured.given().log().all().headers(headers);

        if(queryParams !=null && !queryParams.isEmpty()){
            requestSpecification.queryParams(queryParams);
        }
        if(pathParams !=null && pathParams.isEmpty()){
            requestSpecification.pathParams(pathParams);
        }

        Response response = requestSpecification.when().get(base_uri+end_point).thenReturn();
        response.prettyPrint();
        return  response;
    }

    public static Response sendPostRequest(String base_uri, String end_point, String body, Map<String, String> headers, Map<String, String> queryParams, Map<String, String> pathParams){
        RequestSpecification requestSpecification = RestAssured.given().log().all().headers(headers);

        if(queryParams !=null && !queryParams.isEmpty()){
            requestSpecification.queryParams(queryParams);
        }
        if(pathParams !=null && pathParams.isEmpty()){
            requestSpecification.pathParams(pathParams);
        }

        Response response = requestSpecification.when().body(body).post(base_uri+end_point).thenReturn();
        response.prettyPrint();
        return  response;
    }
}
