import BusinessLogic.User;
import Data_Access.DAO.Grades_Activity_game2DAO;
import Data_Access.DAO.InstitutionDAO;
import Data_Access.DAO.PermissionDAO;
import Data_Access.DAO.PermissionRoleDAO;
import Data_Access.DAO.PersonDAO;
import Data_Access.DAO.RoleDAO;
import Data_Access.DTO.Grades_Activity_game2DTO;
import Data_Access.DTO.InstitutionDTO;
import Data_Access.DTO.PermissionDTO;
import Data_Access.DTO.Permission_roleDTO;
import Data_Access.DTO.PersonDTO;
import Data_Access.DTO.RoleDTO;

public class App {
    public static void main(String[] args) throws Exception {
            User system=new User();
            system.sistema(); 
            /* PermissionRoleDAO consulta=new PermissionRoleDAO();
            for (Permission_roleDTO registo : consulta.role_permission_read(1)) {
                System.out.println(registo.getPermission_name());
            } */
    }

}
