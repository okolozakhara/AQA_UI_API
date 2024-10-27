package org.example;

import io.restassured.RestAssured;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.api.UnicornRequests;
import org.example.api.models.Unicorn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SimpleTest {

    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/5db6f6055bcc42e198f0349b952e96ed";
    }

    @Test
    public void userShouldBeAbleCreateUnicorn() {

        Unicorn unicorn = new Unicorn("Pegas1", "Purple");
        UnicornRequests.createUnicorn(unicorn.toJson());
    }

    @Test
    public void userShouldBeAbleToDeleteUnicorn() {
        Unicorn unicorn = new Unicorn("Pegas2", "Purple2");
        String id = UnicornRequests.createUnicorn(unicorn.toJson());

        UnicornRequests.deleteUnicorn(id);
        given()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }

    @Test
    public void userShouldBeAbleToChangeColor() {
        Unicorn unicorn = new Unicorn("Pegas11", "Purple");
        String id = UnicornRequests.createUnicorn(unicorn.toJson());

        UnicornRequests.changeColor(id, "Pink");
        given()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("color", equalTo("Pink"));

    }


}
