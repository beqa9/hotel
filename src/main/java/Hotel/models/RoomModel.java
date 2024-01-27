package Hotel.models;

import lombok.Builder;

@Builder
public record RoomModel(
        Integer roomId,
        Integer roomNumber,
        String category,
        Integer capacity,
        float price

) {
}