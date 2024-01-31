package Hotel.services;

import Hotel.entities.Hotel;
import Hotel.entities.Room;
import Hotel.models.HotelModel;
import Hotel.models.RoomModel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();

    Hotel addHotelByModel(HotelModel hotelModel);

    Hotel getHotelById(Integer id);

    Hotel updateHotelByIdAndModel(Integer id, HotelModel hotelModel);
}