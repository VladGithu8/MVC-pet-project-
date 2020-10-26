package Services;

import DAO.OrderDaoImp;
import Models.Order;


public class OrderService extends AbstractService<Order, OrderDaoImp> {

    public OrderService(OrderDaoImp entity) {
        super(entity);
    }
}

