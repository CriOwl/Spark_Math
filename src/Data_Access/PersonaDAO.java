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
import DataAccess.DTO.PersonDTO;
import Framework.PatException;

public class PersonaDAO extends Data_Helper_Sqlite implements IDAO<PersonDTO> {

    @Override
    public PersonDTO readBy(Integer id) throws Exception {
        PersonDTO person = new PersonDTO();
        String query = " SELECT IdPersona, Nombre, Apellido, DNI, Email, Clave, FechaNacimiento, IdRole, Estado, FechaCrea, FechaModifica "
                     + " FROM PERSONA "
                     + " WHERE Estado = 'A' AND IdPersona = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                person = new PersonDTO(rs.getInt(1),  // IdPersona
                                       rs.getString(2), // Nombre
                                       rs.getString(3), // Apellido
                                       rs.getString(4), // DNI
                                       rs.getString(5), // Email
                                       rs.getString(6), // Clave
                                       rs.getString(7), // FechaNacimiento
                                       rs.getInt(8),    // IdRole
                                       rs.getInt(9),    // Estado
                                       rs.getString(10),// FechaCrea
                                       rs.getString(11) // FechaModifica
                );
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return person;
    }

    @Override
    public List<PersonDTO> readAll() throws Exception {
        List<PersonDTO> persons = new ArrayList<>();
        String query = " SELECT IdPersona, Nombre, Apellido, DNI, Email, Clave, FechaNacimiento, IdRole, Estado, FechaCrea, FechaModifica "
                     + " FROM PERSONA "
                     + " WHERE Estado = 'A' ";

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PersonDTO person = new PersonDTO(rs.getInt(1),  // IdPersona
                                                rs.getString(2), // Nombre
                                                rs.getString(3), // Apellido
                                                rs.getString(4), // DNI
                                                rs.getString(5), // Email
                                                rs.getString(6), // Clave
                                                rs.getString(7), // FechaNacimiento
                                                rs.getInt(8),    // IdRole
                                                rs.getInt(9),    // Estado
                                                rs.getString(10),// FechaCrea
                                                rs.getString(11) // FechaModifica
                );
                persons.add(person);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return persons;
    }

    @Override
    public boolean create(PersonDTO entity) throws Exception {
        String query = " INSERT INTO PERSONA (Nombre, Apellido, DNI, Email, Clave, FechaNacimiento, IdRole) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getLast_name());
            pstmt.setString(3, entity.getDNI());
            pstmt.setString(4, entity.getEmail());
            pstmt.setString(5, entity.getPassword());
            pstmt.setString(6, entity.getBirthdate());
            pstmt.setInt(7, entity.getId_role());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(PersonDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE PERSONA SET Nombre = ?, Apellido = ?, DNI = ?, Email = ?, Clave = ?, FechaNacimiento = ?, IdRole = ?, FechaModifica = ? WHERE IdPersona = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getLast_name());
            pstmt.setString(3, entity.getDNI());
            pstmt.setString(4, entity.getEmail());
            pstmt.setString(5, entity.getPassword());
            pstmt.setString(6, entity.getBirthdate());
            pstmt.setInt(7, entity.getId_role());
            pstmt.setString(8, dtf.format(now));
            pstmt.setInt(9, entity.getId_person());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE PERSONA SET Estado = ? WHERE IdPersona = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM PERSONA WHERE Estado = 'A' ";
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