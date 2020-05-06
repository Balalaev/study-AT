package edu.technoserv.apitest;

import edu.technoserv.apitest.users.NewUser;
import edu.technoserv.apitest.users.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;


public class APITest {

    @Test
    public void getUsers() {
        Response resp = RestAssured.get("https://reqres.in/api/users?page=2");

        String json = resp.getBody().asString();

        List<User> userList = Arrays.asList(from(json).getObject("data", User[].class));

        for (User user : userList) {
            Assert.assertNotNull(user.getId());
            Assert.assertNotNull(user.getEmail());
            Assert.assertNotNull(user.getFirst_name());
            Assert.assertNotNull(user.getLast_name());
            Assert.assertNotNull(user.getAvatar());
        }
    }

    @Test
    public void createNewUser() {
        String userName = "morpheus";
        String userJob = "leader";

        NewUser morpheus = new NewUser(userName, userJob);
        Response resp = given()
                .contentType("application/json")
                .body(morpheus)
                .when()
                .post("https://reqres.in/api/users");

        NewUser userResp = resp.as(NewUser.class);

        Assert.assertEquals(userResp.getName(), userName);
        Assert.assertEquals(userResp.getJob(), userJob);
    }
}
