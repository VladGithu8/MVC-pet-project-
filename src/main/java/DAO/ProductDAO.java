package DAO;

import Models.Product;

import Utils.HibernateSessionFactoryUtil;
import Utils.SessionUtilDAO;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ProductDAO {

    private SessionUtilDAO sessionUtilDAO;
    public ProductDAO() {sessionUtilDAO = new SessionUtilDAO();}

    public Product findById(int id) throws Exception {
       return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class, id);}

    public boolean saveProduct(Product product) {
        sessionUtilDAO.save(product);
        System.out.println("Product saved :" + product);
        return true;}

    public boolean updateProduct(Product product) throws Exception {
        sessionUtilDAO.update(product);
        System.out.println("Product updated :" + product);
        return true;}

    public boolean deleteProduct(Product product) throws Exception {
       sessionUtilDAO.delete(product);
        System.out.println("Product deleted :" + product);
        return true;}

    public LinkedList<String> findAllProducts() throws IOException {
        List<String> sqlProducts = new LinkedList<>();
        List<Product> products = (List<Product>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Product")
                .list();
        while (sqlProducts.size() != products.size()){
        for (Product p:products) {
            int pId = Integer.valueOf(p.getId());
            String pDescription = String.valueOf(p.getDescription());
            double pPrice = Double.valueOf(p.getPrice());
            String pProductName = String.valueOf(p.getProductName());
            String pS = "\nId: " + pId + ", Product name: " + pProductName +
                    ", Product price: " + pPrice +
                    ", Description: " + pDescription;
            sqlProducts.add(pS);
        }
        } return (LinkedList<String>) sqlProducts;
    }
}





