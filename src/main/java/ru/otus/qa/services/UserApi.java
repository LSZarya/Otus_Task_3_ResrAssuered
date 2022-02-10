package ru.otus.qa.services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.otus.qa.dto.User;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String BASE_URI = "https://petstore.swagger.io/v2/";
    private final RequestSpecification spec;
    private static final String USER_POST = "/user";

    public UserApi(){
        spec = given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON);
    }

    public Response createUser(User user){
        return given(spec)
                .body(user)
                .log().all()
                .when()
                .post(USER_POST);
    }
}
