package Hotel.services;

import Hotel.entities.Reservation;
import Hotel.entities.Room;
import Hotel.models.ReservationModel;
import Hotel.repositories.ReservationRepository;
import Hotel.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
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

        if (!isRoomAvailable(room, reservationModel.checkinDate(), reservationModel.checkoutDate())) {
            throw new IllegalArgumentException("Room is already taken for the specified dates. Please choose another room or adjust your dates.");
        }

        Reservation reservation = new Reservation();
        reservation.setRoom(room);
        reservation.setGuestName(reservationModel.guestName());
        reservation.setCheckinDate(reservationModel.checkinDate());
        reservation.setCheckoutDate(reservationModel.checkoutDate());
        reservation.setTotalPrice(reservationModel.totalPrice());

        return reservationRepository.save(reservation);
    }

    private boolean isRoomAvailable(Room room, Date checkinDate, Date checkoutDate) {
        // Check if the room is available for the specified dates
        long overlappingReservations = reservationRepository.countByRoomAndCheckinDateLessThanEqualAndCheckoutDateGreaterThanEqual(
                room,
                checkoutDate,
                checkinDate
        );

        return overlappingReservations == 0;
    }
    @Override
    public Reservation updateReservationByIdAndModel(Integer id, ReservationModel reservationModel) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Reservation not found"));

        existingReservation.setGuestName(reservationModel.guestName());
        existingReservation.setCheckinDate(reservationModel.checkinDate());
        existingReservation.setCheckoutDate(reservationModel.checkoutDate());
        existingReservation.setTotalPrice(reservationModel.totalPrice());

        return reservationRepository.save(existingReservation);
    }
}