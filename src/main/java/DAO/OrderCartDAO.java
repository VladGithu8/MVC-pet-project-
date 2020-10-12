package DAO;

import Models.OrderCart;

import Utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderCartDAO extends DAOImpl {

    @Override
    public OrderCart findById(int id) throws SessionException {
        return (OrderCart) findById(id);
    }

    @Override
    public OrderCart save(Object orderCart) throws SessionException {
        return (OrderCart) super.save(orderCart);
    }

    @Override
    public OrderCart delete(Object orderCart) throws NoSuchElementException, SessionException {
        return (OrderCart) super.delete(orderCart);
    }

    @Override
    public OrderCart update(Object orderCart) throws NoSuchElementException, SessionException {
        return (OrderCart) super.update(orderCart);
    }

    @Override
    public List findAll() throws SessionException, SQLException, OutOfMemoryError {
        List<OrderCart> orderCarts = (List<OrderCart>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From OrderCart").list();
        return new ArrayList<>(orderCarts);
    }
}
