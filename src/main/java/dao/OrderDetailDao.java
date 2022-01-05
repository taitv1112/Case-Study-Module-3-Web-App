package dao;

import config.ConnectionJDBC;
import model.OrderDetail;
import model.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDetailDao implements IDao<OrderDetail> {
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List<OrderDetail> getList() throws SQLException {
        String select = "select * from OrderDetail";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            long id_Orders = resultSet.getLong("id_customer");
            long id_Product = resultSet.getLong("id_Product");
            long quantity_order = resultSet.getLong("quantity_order");

            orderDetailList.add(new OrderDetail( id,  id_Orders,  id_Product,  quantity_order));
        }
        return orderDetailList;
    }

    @Override
    public void insert(OrderDetail orderDetail) throws SQLException {
        String insert = "INSERT INTO `product_manager`.`orderdetail` ( `id_Orders`, `id_Product`, `quantity_order`) VALUES ( ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setLong(1, orderDetail.getId_Orders());
        preparedStatement.setLong(2, orderDetail.getId_Product());
        preparedStatement.setLong(3, orderDetail.getQuantity_order());
        preparedStatement.execute();
    }

    @Override
    public void update(long id, OrderDetail orderDetail) throws SQLException {
        String update = "UPDATE orderdetail SET id_Orders =  ?, id_Product =  ?, quantity_order =  ? WHERE (id = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setLong(1, orderDetail.getId_Orders());
        preparedStatement.setLong(2, orderDetail.getId_Product());
        preparedStatement.setLong(3, orderDetail.getQuantity_order());
        preparedStatement.setLong(4, id);
        preparedStatement.execute();
    }

    @Override
    public void delete(long id) throws SQLException {
        String delete = "DELETE FROM orderDetail WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();

    }
}
