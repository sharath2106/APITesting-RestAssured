package APITests;

import apiLayers.APIFactory;
import org.testng.annotations.Test;

public class testGetProducts {

    APIFactory apiFactory = new APIFactory();

    @Test
    public void testGetProducts(){
        apiFactory.getProducts();
    }
}
