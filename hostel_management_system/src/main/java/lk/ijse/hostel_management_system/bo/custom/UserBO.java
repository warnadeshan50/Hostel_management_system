package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hostel_management_system.bo.SuperBO;
import lk.ijse.hostel_management_system.dto.UserDTO;

import java.sql.SQLException;

public interface UserBO extends SuperBO {
    public boolean isSaveUser(UserDTO dto) throws SQLException;
    public boolean isUpdateUser(UserDTO dto) throws SQLException;
    public boolean isDeleteUser(String id) throws SQLException;
}
