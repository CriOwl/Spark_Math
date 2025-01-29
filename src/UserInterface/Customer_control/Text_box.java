package UserInterface.Customer_control;

import java.awt.Insets;

import javax.swing.JTextField;

import UserInterface.Spark_Style;

public class Text_box extends JTextField{
    public Text_box(Font font, Color color){
        customize_textfield( font, color);
    }
    public Text_box(){
        customize_textfield();
    }

    private void customize_textfield(Font font,Color color){
        setFont(font);
        setForeground(color);
        setOpaque(false);
        setCaretColor(Spark_Style.COLOR_CURSOR);
        setMargin(new Insets(10, 10, 10, 10));
    }
    public void customize_textfield(){
        setFont(Spark_Style.FONT);
        setForeground(Spark_Style.COLOR_FONT_LIGHT);
        setCaretColor(Spark_Style.COLOR_CURSOR);
        setOpaque(false);
        setMargin(new Insets(10, 10, 10, 10));
    }


}
