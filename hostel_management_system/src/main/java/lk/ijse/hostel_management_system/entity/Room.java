package lk.ijse.hostel_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    private String room_type_id;
    private String room_type;
    private double key_money;
    private int room_qty;
}
