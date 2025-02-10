package UserInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public abstract class Spark_Style {
    public static final Color COLOR_FONT = new Color(130, 130, 0);
    public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100);
    public static final Color COLOR_CURSOR = Color.black; // cambiar segun el estilo
    public static final Color COLOR_BACKGROUND          = Color.black;
    public static final Color COLOR_BACKGROUND_GRID     = Color.black;
    public static final Color COLOR_BACKGROUND_SELECT   = Color.black;
    public static final Font FONT = new Font("Cambria Math", Font.PLAIN, 15);
    public static final Font FONT_BOLD = new Font("Century Gothic", Font.BOLD, 15);
    public static final Font FONT_SMALL = new Font("JetBrains Mono", Font.PLAIN, 15);
    public static final Font FONT_NUMBER = new Font("Digital-7 Mono", Font.PLAIN, 15);
    public static final Dimension dimension_button = new Dimension(150, 45);

    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final String URL_MAIN = "src\\UserInterface\\Resources\\Img\\Kid_playing.png";
    public static final String URL_LOGO = "src\\UserInterface\\Resources\\Icon\\Logo_Spark_Math.png";
    public static final URL URL_SPLASH = Spark_Style.class.getResource("src\\UserInterface\\Resources\\Img\\Kid_playing.png");
    public static final String URL_SUN_THEMES = "src\\UserInterface\\Resources\\Icon\\sun.png";
    public static final String URL_MOON_THEMES = "src\\UserInterface\\Resources\\Icon\\moon.png";
    public static final String URL_CHECK = "src\\UserInterface\\Resources\\Icon\\sun.png"; // camobarle
    

    public static final void show_mesg_advert(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);

    }

    public static final void show_mesg_correct(String msg, String title) {
        ImageIcon check = new ImageIcon(
                new ImageIcon(URL_CHECK).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE, check);
    }

    public static final void show_mesg_yes_no(String msg, String title) {
        String[] option = { "SI", "No" };
        JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                option, option[0]);
    }

    public static JTable customize_table(JTable tabla) {
        tabla.setFont(Spark_Style.FONT);
        tabla.setForeground(Spark_Style.COLOR_FONT);
        tabla.setBackground(Spark_Style.COLOR_BACKGROUND);
        tabla.setGridColor(Spark_Style.COLOR_BACKGROUND_GRID);
        tabla.setSelectionBackground(Spark_Style.COLOR_BACKGROUND_SELECT);
        tabla.setSelectionForeground(Spark_Style.COLOR_FONT);
        tabla.setRowHeight(30);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setOpaque(false);
        tabla.setFocusable(true);
        tabla.setRowSelectionAllowed(true);
        tabla.setColumnSelectionAllowed(false);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setDefaultEditor(Object.class, null);
        return tabla;
    }
}