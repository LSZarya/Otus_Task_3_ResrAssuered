package User.New;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.otus.qa.Pet.Pet1;
import ru.otus.qa.Specification.SpecificationsNew;

import static io.restassured.RestAssured.get;

public class Pet {
    @BeforeTest
    public void setUp(){
        SpecificationsNew.ConfigureRestAssured();
    }


    @Test
    public void UserListTestRequestListUser() {
    Pet1 pet = get("https://petstore.swagger.io/v2/pet/1")
            .then()
            .log().all()
            .extract()
            .body()
            .as(Pet1.class);

        String pet1 = get("https://petstore.swagger.io/v2/pet/1")
                .then()
                .log().all()
                .extract()
                .body()
                .jsonPath()
                .getString("$..id");

        String pet2 = get("https://petstore.swagger.io/v2/pet/2")
                .then()
                .log().all()
                .extract()
                .body()
                .jsonPath()
                .getString("$..id");


        System.out.println(pet1);
    }
}
