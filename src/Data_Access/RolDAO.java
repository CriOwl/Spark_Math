package Data_Access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.RoleDTODTO;
import Framework.PatException;

public class RoleDAO extends Data_Helper_Sqlite implements IDAO<RoleDTO> {

    @Override
    public RoleDTO readBy(Integer id) throws Exception {
        RoleDTO role = new RoleDTO();
        String query = " SELECT IdRole, Nombre, Estado, FechaCrea, FechaModifica "
                     + " FROM ROLE "
                     + " WHERE Estado = 'A' AND IdRole = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                role = new RoleDTO(rs.getInt(1),  // IdRole
                                   rs.getString(2), // Nombre
                                   rs.getInt(3),    // Estado
                                   rs.getString(4), // FechaCrea
                                   rs.getString(5)  // FechaModifica
                );
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return role;
    }

    @Override
    public List<RoleDTO> readAll() throws Exception {
        List<RoleDTO> roles = new ArrayList<>();
        String query = " SELECT IdRole, Nombre, Estado, FechaCrea, FechaModifica "
                     + " FROM ROLE "
                     + " WHERE Estado = 'A' ";

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RoleDTO role = new RoleDTO(rs.getInt(1),  // IdRole
                                          rs.getString(2), // Nombre
                                          rs.getInt(3),    // Estado
                                          rs.getString(4), // FechaCrea
                                          rs.getString(5)  // FechaModifica
                );
                roles.add(role);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return roles;
    }

    @Override
    public boolean create(RoleDTO entity) throws Exception {
        String query = " INSERT INTO ROLE (Nombre) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(RoleDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE ROLE SET Nombre = ?, FechaModifica = ? WHERE IdRole = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, dtf.format(now));
            pstmt.setInt(3, entity.getId_Role());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE ROLE SET Estado = ? WHERE IdRole = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*) TotalReg FROM ROLE WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}