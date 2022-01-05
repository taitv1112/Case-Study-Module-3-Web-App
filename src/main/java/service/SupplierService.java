package service;

import dao.SupplierDao;
import model.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierService implements IService<Supplier> {
    SupplierDao supplierDao = new SupplierDao();
    @Override
    public List<Supplier> getList() throws SQLException {
        return supplierDao.getList();
    }

    @Override
    public void save(Supplier supplier) throws SQLException {
        supplierDao.insert(supplier);
        getList();
    }

    @Override
    public void update(long id, Supplier supplier) throws SQLException {
        supplierDao.update(id,supplier);
        getList();
    }

    @Override
    public void delete(long id) throws SQLException {
        supplierDao.delete(id);
        getList();
    }
}
