
package pl.polsl.seatreservation.model;

/**
 * This class is representation simple reservation on N chairs
 * 
 * @author Piotr Kuźnik
 * @version 2.0
 */ 
public class CombinationOfPlace {
   
    /**
     * @var int beginning of the reservation range in the row 
     */
    private final int startX;
    
    /**
     * @var int beginning of the reservation range in the column
     */
    private final int startY;
    
    /**
     * @var int end of reservation range in a row
     */
    private final int endX;
    
    /**
     * @var end of reservation range in a column
     */
    private final int endY;

    /**
     * Constructor
     * 
     * @param startX Number chair start to reserved in row
     * @param startY Number chair start to reserved in column
     * @param endX Number chair end to reserved in row
     * @param endY Number chair end to reserved in column
     */
    public CombinationOfPlace(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    /**
     * Method return beginning of the reservation range in the row 
     * @return int 
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Method return beginning of the reservation range in the column
     * @return int
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Method return  end of reservation range in a row
     * @return int
     */
    public int getEndX() {
        return endX;
    }

    /**
     * Method return  end of reservation range in a column
     * @return int
     */
    public int getEndY() {
        return endY;
    }
    
}