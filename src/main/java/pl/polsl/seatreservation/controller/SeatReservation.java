package pl.polsl.seatreservation.controller;

import pl.polsl.seatreservation.model.CinemaHall;
import pl.polsl.seatreservation.model.CombinationOfPlace;
import pl.polsl.seatreservation.model.Parameters;
import pl.polsl.seatreservation.model.Prospector;
import pl.polsl.seatreservation.model.SeatReservationException;
import pl.polsl.seatreservation.view.CinemaHallRender;
import pl.polsl.seatreservation.view.ReservationWindow;

/**
 * Main app controller
 *
 * @author Piotr Kuźnik
 * @version 3.0
 */
public class SeatReservation {

    /**
     * Obeject cinema hall
     */
    private CinemaHall hall;

    /**
     * algorithm looking for vacancies
     */
    private Prospector prospector;

    /**
     * Constructor 
     * 
     * @param parameters Input parametres
     */
    public SeatReservation(Parameters parameters) {
        this.hall = new CinemaHall(parameters.getSizeX(), parameters.getSizeY());
        try {
            this.prospector = new Prospector(this.hall, parameters.getSpaceX(), parameters.getSpaceY());
        } catch (SeatReservationException e) {}
    }

    /**
     * Set new size cinema hall
     * 
     * @param sizeX quantity chairs in row
     * @param sizeY quantity chairs in column
     */
    public void setHallSize(int sizeX, int sizeY) {
        this.hall = new CinemaHall(sizeX, sizeY);
    }

    /**
     * Set new Covid Config
     * 
     * @param spaceInRow space in row beetwen chairs reserved
     * @param spaceInColumn space in column beetwen chairs reserved
     */
    public void setSpaceBeetwenChairsReserved(int spaceInRow, int spaceInColumn) {
        try {
            this.prospector = new Prospector(this.hall,spaceInRow, spaceInColumn);
        } catch (SeatReservationException e) {}
    }
    


    /**
     *
     * @param quantityOfChairs quantity chairs to reserved
     * @throws SeatReservationException throw when param hall is null
     */
    public void reserveQuantityOfChairs(int quantityOfChairs) throws SeatReservationException {
        CombinationOfPlace coordinate;
        try {
            coordinate = this.prospector.findNextToTheChairNextToYou(quantityOfChairs);
            hall.reserveCombinateOfPlace(coordinate);
        } catch (SeatReservationException exception) {
            throw new SeatReservationException("Nie można utworzyć rezerwacji! " + exception.getMessage());
        }
    }
    
    /**
     * 
     * @return object of CinemaHall
     */
    public CinemaHall getHall() {
        return this.hall;
    }
    
    /**
     * 
     * @return Object of Prospector
     */
    public Prospector getProspector() {
        return this.prospector;
    }
    
    /**
     *
     * @param args the argument array passed to the program. Parameters can be
     * passed in any order.
     *
     * Program call: java SeatReservation.java [parameter] [sequence number of
     * seats to reserve]
     *
     * Parameters: -sizeX Number of chairs in a row -sizeY The number of chairs
     * in the column -spaceX Number of vacant chairs in a row as a space between
     * reserved ones -spaceY Number of free chairs in the column as a space
     * between reserved ones -mode UI Mode 1 = console, 2 = dialog graphic
     * default dialog graphic
     *
     */
    public static void main(String args[]) {
        FilterParams filter = new FilterParams(args);
        Parameters params = filter.getParameters();

        SeatReservation controller = new SeatReservation(params);

        if (params.getUIMode() == Parameters.UI_MODE_GRAPHIC) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(ReservationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(ReservationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(ReservationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(ReservationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ReservationWindow(controller).setVisible(true);
                }
            });
        }

        if (params.getUIMode() == Parameters.UI_MODE_CONSOLE) {
            params.getQuantityOfChairsToReserve().forEach(quantityOfChairs -> {
                try {
                    controller.reserveQuantityOfChairs(quantityOfChairs);
                } catch (SeatReservationException e) {
                    System.out.println(e.getMessage());
                }
            });

            CinemaHallRender render = new CinemaHallRender(controller.hall);
            render.renderingGraphicallyInConsole();
        }
    }
}
