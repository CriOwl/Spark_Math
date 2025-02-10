import Data_Access.VIEW.LoginDAO;
import Data_Access.VIEW.LoginDTO;
import UserInterface.Form.MainFrame;
import UserInterface.Spark_Style;

public class App {
    public static void main(String[] args) throws Exception {
           /*  PersonDAO person=new PersonDAO();
            person.delete(11); */
            LoginDAO login=new LoginDAO();
            
            System.out.println(login.login("1751375963","admin"));
             for (LoginDTO elem : login.read_column()) {
                System.out.println(elem.getName_column());
            }
            System.out.println(Spark_Style.URL_MOON_THEMES);
            System.out.println(Spark_Style.URL_SUN_THEMES);
            MainFrame venta= new MainFrame("Spark_Math"); 
            /* User system=new User();
            system.sistema();  */
            /* PermissionRoleDAO consulta=new PermissionRoleDAO();
            for (Permission_roleDTO registo : consulta.role_permission_read(1)) {
                System.out.println(registo.getPermission_name());
            } */
    }
}
