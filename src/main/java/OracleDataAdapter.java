
public class OracleDataAdapter implements IDataAdapter {
    @Override
    public int connect(String dbfile) {
        //...
        return CONNECTION_OPEN_OK;
    }

    @Override
    public int disconnect() {
        // ...
        return CONNECTION_CLOSE_OK;

    }
    @Override
    public CustomerModel loadCustomer(int id) {
        return null;
    }
    @Override
    public int saveCustomer(CustomerModel customer) { return CUSTOMER_SAVED_OK; }

    @Override
    public ProductModel loadProduct(int id) {
        return null;
    }
    @Override
    public int saveProduct(ProductModel model) {
        return PRODUCT_SAVED_OK;
    }

    @Override
    public PurchaseModel loadPurchase(int id) { return null; }
    @Override
    public int savePurchase(PurchaseModel model) {
        return PURCHASE_SAVED_OK;
    }

}
