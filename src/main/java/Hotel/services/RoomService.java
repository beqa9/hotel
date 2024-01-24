package Hotel.services;

import Hotel.entities.Room;
import Hotel.models.RoomModel;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();

    Room addRoom(RoomModel roomModel);
}