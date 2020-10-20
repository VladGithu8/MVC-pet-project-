package Services;

import DAO.OrderCartDaoImp;
import Models.OrderCart;


public class OrderCartService extends AbstractService<OrderCart, OrderCartDaoImp> {

    protected OrderCartService(OrderCartDaoImp entity) {
        super(entity);
    }
}
