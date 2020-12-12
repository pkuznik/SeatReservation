
package pl.polsl.seatreservation.view;

import java.util.Scanner;

/**
 * Class support input data
 * 
 * @author Piotr Kuźnik
 * @version 2.0
 */
public class InputData {
    
    /** 
     * A simple text scanner from keyboard
     */
    private final Scanner scanner;

    /**
     * Constructor
     */
    public InputData() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * get the number of columns from the user
     * 
     * @return Number of chairs in row CienameHall
     */
    public int readWidthHall() {
        return readInteger("Podaj ilość krzeseł w rzędzie:");
    }
    
    
    /**
     * get the number of rows from the user
     * 
     * @return Number of chairs in column CienameHall
     */
    public int readHeightHall() {
        return readInteger("Podaj ilość rzędów: ");
    }
    
    
    /**
     * download from the user the number of chairs to be left empty between reservations in row
     * 
     * @return Number of free chairs between chairs reserved in row
     */
    public int readRowSpaceBetweenReservedChairs() {
        return readInteger("Podaj odstęp w rzędzie pomiędzy zarezerwowanymi już miejscami: ");
    }
    
    /**
     * download from the user the number of chairs to be left empty between reservations in column 
     * 
     * @return Number of free chairs between chairs reserved in column
     */
    public int readColumnSpaceBetweenReservedChairs() {
        return readInteger("Podaj odstęp w kolumnie pomiędzy zarezerwowanymi już miejscami: ");
    }
    
    /**
     * gets the value as an integer from the user, retries the request on error
     * 
     * @param message Question for user
     * @return the user's response as number to the question passed to the message parameter 
     */
    private int readInteger(String message) {
        System.out.println(message);
        String text = scanner.next();
        int number;
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException execption) {
            System.out.println("\nWprowadzone dane nie są liczbą!");
            
            return this.readInteger(message);
        }
    
        return number;
    }

    /**
     * the method takes from the user the number of chairs for a single reservation
     * 
     * @return Array of number to order reserve chairs in cinema hall
     */
    public String[] readQuantityOfChairsToReserve() {
        System.out.println("Podaj kolejno ilość miejsc do zarezerowowania. Liczby odziel spacją");
        String text = scanner.nextLine();
        return text.split(" ");
    }
}
