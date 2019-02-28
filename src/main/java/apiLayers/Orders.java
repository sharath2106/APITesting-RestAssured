package apiLayers;

public class Orders extends APIFactory {

    public void getOrders() {

        makeGetCallAndReturnResponse(apiRoutes.getProducts());

    }
}
