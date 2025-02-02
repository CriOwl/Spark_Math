package UserInterface.Customer_control;

import UserInterface.Spark_Style;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Button_Text extends JButton {
    public Button_Text(String text,Font foText_labelnt,Color color){
        customizeComponent(text,foText_labelnt,color);
    }
    public Button_Text(String text, String iconPath,Font font,Color color){
        customizeComponent(text, iconPath,font,color);
    }

    public void customizeComponent(String text, String iconPath,Font font,Color color){ 
        setSize(20, 70);
        //addMouseListener(this);
        customizeComponent(text,font,color);
        setBounds(50, 30, 90, 20); 
        setIcon(new ImageIcon(iconPath));
    }
    public void customizeComponent(String text,Font font,Color color) {
        setText(text);
        setOpaque(false);
        //setFocusPainted(false);
        //setBorderPainted(false);
        //setContentAreaFilled(false);
        setForeground(color);
        setFont(font);
        setHorizontalAlignment(Spark_Style.ALIGNMENT_LEFT);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}