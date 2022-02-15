package ru.otus.qa.Specification;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class SpecificationsNew {

    public static void ConfigureRestAssured() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.requestSpecification = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().method()
                .log().uri()
                .log().body();

        RestAssured.responseSpecification = given()
                .expect()
                .statusCode(HttpStatus.SC_OK)
                .expect()
                .time(lessThan(3000L));
    }
}
