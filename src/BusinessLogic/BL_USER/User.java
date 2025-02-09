package BusinessLogic.BL_USER;

import Data_Access.VIEW.LoginDAO;
import Data_Access.VIEW.LoginDTO;
import java.util.HashMap;
import java.util.List;

public class User {
    private LoginDAO data_user;
    private LoginDTO content_user;
    private Role rol;
    private List<String> list_permissions;
    private HashMap<String,String> map_permission;
    
    public boolean login_public(String user,String password){
        return login(user, password);
    }
    
    private boolean login(String user,String password){
         data_user = new LoginDAO();
         try {
            content_user=data_user.login(user, password);
            if(!(content_user.getId_role()==null)){
                rol=new Role(content_user.getId_role());
                list_permissions=rol.getList_permissions();
                map_permission=rol.getMap_permission();
            return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
     
    public List<String> getList_permissions() {
        return list_permissions;
    }

    public HashMap<String, String> getMap_permission() {
        return map_permission;
    }
    
}
