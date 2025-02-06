package Data_Access.DAO.DAO_C;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Data_Access.DAO.IDAOGAME;
import Data_Access.Data_Helper_Sqlite;
import Data_Access.DTO.PuntajeDTO;
//import Framework.PatException;

public class PuntajeDAO extends Data_Helper_Sqlite implements IDAOGAME<PuntajeDTO>{
    @Override
    public PuntajeDTO readBy(Integer id) throws Exception {
        PuntajeDTO oS = new PuntajeDTO();
        String query =" SELECT IdPuntaje  " 
                     +" ,IdUsuario "
                     +" ,FechaJuego "
                     +" ,Aciertos "
                     +" ,Errores "
                     +" ,Estado        " 
                     +" ,Fecha_creacion     " 
                     +" ,Fecha_modificacion "
                     +" FROM    Puntaje   "
                     +" WHERE   Estado ='A' AND IdPuntaje =   "+ id.toString() ;
        try {
            Connection conn = opConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new PuntajeDTO(rs.getInt(1)       // IdPuntaje
                                ,rs.getInt(2)           // IdUsuario
                                ,rs.getString(3)        // FechaJuego      
                                ,rs.getInt(4)           // Aciertos
                                ,rs.getInt(5)           // Errores
                                ,rs.getString(6)        // Estado         
                                ,rs.getString(7)        // Fecha_creacion      
                                ,rs.getString(8)        // Fecha_modificacion
                                );                                  
            }
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<PuntajeDTO> readAll() throws Exception {
        List <PuntajeDTO> lst = new ArrayList<>();
        String query =" SELECT IdPuntaje  " 
                     +" ,IdUsuario "
                     +" ,FechaJuego "
                     +" ,Aciertos "
                     +" ,Errores "

                     +" ,Estado        " 
                     +" ,Fecha_creacion     " 
                     +" ,Fecha_modificacion "
                     +" FROM    Puntaje   "
                     +" WHERE   Estado ='A' ";

        try {
            Connection conn = opConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                PuntajeDTO s = new PuntajeDTO( rs.getInt(1)     // IdPuntaje
                                        ,rs.getInt(2)           // IdUsuario
                                        ,rs.getString(3)        // FechaJuego      
                                        ,rs.getInt(4)           // Aciertos
                                        ,rs.getInt(5)           // Errores
                                        ,rs.getString(6)        // Estado         
                                        ,rs.getString(7)        // Fecha_creacion      
                                        ,rs.getString(8));        // Fecha_modificacion
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(PuntajeDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " INSERT INTO Puntaje (id_person,FechaJuego,Aciertos,Errores) VALUES (?,?,?,?)";
        try {
            Connection        conn  = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdUsuario());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getAciertos());
            pstmt.setInt(4, entity.getErrores());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(PuntajeDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Puntaje SET Id_Usuario = ?, FechaJuego = ?, Aciertos = ?, Errores = ?, Fecha_modificacion = ? WHERE IdPuntaje = ?";
        try {
            Connection          conn = opConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdUsuario());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getAciertos());
            pstmt.setInt(4, entity.getErrores());
            pstmt.setString(5, dtf.format(now).toString());
            pstmt.setInt(6, entity.getIdPuntaje());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Puntaje SET Estado = ? WHERE IdPuntaje = ?";
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
        String query =" SELECT COUNT(*) TotalReg FROM Puntaje "
                     +" WHERE   Estado ='A' ";
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
