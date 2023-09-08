package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hostel_management_system.bo.SuperBO;
import lk.ijse.hostel_management_system.dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean isSaveStudent(StudentDTO dto) throws SQLException;
    public boolean isUpdateStudent(StudentDTO dto) throws SQLException;
    public boolean isDeleteStudent(StudentDTO dto) throws SQLException;
    public StudentDTO searchStudent(String id) throws SQLException;
    public List<StudentDTO> getAllStudents() throws SQLException;
}
