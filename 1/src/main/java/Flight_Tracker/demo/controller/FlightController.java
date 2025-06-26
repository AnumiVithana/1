package Flight_Tracker.demo.controller;

import Flight_Tracker.demo.model.Flight;
import Flight_Tracker.demo.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;


    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }
    @GetMapping
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlight(@PathVariable Long id){
        return flightService.getFlight(id);
    }

    @PostMapping("/{airlineId}/{originId}/{destinationId}")
    public Flight createFlight(@RequestBody Flight flight,
                               @PathVariable Long airlineId,
                               @PathVariable Long originId,
                               @PathVariable Long destinationId)
    {
        return flightService.createFlight(flight,airlineId,originId,destinationId);
    }

    @PostMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight){
        return flightService.updateFlight(id,flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
    }

}
