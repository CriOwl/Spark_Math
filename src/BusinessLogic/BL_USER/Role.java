package BusinessLogic.BL_USER;

import Data_Access.DAO.PermissionRoleDAO;
import Data_Access.DTO.Permission_roleDTO;
import java.util.ArrayList;
import java.util.List;


public class Role {
    List<String> list_permissions;
    List<String> list_method;
    
    public  void get_Permission(Integer id_role){
        list_permissions=new ArrayList<>();
        list_method=new ArrayList<>();
        PermissionRoleDAO consulta=new PermissionRoleDAO();
        try {
            for (Permission_roleDTO registo : consulta.role_permission_read(id_role)) {
                list_permissions.add(registo.getPermission_name());
                list_method.add(registo.getMethod_name());
            }
            Permisos p=new Permisos(list_permissions, list_method);
        } catch (Exception e) {
            System.out.println("No se pudieron cargar las listas");
        }
    }

    public List<String> getList_permissions() {
        return list_permissions;
    }
    
}
