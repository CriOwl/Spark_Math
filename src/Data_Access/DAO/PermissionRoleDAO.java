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
            System.out.println(e);
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
            System.out.println(e);
        }
        return tabla;
    }

    @Override
    public boolean created(Permission_roleDTO entity) throws Exception {
        String query = "INSERT INTO permission_role (id_role, id_permission, state, date_created)"
                        +"SELECT ?, ?, 1, datetime('now', 'localtime') "
                        +"WHERE NOT EXISTS ( SELECT 1 FROM Permission_role "
                        +"WHERE id_role = ? AND id_permission = ?) ";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId_role());
            pstmt.setInt(2, entity.getId_permission());
            pstmt.setInt(3, entity.getState());
            pstmt.setString(4, entity.getDate_created());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
        return false;
    }

    @Override
    public boolean update(Permission_roleDTO entity) throws Exception {
        String query = "UPDATE Permission_role "
                        +"SET state = 1, date_updated = datetime('now', 'localtime') "
                        +"WHERE id_role = ? AND id_permission = ? ";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId_role());
            pstmt.setInt(2, entity.getId_permission());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
        return false;
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
            throw e;
        }
    }
    public boolean delete_permissions(Permission_roleDTO entity) throws Exception {
        String query = "UPDATE Permission_role "
                        +"SET state = 0, date_updated = datetime('now', 'localtime') "
                        +"WHERE id_role = ? AND id_permission = ? ";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId_role());
            pstmt.setInt(2, entity.getId_permission());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Permission_roleDTO> role_permission_read(Integer id_role) throws Exception {
        List<Permission_roleDTO> listRegistro = new ArrayList<>();
        String querry = "SELECT "
                + "p.id_permission_role, "
                + "p.id_role, "
                + "r.name, "
                + "p.id_permission, "
                + "n.name, "
                + "n.name_method "
                + "FROM Permission_role p "
                + "JOIN Role r ON p.id_role=r.id_role "
                + "JOIN Permission n ON p.id_permission=n.id_permission "
                + "WHERE p.state = 1  AND p.id_role= "+id_role;
        try {
            Connection cone = opConnection();
            Statement stmt = cone.createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            while (rs.next()) {
                Permission_roleDTO registro = new Permission_roleDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)
                        );
                        listRegistro.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listRegistro;
    }

    @Override
    public List<Permission_roleDTO> read_combobox() throws Exception {
        List<Permission_roleDTO> listRegistro = new ArrayList<>();
        String querry = "SELECT "
                + "p.id_permission_role, "
                + "p.id_role, "
                + "r.name, "
                + "p.id_permission, "
                + "n.name "
                + "FROM Permission_role p "
                + "JOIN Role r ON p.id_role=r.id_role "
                + "JOIN Permission n ON p.id_permission=n.id_permission "
                + "WHERE p.state = 1 ";
        try {
            Connection cone = opConnection();
            Statement stmt = cone.createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            while (rs.next()) {
                Permission_roleDTO registro = new Permission_roleDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3));
                        listRegistro.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listRegistro;
    }

    @Override
    public List<Permission_roleDTO> read_column() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'read_column'");
    }

    @Override
    public List<Permission_roleDTO> search_read() throws Exception {
        List<Permission_roleDTO> listRegistro = new ArrayList<>();
        String querry = "SELECT "
                + "p.id_permission_role, "
                + "p.id_role, "
                + "r.name, "
                + "p.id_permission, "
                + "n.name "
                + "FROM Permission_role p "
                + "JOIN Role r ON p.id_role=r.id_role "
                + "JOIN Permission n ON p.id_permission=n.id_permission "
                + "WHERE p.state = 1 ";
        try {
            Connection cone = opConnection();
            Statement stmt = cone.createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            while (rs.next()) {
                Permission_roleDTO registro = new Permission_roleDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5)
                        );
                        listRegistro.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listRegistro;
    }

    @Override
    public List<Permission_roleDTO> read_combobox2() throws Exception {
        
        throw new UnsupportedOperationException("Unimplemented method 'read_combobox2'");
    }

    @Override
    public Permission_roleDTO search_read_single(String DNI) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'search_read_single'");
    }
}