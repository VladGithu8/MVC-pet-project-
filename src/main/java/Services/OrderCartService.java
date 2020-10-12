package Services;

import DAO.OrderCartDAO;
import Models.OrderCart;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderCartService {

    private OrderCartDAO orderCartDAO;

    public OrderCartService() {
        orderCartDAO = new OrderCartDAO();
    }

    public OrderCart findOrderById(int id) throws SQLException, NoSuchElementException {
        return orderCartDAO.findById(id);
    }

    public OrderCart saveOrder(OrderCart orderCart) throws SQLException{
        return orderCartDAO.save(orderCart);
    }

    public OrderCart deleteOrder(OrderCart orderCart) throws SQLException, NoSuchElementException{
        return orderCartDAO.delete(orderCart);
    }

    public OrderCart updateOrder(OrderCart orderCart) throws SQLException,NoSuchElementException{
        return orderCartDAO.update(orderCart);
    }

    public List findAllOrders() throws SQLException {
        return orderCartDAO.findAll();
    }
}

