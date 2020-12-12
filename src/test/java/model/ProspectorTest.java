/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import pl.polsl.seatreservation.model.Prospector;
import pl.polsl.seatreservation.model.SeatReservationException;
import pl.polsl.seatreservation.model.CinemaHall;

/**
 *
 * @author Piotr Kuźnik
 * @version 1.0
 */
public class ProspectorTest {

    @DisplayName("Najprostszy test algorytmu ;-)")
    @Test
    public void testReserveChairsAlgorithIsReadyToUse() {

        CinemaHall hall = new CinemaHall(10, 10);
        Prospector prospector = new Prospector(hall, 0, 0);
        Boolean error = false;
        
        try {
            prospector.findNextToTheChairNextToYou(1);
        } catch (SeatReservationException e) {
            error = true;
        }
        assertFalse(error, "Błędny algorytm nie można nic zarezerwować!");
    }
 }
