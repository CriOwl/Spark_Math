package BusinessLogic.BL_USER;

import Data_Access.VIEW.LoginDAO;
import Data_Access.VIEW.LoginDTO;
import java.util.List;

public class User {
    private LoginDAO data_user;
    private LoginDTO content_user;
    private Role rol;
    private List<String> list_permissions;
    
    public boolean login_public(String user,String password){
        return login(user, password);
    }
    
    private boolean login(String user,String password){
         data_user = new LoginDAO();
         rol=new Role();
         try {
            content_user=data_user.readby(user);
            if(content_user.getPassword().equals(password)){
                System.out.println("Bienvenido "+content_user.getFull_name()+". Su rol es "+content_user.getName_role()+".");
                rol.get_Permission(content_user.getId_role());
                list_permissions=rol.getList_permissions();
            return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public List<String> getList_permissions() {
        return list_permissions;
    }
    
}
