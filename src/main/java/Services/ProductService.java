package Services;

import DAO.ProductDAO;
import Models.Customer;
import Models.Product;

import java.io.IOException;

public class ProductService {

    ProductDAO productDAO = new ProductDAO();

    public void saveProduct (Product product) throws IOException {
        try { productDAO.saveProduct(product); } 
        catch (Exception e){ e.printStackTrace(); }
    }
}
