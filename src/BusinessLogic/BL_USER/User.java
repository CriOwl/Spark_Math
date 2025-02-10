package BusinessLogic.BL_USER;

import Data_Access.VIEW.LoginDAO;
import Data_Access.VIEW.LoginDTO;
import java.util.HashMap;
import java.util.List;
import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class User {
    private LoginDAO data_user;
    private LoginDTO content_user;
    private Role rol;
    private List<String> list_permissions;
    private HashMap<String,String> map_permission;
    public Integer userId;

    
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
                userId = content_user.getId_person();
            return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public int getIdUsuario() {
        if (content_user != null) {
            return userId; 
        }
        return -1; 
    }
 
    public List<String> getList_permissions() {
        return list_permissions;
    }

    public HashMap<String, String> getMap_permission() {
        return map_permission;
    }
    
}
