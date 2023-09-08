package lk.ijse.hostel_management_system.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTM {
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private String date_of_birth;
    private String gender;
}
