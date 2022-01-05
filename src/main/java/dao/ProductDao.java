package dao;

import config.ConnectionJDBC;
import model.Customer;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IDao<Product> {
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List<Product> getList() throws SQLException {
        String ShowCustomer = "select * from product";
        List<Product> productList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(ShowCustomer)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                long id_supplier = rs.getLong("id_supplier");
                long id_category = rs.getLong("id_category");
                long views = rs.getLong("views");
                long likes = rs.getLong("likes");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                String description = rs.getString("description");
                long quantity = rs.getLong("quantity");
                double import_price = rs.getDouble("import_price");
                double wholesale_prices = rs.getDouble("wholesale_prices");
                double retail_price = rs.getDouble("retail_price");
                double wholesale_quantity = rs.getDouble("wholesale_quantity");
                double discount = rs.getDouble("discount");
                double retail_quantity = rs.getDouble("retail_quantity");
                double wholesale_profit = rs.getDouble("wholesale_profit");
                double retail_profit = rs.getDouble("retail_profit");
                String create_by = rs.getString("create_by");
                String modify_by = rs.getString("modify_by");
                Date create_date = rs.getDate("create_date");
                Date modify_date = rs.getDate("modify_date");
                Boolean status = rs.getBoolean("status");
                productList.add(new Product( id,  sku,  name,  description,
                 quantity,  import_price,  wholesale_prices,  retail_price,
                 wholesale_quantity,  discount,  retail_quantity,
                 wholesale_profit,  retail_profit,  create_by,  modify_by,
                create_date,  modify_date,  id_supplier,  id_category,  views,  likes,  status));

            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Product product) throws SQLException {
        String insert = "INSERT INTO product(sku, name, description,quantity,import_price, discount, wholesale_profit,retail_profit, id_supplier, id_category, status) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, product.getSku());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setString(3, product.getDescription());
        preparedStatement.setLong(4, product.getQuantity());
        preparedStatement.setDouble(5, product.getImport_price());
        preparedStatement.setDouble(6, product.getDiscount());
        preparedStatement.setDouble(7, product.getWholesale_profit());
        preparedStatement.setDouble(8, product.getRetail_profit());
        preparedStatement.setLong(9, product.getId_supplier());
        preparedStatement.setLong(10, product.getId_category());
        preparedStatement.setBoolean(11, product.isStatus());
        preparedStatement.execute();
    }

    @Override
    public void update(long id, Product product) throws SQLException {
        String update = "UPDATE product SET sku = ?, name = ?, description = ?, quantity = ?, import_price = ?, discount = ?, wholesale_profit = ?, retail_profit = ?, id_supplier = ?, id_category = ?, status = ? WHERE (id = ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, product.getSku());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setString(3, product.getDescription());
        preparedStatement.setLong(4, product.getQuantity());
        preparedStatement.setDouble(5, product.getImport_price());
        preparedStatement.setDouble(6, product.getDiscount());
        preparedStatement.setDouble(7, product.getWholesale_profit());
        preparedStatement.setDouble(8, product.getRetail_profit());
        preparedStatement.setLong(9, product.getId_supplier());
        preparedStatement.setLong(10, product.getId_category());
        preparedStatement.setBoolean(11, product.isStatus());
        preparedStatement.setLong(12, id);
        preparedStatement.execute();
    }

    @Override
    public void delete(long id) throws SQLException {
        String delete = "DELETE FROM product WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }
}
