package User.CreateUser;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.otus.qa.models.UserModel;
import ru.otus.qa.models.UserModelOut;
import ru.otus.qa.services.ArrayUserApi;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

public class CreateUserArrayTest {

    @Test(description = "Тест отправляет POST запрос (/user/createWithArray), получает ответ и сравнивает с актуальным ответом")
    public void checkCreateUser() {

        Long code = 200L;
        String type = "unknown";
        String message = "ok";

        UserModelOut userModelOutActual  = UserModelOut.builder().code(code).message(message).type(type).build();

        ArrayUserApi arrayUserApi = new ArrayUserApi();

        List<UserModel> userListToCrete = new ArrayList<UserModel>() {{
            add(UserModel.builder().email("email").build());
        }};

        Response response = arrayUserApi.createWithArrayUser(userListToCrete);

        UserModelOut userModelOutExtern = response.then().extract().as(UserModelOut.class);

        Assert.assertEquals(userModelOutActual, userModelOutExtern);
    }

    @Test(description = "Тест отправляет POST запрос (/user/createWithArray), проверяет время работы и соответствие ответа схме")
    public void checkCreateUser1(){

        UserModel userModel = UserModel
                .builder()
                .id(123L)
                .email("email")
                .firstName("firstName")
                .lastName("lastName")
                .password("password")
                .phone("phone")
                .username("username")
                .build();

        List<UserModel> userListToCrete = new ArrayList<UserModel>() {{add(userModel);}};

        ArrayUserApi arrayUserApi = new ArrayUserApi();

        arrayUserApi.createWithArrayUser(userListToCrete)
                .then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schema/User.json"))
                .time(lessThan(2500L));
    }
}
