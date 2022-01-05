package dao;

import config.ConnectionJDBC;
import model.Category;
import model.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersDao implements IDao<Orders>{
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List<Orders> getList() throws SQLException {
        String select = "select * from Orders";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        List<Orders> ordersList = new ArrayList<>();
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            long id_customer = resultSet.getLong("id_customer");
            long id_manager = resultSet.getLong("id_manager");
            Date create_date = resultSet.getDate("create_date");
            Date modify_date = resultSet.getDate("modify_date");
            String create_by = resultSet.getString("create_by");
            String modify_by = resultSet.getString("modify_by");
            Double total_bill = resultSet.getDouble("total_bill");
            String status = resultSet.getString("status");
            ordersList.add(new Orders( id,  id_customer,  id_manager,  create_date,
            modify_date,  create_by,  modify_by,  total_bill,  status));
        }
        return ordersList;
    }

    @Override
    public void insert(Orders orders) throws SQLException {
        String insert = "INSERT INTO orders (id_customer, id_manager) VALUES (?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setLong(1, orders.getId_customer());
        preparedStatement.setLong(2, orders.getId_manager());
        preparedStatement.execute();
    }

    @Override
    public void update(long id, Orders orders) throws SQLException {
        String update = "UPDATE Orders SET id_customer = ?, id_manager = ?, status = ? WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setLong(1, orders.getId_customer());
        preparedStatement.setLong(2, orders.getId_manager());
        preparedStatement.setString(3, orders.getStatus());
        preparedStatement.setLong(4, id);
        preparedStatement.execute();
    }
    @Override
    public void delete(long id) throws SQLException {
        String delete = "DELETE FROM Orders WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }
}
