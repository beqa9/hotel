package Hotel.models;

import lombok.Builder;

@Builder
public record HotelModel(
        String name,
        String description,
        String address,
        boolean hasParking,
        boolean hasWifi
) {
}