import Data_Access.DAO.CatalogDAO;
import Data_Access.DAO.Catalog_levelDAO;
import Data_Access.DAO.PersonDAO;
import Data_Access.DTO.CatalogDTO;
import Data_Access.DTO.Catalog_levelDTO;
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

            CatalogDAO pdsa = new CatalogDAO();
                
                System.out.println(pdsa.readby(26));        
    }
}
