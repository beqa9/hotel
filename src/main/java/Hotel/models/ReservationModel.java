package Hotel.models;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

@Builder
public record ReservationModel(
        Integer reservationId,
        Integer roomId,
        String guestName,
        Date checkinDate,
        Date checkoutDate,
        BigDecimal totalPrice
) {
}