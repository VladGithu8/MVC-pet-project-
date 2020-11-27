package DAO;

import Models.Order;
import org.hibernate.SessionFactory;

public class OrderDaoImp extends AbstractDao<Order> {

    public OrderDaoImp(SessionFactory sessionFactory) {
        super(sessionFactory, Order.class);
    }
}

