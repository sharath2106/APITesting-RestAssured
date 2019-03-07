package utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {

    public String getPropertyValue(String propKey) {

        Properties props = new Properties();
        try {
            props.load(new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/resources/apiProperties.properties"));
        } catch (IOException | NullPointerException ioe) {
            ioe.getMessage();
        }

        return props.getProperty(propKey);
    }

    public String returnJSONValue(String response, String arrayVal, String tagVal) {

        JSONObject jsonObject;
        JSONParser jsonParser;
        JSONArray jsonArray;
        JSONObject jsonObject1 = new JSONObject();
        try {
            jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse
                    (response);
            jsonArray = (JSONArray) jsonObject.get(arrayVal);
            jsonObject1 = (JSONObject) jsonArray.get(0);
        } catch (ParseException pe) {
            pe.getMessage();
        }
        return jsonObject1.get(tagVal).toString();
    }
}

