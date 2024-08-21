package org.demo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.demo.model.Requests.AddBookRequest;
import org.demo.model.Requests.CollectionOfIsbnsItem;
import org.demo.model.Requests.UserRequest;
import org.demo.model.Response.TokenResponse;
import org.demo.model.Response.UserResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.demo.utils.HttpClientUtils.sendPostRequest;

public class UserService {

   ObjectMapper objectMapper = new ObjectMapper();

    public Response createUser(String userName, String password) throws JsonProcessingException {
        UserRequest userRequest = UserRequest.builder().userName(userName).password(password).build();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        Response response = sendPostRequest("https://demoqa.com","/Account/v1/User",objectMapper.writeValueAsString(userRequest),headers, null, null);
        return response;
    }

    public String getUserId(Response response) throws JsonProcessingException {
        UserResponse userResponse = objectMapper.readValue(response.getBody().asString(), UserResponse.class);
        return  userResponse.getUserID();
    }

    public Response generateUserToken(String userName, String password) throws JsonProcessingException {
        UserRequest userRequest = UserRequest.builder().userName(userName).password(password).build();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        Response response = sendPostRequest("https://demoqa.com","/Account/v1/GenerateToken",objectMapper.writeValueAsString(userRequest),headers, null, null);
        return response;
    }

    public String getUserToken(Response response) throws JsonProcessingException {
        TokenResponse tokenResponse = objectMapper.readValue(response.getBody().asString(), TokenResponse.class);
        return  tokenResponse.getToken();
    }

    public Response addBookToUseAccount(String userId, String isbn, String token) throws JsonProcessingException {
        AddBookRequest addBookRequest = AddBookRequest.builder().userId(userId).collectionOfIsbns(List.of(CollectionOfIsbnsItem.builder().isbn(isbn).build())).build();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Authorization","Bearer " + token);
        Response response = sendPostRequest("https://demoqa.com","/BookStore/v1/Books",objectMapper.writeValueAsString(addBookRequest),headers, null, null);
        return response;
    }
}
