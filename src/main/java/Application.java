public class Application {
    public static void main(String[] args) {

        StoreManager.getInstance().getDataAdapter().connect("/home/connor/dev/COMP_3700/activity12/data/store.db");

/*        ProductModel prod = dao.loadProduct(1); // Apple;
        if (prod != null)
            System.out.println("Product with ID = " + prod.productID + " name = " + prod.name + " price = " + prod.price + " quantity = " + prod.quantity);

        prod.productID = 100;
        prod.name = "Samsung TV";
        prod.price = 399.99;
        prod.quantity = 1000;

        dao.saveProduct(prod);

        prod = dao.loadProduct(100); // Samsung!!!
        if (prod != null)
            System.out.println("Product with ID = " + prod.productID + " name = " + prod.name + " price = " + prod.price + " quantity = " + prod.quantity);

        productView.show();
*/
    }
}
