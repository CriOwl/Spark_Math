package BusinessLogic.BL_USER;

import Data_Access.VIEW.LoginDAO;
import Data_Access.VIEW.LoginDTO;
import java.util.List;

public class User {
    private LoginDAO data_user;
    private LoginDTO content_user;
    private Role rol;
    private List<String> list_permissions;
    public Integer userId;
    public boolean login_public(String user,String password){
        return login(user, password);
    }
    
    private boolean login(String user,String password){
         data_user = new LoginDAO();
         rol=new Role();
         try {
            content_user=data_user.readby(user);
            if(content_user.getPassword().equals(password)){
                System.out.println("Bienvenido "+content_user.getName()+"   "+content_user.getLast_name()+". Su rol es "+content_user.getName_role()+".");
                rol.get_Permission(content_user.getId_role());
                list_permissions=rol.getList_permissions();
                userId = content_user.getId_person();
            return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public int getIdUsuario() {
        if (content_user != null) {
            return userId; // Suponiendo que getId_usuario() devuelve el ID del usuario.
        }
        return -1; // Retorna -1 si no hay usuario autenticado
    }

    public List<String> getList_permissions() {
        return list_permissions;
    }
    
}
