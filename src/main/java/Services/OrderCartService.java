package Services;

import DAO.OrderCartDAO;
import Models.OrderCart;

public class OrderCartService {

    private OrderCartDAO orderCartDAO;
    public OrderCartService(){ orderCartDAO = new OrderCartDAO();}

    public boolean saveOrderCart(OrderCart orderCart) throws Exception{
        orderCartDAO.saveOrderCart(orderCart);
        return true;}
}
