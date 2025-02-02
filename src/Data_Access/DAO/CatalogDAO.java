package Data_Access.DAO;

import Data_Access.DTO.CatalogDTO;
import Data_Access.Data_Helper_Sqlite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAO extends Data_Helper_Sqlite implements IDAO<CatalogDTO>{

    @Override
    public CatalogDTO readby(Integer id) throws Exception {
        CatalogDTO oS = new CatalogDTO();
        String query =" SELECT id_catalog " 
                     +" ,name                    " 
                     +" ,id_catalog_level        " 
                     +" ,state                   " 
                     +" ,date_created            " 
                     +" ,date_updated "
                     +" FROM    Catalog   "
                     +" WHERE   state ='1' AND id_catalog =   "+ id.toString() ;
        try {
            Connection conn = opConnection();          
            Statement  stmt = conn.createStatement();    
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                oS = new CatalogDTO(rs.getInt(1)                   // Id_catalog_level
                                   ,rs.getString(2)                // name
                                   ,rs.getInt(3)                   // id_catalog_level         
                                   ,rs.getInt(4)                   // state        
                                   ,rs.getString(5)                // date_created      
                                   ,rs.getString(6));              // date_update
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return oS;
    }

    @Override
    public List<CatalogDTO> readall() throws Exception {
        List <CatalogDTO> lst = new ArrayList<>();
        String query =" SELECT id_catalog  " 
                     +" ,name                    " 
                     +" ,id_catalog_level        " 
                     +" ,state                   " 
                     +" ,date_created            " 
                     +" ,date_updated            "
                     +" FROM    Catalog          "
                     +" WHERE   state='1'";

        try {
            Connection conn = opConnection();             
            Statement  stmt = conn.createStatement();       
            ResultSet rs   = stmt.executeQuery(query);    
            while (rs.next()) {
                CatalogDTO s = new CatalogDTO(rs.getInt(1)                   // Id_catalog_level
                                             ,rs.getString(2)                // name
                                             ,rs.getInt(3)                   // id_catalog_level         
                                             ,rs.getInt(4)                   // state        
                                             ,rs.getString(5)                // date_created      
                                             ,rs.getString(6));              // date_update
             lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return lst; 
    }


    @Override
    public boolean created(CatalogDTO entity) throws Exception {
        String query = " INSERT INTO Catalogo (name, id_catalog_level) VALUES (?)";
        try {
            Connection        conn  = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getId_catalog_level());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(CatalogDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Catalog SET name = ?, id_catalog_level = ?, date_update = ? WHERE id_catalog = ?";
        try {
            Connection          conn = opConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getId_catalog_level());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getId_catalog_level());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Catalog SET state = ? WHERE id_catalog = ?";
        try {
            Connection          conn = opConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM Catalog "
                     +" WHERE   state ='A' ";
        try {
            Connection conn = opConnection();           // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }

}
