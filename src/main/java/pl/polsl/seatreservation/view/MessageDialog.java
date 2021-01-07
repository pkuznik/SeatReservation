package pl.polsl.seatreservation.view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * This class is generic comunication dialogs
 *
 * @author Piotr Kuźnik
 * @version 2.1
 */
public class MessageDialog {

    /**
     * Show dialog message type of warming
     * 
     * @param message message to show
     */
    public void showWarming(String message) {
        JOptionPane alert = new JOptionPane(message, JOptionPane.WARNING_MESSAGE);
        JDialog alertDialog = alert.createDialog("Błąd");
        alertDialog.setAlwaysOnTop(true);
        alertDialog.setVisible(true);
    }
    
    /**
     * Show dialog message type info
     * 
     * @param message message to show
     */
    public void showInfo(String message) {
        JOptionPane alert = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
        JDialog alertDialog = alert.createDialog("Informacja");
        alertDialog.setAlwaysOnTop(true);
        alertDialog.setVisible(true);
    }
}
