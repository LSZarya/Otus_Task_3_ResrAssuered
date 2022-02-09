package User.сreateUser;

import ArrayUser.*;
import io.restassured.response.Response;
import jdk.jfr.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.ArrayUserApi;

public class CreateUserArrayTest {

    @Test
    @Name("")
    public void checkCreateUser(){
        ArrayUser arrayUser = ArrayUser.builder().email("email").build();

        ArrayUserApi arrayUserApi = new ArrayUserApi();

        Response response = arrayUserApi.createWithArrayUser(arrayUser);

        ArrayUserOut arrayUserOut = response.then().log().all().extract().as(ArrayUserOut.class);

        String userType = "unknown";
        System.out.println(arrayUserOut);
        Assertions.assertEquals(userType, arrayUserOut.getType());
    }

    @Test
    @Name("")
    public void checkCreateUser1(){

    }
}
