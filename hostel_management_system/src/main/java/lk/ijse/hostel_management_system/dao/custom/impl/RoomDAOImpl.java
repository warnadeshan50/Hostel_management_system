package lk.ijse.hostel_management_system.dao.custom.impl;

import lk.ijse.hostel_management_system.dao.FactoryConfiguration;
import lk.ijse.hostel_management_system.dao.custom.RoomDAO;
import lk.ijse.hostel_management_system.entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public boolean isSave(Room entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean isUpdate(Room entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean isDelete(String id) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(id);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Room search(String id) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room=session.load(Room.class,id);
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public ArrayList<Room> getAll() throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        ArrayList<Room> data = new ArrayList<>();
        List<Room>rooms=session.createQuery("SELECT a FROM Room a",Room.class).getResultList();
        data= (ArrayList<Room>) rooms;
        transaction.commit();
        session.close();
        return data;

    }
}
