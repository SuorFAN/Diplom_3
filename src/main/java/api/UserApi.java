package api;

import config.ApiPathEnum;
import config.RestAssuredConfig;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import model.entity.User;

import java.io.File;

import static io.restassured.RestAssured.given;

/**
 * GET https://stellarburgers.nomoreparties.site/api/auth/user
 */
public class UserApi {

    @Step("Создание пользователя с телом {0}")
    public Validatable<ValidatableResponse, Response> createUser(String body) {

        return given()
                .spec(RestAssuredConfig.requestSpecification())
                .body(body)
                .when()
                .post(ApiPathEnum.REGISTER.getTitle());
    }

    @Step("Авторизация пользователя с телом {0}")
    public Validatable<ValidatableResponse, Response> login(String body) {

        return given()
                .spec(RestAssuredConfig.requestSpecification())
                .body(body)
                .when()
                .post(ApiPathEnum.LOGIN.getTitle());
    }


    @Step("Запрос на пользователя с токеном {0} и телом {1}")
    public Validatable<ValidatableResponse, Response> user(String accessToken, String body) {

        return given()
                .header("Authorization", accessToken)
                .spec(RestAssuredConfig.requestSpecification())
                .body(body)
                .when()
                .patch(ApiPathEnum.USER.getTitle());
    }

    @Step("Запрос на пользователя с телом {0}")
    public Validatable<ValidatableResponse, Response> user(File body) {

        return given()
                .spec(RestAssuredConfig.requestSpecification())
                .body(body)
                .when()
                .patch(ApiPathEnum.USER.getTitle());
    }

    @Step("Удалить пользователя с токеном {0}")
    public Validatable<ValidatableResponse, Response> deleteUser(String token) {
        return given()
                .header("Authorization", token)
                .spec(RestAssuredConfig.requestSpecification())
                .when()
                .delete(ApiPathEnum.USER.getTitle());
    }

    public void deleteUser(User user) {
        if (this.login(user.toStringLogin()).then().extract().response().statusCode() == 200) {
            String token=this.login(user.toStringLogin())
                    .then()
                    .statusCode(200)
                    .extract()
                    .response().path("accessToken");
            this.deleteUser(token)
                    .then()
                    .statusCode(202);
        }
    }
}