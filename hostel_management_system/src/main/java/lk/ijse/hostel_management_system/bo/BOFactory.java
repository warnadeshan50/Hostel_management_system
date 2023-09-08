package lk.ijse.hostel_management_system.bo;

import lk.ijse.hostel_management_system.bo.custom.impl.RoomBOImpl;
import lk.ijse.hostel_management_system.bo.custom.impl.StudentBOImpl;
import lk.ijse.hostel_management_system.bo.custom.impl.UserBOImpl;
import lk.ijse.hostel_management_system.dao.custom.impl.UserDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBOFactory() {
        if (boFactory == null) {
            return new BOFactory();
        } else {
            return boFactory;
        }
    }
    public enum BOType{
        USER,STUDENT,ROOM;
    }
    public SuperBO getBO(BOType type){
        switch (type){
            case STUDENT:
                return new StudentBOImpl();
            case USER:
                return new UserBOImpl();
            case ROOM:
                return new RoomBOImpl();
            default:
                return null;
        }
    }
}
