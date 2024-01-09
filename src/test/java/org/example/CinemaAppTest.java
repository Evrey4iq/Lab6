package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CinemaAppTest {

    private CinemaApp cinema;

    @BeforeEach
    void setUp() {
        cinema = new CinemaApp();
    }

    @Test
    void bookSeats() {
        cinema.bookSeats(1, 2, new int[]{3, 4, 5});
        assertTrue(cinema.checkAvailability(1, 3));
    }

    @Test
    void cancelBooking() {
        cinema.bookSeats(1, 2, new int[]{3, 4, 5});
        assertTrue(cinema.checkAvailability(1, 3));
        cinema.cancelBooking(1, 2, new int[]{3, 4});
        assertTrue(cinema.checkAvailability(1, 5));
    }

    @Test
    void checkAvailability() {
        assertTrue(cinema.checkAvailability(1, 5));
        cinema.bookSeats(1, 2, new int[]{3, 4, 5});
    }

    @Test
    void printSeatingArrangement() {
        cinema.bookSeats(0, 0, new int[]{0, 1, 2});
        cinema.bookSeats(0, 1, new int[]{3, 4, 5});
        cinema.bookSeats(0, 2, new int[]{6, 7, 8});

        // Тут просто виведемо на консоль для перевірки вручну
        cinema.printSeatingArrangement(0);
    }
}