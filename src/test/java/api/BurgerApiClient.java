package api;

import io.restassured.RestAssured;
import models.User;
import models.UserCredentials;

import static io.restassured.RestAssured.given;

public class BurgerApiClient {
    static {
        RestAssured.baseURI = System.getProperty("base.url", "https://stellarburgers.education-services.ru");
    }

    public void register(User user){
        given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/api/auth/register")
                .then()
                .statusCode(200);
    }

    public String login(String email, String password){
        return given()
                .contentType("application/json")
                .body(new UserCredentials(email, password))
                .when()
                .post("/api/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .path("accessToken");
    }

    public void deleteUser(String accessToken){
        if (accessToken == null || accessToken.isEmpty())
            return;
        given()
                .header("Authorization", accessToken)
                .when()
                .delete("/api/auth/user")
                .then()
                .statusCode(202);
    }
}
