package Hotel.services;

import Hotel.entities.Hotel;
import Hotel.models.HotelModel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();

    Hotel addHotelByIdAndModel(Integer id, HotelModel hotelModel);
}