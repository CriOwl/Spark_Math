import Data_Access.DAO.PermissionDAO;
import Data_Access.DAO.PersonDAO;
import Data_Access.DTO.PermissionDTO;
import Data_Access.DTO.PersonDTO;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            PersonDAO pdsa= new PersonDAO();
            for (PersonDTO asdasd : pdsa.readall()) {
                System.out.println(asdasd.toString());
            }
        } catch (Exception e) {
        } finally {
        }

        try {
            PermissionDAO pdsa= new PermissionDAO();
            for (PermissionDTO asdasd : pdsa.readall()) {
                System.out.println(asdasd.toString());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
