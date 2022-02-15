package User.New;

import io.restassured.module.jsv.JsonSchemaValidator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.otus.qa.GET_LIST_USERS.Datum;

import ru.otus.qa.GET_LIST_USERS.ListUser;
import ru.otus.qa.GET_LIST_USERS.Support;
import ru.otus.qa.Specification.SpecificationsNew;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static ru.otus.qa.services.GetListUser.LIST_USER;


public class GetListUser {

    @BeforeTest
    public void setUp(){
        SpecificationsNew.ConfigureRestAssured();
    }

    @Test
    public void UserListTest(){
        get(LIST_USER)
                .then()
                .log().all()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/ListUser.json"));
    }

    @Test
    public void UserListTestListData(){
        List<Datum> listUser =
                get(LIST_USER)
                        .then()
                        .extract()
                        .body()
                        .jsonPath()
                        .getList("data", Datum.class);

        System.out.println(listUser);
    }

    @Test
    public void UserListTestRequestListUser(){
//        Class listUser = get(LIST_USER)
//                        .then()
//                        .extract()
//                        .as((Type) ListUser.class);
//
//        System.out.println(listUser);

//        ListUser outLogout = get(LIST_USER)
//                .then()
//                .extract()
//                .body()
//                .jsonPath()
//                .getObject("listUser",ListUser.class);
//
//        System.out.println(outLogout);

        String support = get(LIST_USER)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getString("support.url");

        System.out.println(support);
    }


}
