package apiLayers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIFactory {

    public String getProducts() {

        RestAssured.baseURI = "http://localhost:3000";
        Response response = given()
                        .when()
                        .get("/products");

        return response.prettyPrint();

    }
}
