package Data_Access.DAO;

import Data_Access.DTO.PermissionDTO;
import Data_Access.Data_Helper_Sqlite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PermissionDAO extends Data_Helper_Sqlite implements IDAO<PermissionDTO> {

    @Override
    public PermissionDTO readBy(Integer id) throws Exception {
        PermissionDTO registro = new PermissionDTO();
        String query = "SELECT "
                        + "p.id_permission, "
                        + "p.name, "
                        + "p.description, "
                        + "p.state, "
                        + "p.date_created, "
                        + "p.date_updated "
                        + "FROM permissions p "
                        + "WHERE p.state = 1 AND p.id_permission = " + id + ";";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                registro = new PermissionDTO(rs.getInt(1),
                                            rs.getString(2),
                                            rs.getString(3),
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
    public List<PermissionDTO> readAll() {
        List<PermissionDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                        + "p.id_permission, "
                        + "p.name, "
                        + "p.description, "
                        + "p.state, "
                        + "p.date_created, "
                        + "p.date_updated "
                        + "FROM permissions p;";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PermissionDTO list = new PermissionDTO(rs.getInt(1),
                                                    rs.getString(2),
                                                    rs.getString(3),
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
    public boolean create(PermissionDTO entity) throws Exception {
        String query = "INSERT INTO permissions (name, description, state, date_created, date_updated) VALUES (?, ?, ?, ?, ?);";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getDescription());
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
    public boolean update(PermissionDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE permissions SET name = ?, description = ?, state = ?, date_updated = ? WHERE id_permission = ?;";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getDescription());
            pstmt.setInt(3, entity.getState());
            pstmt.setString(4, dtf.format(now));
            pstmt.setInt(5, entity.getId_permission());
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
        String query = "UPDATE permissions SET state = 0, date_updated = ? WHERE id_permission = ?;";
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
}