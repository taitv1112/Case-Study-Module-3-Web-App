package dao;

import config.ConnectionJDBC;
import model.Category;
import model.Img;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImgDao implements IDao<Img>{
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List<Img> getList() throws SQLException {
        String select = "SELECT img.* FROM img join product on img.id_product = product.id";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        List<Img> imgList = new ArrayList<>();
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            long id_product = resultSet.getLong("id_product");
            String img = resultSet.getString("img");
            String name = resultSet.getString("name");
            imgList.add(new Img( id,  id_product,  img,  name));
        }
        return imgList;
    }

    @Override
    public void insert(Img img) throws SQLException {
        String insert = "INSERT INTO img (id_product, img,name) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setLong(1, img.getId_product());
        preparedStatement.setString(2, img.getImg());
        preparedStatement.setString(3, img.getName());
        preparedStatement.execute();
    }

    @Override
    public void update(long id, Img img) throws SQLException {
        String update = "UPDATE img SET idProduct = ?, img = ?, name =? WHERE (idImg = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setLong(1, img.getId_product());
        preparedStatement.setString(2, img.getImg());
        preparedStatement.setString(3, img.getName());
        preparedStatement.setLong(4, id);
        preparedStatement.execute();
    }

    @Override
    public void delete(long id) throws SQLException {
        String delete = "DELETE FROM img WHERE idImg=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }
}
