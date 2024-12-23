package com.reqres.in.userlistinfo;

import com.reqres.in.model.UserPojo;
import com.reqres.in.testbase.TestBase;
import com.reqres.in.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {

    @Test
    public void createUser() {

        String email = TestUtils.getRandomValue() + "alexpatel@gmail.com";


        UserPojo userPojo = new UserPojo();
        userPojo.setFirstName("Alex");
        userPojo.setLastName("Patel");
        userPojo.setEmail(email);
        userPojo.setAvatar("https://reqres.in/img/faces/11-im");


        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post();
        response.prettyPrint();
        response.then().statusCode(201);



    }

    @Test
    public void loginSuccessfulUser(){



        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body("{ \"email\": \"alexpatel11@gmail.com\", \"password\": \"cityslicka\"}")
                .post("/api/login");
        response.prettyPrint();
        response.then().statusCode(201);

    }
}
