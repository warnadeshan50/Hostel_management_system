package lk.ijse.hostel_management_system.dao.custom.impl;

import lk.ijse.hostel_management_system.dao.FactoryConfiguration;
import lk.ijse.hostel_management_system.dao.custom.UserDAO;
import lk.ijse.hostel_management_system.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean isSave(User entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean isUpdate(User entity) throws SQLException {
        return false;
    }

    @Override
    public boolean isDelete(String id) throws SQLException {
        return false;
    }

    @Override
    public User search(String id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException {
        return null;
    }
}
