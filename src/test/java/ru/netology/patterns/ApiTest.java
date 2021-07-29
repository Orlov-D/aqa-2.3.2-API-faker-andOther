package ru.netology.patterns;

import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {

    public static class User {
        private  String login="vasya";
        private  String password="password";
        private  String status="active";
    }

        private static RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(9999)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        @BeforeAll
        static void setUpAll() {
            Gson gson = new Gson();
            User user = new User();
            given() // "дано"
                    .spec(requestSpec) // указываем, какую спецификацию используем
                    .body(gson.toJson(user)) // передаём в теле объект, который будет преобразован в JSON
            .when() // "когда"
                    .post("/api/system/users") // на какой путь, относительно BaseUri отправляем запрос
            .then() // "тогда ожидаем"
                    .statusCode(200); // код 200 OK
        }
//    ToDo ...
@Test
    public void Pip(){

}
}
