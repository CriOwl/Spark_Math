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
import DataAccess.DTO.InstitutionDTO;
import Framework.PatException;

public class InstitutionDAO extends Data_Helper_Sqlite implements IDAO<InstitutionDTO> {

    @Override
    public InstitutionDTO readBy(Integer id) throws Exception {
        InstitutionDTO institution = new InstitutionDTO();
        String query = " SELECT IdInstitution, IdManager, Nombre, Amie, Estado, FechaCrea, FechaModifica "
                     + " FROM INSTITUTION "
                     + " WHERE Estado = 'A' AND IdInstitution = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                institution = new InstitutionDTO(
                    rs.getString(4), // Amie
                    rs.getString(6), // FechaCrea
                    rs.getString(7), // FechaModifica
                    rs.getInt(1),    // IdInstitution
                    rs.getInt(2),    // IdManager
                    rs.getString(3), // Nombre
                    rs.getInt(5)     // Estado
                );
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return institution;
    }

    @Override
    public List<InstitutionDTO> readAll() throws Exception {
        List<InstitutionDTO> institutions = new ArrayList<>();
        String query = " SELECT IdInstitution, IdManager, Nombre, Amie, Estado, FechaCrea, FechaModifica "
                     + " FROM INSTITUTION "
                     + " WHERE Estado = 'A' ";

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                InstitutionDTO institution = new InstitutionDTO(
                    rs.getString(4), // Amie
                    rs.getString(6), // FechaCrea
                    rs.getString(7), // FechaModifica
                    rs.getInt(1),    // IdInstitution
                    rs.getInt(2),    // IdManager
                    rs.getString(3), // Nombre
                    rs.getInt(5)     // Estado
                );
                institutions.add(institution);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return institutions;
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
        String query = " UPDATE INSTITUTION SET Nombre = ?, Amie = ?, FechaModifica = ? WHERE IdInstitution = ?";
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
        String query = " UPDATE INSTITUTION SET Estado = ? WHERE IdInstitution = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM INSTITUTION WHERE Estado = 'A' ";
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