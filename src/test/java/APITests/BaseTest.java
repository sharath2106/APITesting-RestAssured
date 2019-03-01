package APITests;

import apiLayers.APIFactory;
import apiLayers.Orders;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends APIFactory {

    public Orders orders;

    public BaseTest() {
        orders = new Orders();
    }

    @BeforeSuite(alwaysRun = true)
    public void initialSteps() throws ParseException {
        signUp("abcd@xyz.com", "!abcd1234");
        login("abcd@xyz.com", "!abcd1234");
    }
}
