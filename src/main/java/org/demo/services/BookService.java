package org.demo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.demo.model.Requests.UserRequest;
import org.demo.model.Response.BooksResponse;
import org.demo.model.Response.UserResponse;

import java.util.HashMap;
import java.util.Map;

import static org.demo.utils.HttpClientUtils.sendGetRequest;

public class BookService {

    ObjectMapper objectMapper = new ObjectMapper();
    public Response getBooks() {
        Map<String, String> headers = new HashMap<>();
        headers.put("accept:","application/json");
        Response response = sendGetRequest("https://demoqa.com","/BookStore/v1/Books",headers, null, null);
        return response;
    }

    public String getBooksIsbn(Response response) throws JsonProcessingException {
        BooksResponse booksResponse = objectMapper.readValue(response.getBody().asString(), BooksResponse.class);
        return  booksResponse.getBooks().get(0).getIsbn();
    }
}
