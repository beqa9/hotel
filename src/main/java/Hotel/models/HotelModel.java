package Hotel.models;

import lombok.Builder;

@Builder
public record HotelModel(
        Integer hotelId,
        String name,
        String description,
        String address,
        boolean hasParking,
        boolean hasWifi
) {
}