package com.reqres.in.userlistinfo;

import com.reqres.in.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteTest extends TestBase {

    @Test
    public void deleteTheStudent(){
        given().log().all()
                .pathParam("id", 8)
                .when()
                .delete("/{id}")
                .then().log().all()
                .statusCode(204);
    }
}
