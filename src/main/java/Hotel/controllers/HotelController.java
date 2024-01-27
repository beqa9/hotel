package Hotel.controllers;


import Hotel.entities.Hotel;
import Hotel.models.HotelModel;
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

    @PostMapping("/add")
    public Hotel addHotel(@RequestParam Integer id, @RequestBody HotelModel hotelModel) {
        return hotelService.addHotelByIdAndModel(id, hotelModel);
    }
}