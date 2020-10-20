package Services;

import DAO.CustomerDAOImp;
import DAO.ProductDaoImp;
import Models.Customer;
import Models.Product;

public class ProductService extends AbstractService<Product, ProductDaoImp> {

    public ProductService(ProductDaoImp entity) {
        super(entity);
    }
}
