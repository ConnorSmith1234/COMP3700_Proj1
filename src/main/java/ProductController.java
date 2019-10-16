import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController implements ActionListener {

    ProductView myView;
    SQLiteDataAccess myDB;
    public ProductController(ProductView view, SQLiteDataAccess dao) {
        myView = view;
        myDB = dao;
        myView.btnLoad.addActionListener(this);
        myView.btnSave.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myView.btnLoad) {      // button Load is clicked
            loadProductAndDisplay();
        }

        if (e.getSource() == myView.btnSave) {      // button Load is clicked
            saveProduct();
        }

    }

    private void saveProduct() {
        ProductModel productModel = new ProductModel();

        try {
            int productID = Integer.parseInt(myView.txtProductID.getText());
            productModel.mProductID = productID;
            productModel.mName = myView.txtProductName.getText();
            productModel.mPrice = Double.parseDouble(myView.txtProductPrice.getText());
            productModel.mQuantity = Double.parseDouble(myView.txtProductQuantity.getText());

            myDB.saveProduct(productModel);
            JOptionPane.showMessageDialog(null, "Product saved successfully!");


        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for ProductID");
            ex.printStackTrace();
        }    }

    private void loadProductAndDisplay() {
        try {
            int productID = Integer.parseInt(myView.txtProductID.getText());
            ProductModel productModel = myDB.loadProduct(productID);
            myView.txtProductName.setText(productModel.mName);
            myView.txtProductPrice.setText(String.valueOf(productModel.mPrice));
            myView.txtProductQuantity.setText(String.valueOf(productModel.mQuantity));

        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for ProductID");
            ex.printStackTrace();
        }
    }
}
