package UserInterface.Form;


import BusinessLogic.BL_USER.BL_generalyTable;
import Data_Access.DAO.DAO_C.InstitutionDAO;
import Data_Access.DAO.DAO_C.PersonDAO;
import Data_Access.DAO.RoleDAO;
import Data_Access.DTO.InstitutionDTO;
import Data_Access.DTO.PersonDTO;
import Data_Access.DTO.RoleDTO;
import UserInterface.Customer_control.Button_Text;
import UserInterface.Customer_control.Mascaras;
import UserInterface.Customer_control.Text_box;
import UserInterface.Customer_control.Text_label;
import UserInterface.Spark_Style;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument;
import org.w3c.dom.Text;

public class Update_panel_rol extends JPanel {
    Text_label name_rol ;
    Text_label hierarchy ;
    Text_label State_person ;
    Text_label search_name;
    Text_box name_rol_box ;
    Text_box search_name_box;
    JComboBox<String> State_person_box;
    JComboBox<Integer> hierarchy_combo;
    Integer [] array_hierarchy;
    Button_Text send;
    Button_Text cancel;
    Button_Text search;
    private HashMap<String, Integer> hierarchy_map = new HashMap<>();
    private HashMap<String, Integer> state_map = new HashMap<>();
    Integer id_rol;
    
    public Update_panel_rol() {
        setup_panel();
    }

    private void setup_panel() {
        setLayout(new GridBagLayout());
        name_rol     = new Text_label("Nombre del rol");
        hierarchy    = new Text_label("Categoria");
        State_person = new Text_label("Estado") ;
        search_name  = new Text_label("Buscar por nombre");
        name_rol_box    = new Text_box();
        search_name_box = new Text_box();
        State_person_box = new JComboBox<>(data_estado());
        hierarchy_combo=new JComboBox<>(data_hierarchy());
        send=new Button_Text("Enviar", Spark_Style.FONT, null);
        send.addActionListener(e->validate_data());
        cancel=new Button_Text("Cancelar", Spark_Style.FONT, null);
        search=new Button_Text("Buscar", Spark_Style.FONT, null);
        search.addActionListener(e->search_data());
        cancel.setBackground(new Color(200,0,0));
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(5,20,5,20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        add(search_name, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill=GridBagConstraints.BOTH;
        add(search_name_box, gbc);
        gbc.gridx = 2;
        gbc.fill=GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        add(search, gbc);
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

    private Integer[] data_hierarchy(){
        try {
            BL_generalyTable<RoleDTO> bl_role=new BL_generalyTable<>(RoleDAO::new);
            List<RoleDTO> list_role_hierarchy=bl_role.read_elments2();
            array_hierarchy=new Integer [list_role_hierarchy.size()];
            for (int index = 0; index < list_role_hierarchy.size(); index++) {
                array_hierarchy[index]=list_role_hierarchy.get(index).getId_hierarchy();
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
        int id_hierarchy= (Integer)hierarchy_combo.getSelectedItem();
        int state=state_map.get(State_person_box.getSelectedItem());
        if(name.isEmpty()||id_hierarchy==0){
            Spark_Style.show_mesg_advert("Complete todos los campos", "Registrar Rol");
            return;
        }
        RoleDTO role_created = new RoleDTO(id_rol,name,id_hierarchy,state);
        send_data(role_created);
    }
    public boolean send_data(RoleDTO role){
        BL_generalyTable<RoleDTO> table_role=new BL_generalyTable<>(RoleDAO::new);
        try {
         if(table_role.update_elements(role)){
            Spark_Style.show_mesg_correct("Usuario creado ", "Estado");
            name_rol_box.setText("");
            return true;
         }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    private void search_data(){
        BL_generalyTable<RoleDTO> bl_role=new BL_generalyTable<>(RoleDAO::new);
        try {
        RoleDTO rol= bl_role.search_single(search_name_box.getText());
            name_rol_box.setText(rol.getName());
            hierarchy_combo.setSelectedItem(search(hierarchy_map,rol.getState()));
            State_person_box.setSelectedItem(search(state_map,rol.getState()));
            id_rol=rol.getId_Role();
            System.out.println(rol.getId_Role());
        } catch (Exception e) {
        }
    }
    private <name,id> name search(Map<name,id> map,id value){
    for (Map.Entry<name, id> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                System.out.println(entry.getKey());
                return entry.getKey();
            }
        }
        return null; 
    }
}
