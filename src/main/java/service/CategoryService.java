package service;

import dao.CategoryDao;
import model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements IService<Category>{
    CategoryDao categoryDao = new CategoryDao();

    @Override
    public List<Category> getList() throws SQLException {
        return categoryDao.getList();
    }

    @Override
    public void save(Category category) throws SQLException {
        categoryDao.insert(category);
        getList();
    }

    @Override
    public void update(long id, Category category) throws SQLException {
            categoryDao.update(id,category);
        getList();
    }

    @Override
    public void delete(long id) throws SQLException {
                categoryDao.delete(id);
                getList();
    }
}
