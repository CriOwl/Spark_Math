package BusinessLogic;

import java.util.List;

import Data_Access.DAO.PermissionRoleDAO;
import Data_Access.DTO.Permission_roleDTO;
import java.util.ArrayList;

public class Role {
    public  List<String> get_Permission(Integer id_role){
        List<String> list=new ArrayList<>();
        PermissionRoleDAO consulta=new PermissionRoleDAO();
        try {
            for (Permission_roleDTO registo : consulta.role_permission_read(id_role)) {
                list.add(registo.getPermission_name());
            }
        } catch (Exception e) {
            System.out.println("No se pudieron cargas las listas");
        }
        return list;
    }
    
}
