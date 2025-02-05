package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyTable;
import Data_Access.DAO.PermissionDAO;
import Data_Access.DAO.RoleDAO;
import Data_Access.DTO.PermissionDTO;
import Data_Access.DTO.Permission_roleDTO;
import Data_Access.DTO.RoleDTO;
import UserInterface.Customer_control.Button_Text;
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

public class Update_panel_permission_role extends JPanel {
    Text_label role_label;
    Text_label permission_label;
    Text_label state_label;
    JComboBox<String> role_box;
    JComboBox<String> permission_box;
    JComboBox<String> state_box;
    Button_Text send;
    Button_Text cancel;
    private HashMap<String, Integer> role_map = new HashMap<>();
    private HashMap<String, Integer> permission_map = new HashMap<>();
    private HashMap<String, Integer> state_map = new HashMap<>();

    public Update_panel_permission_role() {
        setup_panel();
    }

    private void setup_panel() {
        setLayout(new GridBagLayout());
        role_label = new Text_label("Rol:");
        permission_label = new Text_label("Permiso:");
        state_label = new Text_label("Estado:");
        role_box = new JComboBox<>(data_roles());
        permission_box = new JComboBox<>(data_permissions());
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
        add(role_label, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(role_box, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(permission_label, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(permission_box, gbc);
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

    private String[] data_roles() {
        BL_generalyTable<RoleDTO> bl_role = new BL_generalyTable<>(RoleDAO::new);
        String[] roles = new String[0];
        try {
            List<RoleDTO> list_roles = bl_role.read_elments();
            roles = new String[list_roles.size()];
            for (int index = 0; index < list_roles.size(); index++) {
                roles[index] = list_roles.get(index).getName();
                role_map.put(list_roles.get(index).getName(), list_roles.get(index).getId_Role());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return roles;
    }

    private String[] data_permissions() {
        BL_generalyTable<PermissionDTO> bl_permission = new BL_generalyTable<>(PermissionDAO::new);
        String[] permissions = new String[0];
        try {
            List<PermissionDTO> list_permissions = bl_permission.read_elments();
            permissions = new String[list_permissions.size()];
            for (int index = 0; index < list_permissions.size(); index++) {
                permissions[index] = list_permissions.get(index).getName();
                permission_map.put(list_permissions.get(index).getName(), list_permissions.get(index).getId_permission());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return permissions;
    }

    private String[] data_estado() {
        String[] data_es = {"Activo", "Inactivo"};
        state_map.put("Activo", 1);
        state_map.put("Inactivo", 0);
        return data_es;
    }

    private void sent_data() {
        int id_role = role_map.get(role_box.getSelectedItem());
        int id_permission = permission_map.get(permission_box.getSelectedItem());
        int state = state_map.get(state_box.getSelectedItem());
        System.out.println(id_role + "---" + id_permission + "---" + state);
        Permission_roleDTO permissionRole = new Permission_roleDTO(id_role, id_permission, state);
        // Aquí puedes agregar la lógica para guardar en la base de datos
    }
}