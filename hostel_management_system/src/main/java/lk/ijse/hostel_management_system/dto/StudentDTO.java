package lk.ijse.hostel_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private String date_of_birth;
    private String gender;
}
