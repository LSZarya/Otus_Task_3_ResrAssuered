package User.сreateUser;

import dto.User;
import dto.UserOut;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import jdk.jfr.Name;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.UserApi;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;


public class CreateUserTest {

    @Test
    @Name("Тест отправляет пустой запрос POST запрос (данные NULL), ожидает получить статус 200, время теста до 2500 млсек. и проверяет соответствие схемы, и поле code на int = 200")
    public void checkCreateUser(){
        User user = User.builder().build();

        UserApi userApi = new UserApi();

        userApi.createUser(user)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(2500L))
                .body("code",equalTo(200))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/User.json"));
    }

    @Test
    @Name("Тест проверяет response userType = unknown, полный запрос \"UserOut(code=200, message=0, type=unknown)\", и поле code на int = 200")
    public void checkCreateUserAllParams(){
        User user = User.builder()
                .email("email")
                .firstName("firstName")
                .lastName("lastName")
                .build();

        UserApi userApi = new UserApi();

        Response response = userApi.createUser(user);

        UserOut userOut = response.then().log().all().extract().as(UserOut.class);

        String userType = "unknown";

        Assertions.assertEquals(userType, userOut.getType());

        Assertions.assertEquals("UserOut(code=200, message=0, type=unknown)", userOut.toString());

        Assertions.assertEquals(200, userOut.getCode());
    }
}
