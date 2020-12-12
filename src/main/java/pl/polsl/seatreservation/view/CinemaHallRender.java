
package pl.polsl.seatreservation.view;

import pl.polsl.seatreservation.model.CinemaHall;

/**
 * The task of the class is to display a graphic representation of a cinema hall 
 * or in the form of a list of occupied seats
 * 
 * @author Piotr Kuźnik
 * @version 2.0
 */
public class CinemaHallRender {
 
    /** 
     * @var Model of CinemaHall
     */
    private final CinemaHall cinemaHallModel;

    /**
     * Constuctor class
     * @param cinemaHallModel Model of CinemaHall
     */
    public CinemaHallRender(CinemaHall cinemaHallModel) {
        this.cinemaHallModel = cinemaHallModel;
    }
    
    
    /**
     * render cinema room graphically in console
     */
    public void renderingGraphicallyInConsole() {
      System.out.println("");
      System.out.println("Sala kinowa o rozmiarze " + (this.cinemaHallModel.getQuntityOfchairsInRow() - 1) + "x" + (this.cinemaHallModel.getQuantityOfChairsInColumn() - 1));
      
      System.out.print("_X_ ");
      for (int x = 1; x < this.cinemaHallModel.getQuntityOfchairsInRow(); x++) {
          System.out.print("_" + x + "_ ");
      }
      System.out.println("");

      for (int y = 1; y < this.cinemaHallModel.getQuantityOfChairsInColumn(); y++) {
            System.out.print("_" + y + "_ ");
            for (int x = 1; x < this.cinemaHallModel.getQuntityOfchairsInRow(); x++) {
                if (this.cinemaHallModel.isChairReserved(y, x)) {
                    System.out.print("[x]");
                } else {
                    System.out.print("[ ]");
                }
                
                System.out.print(" ");
            }

            System.out.println("");
        }  
    }
    
    /**
     * Generic list model object for use in view ReservationWindow
     * 
     * @return Model for ListInput
     */
    public javax.swing.AbstractListModel<String> genericModel() {
        String lines[] = new String[this.cinemaHallModel.getQuantityOfChairsInColumn()];
        String simpleLine;
        lines[0] = "Sala kinowa";
        for (int y = 1; y < this.cinemaHallModel.getQuantityOfChairsInColumn(); y++) {
            lines[y] = "_" + y + "_ ";
            for (int x = 1; x < this.cinemaHallModel.getQuntityOfchairsInRow(); x++) {
                if (this.cinemaHallModel.isChairReserved(y, x)) {
                    lines[y] += "[x]";
                } else {
                    lines[y] +=  "[ ]";
                }
                lines[y] +=  " ";
            }
        }  
        
        return new javax.swing.AbstractListModel<String>() {
            String[] strings = lines;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        };
    }
}
