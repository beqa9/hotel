package Hotel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(schema = "public", name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "category")
    private String category;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "price")
    private float price;

}
