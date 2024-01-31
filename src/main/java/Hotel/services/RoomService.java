package Hotel.services;

import Hotel.entities.Room;
import Hotel.models.RoomModel;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();

    Room addRoomByModel(RoomModel roomModel);
    Room updateRoomByIdAndModel(Integer id, RoomModel roomModel);
    Room getRoomById(Integer id);

}