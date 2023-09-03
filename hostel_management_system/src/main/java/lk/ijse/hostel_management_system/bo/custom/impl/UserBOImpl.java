package lk.ijse.hostel_management_system.bo.custom.impl;

import lk.ijse.hostel_management_system.bo.custom.UserBO;
import lk.ijse.hostel_management_system.dao.DAOFactory;
import lk.ijse.hostel_management_system.dao.custom.UserDAO;
import lk.ijse.hostel_management_system.dto.UserDTO;
import lk.ijse.hostel_management_system.entity.User;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {
    UserDAO UserDAO= (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean isSaveUser(UserDTO dto) throws SQLException {
        return UserDAO.isSave(new User(dto.getUsername(),dto.getPassword()));
    }

    @Override
    public boolean isUpdateUser(UserDTO dto) throws SQLException {
        return UserDAO.isUpdate(new User(dto.getUsername(), dto.getPassword()));
    }

    @Override
    public boolean isDeleteUser(String id) throws SQLException {
        return UserDAO.isDelete(id);
    }
}
