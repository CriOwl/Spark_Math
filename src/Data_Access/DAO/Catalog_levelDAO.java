package Data_Access.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Data_Access.Data_Helper_Sqlite;
import Data_Access.DAO.DAO_C.IDAO;
import Data_Access.DTO.Catalog_levelDTO;

public class Catalog_levelDAO extends Data_Helper_Sqlite implements IDAO<Catalog_levelDTO> {

    @Override
    public Catalog_levelDTO readby(Integer id) throws Exception {
        Catalog_levelDTO oS = new Catalog_levelDTO();
        String query =" SELECT id_catalog_level  " 
                     +" ,name                    " 
                     +" ,state                   " 
                     +" ,date_created            " 
                     +" ,date_updated "
                     +" FROM    Catalog_level   "
                     +" WHERE   state ='1' AND id_catalog_level =   "+ id.toString() ;
        try {
            Connection conn = opConnection();            
            Statement  stmt = conn.createStatement();     
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                oS = new Catalog_levelDTO(rs.getInt(1)       // Id_catalog_level
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
                     +" ,date_updated "
                     +" FROM    Catalog_level   "
                     +" WHERE   state='1'";

        try {
            Connection conn = opConnection();            
            Statement  stmt = conn.createStatement();     
            ResultSet rs   = stmt.executeQuery(query);    
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
    public boolean created(Catalog_levelDTO entity) throws Exception {
        String query = " INSERT INTO Catalog_level (name) VALUES (?)";
        try {
            Connection        conn  = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(Catalog_levelDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Catalog_level SET name = ?, date_update = ? WHERE id_catalog_level = ?";
        try {
            Connection          conn = opConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getId_catalog_level());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Catalog_level SET state = ? WHERE id_catalog_level = ?";
        try {
            Connection          conn = opConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM Catalog_level "
                     +" WHERE   state ='A' ";
        try {
            Connection conn = opConnection();         // conectar a DB     
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
