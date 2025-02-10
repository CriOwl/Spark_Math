package Data_Access.DAO.DAO_C;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Data_Access.Data_Helper_Sqlite;
import Data_Access.IVIEWDAO;
import Data_Access.DTO.Catalog_levelDTO;

public class Catalog_levelDAO extends Data_Helper_Sqlite implements IVIEWDAO<Catalog_levelDTO> {

    @Override
    public Catalog_levelDTO readby(Integer id) throws Exception {
        Catalog_levelDTO oS = new Catalog_levelDTO();
        String query =" SELECT id_catalog_level  " 
                     +" ,name                    " 
                     +" ,state                   " 
                     +" ,date_created            " 
                     +" ,date_updated            "
                     +" FROM    Catalog_level    "
                     +" WHERE   state ='1' AND id_catalog_level =   "+ id.toString() ;
        try {
            Connection conn = opConnection();            
            Statement  stmt = conn.createStatement();     
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                oS = new Catalog_levelDTO(rs.getInt(1)                // Id_catalog_level
                                         ,rs.getString(2)             // name             
                                         ,rs.getInt(3)                // state        
                                         ,rs.getString(4)             // date_created      
                                         ,rs.getString(5));           // date_update
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return oS;
    }

    @Override
    public List<Catalog_levelDTO> readall() throws Exception {
        List <Catalog_levelDTO> lst = new ArrayList<>();
        String query =" SELECT id_catalog_level  " 
                     +" ,name                    " 
                     +" ,state                   " 
                     +" ,date_created            " 
                     +" ,date_updated            "
                     +" FROM    Catalog_level    "
                     +" WHERE   state='1'        ";

        try {
            Connection conn = opConnection();            
            Statement  stmt = conn.createStatement();     
            ResultSet rs    = stmt.executeQuery(query);    
            while (rs.next()) {
                Catalog_levelDTO s = new Catalog_levelDTO(rs.getInt(1)       // Id_catalog_level
                                                ,rs.getString(2)             // name             
                                                ,rs.getInt(3)                // state        
                                                ,rs.getString(4)             // date_created      
                                                ,rs.getString(5));           // date_update
             lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return lst; 
    }

    @Override
    public Catalog_levelDTO readby(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readby'");
    }

    @Override
    public List<Catalog_levelDTO> read_column() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read_column'");
    }

    @Override
    public List<Catalog_levelDTO> search_read(String DNI) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search_read'");
    }

    @Override
    public List<Catalog_levelDTO> read_combobox() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read_combobox'");
    }


}
