package service;

import dao.OrdersDao;
import model.Orders;

import java.sql.SQLException;
import java.util.List;

public class OrdersServive implements IService<Orders>{
    OrdersDao ordersDao = new OrdersDao();
    @Override
    public List<Orders> getList() throws SQLException {
        return ordersDao.getList();
    }

    @Override
    public void save(Orders orders) throws SQLException {
        ordersDao.insert(orders);
        getList();
    }

    @Override
    public void update(long id, Orders orders) throws SQLException {
        ordersDao.update(id,orders);
        getList();
    }

    @Override
    public void delete(long id) throws SQLException {
        ordersDao.delete(id);
        getList();
    }
}
