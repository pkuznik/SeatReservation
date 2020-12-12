
package pl.polsl.seatreservation.model;

/**
 *
 * @author Piotr Kuźnik
 * @version 1.11
 */
public class Prospector {

    /**
     * #var CinemaHall object of Cinema Hall
     */
    private final CinemaHall hall;
    
    /**
     * @var int Number of free chairs between reserved in row
     */
    private final int spaceX;
    
    /**
     * @var int Number of free chairs between reserved in column
     */
    private final int spaceY;

    /**
     * Constructor 
     * 
     * @param hall Object CinemaHall
     * @param spaceX Number of free chairs between reserved in row
     * @param spaceY Number of free chairs between reserved in column
     */
    public Prospector(CinemaHall hall, int spaceX, int spaceY) {
        this.hall = hall;
        this.spaceX = spaceX;
        this.spaceY = spaceY;
    }

    /**
     * method find next free chairs to reserved 
     * @param quantityChairs number 
     * @return On success object CombinationOfPlace of coords in hall
     * @throws SeatReservationException on errror when cannot reserwation
     */
    public CombinationOfPlace findNextToTheChairNextToYou(int quantityChairs) throws SeatReservationException {
        int freeChairsInRow;
        int startX, endX;
        for (int numberColumn = 1; numberColumn <= this.hall.getQuantityOfChairsInColumn(); numberColumn++) {
            startX = 1;
            freeChairsInRow = 0;
            for (int numberRow = 1; numberRow <= this.hall.getQuntityOfchairsInRow(); numberRow++) {
                endX = numberRow;
                if (this.hall.isChairReserved(numberColumn, numberRow)) {
                    freeChairsInRow = 0;
                    startX = numberRow + this.spaceX;
                } else {
                    freeChairsInRow++;
                }
                    
                
                //System.out.println("Find::" + quantityChairs + " coordinate(" + numberRow + ", " + numberColumn + ") free=" + freeChairsInRow + " prepare (" + startX + ", " + numberColumn + ", " + endX + ", " + numberColumn + ")" );
                if (freeChairsInRow >= quantityChairs) {
                    return new CombinationOfPlace(startX, numberColumn, endX, numberColumn);
                }
            }

            numberColumn += this.spaceY;
        }
        
        throw new SeatReservationException("Brak możliwości zarezerowania " + quantityChairs + " miejsc!");
    }

}