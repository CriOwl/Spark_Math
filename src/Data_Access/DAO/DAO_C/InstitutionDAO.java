 package Data_Access.DAO.DAO_C;

import Data_Access.DTO.InstitutionDTO;
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

public class InstitutionDAO extends Data_Helper_Sqlite implements IDAO <InstitutionDTO> {
    @Override
    public InstitutionDTO readby(Integer id) throws Exception {
        InstitutionDTO institution = new InstitutionDTO();
        String query = "SELECT " 
                     + "i.id_institution, "
                     + "i.id_manager, "
                     + "i.name, "
                     + "i.amie, "
                     + "i.state, "
                     + "i.date_created, "
                     + "i.date_updated "
                     + "FROM Institution i "
                     + "JOIN Persona p ON i.id_manager = p.id_person "
                     + "WHERE i.state = 1 AND i.id_institution = " + id + ";";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                institution = new InstitutionDTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7)
                );
            }
        } catch (SQLException e) {
            System.out.println("e");
        }
        return institution;
    }

    @Override
    public List<InstitutionDTO> readall(){
        List<InstitutionDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                        + "i.id_institution, "
                        + "i.id_manager, "
                        + "i.name, "
                        + "i.amie, "
                        + "i.state, "
                        + "i.date_created, "
                        + "i.date_updated "
                        + "FROM Institution i; "
                        + "JOIN Persona p ON i.id_manager = p.id_person "
                        + "WHERE i.state = 1;";

        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                InstitutionDTO list = new InstitutionDTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7)
                );
                tabla.add(list);
            }
        } catch (SQLException e) {
            System.out.println(e);
            //throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return tabla;
    }

    @Override
    public boolean created(InstitutionDTO entity) throws Exception {
        String query = " INSERT INTO INSTITUTION (name, amie) VALUES (?, ?)";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getAmie());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(InstitutionDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Institution SET name = ?, amie = ?, date_updated = ? WHERE IdInstitution = ?";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getAmie());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getId_institution());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;//new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Institution SET state = ?, date_updated = ? WHERE IdInstitution = ?";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
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
    public List<InstitutionDTO> read_combobox(){
        List<InstitutionDTO> list_institution=new ArrayList<>();
        String querry=  "SELECT " 
                        + "i.id_institution, "
                        + "i.name,"
                        + "i.amie "
                        + "FROM Institution i "
                        + "WHERE i.state = 1" ;
        try {
            Connection cone=opConnection();
            Statement stmt= cone.createStatement();
            ResultSet rs= stmt.executeQuery(querry);
            while(rs.next()){
                InstitutionDTO institution = new InstitutionDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
                );
                list_institution.add(institution);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } 
        return list_institution; 
    }
    @Override
    public List<InstitutionDTO> read_column() throws Exception {
        List<InstitutionDTO> columns = new ArrayList<>();
        String query = "PRAGMA table_info(vw_persona) ";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                InstitutionDTO column = new InstitutionDTO(
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
    public List<InstitutionDTO> search_read(String AMIE) throws Exception {
        List<InstitutionDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                        + "i.id_institution, "
                        + "i.id_manager, "
                        + "i.name, "
                        + "i.amie, "
                        + "i.state, "
                        + "i.date_created, "
                        + "i.date_updated "
                        + "FROM Institution i; "
                        + "JOIN Persona p ON i.id_manager = p.id_person "
                        + "WHERE i.state = 1 AND i.amie LIKE ? ";

        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, "%"+AMIE+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                InstitutionDTO list = new InstitutionDTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7)
                );
                tabla.add(list);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tabla;
    }
    @Override
    public List<InstitutionDTO> read_combobox2(){
        List<InstitutionDTO> list_institution=new ArrayList<>();
        String querry=  "SELECT " 
                        + "i.id_institution, "
                        + "i.name,"
                        + "i.amie "
                        + "FROM Institution i "
                        + "WHERE i.state = 1" ;
        try {
            Connection cone=opConnection();
            Statement stmt= cone.createStatement();
            ResultSet rs= stmt.executeQuery(querry);
            while(rs.next()){
                InstitutionDTO institution = new InstitutionDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
                );
                list_institution.add(institution);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } 
        return list_institution; 
    }

    @Override
    public InstitutionDTO search_read_single(String DNI) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search_read_single'");
    }
    
}