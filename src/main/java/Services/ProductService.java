package Services;

import DAO.ProductDAO;
import Models.Customer;
import Models.Product;

public class ProductService {


    ProductDAO productDAO = new ProductDAO();

    public void saveProduct (Product product) throws Exception {
        productDAO.saveProduct(product);
    }
}
