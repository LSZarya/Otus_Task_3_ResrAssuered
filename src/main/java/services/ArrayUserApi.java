package services;

import ArrayUser.ArrayUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ArrayUserApi {

    private static final String BASE_URI = "https://petstore.swagger.io/v2/";
    private final RequestSpecification spec;
    private static final String USER_POST = "/user/createWithArray";

    public ArrayUserApi(){
        spec = given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON);
    }

    public Response  createWithArrayUser(ArrayUser user){
        return given(spec)
                .body(user)
                .log().all()
                .when()
                .post(USER_POST);
    }
}
