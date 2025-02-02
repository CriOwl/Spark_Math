package UserInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public abstract class Spark_Style {
    public static final Color COLOR_FONT = new Color(250,250 , 250); 
    public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100);
    public static final Color COLOR_CURSOR = Color.black; //cambiar segun el estilo
    public static final Color COLOR_BORDER = Color.lightGray;
    public static final Font  FONT         = new Font("Cambria Math", Font.PLAIN, 20);
    public static final Font  FONT_BOLD    = new Font("Century Gothic", Font.BOLD, 20);
    public static final Font  FONT_SMALL   = new Font("JetBrains Mono", Font.PLAIN, 20);
    public static final Font  FONT_NUMBER   = new Font("Digital-7 Mono", Font.PLAIN, 20);
    public static final Dimension  dimension_button   = new Dimension(150, 45);

    public static final int ALIGNMENT_LEFT  = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER= SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND    = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL URL_MAIN  = Spark_Style.class.getResource("src\\UserInterface\\Resources\\Img\\Kid_playing.png");
    public static final String URL_LOGO  = "src\\UserInterface\\Resources\\Icon\\Logo_Spark_Math.png";
    public static final URL URL_SPLASH= Spark_Style.class.getResource("src\\UserInterface\\Resources\\Img\\Kid_playing.png");
    public static final String URL_SUN_THEMES= "src\\UserInterface\\Resources\\Icon\\sun.png";
    public static final String URL_MOON_THEMES= "src\\UserInterface\\Resources\\Icon\\moon.png";
    public static final String URL_CHECK= "src\\UserInterface\\Resources\\Icon\\moon.png";
    
    public static final void show_mesg_advert(String msg,String title){
        JOptionPane.showMessageDialog(null, msg, title,JOptionPane.ERROR_MESSAGE);

    }
    public static final void show_mesg_correct(String msg,String title){
        ImageIcon check=new ImageIcon(new ImageIcon(URL_CHECK).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.PLAIN_MESSAGE,check);
    }
}