package DAO;

import Models.OrderCart;
import Utils.HibernateSessionFactoryUtil;
import Utils.SessionUtilDAO;

public class OrderCartDAO {

    private SessionUtilDAO sessionUtilDAO;
    public OrderCartDAO() {sessionUtilDAO = new SessionUtilDAO();}

    public OrderCart findById(int id) throws Exception{
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(OrderCart.class, id);}

    public boolean saveOrderCart(OrderCart orderCart){
        sessionUtilDAO.save(orderCart);
        return true;}

    public boolean updateOrderCart(OrderCart orderCart){
        sessionUtilDAO.update(orderCart);
        return true;}

    public boolean deleteOrderCart(OrderCart orderCart){
        sessionUtilDAO.delete(orderCart);
        return true;}
}
