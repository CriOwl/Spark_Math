package Data_Access.DAO;

import Data_Access.DTO.RoleDTO;
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

public class RoleDAO extends Data_Helper_Sqlite implements IDAO<RoleDTO> {

    @Override
    public RoleDTO readby(Integer id) throws Exception {
        RoleDTO registro = new RoleDTO();
        String query = "SELECT "
                        + "r.id_role, "
                        + "r.name, "
                        + "r.state, "
                        + "r.date_created, "
                        + "r.date_updated "
                        + "FROM role r "
                        + "WHERE r.state = 1 AND r.id_role = " + id + ";";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                registro = new RoleDTO(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getInt(3),
                                    rs.getString(4),
                                    rs.getString(5));
            }
        } catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return registro;
    }

    @Override
    public List<RoleDTO> readall() {
        List<RoleDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                        + "r.id_role, "
                        + "r.name, "
                        + "r.state, "
                        + "r.date_created, "
                        + "r.date_updated "
                        + "FROM role r "
                        + "WHERE r.state = 1; ";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RoleDTO list = new RoleDTO(rs.getInt(1),
                                        rs.getString(2),
                                        rs.getInt(3),
                                        rs.getString(4),
                                        rs.getString(5));
                tabla.add(list);
            }
        } catch (SQLException e) {
            System.out.println(e);
            //throw new PatException(e.getMessage(), getClass().getName(), "readall()");
        }
        return tabla;
    }

    @Override
    public boolean created(RoleDTO entity) throws Exception {
        String query = "INSERT INTO role (name, state, date_created, date_updated) VALUES (?, ?, ?, ?);";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2,    entity.getState());
            pstmt.setString(3, entity.getDate_created());
            pstmt.setString(4, entity.getDate_update());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(RoleDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE role SET name = ?, state = ?, date_updated = ? WHERE id_role = ?;";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getState());
            pstmt.setString(3, dtf.format(now));
            pstmt.setInt(4, entity.getId_Role());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE role SET state = ?, date_updated = ? WHERE id_role = ?;";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 0);
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
}