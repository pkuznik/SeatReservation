package pl.polsl.seatreservation.model;

/**
 * Collection chairs in one cinema hall
 *
 * @author Piotr Kuźnik
 * @version 2.0
 */
public class CinemaHall {

    /**
     * List of object with two-dimensional array as List
     *
     * @var TwoDimensionalBox
     */
    private final TwoDimensionalBox<Boolean> space;

    /**
     * Construcotr
     *
     * @param width nuber of chairs in row
     * @param height number of chairs in column
     */
    public CinemaHall(int width, int height) {
        this.space = new TwoDimensionalBox<>(width, height, false);
    }

    /**
     * returns the number of chairs in a column
     *
     * @return quantity of chairs in one column
     */
    public int getQuantityOfChairsInColumn() {
        return this.space.getColumnSize();
    }

    /**
     * returns the number of chairs in a row
     *
     * @return quantity of chairs in one row
     */
    public int getQuntityOfchairsInRow() {
        return this.space.getRowSize();
    }

    /**
     * checks if the chair with the given coordinates is reserved
     *
     * @param numberColumn Number of column
     * @param numberRow Number of row
     * @return True if chair is reservation
     */
    public boolean isChairReserved(int numberColumn, int numberRow) {
        return this.space.get(numberRow, numberColumn);
    }

    /**
     * This metod save reserve chair in cinema hall about coordinte x,y
     *
     * @param numberColumn nuober column
     * @param numberRow number row
     * @return True if success
     */
    public boolean reserveChair(int numberColumn, int numberRow) {
        if (isChairReserved(numberColumn, numberRow) == false) {
            this.space.add(numberRow, numberColumn, true);
            return true;
        }

        return false;
    }

    /**
     * method denotes the range of chairs provided by the cinema room facility
     * as reserved
     *
     * @param combinateOfPlace Object of combinate coordinate column and row to
     * chair reserve
     */
    public void reserveCombinateOfPlace(CombinationOfPlace combinateOfPlace) {
        for (int y = combinateOfPlace.getStartY(); y <= combinateOfPlace.getEndY(); y++) {
            for (int x = combinateOfPlace.getStartX(); x <= combinateOfPlace.getEndX(); x++) {
                this.reserveChair(y, x);
            }
        }
    }
}
