package UserInterface.Form;
import BusinessLogic.BL_USER.BL_catalog;
import BusinessLogic.BL_USER.BL_generalyTable;
import Data_Access.DAO.DAO_C.CatalogDAO;
import Data_Access.DAO.DAO_C.RoleDAO;
import Data_Access.DTO.CatalogDTO;
import Data_Access.DTO.RoleDTO;
import UserInterface.Customer_control.Button_Text;
import UserInterface.Customer_control.Text_box;
import UserInterface.Customer_control.Text_label;
import UserInterface.Spark_Style;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class Create_panel_rol extends JPanel {
    private Text_label name_rol ;
    private Text_label hierarchy ;
    private Text_label State_person ;
    private Text_box name_rol_box ;
    private JComboBox<String> State_person_box;
    private JComboBox<String> hierarchy_combo;
    private String [] array_hierarchy;
    private Button_Text send;
    private Button_Text cancel;
    private HashMap<String, Integer> hierarchy_map = new HashMap<>();
    private HashMap<String, Integer> state_map = new HashMap<>();
    
    public Create_panel_rol() {
        setup_panel();
    }

    private void setup_panel() {
        setLayout(new GridBagLayout());
        name_rol     = new Text_label("Nombre del rol");
        hierarchy    = new Text_label("Categoria");
        State_person = new Text_label("Estado") ;
        name_rol_box    = new Text_box();
        State_person_box = new JComboBox<>(data_estado());
        hierarchy_combo=new JComboBox<>(data_hierarchy());
        send=new Button_Text("Enviar", Spark_Style.FONT, null);
        send.addActionListener(e->validate_data());
        cancel=new Button_Text("Cancelar", Spark_Style.FONT, null);
        cancel.addActionListener(e->change_panel(new Manage_panel_role()));
        cancel.setBackground(new Color(200,0,0));
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(5,20,5,20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(name_rol, gbc);
        gbc.gridy = 2;
        add(name_rol_box, gbc);
        gbc.gridy = 3;
        add(hierarchy, gbc);
        gbc.gridy = 4;
        add(hierarchy_combo, gbc);
        gbc.gridy = 5;
        add(State_person, gbc);
        gbc.gridy = 6;
        add(State_person_box, gbc);
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(send, gbc);
        gbc.gridy = 20;
        gbc.anchor = GridBagConstraints.EAST;
        add(cancel, gbc);
    }

    private String[] data_hierarchy(){
        try {
            BL_catalog bl_catalog=new BL_catalog(new CatalogDAO());
            List<CatalogDTO> list_role_hierarchy=bl_catalog.read_elments_role();
            array_hierarchy=new String [list_role_hierarchy.size()];
            for (int index = 0; index < list_role_hierarchy.size(); index++) {
                array_hierarchy[index]=list_role_hierarchy.get(index).getName();
                hierarchy_map.put(list_role_hierarchy.get(index).getName(),list_role_hierarchy.get(index).getId_catalog());

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return array_hierarchy;
    }


    private String[] data_estado(){
        String[] data_es={"Activo","Inactivo"};
        state_map.put("Activo", 1);
        state_map.put("Inactivo", 0);
        return data_es;
    }

    private void validate_data(){
         String name=name_rol_box.getText();
        int id_hierarchy= hierarchy_map.get(hierarchy_combo.getSelectedItem());
        int state=state_map.get(State_person_box.getSelectedItem());
        if(name.isEmpty()||id_hierarchy==0){
            Spark_Style.show_mesg_advert("Complete todos los campos", "Registrar Rol");
            return;
        }
        RoleDTO role_created = new RoleDTO(name,id_hierarchy,state);
        send_data(role_created);
    }
    public boolean send_data(RoleDTO role){
        name_rol.setText("");
        BL_generalyTable<RoleDTO> table_role=new BL_generalyTable<>(RoleDAO::new);
        try {
         if(table_role.cretated_elements(role)){
            Spark_Style.show_mesg_correct("Usuario creado ", "Estado");
            name_rol_box.setText("");
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

