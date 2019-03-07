package APITests;

import apiLayers.APIFactory;
import apiLayers.Orders;
import apiLayers.Products;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends APIFactory {

    Orders orders;
    Products products;

    BaseTest() {
        products = new Products();
        orders = new Orders();
    }

    @BeforeSuite(alwaysRun = true)
    public void initialSteps() throws ParseException {
        signUp(utility.getPropertyValue("emailId"),
                utility.getPropertyValue("password"));
        login(utility.getPropertyValue("emailId"),
                utility.getPropertyValue("password"));
    }
}
