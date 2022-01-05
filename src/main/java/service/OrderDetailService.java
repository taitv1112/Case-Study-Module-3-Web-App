package service;

import dao.OrderDetailDao;
import model.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailService implements IService<OrderDetail>{
    OrderDetailDao orderDetailDao = new OrderDetailDao();

    @Override
    public List<OrderDetail> getList() throws SQLException {
        return orderDetailDao.getList();
    }

    @Override
    public void save(OrderDetail orderDetail) throws SQLException {
        orderDetailDao.insert(orderDetail);
        getList();
    }

    @Override
    public void update(long id, OrderDetail orderDetail) throws SQLException {
        orderDetailDao.update(id,orderDetail);
        getList();
    }

    @Override
    public void delete(long id) throws SQLException {
        orderDetailDao.delete(id);
        getList();
    }
}
