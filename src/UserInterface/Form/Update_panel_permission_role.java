package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyTable;
import Data_Access.DAO.DAO_C.RoleDAO;
import Data_Access.DAO.PermissionRoleDAO;
import Data_Access.DTO.Permission_roleDTO;
import Data_Access.DTO.RoleDTO;
import UserInterface.Customer_control.Button_Text;
import UserInterface.Customer_control.Text_box;
import UserInterface.Customer_control.Text_label;
import UserInterface.Spark_Style;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Update_panel_permission_role extends JPanel {
   private Text_label name_rol ;
    private Text_label search_name;
    private Text_box search_name_box;
    private Button_Text send;
    private Button_Text cancel;
    private Button_Text search;
    private List<JRadioButton> list_permission;
    private List<Permission_roleDTO> data_permission_role;
    private List<Permission_roleDTO> data_select;
    private GridBagConstraints gbc;
    private JComboBox<String> role;
    private String[] roles;
    private final HashMap<String, Integer> Role_map = new HashMap<>();
    private HashMap<String, Integer> permission_Map = new HashMap<>();
    private JRadioButton test;
    public Update_panel_permission_role(){
      data_rol();
      data_permisos();
      setup_panel();
    }
    private void setup_panel() {
      setLayout(new GridBagLayout());
      gbc = new GridBagConstraints();
      gbc.insets = new Insets(5, 20, 5, 20);
      search_name = new Text_label("Buscar por rol");
      search_name_box = new Text_box();
      send = new Button_Text("Enviar", Spark_Style.FONT, null);
      cancel = new Button_Text("Cancelar", Spark_Style.FONT, null);
      search = new Button_Text("Buscar", Spark_Style.FONT, null);
      role = new JComboBox<>(roles);
      
      list_permission = new ArrayList<>();
      
      int maxPermissions = Math.min(data_permission_role.size(), 13);
      
      for (int i = 0; i < maxPermissions; i++) {
          System.out.println(data_permission_role.get(i).getPermission_name() + " ----------------------");
          list_permission.add(new JRadioButton(data_permission_role.get(i).getPermission_name()));
      }
      search.addActionListener(e -> search_data_role());
      cancel.setBackground(new Color(200, 0, 0));
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
      gbc.fill = GridBagConstraints.BOTH;
      add(role, gbc);
      
      gbc.gridx = 2;
      gbc.fill = GridBagConstraints.NONE;
      gbc.anchor = GridBagConstraints.EAST;
      add(search, gbc);
    
      gbc.gridx = 1;
      gbc.fill = GridBagConstraints.NONE;
      gbc.anchor = GridBagConstraints.WEST;
      for (int i = 0; i < maxPermissions; i++) {
          gbc.gridy = i + 2;
          add(list_permission.get(i), gbc);
      }
      gbc.gridy = maxPermissions + 3; 
      gbc.fill = GridBagConstraints.NONE;
      gbc.anchor = GridBagConstraints.CENTER;
      add(send, gbc);
      gbc.gridy = maxPermissions + 3;
      gbc.anchor = GridBagConstraints.EAST;
      add(cancel, gbc);
  }

     private String[] data_rol(){
        BL_generalyTable<RoleDTO> bl_rol = new BL_generalyTable<>(RoleDAO::new);
        try {
            List<RoleDTO> list_role=bl_rol.read_elments();
            roles=new String [list_role.size()];
            for (int index = 0; index < list_role.size(); index++) {
               roles[index]=list_role.get(index).getName();
                Role_map.put(list_role.get(index).getName(), list_role.get(index).getId_Role());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return roles;
    }
    private void data_permisos(){
      BL_generalyTable<Permission_roleDTO> bl_role_permission=new BL_generalyTable<>(PermissionRoleDAO::new);
        try {
            data_permission_role=new ArrayList<>();
            data_permission_role= bl_role_permission.search();
            
        } catch (Exception e) {
         System.out.println(e);
        }
  }

    private void search_data_role(){
      PermissionRoleDAO consulta=new PermissionRoleDAO();
        try {
         data_select=new ArrayList<>();
            data_select=consulta.role_permission_read(Role_map.get((role.getSelectedItem())));
            for (int i = 0; i < list_permission.size(); i++) {
               list_permission.get(i).setSelected(false);
            }
            for (int i = 0; i < data_select.size(); i++) {
               for (int j = 0; j < list_permission.size(); j++) {
                  if(list_permission.get(j).getText().equals(data_select.get(i).getPermission_name()))
                  list_permission.get(j).setSelected(true);
               }
            }
        } catch (Exception e) {
         System.out.println(e);
        }
    }
    private void send_data(){
      PermissionRoleDAO dataSend=new PermissionRoleDAO();
      for (int i = 0; i < list_permission.size(); i++) {
         if(list_permission.get(i).isSelected()){
            Permission_roleDTO permission=new Permission_roleDTO(Role_map.get(role.getSelectedItem()),permission_Map.get(list_permission.get(i).getText()));
         }else{

         }
          
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
