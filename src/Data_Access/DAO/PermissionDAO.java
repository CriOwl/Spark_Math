package Data_Access.DAO;

import Data_Access.DTO.PermissionDTO;
import Data_Access.Data_Helper_Sqlite;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Statement;
import java.security.Permission;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class PermissionDAO extends Data_Helper_Sqlite implements IDAO<PermissionDTO> {
    @Override
    public PermissionDTO readBy(Integer id) throws Exception {
        PermissionDTO permission = new PermissionDTO();
        String query = "SELECT " 
                     + "p.id_permission, "
                     + "p.name, "
                     + "p.description, "
                     + "p.state, "
                     + "p.date_created, "
                     + "p.date_updated "
                     + "FROM Permission p "
                     + "WHERE p.state = 1 AND p.id_permission = " + id + ";";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                permission = new PermissionDTO(rs.getInt(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getInt(4),
                                                rs.getString(5),
                                                rs.getString(6));
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return permission;
    }

    @Override
    public List<PermissionDTO> readall(){
        List<PermissionDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                        + "p.id_permission, "
                        + "p.name, "
                        + "p.description, "
                        + "p.state, "
                        + "p.date_created, "
                        + "p.date_updated "
                        + "FROM Permission p "
                        + "WHERE p.state = 1 ";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PermissionDTO list =new PermissionDTO(rs.getInt(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getInt(4),
                                            rs.getString(5),
                                            rs.getString(6));
                                            tabla.add(list);
            }

        } catch (SQLException e) {
            //throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return tabla;
    }
    

    @Override
    public boolean created(PermissionDTO entity) throws Exception{
        String query =  "INSERT INTO Permission (name, description) VALUES(?,?);";
        try{
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getDescription());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }   
    }


    @Override
    public boolean update(PermissionDTO entity) throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Permission SET name = ?, description = ?, date_updated = ? WHERE id_permission = ?;";
        try{
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getDescription());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Permission SET state = ?, date_updated = ? WHERE id_permission = ?;";
        try{
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 0);
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
}
