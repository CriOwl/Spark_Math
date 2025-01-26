import Data_Access.DAO.Catalog_levelDAO;
import Data_Access.DAO.PersonDAO;
import Data_Access.DTO.Catalog_levelDTO;
import Data_Access.DTO.PersonDTO;

public class App {
    public static void main(String[] args) throws Exception {
        // try {
        //     PersonDAO pdsa= new PersonDAO();
        //     for (PersonDTO asdasd : pdsa.readall()) {
        //         System.out.println(asdasd.toString());
        //     }
        // } catch (Exception e) {
        // } finally {
        // }

        try{
            Catalog_levelDAO asd= new Catalog_levelDAO ();
            for(Catalog_levelDTO dsa : asd.readall()){
                System.out.println(dsa.toString());
            }
        }catch(Exception e){
            
        }
            
           
    }
}

