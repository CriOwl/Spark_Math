package Data_Access.DAO;

import Data_Access.DTO.Permission_roleDTO;
import Data_Access.Data_Helper_Sqlite;
import Data_Access.DAO.DAO_C.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PermissionRoleDAO extends Data_Helper_Sqlite implements IDAO<Permission_roleDTO> {

    @Override
    public Permission_roleDTO readby(Integer id) throws Exception {
        Permission_roleDTO registro = new Permission_roleDTO();
        String query = "SELECT "
                        + "pr.id_permission_role, "
                        + "pr.id_role, "
                        + "pr.id_permission, "
                        + "pr.state, "
                        + "pr.date_created, "
                        + "pr.date_updated "
                        + "FROM permission_role pr "
                        + "WHERE pr.state = 1 AND pr.id_permission_role = " + id + ";";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                registro = new Permission_roleDTO(rs.getInt(1),
                                                rs.getInt(2),
                                                rs.getInt(3),
                                                rs.getInt(4),
                                                rs.getString(5),
                                                rs.getString(6));
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return registro;
    }

    @Override
    public List<Permission_roleDTO> readall() {
        List<Permission_roleDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                        + "pr.id_permission_role, "
                        + "pr.id_role, "
                        + "pr.id_permission, "
                        + "pr.state, "
                        + "pr.date_created, "
                        + "pr.date_updated "
                        + "FROM permission_role pr;";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Permission_roleDTO list = new Permission_roleDTO(rs.getInt(1),
                                                                rs.getInt(2),
                                                                rs.getInt(3),
                                                                rs.getInt(4),
                                                                rs.getString(5),
                                                                rs.getString(6));
                tabla.add(list);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return tabla;
    }

    @Override
    public boolean created(Permission_roleDTO entity) throws Exception {
        String query = "INSERT INTO permission_role (id_role, id_permission, state, date_created, date_updated) VALUES (?, ?, ?, ?, ?);";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId_role());
            pstmt.setInt(2, entity.getId_permission());
            pstmt.setInt(3, entity.getState());
            pstmt.setString(4, entity.getDate_created());
            pstmt.setString(5, entity.getDate_updated());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(Permission_roleDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE permission_role SET id_role = ?, id_permission = ?, state = ?, date_updated = ? WHERE id_permission_role = ?;";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId_role());
            pstmt.setInt(2, entity.getId_permission());
            pstmt.setInt(3, entity.getState());
            pstmt.setString(4, dtf.format(now));
            pstmt.setInt(5, entity.getId_permission_role());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE permission_role SET state = 0, date_updated = ? WHERE id_permission_role = ?;";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, dtf.format(now));
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public List<Permission_roleDTO> role_permission_read(Integer id_role) throws Exception {
        List<Permission_roleDTO> tabla=new ArrayList<>();
        Permission_roleDTO registro=new Permission_roleDTO();
        String query = "SELECT "
                        + "p.name, "
                        + "pr.state, "
                        + "p.name_method "
                        + "FROM Permission_role pr "
                        + "JOIN Permission p ON pr.id_permission=p.id_permission "
                        + "WHERE pr.state = 1 AND pr.id_role = " + id_role + ";";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                registro=new Permission_roleDTO(rs.getString(1),rs.getString(3));
                tabla.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tabla;
    }

    @Override
    public List<Permission_roleDTO> read_combobox() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read_combobox'");
    }

    @Override
    public List<Permission_roleDTO> read_column() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read_column'");
    }

    @Override
    public List<Permission_roleDTO> search_read(String DNI) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search_read'");
    }
}