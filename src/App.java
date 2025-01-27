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
        try {
            PersonDAO pdsa= new PersonDAO();
            for (PersonDTO asdasd : pdsa.readall()) {
                System.out.println("::::::::::::::::::::::");
                System.out.println(asdasd.toString());
            }
        } catch (Exception e) {
        } finally {
        }

        try {
            PermissionDAO pdsa= new PermissionDAO();
            for (PermissionDTO asdasd : pdsa.readall()) {
                System.out.println("//////////////////////");
                System.out.println(asdasd.toString());
            }
        } catch (Exception e) {
        }

        try {
            PersonDAO pdsa = new PersonDAO();
            for (PersonDTO asdasd : pdsa.readall()) {
                System.out.println("*********************");
                System.out.println(asdasd.toString());
            }
        } catch (Exception e) {
        }

        try {
            PermissionRoleDAO pdsa = new PermissionRoleDAO();
            for (Permission_roleDTO asdasd : pdsa.readall()) {
                System.out.println("______________________");
                System.out.println(asdasd.toString());
            }
        } catch (Exception e) {
        }

        try {
            RoleDAO pdsa = new RoleDAO();
            for (RoleDTO asdasd : pdsa.readall()) {
                System.out.println("++++++++++++++++++++");
                System.out.println(asdasd.toString());
            }
        } catch (Exception e) {
        }

        try{
            InstitutionDAO pdsa = new InstitutionDAO();
            for(InstitutionDTO  asdasd : pdsa.readall()){
                System.out.println("-------------------");
                System.out.println(asdasd.toString());
            }
        }catch(Exception e){}finally{}
        
        try{
            Grades_Activity_game2DAO pdsa = new Grades_Activity_game2DAO();
            for(Grades_Activity_game2DTO asdasd : pdsa.readall()){
                System.out.println("-/-/-/-/-/-/-/-/-/-/");
                System.out.println(asdasd.toString());
            }
        }catch (Exception e){}finally{}
    }

}
