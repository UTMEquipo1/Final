/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedor.persisitencia;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author willm
 */
public class RenderImagen extends DefaultTableCellRenderer{
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {
        if (value instanceof JLabel) {
            JLabel lbl = (JLabel) value;
            return lbl;

        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
    
    
    
}
