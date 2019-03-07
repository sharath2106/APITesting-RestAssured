package apiLayers;

public class Products extends APIFactory {

    public String getProducts() {

       return makeGetCallAndReturnResponseWithToken(apiRoutes.getProducts());

    }
}
