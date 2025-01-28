package BusinessLogic;

import Data_Access.DAO.PermissionRoleDAO;
import Data_Access.DTO.Permission_roleDTO;
import java.util.ArrayList;
import java.util.List;


public class Role {
    public  void get_Permission(Integer id_role){
        List<String> list_permissions=new ArrayList<>();
        List<String> list_method=new ArrayList<>();
        PermissionRoleDAO consulta=new PermissionRoleDAO();
        try {
            for (Permission_roleDTO registo : consulta.role_permission_read(id_role)) {
                list_permissions.add(registo.getPermission_name());
                list_method.add(registo.getMethod_name());
            }
        Permisos p=new Permisos(list_permissions, list_method);
            p.ejecutarAccion("Realizar Actividades");
        } catch (Exception e) {
            System.out.println("No se pudieron cargas las listas");
        }
    }
    
    


    
}
