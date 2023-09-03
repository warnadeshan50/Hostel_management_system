package lk.ijse.hostel_management_system.dao;

import java.sql.SQLException;
import java.util.ArrayList;


public interface CrudDAO <Type> extends SuperDAO {
    public boolean isSave(Type entity) throws SQLException;
    public boolean isUpdate(Type entity) throws SQLException;
    public boolean isDelete(String id) throws SQLException;
    public Type search(String id) throws SQLException;
    public ArrayList<Type> getAll() throws SQLException;
}
