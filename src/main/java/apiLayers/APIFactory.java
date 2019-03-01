package apiLayers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import routes.APIRoutes;

import static io.restassured.RestAssured.given;

public class APIFactory {

    public APIRoutes apiRoutes;
    private String token;

    public APIFactory() {

        apiRoutes = new APIRoutes();

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void signUp(String username, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", username);
        requestBody.put("password", password);

        System.out.println("signup - "+requestBody );

        makePostCallAndReturnResponse(apiRoutes.getSignup(), requestBody);
    }

    public void login(String username, String password) throws ParseException {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", username);
        requestBody.put("password", password);

        System.out.println("login - "+requestBody );

        String fetchTokenFromResponse = makePostCallAndReturnResponse(apiRoutes.getLogin(), requestBody);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fetchTokenFromResponse);
        setToken(jsonObject.get("token").toString());

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
