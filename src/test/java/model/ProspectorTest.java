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
import pl.polsl.seatreservation.model.CombinationOfPlace;
import pl.polsl.seatreservation.view.CinemaHallRender;

/**
 *
 * @author Piotr Kuźnik
 * @version 1.1
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

    @DisplayName("Test sytuacji wyjątkowej - rezerwacja dwóch rzędów")
    @Test
    public void testTwoRowsReservedInCienameHall() {
        CinemaHall hall = new CinemaHall(10, 10);
        Prospector prospector = new Prospector(hall, 0, 0);
        Boolean error = false;

        try {
            prospector.findNextToTheChairNextToYou(20);
        } catch (SeatReservationException e) {
            error = true;
        }
        assertFalse(error, "Nie obsłużono rezerwacji kilku rzędów sali kinowej!");
    }

    @DisplayName("Test sytuacji wyjątkowej - przepełnienie")
    @Test
    public void testOwerflowCienameHall() {
        CinemaHall hall = new CinemaHall(10, 10);
        Prospector prospector = new Prospector(hall, 0, 0);
        Boolean error = false;
        CombinationOfPlace coordinate = null;
        try {
            coordinate = prospector.findNextToTheChairNextToYou(10);
            hall.reserveCombinateOfPlace(coordinate);

            coordinate = prospector.findNextToTheChairNextToYou(20);
            hall.reserveCombinateOfPlace(coordinate);

            coordinate = prospector.findNextToTheChairNextToYou(30);
            hall.reserveCombinateOfPlace(coordinate);

            coordinate = prospector.findNextToTheChairNextToYou(40);
            hall.reserveCombinateOfPlace(coordinate);

            coordinate = prospector.findNextToTheChairNextToYou(1); //overflow
        } catch (SeatReservationException e) {
            error = true;
        }
        
        assertTrue(error, "Nie obsłużono przepełnienia sali kinowej! - " + coordinate);
    }
}
