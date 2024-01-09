package org.example;

public class CinemaApp {
    private final int NUM_HALLS = 5;
    private final int NUM_ROWS = 10;
    private final int NUM_SEATS_PER_ROW = 20;

    private int[][][] cinemaArray;

    public CinemaApp() {
        cinemaArray = new int[NUM_HALLS][NUM_ROWS][NUM_SEATS_PER_ROW];
        initializeCinemaArray();
    }

    private void initializeCinemaArray() {
        for (int hall = 0; hall < NUM_HALLS; hall++) {
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
                    cinemaArray[hall][row][seat] = 0;
                }
            }
        }
    }

    // Бронювання місць
    public void bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seat < NUM_SEATS_PER_ROW && cinemaArray[hallNumber][row][seat] == 0) {
                cinemaArray[hallNumber][row][seat] = 1;
                System.out.println("Місце " + seat + " в ряду " + row + " в залі " + hallNumber + " успішно заброньовано.");
            } else {
                System.out.println("Місце " + seat + " в ряду " + row + " в залі " + hallNumber + " вже заброньоване або недоступне.");
            }
        }
    }

    // Скасування бронювання
    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (cinemaArray[hallNumber][row][seat] == 1) {
                cinemaArray[hallNumber][row][seat] = 0;
                System.out.println("Бронь для місця " + seat + " в ряду " + row + " в залі " + hallNumber + " скасована.");
            } else {
                System.out.println("Місце " + seat + " в ряду " + row + " в залі " + hallNumber + " не було заброньоване.");
            }
        }
    }

    // Перевірка доступності заданої кількості місць
    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
                boolean available = true;
                for (int i = 0; i < numSeats; i++) {
                    if (seat + i >= NUM_SEATS_PER_ROW || cinemaArray[hallNumber][row][seat + i] == 1) {
                        available = false;
                        break;
                    }
                }
                if (available) {
                    System.out.println("Доступно " + numSeats + " послідовних місць в ряду " + row + " в залі " + hallNumber + ".");
                    return true;
                }
            }
        }
        System.out.println("Недостатньо послідовних місць в залі " + hallNumber + ".");
        return false;
    }


    // Друк схеми розміщення місць для заданого залу
    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Схема розміщення місць для залу " + hallNumber + ":");
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
                if (cinemaArray[hallNumber][row][seat] == 0) {
                    System.out.print("O "); // Вільне місце
                } else {
                    System.out.print("X "); // Заброньоване місце
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        CinemaApp cinema = new CinemaApp();

        cinema.bookSeats(1, 2, new int[]{3, 4, 5});
        cinema.printSeatingArrangement(1);

        cinema.cancelBooking(1, 2, new int[]{3, 4});
        cinema.printSeatingArrangement(1);

        cinema.checkAvailability(1, 2);
    }
}
