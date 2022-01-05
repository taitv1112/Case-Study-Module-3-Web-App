package service;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
    List<T> getList() throws SQLException;
    void save (T t) throws SQLException;
    void update(long id,T t) throws SQLException;
    void delete(long id) throws SQLException;
 }
