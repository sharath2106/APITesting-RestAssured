package apiLayers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Orders extends APIFactory {

    public void getOrders() {

        makeGetCallAndReturnResponseWithToken(apiRoutes.getOrders());

    }

    public void createOrders() {

        JSONArray productsInOrder = new JSONArray();
        JSONObject requestBody = new JSONObject();

        productsInOrder.add(addProduct("id", "5c78db9766dde40020f07809"));
        requestBody.put("products",productsInOrder);

        System.out.println(requestBody);

        makePostCallAndReturnResponseWithToken(apiRoutes.getOrders(), requestBody);
    }


    private JSONObject addProduct(String id, String product){
        JSONObject jsonProductObject = new JSONObject();
        jsonProductObject.put(id, product);
        return jsonProductObject;
    }
}
