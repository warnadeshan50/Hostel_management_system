package lk.ijse.hostel_management_system.bo.custom.impl;

import lk.ijse.hostel_management_system.bo.custom.StudentBO;
import lk.ijse.hostel_management_system.dao.DAOFactory;
import lk.ijse.hostel_management_system.dao.custom.StudentDAO;
import lk.ijse.hostel_management_system.dto.StudentDTO;
import lk.ijse.hostel_management_system.dto.UserDTO;
import lk.ijse.hostel_management_system.entity.Student;
import lk.ijse.hostel_management_system.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public boolean isDeleteStudent(StudentDTO dto) throws SQLException {
        return studentDAO.isDelete(new Student(dto.getStudent_id(),dto.getName(),dto.getAddress(),dto.getContact_no(),dto.getDate_of_birth(),dto.getGender()));
    }

    @Override
    public StudentDTO searchStudent(String id) throws SQLException {
        Student student=studentDAO.search(id);
        if(student!=null) {
            return new StudentDTO(student.getStudent_id(),student.getName(),student.getAddress(),student.getContact_no(),student.getDate_of_birth(),student.getGender());
        }
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudents() throws SQLException {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        List<Student>all=studentDAO.getAll();
        for (Student student:all) {
            studentDTOS.add(new StudentDTO(student.getStudent_id(),student.getName(),student.getAddress(),student.getContact_no(),student.getDate_of_birth(),student.getGender()));
        }
        return studentDTOS;
    }
}
