package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hostel_management_system.bo.SuperBO;
import lk.ijse.hostel_management_system.dto.RoomDTO;

import java.sql.SQLException;

public interface RoomBO extends SuperBO{
    public boolean isSaveRoom(RoomDTO dto) throws SQLException;
    public boolean isUpdateRoom(RoomDTO dto) throws SQLException;
    public boolean isDeleteRoom(RoomDTO room) throws SQLException;
}
