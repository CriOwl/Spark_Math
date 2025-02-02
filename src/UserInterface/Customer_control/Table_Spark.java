package UserInterface.Customer_control;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import UserInterface.Spark_Style;
import java.awt.Color;

public class Table_Spark extends Jtable{
    public Table_Spark(){
        set_customize();
    }
    public Table_Spark(DefaultTableModel model){
        set_customize();
    }
    public Table_Spark(Font font, Color color_font, Color color_background,Color color_background_grid,Color setSelectionBackground){
        set_customize(Font font, Color color_font, Color color_background,Color color_background_grid,Color setSelectionBackground);
    }
    private void set_customize(){
        setFont(Spark_Style.FONT);
        setForeground(Spark_Style.COLOR_FONT);
        setBackground(Spark_Style.COLOR_BACKGROUND);
        setGridColor(Spark_Style.COLOR_BACKGROUND_GRID);
        setSelectionBackground(Spark_Style.COLOR_BACKGROUND_SELECT);
        setSelectionForeground(Spark_Style.COLOR_FONT);
        setRowHeight(30);
        setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        setOpaque(false);
        setFocusable(true);
        setRowSelectionAllowed(true);
        setColumnSelectionAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setDefaultEditor(Object.class, null);        
    }
    private void set_customize(Font font, Color color_font, Color color_background,Color color_background_grid,Color setSelectionBackground){
        setFont(font);
        setForeground(color_font);
        setBackground(color_background);
        setGridColor(color_background_grid);
        setSelectionBackground(setSelectionBackground);
        setSelectionForeground(font);
        setRowHeight(30);
        setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        setOpaque(false);
        setFocusable(true);
        setRowSelectionAllowed(true);
        setColumnSelectionAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setDefaultEditor(Object.class, null);        
    }   
}
