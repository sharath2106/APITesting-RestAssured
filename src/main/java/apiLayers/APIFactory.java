package apiLayers;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import routes.APIRoutes;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class APIFactory {

    public APIRoutes apiRoutes;
    private static String authToken;

    public APIFactory() {

        apiRoutes = new APIRoutes();

    }

    public void signUp(String username, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", username);
        requestBody.put("password", password);

        makePostCallAndReturnResponse(apiRoutes.getSignup(), requestBody);
    }

    public void login(String username, String password) throws ParseException {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", username);
        requestBody.put("password", password);

        String fetchTokenFromResponse = makePostCallAndReturnResponse(apiRoutes.getLogin(), requestBody);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fetchTokenFromResponse);
        authToken = jsonObject.get("token").toString();
        System.out.println(authToken);

    }

    protected String makeGetCallAndReturnResponse(String URI) {

        RestAssured.baseURI = URI;
        Response response = given()
                .when()
                .get();

        return response.prettyPrint();
    }

    protected String makeGetCallAndReturnResponseWithToken(String URI) {

        RestAssured.baseURI = URI;
        Response response = given()
                .header("Authorization", "Bearer "+authToken)
                .when()
                .get();

        return response.prettyPrint();
    }

    protected String makePostCallAndReturnResponse(String URI, JSONObject requestBody) {

        RestAssured.baseURI = URI;
        Response response = given()
                .when()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post();

        return response.getBody().asString();
    }

    protected String makePostCallAndReturnResponseWithToken(String URI, JSONObject requestBody) {

        RestAssured.baseURI = URI;
        Response response = given()
                .when()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+authToken)
                .body(requestBody)
                .post();

        System.out.println(response.getBody().asString());
        return response.getBody().asString();
    }

    protected String makePutCallAndReturnResponseWithToken(String URI, JSONObject requestBody) {

        RestAssured.baseURI = URI;
        Response response = given()
                .when()
                .header("Content-Type", "application/json")
                .header("Authorization", authToken)
                .body(requestBody)
                .put();

        return response.getBody().asString();
    }
}
