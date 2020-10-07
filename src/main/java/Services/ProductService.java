package Services;

import DAO.ProductDAO;
import Models.Product;
import java.io.IOException;
import java.util.List;

public class ProductService {

   private ProductDAO productDAO;
   public ProductService() {productDAO = new ProductDAO();}

    public boolean saveProduct(Product product) throws IOException {
        productDAO.saveProduct(product);
        return true;}

    public List<String> findAllProducts() throws Exception {
        return (List<String>) productDAO.findAllProducts();}

    public boolean findProduct(int id) throws Exception {
        productDAO.findById(id);
        System.out.println(id);
        return true;}

    public boolean deleteProduct(Product product) throws Exception {
        productDAO.deleteProduct(product);
        return true;}

    public boolean updateProduct(Product product) throws Exception {
        productDAO.updateProduct(product);
        return true;}
}
