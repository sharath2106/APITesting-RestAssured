package apiLayers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Orders extends APIFactory {

    private static String orderId;

    public void getOrders() {
        makeGetCallAndReturnResponseWithToken(apiRoutes.getOrders());
    }

    public void createOrders(String productResponse) {
        JSONArray productsInOrder = new JSONArray();
        JSONObject requestBody = new JSONObject();
        productsInOrder.add(addProduct("id",
                utility.returnJSONValue(productResponse, "products", "productId")));
        requestBody.put("products", productsInOrder);

        String orderIdResponse =
                makePostCallAndReturnResponseWithToken(apiRoutes.getOrders(), requestBody);
        orderId = utility.returnJSONValue(orderIdResponse,
                "createdOrder", "orderId");
    }

    public void deleteOrders() {
        makeDeleteCallAndReturnResponseWithToken(apiRoutes.getOrders() + orderId);
    }


    private JSONObject addProduct(String id, String product) {
        JSONObject jsonProductObject = new JSONObject();
        jsonProductObject.put(id, product);
        return jsonProductObject;
    }
}
