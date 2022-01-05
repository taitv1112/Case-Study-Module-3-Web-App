package service;

import dao.ManagerDao;
import model.Customer;
import model.Manager;

import java.util.List;

public class ManagerServiceImpl implements IService<Manager>{
    ManagerDao managerDao = new ManagerDao();

    @Override
    public List<Manager> getList() {
        return managerDao.getList();
    }

    @Override
    public void save(Manager manager) {
        managerDao.insert(manager);
        getList();
    }

    @Override
    public void update(long id, Manager manager) {
        managerDao.update(id, manager);
        getList();
    }

    @Override
    public void delete(long id) {
    managerDao.delete(id);
        getList();
    }
    public Manager checkLoginManager(String user, String password){
        List<Manager> managerList = managerDao.getList();
        for (Manager m: managerList) {
            if((m.getUser_name().equals(user)) && m.getPasswords().equals(password)){
                return  m;
            }
        }
        return null;
    }
}
