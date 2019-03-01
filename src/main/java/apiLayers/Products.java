package apiLayers;

public class Products extends APIFactory {

    public void getProducts() {

        makeGetCallAndReturnResponse(apiRoutes.getProducts());

    }
}
