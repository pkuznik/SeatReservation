package pl.polsl.seatreservation.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Renderer cell for representation reservation chairs
 * 
 * @author Piotr Kuźnik
 * @version 1.0
 */
public class TableChairCellRenderer extends JLabel implements TableCellRenderer {

    /**
     * Constructor
     */
    public TableChairCellRenderer() {
        setFont(new Font("Consolas", Font.BOLD, 14));
        setHorizontalAlignment(JLabel.CENTER);
    }

    /**
     * Prepare cell to print
     * 
     * @param table object instance of JTable
     * @param value object instance from source data
     * @param isSelected boolean true if cell selected 
     * @param hasFocus boolean true if coursore in cell
     * @param row number of row
     * @param column number of column
     * @return instance of TableChairCellRenderer 
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        boolean val = (Boolean) value;
        if (val) {
            setText("X");
        } else {
            setText("");
        }
        
        return this;
    }
}
