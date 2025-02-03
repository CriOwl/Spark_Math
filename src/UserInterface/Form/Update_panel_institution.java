package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyTable;
import Data_Access.DAO.DAO_C.InstitutionDAO;
import Data_Access.DTO.InstitutionDTO;
import UserInterface.Customer_control.Button_Text;
import UserInterface.Customer_control.Text_box;
import UserInterface.Customer_control.Text_label;
import UserInterface.Spark_Style;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Update_panel_institution extends JPanel {
    Text_label name_label;
    Text_label amie_label;
    Text_label state_label;
    Text_box name_box;
    Text_box amie_box;
    JComboBox<String> state_box;

    Button_Text send;
    Button_Text cancel;
    private HashMap<String, Integer> state_map = new HashMap<>();

    public Update_panel_institution() {
        setup_panel();
    }

    private void setup_panel() {
        setLayout(new GridBagLayout());
        name_label = new Text_label("Nombre:");
        amie_label = new Text_label("AMIE:");
        state_label = new Text_label("Estado:");
        name_box = new Text_box();
        amie_box = new Text_box();
        state_box = new JComboBox<>(data_estado());
        send = new Button_Text("Enviar", Spark_Style.FONT, null);
        send.addActionListener(e -> sent_data());
        cancel = new Button_Text("Cancelar", Spark_Style.FONT, null);
        cancel.setBackground(new Color(200, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(name_label, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(name_box, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(amie_label, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(amie_box, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(state_label, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(state_box, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(send, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        add(cancel, gbc);
    }

    private String[] data_estado() {
        String[] data_es = {"Activo", "Inactivo"};
        state_map.put("Activo", 1);
        state_map.put("Inactivo", 0);
        return data_es;
    }

    private void sent_data() {
        String name = name_box.getText();
        String amie = amie_box.getText();
        int state = state_map.get(state_box.getSelectedItem());
        System.out.println(name + "---" + amie + "---" + state);
        InstitutionDTO institution = new InstitutionDTO(name,amie,state);

    }
}