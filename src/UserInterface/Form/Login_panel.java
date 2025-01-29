package UserInterface.Form;

import UserInterface.Customer_control.Text_box;
import UserInterface.Customer_control.Text_label;
import java.awt.*;
import javax.swing.*;

public class Login_panel extends JPanel {
    private Text_label DNI_text;
    private Text_label password_text;
    private Text_box   DNI_box;
    private JPasswordField  password_box;
    private JButton login_button;
    public Login_panel(){

    }
    private void init_component(){
        DNI_text=new Text_label("Cedula ");
        password_text=new Text_label("Contraseña ");
        DNI_box = new Text_box();
        password_box = new JPasswordField();
        login_button = new JButton("Ingresar");
        setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        gc.insets=new Insets(10, 10, 10, 10);
        gc.gridx=0;
        gc.gridy=0;
        gc.anchor=GridBagConstraints.EAST;
        add(DNI_text,gc);
        gc.gridx=1;
        gc.gridy=0;
        gc.anchor=GridBagConstraints.WEST;
        gc.fill=GridBagConstraints.HORIZONTAL;
        add(DNI_box,gc);
        gc.gridx=0;
        gc.gridy=1;
        gc.anchor=GridBagConstraints.EAST;
        add(password_text,gc);
        gc.gridx=1;
        gc.gridy=1;
        gc.anchor=GridBagConstraints.WEST;
        add(password_box,gc);
        gc.gridx=1;
        gc.gridy=2;
        gc.anchor=GridBagConstraints.CENTER;


    }


}
