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
 * @version 2.0
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
     *
     * @param sizeX quantity chairs in row
     * @param sizeY quantity chairs in column
     */
    public void setHallSize(int sizeX, int sizeY) {
        this.hall = new CinemaHall(sizeX, sizeY);
    }

    /**
     *
     * @return quantity of chairs in one row
     */
    public int getWidthCinemaHall() {
        return this.hall.getQuntityOfchairsInRow();
    }

    /**
     *
     * @return quantity of chairs in one column
     */
    public int getHeightCinemaHall() {
        return this.hall.getQuantityOfChairsInColumn();
    }

    /**
     *
     * @param quantityOfChairs quantity chairs to reserved
     */
    public void reserveQuantityOfChairs(int quantityOfChairs) {
        CombinationOfPlace coordinate;
        try {
            coordinate = this.prospector.findNextToTheChairNextToYou(quantityOfChairs);
            hall.reserveCombinateOfPlace(coordinate);
        } catch (SeatReservationException exception) {
            System.out.println("Błąd! " + exception.getMessage());
        }
    }

    /**
     *
     * @return Model for ListInput
     */
    public javax.swing.AbstractListModel<String> renderGraficToModelList() {
        CinemaHallRender render = new CinemaHallRender(this.hall);

        return render.genericModel();
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
                controller.reserveQuantityOfChairs(quantityOfChairs);
            });

            CinemaHallRender render = new CinemaHallRender(controller.hall);
            render.renderingGraphicallyInConsole();
        }
    }
}
