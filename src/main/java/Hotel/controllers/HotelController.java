package Hotel.controllers;


import Hotel.entities.Hotel;
import Hotel.entities.Room;
import Hotel.models.HotelModel;
import Hotel.models.RoomModel;
import Hotel.services.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/all")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@RequestParam Integer id) {
        return hotelService.getHotelById(id);
    }

    @PostMapping("/add")
    public Hotel addHotel(@RequestParam Integer id, @RequestBody HotelModel hotelModel) {
        return hotelService.addHotelByModel(hotelModel);
    }

    @PutMapping("/{id}/update")
    public Hotel updateHotel(@PathVariable Integer id, @RequestBody HotelModel hotelModel) {
        return hotelService.updateHotelByIdAndModel(id, hotelModel);
    }

}