package apiLayers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import routes.APIRoutes;

import static io.restassured.RestAssured.given;

public class APIFactory {

    public APIRoutes apiRoutes;

    public APIFactory() {

        apiRoutes = new APIRoutes();

    }

    public void signUp(String username, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", username);
        requestBody.put("password", password);

        System.out.println("signup - "+requestBody );

        makePostCallAndReturnResponse(apiRoutes.getSignup(), requestBody);
    }

    public void login(String username, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", username);
        requestBody.put("password", password);

        System.out.println("login - "+requestBody );

        makePostCallAndReturnResponse(apiRoutes.getLogin(), requestBody);
    }

    public String makeGetCallAndReturnResponse(String URI) {

        RestAssured.baseURI = URI;
        Response response = given()
                .when()
                .get();

        return response.prettyPrint();

    }

    public String makePostCallAndReturnResponse(String URI, JSONObject requestBody) {

        RestAssured.baseURI = URI;
        Response response = given()
                .when()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post();

        System.out.println("JSON Object response - "+response.getBody().asString());

        return response.getBody().asString();

    }
}
