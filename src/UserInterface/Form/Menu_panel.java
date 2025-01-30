package UserInterface.Form;

import BusinessLogic.User;
import UserInterface.Spark_Style;
import UserInterface.Customer_control.Button_Text;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Menu_panel extends JPanel {
    private List<Button_Text> lista_botones;
    private JPanel menu_panel;

    public Menu_panel(List<String> Opciones_permisos) {
        customizepanel(Opciones_permisos);
    }

    private void init_component(List<String> Opciones_permisos) {
        lista_botones=new ArrayList<>();
    for (int i = 0; i < Opciones_permisos.size(); i++) {
        lista_botones.add(new Button_Text(Opciones_permisos.get(i),Spark_Style.FONT,Spark_Style.COLOR_FONT));
    }
    }
    private void customizepanel(List<String> Opciones_permisos){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250,getHeight()));
        init_component(Opciones_permisos);
        for (int i = 0; i < lista_botones.size(); i++) {
            add(lista_botones.get(i));
        }
    }
}
