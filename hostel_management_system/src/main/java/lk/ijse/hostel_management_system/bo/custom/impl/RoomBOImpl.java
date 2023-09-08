package lk.ijse.hostel_management_system.bo.custom.impl;

import lk.ijse.hostel_management_system.bo.BOFactory;
import lk.ijse.hostel_management_system.bo.custom.RoomBO;
import lk.ijse.hostel_management_system.dao.custom.RoomDAO;
import lk.ijse.hostel_management_system.dto.RoomDTO;
import lk.ijse.hostel_management_system.entity.Room;

import java.sql.SQLException;

public class RoomBOImpl implements RoomBO {
    RoomDAO roomDAO = (RoomDAO) BOFactory.getBOFactory().getBO(BOFactory.BOType.ROOM);
    @Override
    public boolean isSaveRoom(RoomDTO dto) throws SQLException {
        return roomDAO.isSave(new Room(dto.getRoom_type_id(), dto.getRoom_type(), dto.getKey_money(), dto.getRoom_qty()));
    }

    @Override
    public boolean isUpdateRoom(RoomDTO dto) throws SQLException {
        return roomDAO.isUpdate(new Room(dto.getRoom_type_id(),dto.getRoom_type(), dto.getKey_money(), dto.getRoom_qty()));
    }

    @Override
    public boolean isDeleteRoom(RoomDTO dto) throws SQLException {
        return roomDAO.isDelete(new Room(dto.getRoom_type_id(),dto.getRoom_type(), dto.getKey_money(), dto.getRoom_qty()));
    }
}
