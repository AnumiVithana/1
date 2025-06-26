package Flight_Tracker.demo.controller;

import Flight_Tracker.demo.model.Airline;
import Flight_Tracker.demo.service.AirlineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping
    public List<Airline> getAllAirlines(){
        return airlineService.getAllAirlines();
    }

    @GetMapping("/{id}")
    public Airline getAirline(@PathVariable Long id){
        return airlineService.getAllAirlineById(id).orElseThrow();
    }

    @PostMapping
    public Airline createAirline(@RequestBody Airline airline){
        return airlineService.createAirline(airline);
    }

    @PutMapping("/{id}")
    public Airline updateAirline(@PathVariable Long id, @RequestBody Airline airline){
        return airlineService.updateAirline(id,airline);
    }

    @DeleteMapping("/{id}")
    public void deleteAirline(@PathVariable Long id){
        airlineService.deleteAirline(id);
    }
}
