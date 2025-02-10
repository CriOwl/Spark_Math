package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyTable;
import Data_Access.DAO.PermissionDAO;
import Data_Access.DTO.PermissionDTO;
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


public class Create_panel_permission extends JPanel {
    private Text_label name_permission ;
    private Text_label description ;
    private Text_label State_permission ;
    private Text_label name_method;
    private Text_box name_method_box;
    private Text_box name_permission_box;
    private Text_box description_box;
    private JComboBox<String> State_person_box;
    private Button_Text send;
    private Button_Text cancel;
    private final HashMap<String, Integer> state_map = new HashMap<>();
    
    public Create_panel_permission() {
        setup_panel();
    }

    private void setup_panel() {
        setLayout(new GridBagLayout());
        name_permission     = new Text_label("Nombre del permiso");
        description    = new Text_label("Descripcion");
        State_permission = new Text_label("Estado") ;
        name_method  = new Text_label("Nombre del metodo");
        name_method_box   = new Text_box();
        description_box   = new Text_box();
        name_permission_box   = new Text_box();
        State_person_box = new JComboBox<>(data_estado());
        send=new Button_Text("Enviar", Spark_Style.FONT, null);
        send.addActionListener(e->validate_data());
        cancel=new Button_Text("Cancelar", Spark_Style.FONT, null);
        cancel.setBackground(new Color(200,0,0));
        cancel.addActionListener(e->change_panel(new Manage_panel_permission_role()));
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(5,20,5,20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(name_permission, gbc);
        gbc.gridy = 2;
        add(name_permission_box, gbc);
        gbc.gridy = 3;
        add(description, gbc);
        gbc.gridy = 4;
        add(description_box, gbc);
        gbc.gridy = 5;
        add(State_permission, gbc);
        gbc.gridy = 6;
        add(State_person_box, gbc);
        gbc.gridy = 7;
        add(name_method, gbc);
        gbc.gridy = 8;
        add(name_method_box, gbc);
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(send, gbc);
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        add(cancel, gbc);
    }


    private String[] data_estado(){
        String[] data_es={"Activo","Inactivo"};
        state_map.put("Activo", 1);
        state_map.put("Inactivo", 0);
        return data_es;
    }

    private void validate_data(){
        String name=name_permission_box.getText();
        String description=description_box.getText();
        String method=name_method_box.getText();
        int state=state_map.get(State_person_box.getSelectedItem());
        if(name.isEmpty()||description.isEmpty()||method.isEmpty()){
            Spark_Style.show_mesg_advert("Complete todos los campos", "Registrar Rol");
            return;
        }
        PermissionDTO permission = new PermissionDTO(name,description,method,state);
        send_data(permission);
    }
    public boolean send_data(PermissionDTO permission){
        BL_generalyTable<PermissionDTO> table_permission=new BL_generalyTable<>(PermissionDAO::new);
        try {
         if(table_permission.cretated_elements(permission)){
            Spark_Style.show_mesg_correct("Usuario creado ", "Estado");
            name_permission_box.setText("");
            description_box.setText("");
            name_method_box.setText("");
            return true;
         }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    private void change_panel(JPanel newPanel) {
        removeAll(); 
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(newPanel, gbc);
        revalidate();
        repaint(); 
    }
}
