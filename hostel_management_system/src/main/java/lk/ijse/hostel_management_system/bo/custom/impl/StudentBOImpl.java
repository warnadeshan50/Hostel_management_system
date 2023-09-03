package lk.ijse.hostel_management_system.bo.custom.impl;

import lk.ijse.hostel_management_system.bo.custom.StudentBO;
import lk.ijse.hostel_management_system.dao.DAOFactory;
import lk.ijse.hostel_management_system.dao.custom.StudentDAO;
import lk.ijse.hostel_management_system.dto.StudentDTO;
import lk.ijse.hostel_management_system.entity.Student;

import java.sql.SQLException;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO= (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public boolean isSaveStudent(StudentDTO dto) throws SQLException {
        return studentDAO.isSave(new Student(dto.getStudent_id(),dto.getName(),dto.getAddress(),dto.getContact_no(),dto.getDate_of_birth(),dto.getGender()));
    }

    @Override
    public boolean isUpdateStudent(StudentDTO dto) throws SQLException {
        return studentDAO.isUpdate(new Student(dto.getStudent_id(),dto.getName(),dto.getAddress(),dto.getContact_no(),dto.getDate_of_birth(),dto.getGender()) );
    }

    @Override
    public boolean isDeleteStudent(String id) throws SQLException {
        return studentDAO.isDelete(id);
    }
}
