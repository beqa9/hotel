package Hotel.controllers;

import Hotel.entities.Reservation;
import Hotel.models.ReservationModel;
import Hotel.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping("/add/{roomId}")
    public Reservation addReservation(@PathVariable Integer roomId, @RequestBody ReservationModel reservationModel) {
        return reservationService.addReservationByIdAndModel(roomId, reservationModel);
    }

    @PutMapping("/{reservationId}/update")
    public Reservation updateReservation(@PathVariable Integer reservationId, @RequestBody ReservationModel reservationModel) {
        return reservationService.updateReservationByIdAndModel(reservationId, reservationModel);
    }
}