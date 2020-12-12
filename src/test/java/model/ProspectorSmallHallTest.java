
package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.seatreservation.model.Prospector;
import pl.polsl.seatreservation.model.SeatReservationException;
import pl.polsl.seatreservation.model.CinemaHall;

/**
 *
 * @author Piotr Kuźnik
 * @version 1.0
 */
public class ProspectorSmallHallTest {
    
     /**
     * @var Prospector algorithm searching for free seats in the cinema room 
     */
    private final Prospector prospector;

    public ProspectorSmallHallTest() {
        CinemaHall hall = new CinemaHall(10, 10);
        this.prospector = new Prospector(hall, 0, 0);
    }
        
    /**
     * Test check reserved all from source array
     * 
     * @param numberOfchairs Order number of chairs to reserved
     */
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 2, 3, 4, 5, 6})
    public void testSmallHall(Integer numberOfchairs) {
        Boolean error = false;
        
        try {
            this.prospector.findNextToTheChairNextToYou(numberOfchairs);
        } catch (SeatReservationException e) {
            error = true;
        }
        assertFalse(error, "Błędny algorytm nie można zarezerwować " + numberOfchairs + " miejsc w sali kinowej!");
    }
}
