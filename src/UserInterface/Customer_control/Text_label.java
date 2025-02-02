package UserInterface.Customer_control;

import UserInterface.Spark_Style;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Text_label extends JLabel {
    public Text_label(String text){
        setText(text);
        set_customize();
    }
    public Text_label(){
        set_customize();
    }
    private void set_customize(){
        customize_label(getText(),Spark_Style.FONT,Spark_Style.COLOR_FONT,Spark_Style.ALIGNMENT_LEFT);
    }
    public void set_customize(String text,Font font, Color color, int alignment){
        customize_label(text, font,  color, alignment);
    }
    private void customize_label(String text,Font font, Color color, int alignment){
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
       // setForeground(color);
        setHorizontalAlignment(alignment);
    }
}
