package Data_Access.DAO.DAO_C;

import Data_Access.DTO.DocenteDTO;
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

public class DocenteDAO extends Data_Helper_Sqlite {
    
    public DocenteDTO readby(Integer id) throws Exception {
        DocenteDTO registro = new DocenteDTO();
        String query = " SELECT "
                + " c.id_catalog, "
                + " c.name,                    "
                + " c.id_catalog_level,        "
                + " l.name,"
                + " c.state                   "
                + " FROM    Catalog   c "
                + " JOIN Catalog_level l ON c.id_catalog_level=l.id_catalog_level "
                + " WHERE   state = 1 AND c.id_catalog =   " + id.toString();
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                registro = new DocenteDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
            }
        } catch (SQLException e) {
            throw e;
        }
        return registro;
    }

    public List<DocenteDTO> readall() {
        List<DocenteDTO> tabla = new ArrayList<>();
        String query = " SELECT "
                + " c.id_catalog, "
                + " c.name,                    "
                + " c.id_catalog_level,        "
                + " l.name,"
                + " c.state                   "
                + " FROM    Catalog   c "
                + " JOIN Catalog_level l ON c.id_catalog_level=l.id_catalog_level "
                + " WHERE   state = 1";
        try {
            Connection conect = opConnection();
            Statement stm = conect.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                DocenteDTO registro = new DocenteDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                        rs.getInt(5));
                tabla.add(registro);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tabla;
    }

    public boolean created(DocenteDTO entity) {
        String query = " INSERT INTO Catalog (name, id_catalog_level)"
                + " VALUES(?,?,?)";
        try {
            Connection conect = opConnection();
            PreparedStatement pstm = conect.prepareStatement(query);
            pstm.setString(1,entity.getName());
            pstm.setInt(2,entity.getId_catalog_level());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean update(DocenteDTO entity) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Catalog SET "
        + " name = ?,                    "
        + " id_catalog_level = ?,        "
        + " state = ?  "
        + "date_updated = ?"
        + "WHERE id_catalog = "+entity.getId_catalog();    
        try {
            Connection conect = opConnection();
            PreparedStatement pstm = conect.prepareStatement(query);
            pstm.setString(1,entity.getName());
            pstm.setInt(2,entity.getId_catalog_level());
            pstm.setInt(3,entity.getId_catalog_level());
            pstm.setString(4, dtf.format(now).toString());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean delete(DocenteDTO entity) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Catalog SET "
        +" state = ?  "
        +"date_updated = ?"
        +"WHERE id_catalog = "+entity.getId_catalog();    
        try {
            Connection conect = opConnection();
            PreparedStatement pstm = conect.prepareStatement(query);
            pstm.setInt(1,0);
            pstm.setString(2, dtf.format(now).toString());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public List<DocenteDTO> read_combobox_role() {
        List<DocenteDTO> list_hierarchy = new ArrayList<>();
        String querry = "SELECT "
                + "c.id_catalog, "
                + "c.name, "
                + "c.id_catalog_level, "
                + "l.name, "
                + "c.state "
                + "FROM Catalog c "
                + "JOIN Catalog_level l ON c.id_catalog_level = l.id_catalog_level "
                + "WHERE c.state = 1 AND c.id_catalog_level=6";
        try {
            Connection cone = opConnection();
            Statement stmt = cone.createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            while (rs.next()) {
                DocenteDTO registro = new DocenteDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5));
                        list_hierarchy.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list_hierarchy;
    }

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

    public DocenteDTO search_read_single(String NAME) throws Exception {
        DocenteDTO registro = new DocenteDTO();
        String query = " SELECT "
                + " c.id_catalog, "
                + " c.name,                    "
                + " c.id_catalog_level,        "
                + " l.name,"
                + " c.state                   "
                + " FROM    Catalog   c "
                + " JOIN Catalog_level l ON c.id_catalog_level=l.id_catalog_level "
                + " WHERE c.id_catalog =  ?";
        try {
            Connection conn = opConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%"+"name"+"%");
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                registro = new DocenteDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
            }
        } catch (SQLException e) {
            throw e;
        }
        return registro;
    }
}
