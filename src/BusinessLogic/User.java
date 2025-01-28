package BusinessLogic;
import Data_Access.VIEW.LoginDAO;
import Data_Access.VIEW.LoginDTO;
import Math_Spark.*;
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
        Role sd=new Role();
        try {
            if(hash.getPassword().equals(password)){
                System.out.println("Bienvenido "+hash.getFull_name()+" Su rol es "+hash.getName_role());
                sd.get_Permission(hash.getId_role());
            }
        return false;
        } catch (Exception e) {
            return true;
        }
        
    }
}
