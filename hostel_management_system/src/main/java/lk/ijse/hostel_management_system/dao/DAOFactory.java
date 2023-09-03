package lk.ijse.hostel_management_system.dao;

import lk.ijse.hostel_management_system.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostel_management_system.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostel_management_system.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}

    public static DAOFactory getDaoFactory() {
        if (daoFactory == null) {
            return new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOTypes{
        USER,STUDENT,ROOM;
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case USER:
                return new UserDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
                default:
                    return null;
        }
    }
}

