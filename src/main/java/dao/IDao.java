package dao;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    List<T> getList () throws SQLException;
    void insert(T t) throws SQLException;
    void update(long id,T t) throws SQLException;
    void delete(long id) throws SQLException;
}
