package com.reqres.in.userlistinfo;

import com.reqres.in.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserGetTest extends TestBase {


    @Test
    public void getAllUserInfo(){
        Response response= given()
                .when()
                .get("/users");
        response.prettyPrint();
        response.then().statusCode(200);

    }

    @Test
    public void getUserSingleInfo(){
        Response response = given()
                .pathParam("id", 8)
                .when()
                .get("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }



}
