package Hotel.services;

import Hotel.entities.Reservation;
import Hotel.entities.Room;
import Hotel.models.ReservationModel;
import Hotel.repositories.ReservationRepository;
import Hotel.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservationByIdAndModel(Integer id, ReservationModel reservationModel) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Room not found"));

        Reservation reservation = new Reservation();
        reservation.setRoom(room);
        reservation.setGuestName(reservationModel.guestName());
        reservation.setCheckinDate(reservationModel.checkinDate());
        reservation.setCheckoutDate(reservationModel.checkoutDate());
        reservation.setTotalPrice(reservationModel.totalPrice());

        return reservationRepository.save(reservation);
    }
}