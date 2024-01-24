package Hotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(schema = "public", name = "room")
public class Room {
    @Id
    private Integer id;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "category")
    private String category;

    @Column(name = "is_smoking")
    private boolean isSmoking;
}
