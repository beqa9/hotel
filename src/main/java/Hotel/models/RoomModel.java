package Hotel.models;

import Hotel.entities.Room;
import lombok.Builder;

@Builder
public record RoomModel(
        Integer id,
        Integer roomNumber,
        String category,
        boolean isSmoking,
        Integer hotelId
) {
    public static RoomModel fromRoom(Room room) {
        return RoomModel.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .category(room.getCategory())
                .isSmoking(room.isSmoking())
                .build();
    }
}