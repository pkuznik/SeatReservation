
package pl.polsl.seatreservation.model;

import java.util.List;

/**
 * Entity class for startup parameters
 * 
 * @author Piotr Kuźnik
 * @version 2.0
 */
public class Parameters {
    
    /**
     * @var int number of chairs in a row available in the cinema room
     */
    private final int sizeX;
    
    /**
     * @var int  number of chairs in a column available in the cinema room
     */
    private final int sizeY;

    /**
     * @var the number of chairs to be left empty between reservations in row
     */
    private final int spaceX;
    
    /**
     * @var the number of chairs to be left empty between reservations in column
     */
    private final int spaceY;
    
    
    private final List<Integer> quantityOfChairsToReserve;

    /**
     * Constructor 
     * 
     * @param sizeX int number of chairs in a row available in the cinema room
     * @param sizeY int  number of chairs in a column available in the cinema room
     * @param spaceX int number of chairs to be left empty between reservations in row
     * @param spaceY int number of chairs to be left empty between reservations in column
     * @param quantityOfChairsToReserve number of chairs for a single reservation
     */
    public Parameters(int sizeX, int sizeY, int spaceX, int spaceY, List<Integer> quantityOfChairsToReserve, int mode) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.spaceX = spaceX;
        this.spaceY = spaceY;
        this.quantityOfChairsToReserve = quantityOfChairsToReserve;
    }
    
    /**
     * get the number of chairs in a row available in the cinema room
     * @return int
     */
    public int getSizeX() {
        return sizeX;
    }

    /**
     * get number of chairs in a column available in the cinema room
     * @return int
     */
    public int getSizeY() {
        return sizeY;
    }

    /**
     * get number of chairs to be left empty between reservations in row
     * @return int
     */
    public int getSpaceX() {
        return spaceX;
    }
    
    /**
     * get number of chairs to be left empty between reservations in column
     * @return int
     */
    public int getSpaceY() {
        return spaceY;
    }

    /**
     * get numbers of chairs for a single reservation
     * @return List of integer
     */
    public List<Integer> getQuantityOfChairsToReserve() {
        return this.quantityOfChairsToReserve;
    }
}


