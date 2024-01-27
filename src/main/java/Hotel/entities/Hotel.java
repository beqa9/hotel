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
@Table(schema ="public", name = "hotel")
public class Hotel {
    @Id
    private Integer hotelId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "has_parking")
    private boolean hasParking;

    @Column(name = "has_wifi")
    private boolean hasWifi;
}
