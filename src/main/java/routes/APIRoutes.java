package routes;

import utilities.Utility;

public class APIRoutes {


    //    private static String baseURL = "http://localhost:3000";
    private Utility utility = new Utility();
    private String baseURL = utility.getPropertyValue("API_URI");
    private String login;
    private String signup;
    private String products;
    private String orders;
    private String createProduct;
    private String createOrder;
    private String getSingleProduct;

    public String getDeleteOrder() {
        return deleteOrder;
    }

    public void setDeleteOrder(String deleteOrder) {
        this.deleteOrder = deleteOrder;
    }

    private String deleteOrder;

    public APIRoutes() {
        setLogin();
        setSignup();
        setProducts();
        setCreateProduct();
        setGetSingleProduct();
        setOrders();
        setCreateOrder();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin() {
        this.login = baseURL + "/user/login";
    }

    public String getSignup() {
        return signup;
    }

    public void setSignup() {
        this.signup = baseURL + "/user/signup";
    }


    public String getProducts() {
        return products;
    }

    public void setProducts() {
        this.products = baseURL + "/products/";
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders() {
        this.orders = baseURL + "/orders/";
    }

    public String getCreateProduct() {
        return createProduct;
    }

    public void setCreateProduct() {
        this.createProduct = createProduct;
    }

    public String getCreateOrder() {
        return createOrder;
    }

    public void setCreateOrder() {
        this.createOrder = createOrder;
    }

    public String getGetSingleProduct() {
        return getSingleProduct;
    }

    public void setGetSingleProduct() {
        this.getSingleProduct = getSingleProduct;
    }

    public void returnProperty(String value) {

    }

}
