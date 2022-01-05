package dao;

import config.ConnectionJDBC;
import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements IDao<Category> {
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List<Category> getList() throws SQLException {
        String select = "select * from category";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        List<Category> categoryList = new ArrayList<>();
        while (resultSet.next()) {
            long idCategory = resultSet.getLong("id");
            String nameCategory = resultSet.getString("name");
            String codeCategory = resultSet.getString("code");
            String descriptionCategory = resultSet.getString("description");
            categoryList.add(new Category(idCategory, nameCategory, codeCategory, descriptionCategory));
        }
        return categoryList;
    }

    @Override
    public void insert(Category category) throws SQLException {
        String insert = "INSERT INTO category (name, code, description) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, category.getName());
        preparedStatement.setString(2, category.getCode());
        preparedStatement.setString(3, category.getDescription());
        preparedStatement.execute();
    }

    @Override
    public void update(long id, Category category) throws SQLException {
        String update = "UPDATE category SET `name` = ?, `code` = ?, `description` = ? WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, category.getName());
        preparedStatement.setString(2, category.getCode());
        preparedStatement.setString(3, category.getDescription());
        preparedStatement.setLong(4, id);
        preparedStatement.execute();
    }

    @Override
    public void delete(long id) throws SQLException {
        String delete = "DELETE FROM category WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }
}
