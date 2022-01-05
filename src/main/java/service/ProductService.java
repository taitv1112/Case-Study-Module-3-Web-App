package service;

import dao.ProductDao;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IService<Product> {
    ProductDao productDao = new ProductDao();

    @Override
    public List<Product> getList() throws SQLException {
        return productDao.getList();
    }

    @Override
    public void save(Product product) throws SQLException {
        productDao.insert(product);
        getList();
    }

    @Override
    public void update(long id, Product product) throws SQLException {
        productDao.update(id,product);
        getList();
    }

    @Override
    public void delete(long id) throws SQLException {
        productDao.delete(id);
        getList();
    }
}
