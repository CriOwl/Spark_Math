package Data_Access.DAO;

import Data_Access.DTO.InstitutionDTO;
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

public class InstitutionDAO extends Data_Helper_Sqlite implements IDAO<InstitutionDTO> {
    @Override
    public InstitutionDTO readBy(Integer id) throws Exception {
        InstitutionDTO institution = new InstitutionDTO();
        String query = "SELECT " 
                     + "i.id_institution,"
                     + "i.id_manager,"
                     + "i.nombre,"
                     + "i.amie,"
                     + "i.state,"
                     + "i.date_created,"
                     + "i.date_updated"
                     + "FROM Institution i "
                     + "WHERE i.state = 'A' AND i.id_institution = " + id + ";";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                institution = new InstitutionDTO(rs.getString(4),
                                                rs.getString(6),
                                                rs.getString(7),
                                                rs.getInt(1),
                                                rs.getInt(2),
                                                rs.getString(3),
                                                rs.getInt(5));
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return institution;
    }

    @Override
    public List<InstitutionDTO> readAll(){
        List<InstitutionDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                        + "i.id_institution,"
                        + "i.id_manager,"
                        + "i.nombre,"
                        + "i.amie,"
                        + "i.state,"
                        + "i.date_created,"
                        + "i.date_updated"
                        + "FROM Institution i; ";

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                InstitutionDTO list = new InstitutionDTO(rs.getString(4),
                                                        rs.getString(6),
                                                        rs.getString(7),
                                                        rs.getInt(1),
                                                        rs.getInt(2),
                                                        rs.getString(3),
                                                        rs.getInt(5));
                tabla.add(list);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return tabla;
    }

    @Override
    public boolean create(InstitutionDTO entity) throws Exception {
        String query = " INSERT INTO INSTITUTION (Nombre, Amie) VALUES (?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getAmie());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(InstitutionDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Institution SET Nombre = ?, Amie = ?, FechaModifica = ? WHERE IdInstitution = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getAmie());
            pstmt.setString(3, dtf.format(now));
            pstmt.setInt(4, entity.getId_institution());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Institution SET state = ? WHERE IdInstitution = ?";
        try {
            Connection conet = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 0);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
}