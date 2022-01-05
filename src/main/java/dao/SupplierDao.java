package dao;

import config.ConnectionJDBC;
import model.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDao implements IDao<Supplier> {
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List<Supplier> getList() throws SQLException {
        String select = "select * from supplier";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        List<Supplier> supplierList = new ArrayList<>();
        while (resultSet.next()) {
            int idSupplier = resultSet.getInt("id");
            String nameSupplier = resultSet.getString("name");
            String descriptionSupplier = resultSet.getString("description");
            supplierList.add(new Supplier(idSupplier, nameSupplier, descriptionSupplier));
        }
        return supplierList;
    }

    @Override
    public void insert(Supplier supplier) throws SQLException {
        String insert = "INSERT INTO supplier (name, description) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, supplier.getName());
        preparedStatement.setString(2, supplier.getDescription());
        preparedStatement.execute();
    }

    @Override
    public void update(long id, Supplier supplier) throws SQLException {
        String update = "UPDATE supplier SET `name` = ?, `description` = ? WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, supplier.getName());
        preparedStatement.setString(2, supplier.getDescription());
        preparedStatement.setLong(3, id);
        preparedStatement.execute();

    }

    @Override
    public void delete(long id) throws SQLException {
        String delete = "DELETE FROM supplier WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }
}
