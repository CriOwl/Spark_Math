package UserInterface.Form;

import UserInterface.Customer_control.Button_Text;
import UserInterface.Spark_Style;
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
        lista_botones = new ArrayList<>();
        for (int i = 0; i < Opciones_permisos.size(); i++) {
            lista_botones.add(new Button_Text(Opciones_permisos.get(i), Spark_Style.FONT, Spark_Style.COLOR_FONT));
        }
    }

    private void customizepanel(List<String> Opciones_permisos) {
       
        init_component(Opciones_permisos);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setPreferredSize(new Dimension(300, getHeight()));
        gbc.insets = new Insets(5, 10, 5, 10);
        for (int i = 0; i < lista_botones.size(); i++) {
            gbc.gridy = i;
            gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;
            lista_botones.get(i).setPreferredSize(new Dimension(250, 50));
            add(lista_botones.get(i), gbc);
        }
    }

    private void contanier() {

    }
}