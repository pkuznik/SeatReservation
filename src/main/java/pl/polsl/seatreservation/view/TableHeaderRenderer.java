
package pl.polsl.seatreservation.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Renderer cell for header row and last columns
 * 
 * @author Piotr Kuźnik
 * @version 3.0
 */
public class TableHeaderRenderer extends JLabel implements TableCellRenderer {
    
    /**
     * Constructor
     */
     public TableHeaderRenderer() {
        setOpaque(true);
        setFont(new Font("Consolas", Font.BOLD, 14));
        setForeground(Color.white);
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createEtchedBorder());
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
     * @return instance of TableHeaderRenderer 
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if (row == -1) {
            setText(value.toString());
        } else {
            setText("" + (row + 1));
        }
     
        return this;
    }
}
