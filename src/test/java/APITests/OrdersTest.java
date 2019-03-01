package APITests;

import apiLayers.Orders;
import org.testng.annotations.Test;

public class OrdersTest extends BaseTest {

    @Test
    public void testGetOrders(){
        orders.getOrders();
    }

    @Test
    public void testCreateOrders(){
        orders.createOrders();
    }
}
