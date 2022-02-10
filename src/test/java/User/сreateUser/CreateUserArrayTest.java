package User.сreateUser;

import io.restassured.response.Response;
import jdk.jfr.Name;
import org.junit.jupiter.api.Test;
import ru.otus.qa.models.UserModel;
import ru.otus.qa.services.ArrayUserApi;

import java.util.ArrayList;
import java.util.List;

public class CreateUserArrayTest {

    @Test
    @Name("")
    public void checkCreateUser() {
        ArrayUserApi arrayUserApi = new ArrayUserApi();
        List<UserModel> userListToCrete = new ArrayList<>() {{
            add(UserModel.builder().email("email").build());
        }};

        Response response = arrayUserApi.createWithArrayUser(userListToCrete);


//        Unknown class ArrayUserOut, so commit this
//        ArrayUserOut arrayUserOut = response.then().log().all().extract().as(ArrayUserOut.class);

        System.out.println(response.then().extract().body().asString());

        String userType = "unknown";

//        System.out.println(arrayUserOut);
//        Assertions.assertEquals(userType, arrayUserOut.getType());
    }

    @Test
    @Name("")
    public void checkCreateUser1(){

    }
}
