package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hostel_management_system.bo.SuperBO;
import lk.ijse.hostel_management_system.dto.StudentDTO;

import java.sql.SQLException;

public interface StudentBO extends SuperBO {
    public boolean isSaveStudent(StudentDTO dto) throws SQLException;
    public boolean isUpdateStudent(StudentDTO dto) throws SQLException;
    public boolean isDeleteStudent(String id) throws SQLException;
}
