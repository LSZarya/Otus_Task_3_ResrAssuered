package User.CreateUser;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.otus.qa.Specification.Specifications;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static ru.otus.qa.services.UserLoginApi.*;

public class UserLoginTest {

    @BeforeTest
    public void setUp(){
        Specifications.ConfigureRestAssured();
    }

    @Test
    public void UserLoginTestOk(){

        get(USER_LOGIN_GET)
                .then()
                .log().all()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/User.json"));
    }

    @DataProvider(name = "dara-provider")
    public Object[][] dataProviderMethod(){
        return new Object[][]{{"1" , "2"},
                {"3" , "4"},
                {" " , " "},
                {"" , ""}};
    }

    @Test(dataProvider = "dara-provider")
    public void UserLogoutTestDataProvider(String name, String password){

        System.out.println("USERNAME= " + name + " PASSWORD= " + password);
        get(USERNAME + name + PASSWORD + password)
                .then()
                .log().body()
                .body("code", equalTo(200))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/User.json"));
    }

}
