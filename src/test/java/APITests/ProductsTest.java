package APITests;

import apiLayers.Orders;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void testGetProducts(){
        orders.getOrders();
    }
}
