package Services;

import DAO.ProductDaoImp;
import Models.Customer;
import Models.Product;

import java.sql.SQLException;

public class ProductService {
    private  final ProductDaoImp productDaoImp;

    public ProductService(ProductDaoImp productDaoImp) {
        this.productDaoImp = productDaoImp;
    }

    public Product saveProduct(Product pr) throws SQLException {
        return productDaoImp.save(pr);
    }
}
