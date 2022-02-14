package User.CreateUser;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.otus.qa.GET_user_logout.OutLogout;
import ru.otus.qa.Specification.Specifications;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static ru.otus.qa.services.UserLogoutApi.*;

public class UserLogoutTest {

    @Test
    public void UserLogoutTestOk(){
        Specifications.ConfigureRestAssured();

        get(USER_LOGOUT_GET)
                .then()
                .log().body()
                .body("code", notNullValue())
                .body("code", equalTo(200))
                .body("type", notNullValue())
                .body("type", equalTo("unknown"))
                .body("message", notNullValue())
                .body("message", equalTo("ok"))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/User.json"));
    }

    @Test
    public void UserLogoutTestResponse(){
        Specifications.ConfigureRestAssured();

        Long code = 200L;
        String type = "unknown";
        String message = "ok";

        OutLogout outLogout1 = OutLogout.builder().code(code).message(message).type(type).build();

        OutLogout outLogout = get(USER_LOGOUT_GET).then().log().status().log().body().extract().as(OutLogout.class);

        Assert.assertEquals(code, outLogout.getCode());
        Assert.assertEquals(type, outLogout.getType());
        Assert.assertEquals(message, outLogout.getMessage());

        Assert.assertEquals("200", outLogout.getCode().toString());

        Assert.assertEquals(outLogout, outLogout1);
    }
}
