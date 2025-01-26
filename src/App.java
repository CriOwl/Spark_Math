import Data_Access.DAO.CatalogDAO;
import Data_Access.DAO.Catalog_levelDAO;
import Data_Access.DAO.CourseDAO;
import Data_Access.DAO.PersonDAO;
import Data_Access.DTO.CatalogDTO;
import Data_Access.DTO.Catalog_levelDTO;
import Data_Access.DTO.CourseDTO;
import Data_Access.DTO.PersonDTO;

public class App {
    public static void main(String[] args) throws Exception {
        // try {
        //     PersonDAO pdsa = new PersonDAO();
        //     for (PersonDTO asdasd : pdsa.readall()) {
        //         System.out.println(asdasd.toString());
        //     }
        // } catch (Exception e) {
        // } finally {
        // }

        CourseDAO cs = new CourseDAO();
        for(CourseDTO cdt : cs.readall()){
        System.out.println(cdt);
        }
    }
}
