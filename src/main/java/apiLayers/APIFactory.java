package apiLayers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import routes.APIRoutes;
import utilities.Utility;

import static io.restassured.RestAssured.given;

public class APIFactory {

    public APIRoutes apiRoutes;
    private static String authToken;
    public Utility utility;


    public APIFactory() {

        apiRoutes = new APIRoutes();
        utility = new Utility();
    }

    protected void signUp(String username, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", username);
        requestBody.put("password", password);

        makePostCallAndReturnResponseWithToken(apiRoutes.getSignup(), requestBody);
    }

    protected void login(String username, String password) throws ParseException {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", username);
        requestBody.put("password", password);

        String fetchTokenFromResponse = makePostCallAndReturnResponseWithToken(apiRoutes.getLogin(), requestBody);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fetchTokenFromResponse);
        authToken = jsonObject.get("token").toString();
        System.out.println(authToken);

    }

    String makeGetCallAndReturnResponseWithToken(String URI) {

        RestAssured.baseURI = URI;
        Response response = given()
                .header("Authorization", "Bearer "+authToken)
                .when()
                .get();

        return response.prettyPrint();
    }

    String makePostCallAndReturnResponseWithToken(String URI, JSONObject requestBody) {

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

    protected String makeDeleteCallAndReturnResponseWithToken(String URI) {

        RestAssured.baseURI = URI;
        Response response = given()
                .when()
                .header("Content-Type", "application/json")
                .header("Authorization", authToken)
                .delete();

        return response.getBody().asString();
    }
}
