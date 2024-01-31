package Hotel.repositories;

import Hotel.entities.Reservation;
import Hotel.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;


public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    long countByRoomAndCheckinDateLessThanEqualAndCheckoutDateGreaterThanEqual(
            Room room,
            Date checkinDate,
            Date checkoutDate
    );
}