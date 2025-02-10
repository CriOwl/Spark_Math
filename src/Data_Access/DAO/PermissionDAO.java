package Data_Access.DAO;

import Data_Access.DTO.PermissionDTO;
import Data_Access.Data_Helper_Sqlite;
import Data_Access.DAO.DAO_C.IDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class PermissionDAO extends Data_Helper_Sqlite implements IDAO<PermissionDTO> {
    @Override
    public PermissionDTO readby(Integer id) throws Exception {
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
            throw e; //new PatException(e.getMessage(), getClass().getName(), "readBy()");
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
                PermissionDTO list =new PermissionDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6)
                    );
                    tabla.add(list);
                }

        } catch (SQLException e) {
            
        }
        return tabla;
    }
    

    @Override
    public boolean created(PermissionDTO entity) throws Exception{
        String query =  "INSERT INTO Permission (name , description , name_method, state) VALUES (?,?,?,?)";
        try{
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getDescription());
            pstmt.setString(3, entity.getName_method());
            pstmt.setInt(4, entity.getState());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println(e);
        }   
        return false;
    }


    @Override
    public boolean update(PermissionDTO entity) throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Permission SET name = ?, description = ?, name_method = ? , state = ?, date_updated = ? WHERE id_permission = ?;";
        try{
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getDescription());
            pstmt.setString(3, entity.getName_method());
            pstmt.setInt(4, entity.getState());
            pstmt.setString(5, dtf.format(now).toString());
            pstmt.setInt(6, entity.getId_permission());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
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
            throw e;// new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
    @Override
    public List<PermissionDTO> read_combobox() {
        List<PermissionDTO> list_role = new ArrayList<>();
        /* String querry = "SELECT "
                + "r.id_role, "
                + "r.name "
                + "FROM Role r "
                + "WHERE r.state = 1";
        try {
            Connection cone = opConnection();
            Statement stmt = cone.createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            while (rs.next()) {
                PermissionDTO roles = new PermissionDTO(
                        rs.getInt(1),
                        rs.getString(2));
                        list_role.add(roles);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } */
        return list_role;
    }

    @Override
    public List<PermissionDTO> read_column() throws Exception {
        List<PermissionDTO> columns = new ArrayList<>();
       /*  String query = "PRAGMA table_info(Role) ";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PermissionDTO column = new PermissionDTO(
                        rs.getString(2)

                );
                columns.add(column);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } */
        return columns;
    }

    @Override
    public List<PermissionDTO> search_read(String name) throws Exception {
       /*  List<PermissionDTO> tabla = new ArrayList<>();
        PermissionDTO registro = new PermissionDTO();
        String query = "SELECT "
                + "r.id_role, "
                + "r.name, "
                + "r.state, "
                + "r.id_hierarchy, "
                + "r.name " //---------------------------------//
                + "FROM role r "
                + "WHERE r.state = 1 AND r.id_role LIKE ?";
        try {
            Connection conn = opConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%"+name+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                registro = new PermissionDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3));
                tabla.add(registro);
                System.out.println(rs.getString(2)+"------------");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tabla; */
       List<PermissionDTO> tabla = new ArrayList<>(); ///----------------///
        return tabla;
    }

    @Override
    public List<PermissionDTO> read_combobox2() {
        List<PermissionDTO> list_role = new ArrayList<>();
        /* String querry = "SELECT "
                + "r.id_hierarchy "
                + "FROM Role r "
                + "JOIN Catalog c ON r.id_hierarchy=c.id_catalog "
                + "WHERE r.state = 1";
        try {
            Connection cone = opConnection();
            Statement stmt = cone.createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            while (rs.next()) {
                PermissionDTO roles = new PermissionDTO(
                        rs.getInt(1));
                        list_role.add(roles);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } */
        return list_role;
    }
    @Override
    public PermissionDTO search_read_single(String name) throws Exception {
        PermissionDTO registro = new PermissionDTO();
        String query = "SELECT "
                + "p.id_permission, "
                + "p.name, "
                + "p.description, "
                + "p.name_method, "
                + "p.state "
                + "FROM Permission p "
                + "WHERE p.state = 1 AND p.name LIKE ?";
        try {
            Connection conn = opConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                registro = new PermissionDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                        );
                System.out.println(rs.getString(2)+"------------");
                System.out.println(registro.toString());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println(registro.toString());
        return registro;
    }
}
