package UserInterface.Form;

import UserInterface.Customer_control.Button_Text;
import UserInterface.Spark_Style;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
public class Menu_panel extends JPanel {
    private List<Button_Text> lista_botones;

    public Menu_panel(List<String> Opciones_permisos, Integer userId) {
        customizepanel(Opciones_permisos, userId);
    }

    private void init_component(List<String> Opciones_permisos, Integer userId) {
        lista_botones = new ArrayList<>();
        for (int i = 0; i < Opciones_permisos.size(); i++) {
            lista_botones.add(new Button_Text(Opciones_permisos.get(i), Spark_Style.FONT, Spark_Style.COLOR_FONT));
            lista_botones.get(i).addActionListener(e->open_Game(userId));
            if(Opciones_permisos.get(i).equals("Jugar")){
                lista_botones.get(i).addActionListener(e -> open_Game(userId));
            }
        }
        
    }

    private void open_Game(Integer userId){
        JFrame gameWindow = new JFrame("Game");
        gameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cuando se cierre, se cierra solo esa ventana
        gameWindow.setSize(800, 600); // Tamaño de la ventana del juego

        // Crear el panel de juego y agregarlo a la nueva ventana
        Juego_panel_2 juegoPanel = new Juego_panel_2(gameWindow, userId);
        gameWindow.add(juegoPanel);
        // Hacer visible la ventana del juego
        gameWindow.setVisible(true);
    }
   

    private void customizepanel(List<String> Opciones_permisos, Integer userId) {
        init_component(Opciones_permisos, userId);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setPreferredSize(new Dimension(300, getHeight()));
        gbc.insets = new Insets(5, 10, 5, 10);
        for (int i = 0; i < lista_botones.size(); i++) {
            gbc.gridy = i;
            gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;
            lista_botones.get(i).setPreferredSize(new Dimension(250, 50));
            //lista_botones.get(i).addActionListener();
            add(lista_botones.get(i), gbc);
        }
    }
    


}