package Data_Access.VIEW;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Data_Access.Data_Helper_Sqlite;
import Data_Access.IVIEWDAO;

public class InstitutionViewDAO extends Data_Helper_Sqlite implements IVIEWDAO<InstitutionViewDTO> {

    @Override
    public InstitutionViewDTO readby(String id_institution) throws Exception {
        InstitutionViewDTO institution = new InstitutionViewDTO();
        String query = "SELECT "
                + "i.id_institution, "
                + "i.id_manger, "
                + "i.name, "
                + "i.amie,"
                + "i.state "
                + "FROM vw_institution "
                + "JOIN Persona p ON i.id_manager = p.id_person"
                + "WHERE i.state = 1 AND i.id_institution = ? ";

        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, id_institution);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                institution = new InstitutionViewDTO(
                        rs.getInt(1), // id institution
                        rs.getInt(2), // id manager
                        rs.getString(3), // name
                        rs.getString(4), // amie
                        rs.getInt(5) // estado
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return institution;
    }

    @Override
    public List<InstitutionViewDTO> readall() throws Exception {
        List<InstitutionViewDTO> institutions = new ArrayList<>();
        InstitutionViewDTO insitution = new InstitutionViewDTO();
        String query = "SELECT i.ID, i.INSTITUTION, i.CODIGO,  i.MANAGER FROM vw_institution i ";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                insitution = new InstitutionViewDTO(
                        rs.getInt(1), // id_institution
                        rs.getString(2), //name institution
                        rs.getString(3), // name
                        rs.getString(4) // amie
                );
                institutions.add(insitution);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return institutions;
    }

    @Override
    public List<InstitutionViewDTO> read_column() throws Exception {

        List<InstitutionViewDTO> columns = new ArrayList<>();
        InstitutionViewDTO column = new InstitutionViewDTO();
        String query = "PRAGMA table_info(vw_institution)";

        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                column = new InstitutionViewDTO(
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
    public List<InstitutionViewDTO> search_read(String AMIE) throws Exception {
        List<InstitutionViewDTO> institutions = new ArrayList<>();
        InstitutionViewDTO insitution = new InstitutionViewDTO();
        String query = "SELECT ID, INSTITUTION, CODIGO, MANAGER FROM vw_institution WHERE CODIGO LIKE ? ";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, "%" + AMIE + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                insitution = new InstitutionViewDTO(
                    rs.getInt(1), // id_institution
                    rs.getString(2), //name institution
                    rs.getString(3), // name
                    rs.getString(4) // amie
                );
                institutions.add(insitution);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return institutions;

    }

    @Override
    public List<InstitutionViewDTO> read_combobox() throws Exception {
        List<InstitutionViewDTO> list_Institution = new ArrayList<>();
        String query = "SELECT "
                + "i.id_institution, "
                + "i.id_manger, "
                + "i.name, "
                + "i.amie,"
                + "FROM vw_institution "
                + "JOIN Persona p ON i.id_manager = p.id_person"
                + "WHERE i.state = 1 AND i.id_institution = ? ";

        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1, 4);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                InstitutionViewDTO institution = new InstitutionViewDTO(
                        rs.getInt(1), // id institution
                        rs.getInt(2), // id manager
                        rs.getString(3), // name
                        rs.getString(4), // amie
                        rs.getInt(5) // estado
                );
                list_Institution.add(institution);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list_Institution;

    }

    @Override
    public InstitutionViewDTO readby(Integer id) throws Exception {
        InstitutionViewDTO institution = new InstitutionViewDTO();
        String query = "SELECT "
                + "i.id_institution, "
                + "i.id_manger, "
                + "i.name, "
                + "i.amie,"
                + "i.state "
                + "FROM vw_institution "
                + "JOIN Persona p ON i.id_manager = p.id_person"
                + "WHERE i.state = 1 AND i.id_institution = ? ";

        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                institution = new InstitutionViewDTO(
                        rs.getInt(1), // id institution
                        rs.getInt(2), // id manager
                        rs.getString(3), // name
                        rs.getString(4), // amie
                        rs.getInt(5) // estado
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return institution;
    }
}
