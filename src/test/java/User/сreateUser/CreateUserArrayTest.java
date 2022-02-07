package User.сreateUser;

import ArrayUser.ArrayUser;
import ArrayUser.UserMass;
import jdk.jfr.Name;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import services.ArrayUserApi;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class CreateUserArrayTest {

    @Test
    @Name("")
    public void checkCreateUser(){

        ArrayUser arrayUser = ArrayUser.builder().userStatus(200L).build();

        UserMass userMass = UserMass.builder().ArrayUser(arrayUser).build();

        ArrayUserApi userMassApi = new ArrayUserApi();

        userMassApi.createWithArrayUser(userMass)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(2500L))
                .body("code",equalTo(500));
    }
}
