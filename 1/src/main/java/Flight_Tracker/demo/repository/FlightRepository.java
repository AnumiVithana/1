package Flight_Tracker.demo.repository;

import Flight_Tracker.demo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
