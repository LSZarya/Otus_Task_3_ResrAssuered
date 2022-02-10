package ru.otus.qa.services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.otus.qa.models.UserModel;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ArrayUserApi {

    private static final String BASE_URI = "https://petstore.swagger.io/v2/";
    private final RequestSpecification spec;
    private static final String USER_POST = "/user/createWithArray";

    public ArrayUserApi() {
        spec = given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON);
    }

    // We need array list or something, that extend list and implements toString
    public Response createWithArrayUser(List<UserModel> user) {
        return given(spec)
                .body(user)
                .log().all()
                .when()
                .post(USER_POST);
    }
}
