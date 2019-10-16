import java.sql.*;

public class SQLiteDataAccess {
    Connection conn = null;

    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:store.db";
            // create a connection to the database
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection(url);

            if (conn == null)
                System.out.println("Cannot make the connection!!!");
            else
                System.out.println("The connection object is " + conn);

            System.out.println("Connection to SQLite has been established.");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product");

            while (rs.next())
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveProduct(ProductModel product) {
        try {
            Statement stmt = conn.createStatement();

            if (loadProduct(product.mProductID) == null) {           // this is a new product!
                stmt.execute("INSERT INTO Product(productID, name, price, quantity) VALUES ("
                        + product.mProductID + ","
                        + '\'' + product.mName + '\'' + ","
                        + product.mPrice + ","
                        + product.mQuantity + ")"
                );
            }
            else {
                stmt.executeUpdate("UPDATE Product SET "
                        + "productID = " + product.mProductID + ","
                        + "name = " + '\'' + product.mName + '\'' + ","
                        + "price = " + product.mPrice + ","
                        + "quantity = " + product.mQuantity +
                        " WHERE productID = " + product.mProductID
                );

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ProductModel loadProduct(int productID) {
        ProductModel product = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product WHERE ProductID = " + productID);
            if (rs.next()) {
                product = new ProductModel();
                product.mProductID = rs.getInt(1);
                product.mName = rs.getString(2);
                product.mPrice = rs.getDouble(3);
                product.mQuantity = rs.getDouble(4);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return product;
    }


}
