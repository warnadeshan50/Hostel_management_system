package lk.ijse.hostel_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private String date_of_birth;
    private String gender;
}
