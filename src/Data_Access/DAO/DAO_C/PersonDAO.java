package Data_Access.DAO.DAO_C;

import Data_Access.DTO.PersonDTO;
import Data_Access.Data_Helper_Sqlite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO extends Data_Helper_Sqlite implements IDAO<PersonDTO> {
    @Override
    public PersonDTO readby(Integer id) throws Exception {
        PersonDTO registro = new PersonDTO();
        String query = "SELECT "
                + "p.id_person, "
                + "p.name, "
                + "p.last_name, "
                + "p.DNI, "
                + "p.email, "
                + "p.password, "
                + "p.birthdate, "
                + "r.name,"
                + "p.state, "
                + "p.date_created, "
                + "p.date_updated "
                + "FROM Persona p "
                + "JOIN Role r ON p.id_role=r.id_role "
                + "WHERE p.state= 1 AND p.id_person = " + id;
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                registro = new PersonDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return registro;
    }

    @Override
    public List<PersonDTO> readall() {
        List<PersonDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                + "p.id_person, "
                + "p.name, "
                + "p.last_name, "
                + "p.DNI, "
                + "p.email, "
                + "p.password, "
                + "p.birthdate, "
                + "r.name,"
                + "p.state, "
                + "p.date_created, "
                + "p.date_updated "
                + "FROM Persona p "
                + "JOIN Role r ON p.id_role=r.id_role "
                + "WHERE p.state= 1 ";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PersonDTO list = new PersonDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11));
                tabla.add(list);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tabla;
    }

    @Override
    public boolean created(PersonDTO entity) throws Exception {
        String query = "INSERT INTO Persona (name, last_name,DNI,email,password,birthdate,id_role,id_institution) VALUES(?,?,?,?,?,?,?,?);";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getLast_name());
            pstmt.setString(3, entity.getDNI());
            pstmt.setString(4, entity.getEmail());
            pstmt.setString(5, entity.getPassword());
            pstmt.setString(6, entity.getBirthdate());
            pstmt.setInt(7, (int) entity.getId_role());
            pstmt.setInt(8, (int) entity.getId_institution());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean update(PersonDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Persona SET name=?,last_name=?,DNI=?,email=?,password=?,id_role=?,state = ?, id_institution = ? ,date_updated=?, birthdate= ? WHERE id_person= "
                + entity.getId_person();
        try {
            Connection conect = opConnection();
            PreparedStatement pstmt = conect.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getLast_name());
            pstmt.setString(3, entity.getDNI());
            pstmt.setString(4, entity.getEmail());
            pstmt.setString(5, entity.getPassword());
            pstmt.setInt(6, (int) entity.getId_role());
            pstmt.setInt(7, (int) entity.getId_state());
            pstmt.setInt(8, (int) entity.getId_institution());
            pstmt.setString(9, dtf.format(now).toString());
            pstmt.setString(10, entity.getBirthdate());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Persona SET state=?,date_updated=? Where id_person=?";
        try {
            Connection conect = opConnection();
            PreparedStatement pstmt = conect.prepareStatement(query);
            pstmt.setInt(1, 0);
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<PersonDTO> read_combobox() {
        List<PersonDTO> list_person = new ArrayList<>();
        String querry = "SELECT "
                + "p.id_person, "
                + "p.DNI, "
                + "p.email "
                + "FROM Person p "
                + "WHERE p.state = 1";
        try {
            Connection cone = opConnection();
            Statement stmt = cone.createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            while (rs.next()) {
                PersonDTO person = new PersonDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                list_person.add(person);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list_person;
    }

    @Override
    public List<PersonDTO> read_column() throws Exception {
        List<PersonDTO> columns = new ArrayList<>();
        String query = "PRAGMA table_info(vw_persona) ";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PersonDTO column = new PersonDTO(
                        rs.getString(2)

                );
                columns.add(column);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return columns;
    }

    @Override
    public List<PersonDTO> search_read(String DNI) throws Exception {
        List<PersonDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                + "p.id_person, "
                + "p.name, "
                + "p.last_name, "
                + "p.DNI, "
                + "p.email, "
                + "p.password, "
                + "p.birthdate, "
                + "p.id_role,"
                + "p.state, "
                + "p.date_created, "
                + "p.id_institution, "
                + "p.date_updated "
                + "FROM Persona p "
                + "WHERE p.state= 1  AND p.DNI LIKE ?";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, "%" + DNI + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PersonDTO registro = new PersonDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12));
                tabla.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tabla;
    }

    @Override
    public PersonDTO search_read_single(String DNI) throws Exception {
        PersonDTO registro = new PersonDTO();
        String query = "SELECT "
                + "p.id_person, "
                + "p.name, "
                + "p.last_name, "
                + "p.DNI, "
                + "p.email, "
                + "p.password, "
                + "p.birthdate, "
                + "p.id_role,"
                + "p.state, "
                + "p.date_created, "
                + "p.id_institution, "
                + "p.date_updated "
                + "FROM Persona p "
                + "WHERE p.state= 1  AND p.DNI LIKE ?";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, "%" + DNI + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                registro = new PersonDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return registro;
    }

}