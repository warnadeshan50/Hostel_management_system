package lk.ijse.hostel_management_system.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public interface CrudDAO <Type> extends SuperDAO {
    public boolean isSave(Type entity) throws SQLException;
    public boolean isUpdate(Type entity) throws SQLException;
    public boolean isDelete(Type entity) throws SQLException;
    public Type search(String id) throws SQLException;
    public List<Type> getAll() throws SQLException;
}
