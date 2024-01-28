package Hotel.services;

import Hotel.entities.Reservation;
import Hotel.models.ReservationModel;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations();

    Reservation addReservationByIdAndModel(Integer id, ReservationModel reservationModel);
}