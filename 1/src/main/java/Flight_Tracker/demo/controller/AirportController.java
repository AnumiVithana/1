package Flight_Tracker.demo.controller;

import Flight_Tracker.demo.model.Airport;
import Flight_Tracker.demo.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService airportService;


    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public List<Airport> getAllAirports(){
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public Airport getAirport(@PathVariable Long id){
        return airportService.getAirport(id);
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport){
        return airportService.createAirport(airport);
    }

    @PutMapping("/{id}")
    public Airport updateAirport(@PathVariable Long id, @RequestBody Airport airport){
        return airportService.updateAirport(id, airport);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id){
        airportService.deleteAirport(id);
    }

    @GetMapping("/country/{country}")
    public List<Airport> findByCountry(@PathVariable String country){
        return airportService.findByCountry(country);
    }
}
