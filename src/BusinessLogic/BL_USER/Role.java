package BusinessLogic.BL_USER;

import Data_Access.DAO.PermissionRoleDAO;
import Data_Access.DTO.Permission_roleDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Role {
    private List<String> list_permissions;
    private HashMap <String,String> map_permission;
    public Role(Integer id_role){
        get_Permission(id_role);
    }
    private void get_Permission(Integer id_role){
        map_permission=new HashMap<>();
        list_permissions=new ArrayList<>();
        PermissionRoleDAO consulta=new PermissionRoleDAO();
        try {
            for (Permission_roleDTO registo : consulta.role_permission_read(id_role)) {
                list_permissions.add(registo.getPermission_name());
                map_permission.put(registo.getPermission_name(), registo.getMethod_name());
            }
        } catch (Exception e) {
            System.out.println("No se pudieron cargar las listas");
        }
    }

    public List<String> getList_permissions() {
        return list_permissions;
    }

    public HashMap<String, String> getMap_permission() {
        return map_permission;
    }
    
}
