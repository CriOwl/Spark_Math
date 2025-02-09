package UserInterface.Form;

import BusinessLogic.BL_USER.User;
import UserInterface.Customer_control.Mascaras;
import UserInterface.Customer_control.Text_box;
import UserInterface.Customer_control.Text_label;
import UserInterface.Spark_Style;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;
import javax.swing.text.AbstractDocument;

public class Login_panel extends JPanel {
    private Text_label DNI_text;
    private Text_label password_text;
    private Text_box DNI_box;
    private JButton validate_DNI;
    private JPasswordField password_box;
    public JButton login_button;
    private final User user=new User();
    private List<String> list_permissions;
    private HashMap<String,String> map_panel;
    private Integer userId;

    public HashMap<String, String> getMap_panel() {
        return map_panel;
    }

    public Login_panel() {
        init_component();
    }

    private void init_component() {
        DNI_text = new Text_label("Cedula ");
        password_text = new Text_label("Contraseña ");
        DNI_box = new Text_box(Spark_Style.FONT_NUMBER);
        DNI_box.setPreferredSize(Spark_Style.dimension_button);
        validate_DNI = new JButton("Validar");
        ((AbstractDocument) DNI_box.getDocument()).setDocumentFilter(new Mascaras(10));
        validate_DNI.addActionListener(e->validate_dni(DNI_box.getText()));
        password_box = new JPasswordField();
        password_box.setPreferredSize(Spark_Style.dimension_button);
        login_button = new JButton("Ingresar");
        login_button.addActionListener(e->login_bl());
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(10, 10, 10, 10);
        gc.gridx = 4;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.WEST;
        add(DNI_text, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        gc.gridwidth = 5;
        gc.anchor = GridBagConstraints.WEST;
        add(DNI_box, gc);
        gc.gridx = 5;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(validate_DNI, gc);
        gc.gridx = 3;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.CENTER;
        add(password_text, gc);
        gc.gridx = 0;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.WEST;
        add(password_box, gc);
        gc.gridx = 0;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.CENTER;
        add(login_button, gc);
    }

    private boolean validate_dni(String DNI){
        if(!(Mascaras.validate_DNI(DNI))){
            Spark_Style.show_mesg_advert("Cedula incorrecta","Cedula");
            return false;
        }
        Spark_Style.show_mesg_correct("Cedula Correcta","Cedula");
        return true;
    }

    public boolean login_bl(){
        if(!(user.login_public(DNI_box.getText(),new String(password_box.getPassword())))){
            Spark_Style.show_mesg_advert("Datos Incorrectos", "Login");
            return false;
        }
            userId = user.getIdUsuario();
            System.out.println("ID del usuario autenticado: " + userId);

        list_permissions=new ArrayList<>();
        list_permissions=user.getList_permissions();
        map_panel=user.getMap_permission();
        return true;
    }


    public List<String> getList_permissions() {
        return list_permissions;
    }

    public Integer getUser_id(){
        return userId;
    }
}
