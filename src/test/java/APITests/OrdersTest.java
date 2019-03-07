package APITests;

import org.testng.annotations.Test;


public class OrdersTest extends BaseTest {

    @Test
    public void testGetOrders() {
        orders.getOrders();
    }

    @Test
    public void testCreateOrders() {
        orders.createOrders(products.getProducts());
    }

    @Test
    public void testDeleteOrders() {
        orders.createOrders(products.getProducts());
        orders.deleteOrders();
    }
}
