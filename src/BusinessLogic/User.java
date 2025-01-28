package BusinessLogic;
import Math_Spark.*;

import java.util.List;

import Data_Access.VIEW.LoginDAO;
import Data_Access.VIEW.LoginDTO;
public class User {
    public void sistema(){
        String user;
        String password;
        boolean les=true;
        while (les) { 
        System.out.println("User:");
        user=Utilitary.keyboard.nextLine();
        System.out.println("Password:");
        password=Utilitary.keyboard.nextLine();
        les=login(user, password);
        }
    }
    private boolean login(String user,String password){
        LoginDAO person = new LoginDAO();
        LoginDTO hash=person.login(user);
        Role permisos= new Role();
        try {
            if(hash.getPassword().equals(password)){
                System.out.println("Bienvenido "+hash.getFull_name()+" Su rol es "+hash.getName_role());
                List<String> permi = permisos.get_Permission(hash.getId_role());
                for (String a : permi) {
                    System.out.println(a);
                }
            }
        return false;
        } catch (Exception e) {
            return true;
        }
    }
}
