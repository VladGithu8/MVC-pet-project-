package Services;

import DAO.ProductDAO;
import Models.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductService {

    private ProductDAO productDAO;

    public ProductService() {
        productDAO = new ProductDAO();
    }

    public Product findProductById(int id) throws SQLException, NoSuchElementException {
        return productDAO.findById(id);
    }

    public Product saveProduct(Product product) throws SQLException{
        return productDAO.save(product);
    }

    public Product deleteProduct(Product product) throws SQLException, NoSuchElementException {
        return productDAO.delete(product);
    }

    public Product updateProduct(Product product) throws SQLException,NoSuchElementException {
        return productDAO.update(product);
    }

    public List findAllProducts() throws SQLException {
        return productDAO.findAll();
    }

    public List<String> findAllProductsToString() throws SQLException {
        return productDAO.findAllProductsToString();
    }
}
