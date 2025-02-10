package Data_Access.VIEW;

import Data_Access.Data_Helper_Sqlite;
import Data_Access.IVIEWDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DocenteViewDAO extends Data_Helper_Sqlite implements IVIEWDAO<DocenteViewDTO> {
    @Override
    public DocenteViewDTO readby(String DNI) throws Exception {
        DocenteViewDTO docente = new DocenteViewDTO();
        String query = "SELECT * FROM vw_docente WHERE DNI = ?";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, DNI);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                docente = new DocenteViewDTO(
                        rs.getInt("ID"),
                        rs.getString("PROFESOR"),
                        rs.getString("INSTITUCION"),
                        rs.getString("AMIE"),
                        rs.getString("PERIODO"),
                        rs.getString("JORNADA"),
                        rs.getString("CURSO"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return docente;
    }

    @Override
    public List<DocenteViewDTO> readall() throws Exception {
        List<DocenteViewDTO> docentes = new ArrayList<>();
        String query = "SELECT * FROM vw_docente";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DocenteViewDTO docente = new DocenteViewDTO(
                        rs.getInt("ID"),
                        rs.getString("PROFESOR"),
                        rs.getString("INSTITUCION"),
                        rs.getString("AMIE"),
                        rs.getString("PERIODO"),
                        rs.getString("JORNADA"),
                        rs.getString("CURSO"));
                docentes.add(docente);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return docentes;
    }

    @Override
    public List<DocenteViewDTO> read_column() throws Exception {
        List<DocenteViewDTO> columns = new ArrayList<>();
        String query = "PRAGMA table_info(vw_docente)";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DocenteViewDTO column = new DocenteViewDTO(rs.getString("name"));
                columns.add(column);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return columns;
    }

    @Override
    public List<DocenteViewDTO> search_read(String DNI) throws Exception {
        List<DocenteViewDTO> docentes = new ArrayList<>();
        String query = "SELECT * FROM vw_docente WHERE DNI LIKE ?";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, "%" + DNI + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DocenteViewDTO docente = new DocenteViewDTO(
                        rs.getInt("ID"),
                        rs.getString("PROFESOR"),
                        rs.getString("INSTITUCION"),
                        rs.getString("AMIE"),
                        rs.getString("PERIODO"),
                        rs.getString("JORNADA"),
                        rs.getString("CURSO"));
                docentes.add(docente);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return docentes;
    }

    @Override
    public DocenteViewDTO readby(Integer id) throws Exception {
        DocenteViewDTO docente = new DocenteViewDTO();
        String query = "SELECT * FROM vw_docente WHERE ID = ?";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                docente = new DocenteViewDTO(
                        rs.getInt("ID"),
                        rs.getString("PROFESOR"),
                        rs.getString("INSTITUCION"),
                        rs.getString("AMIE"),
                        rs.getString("PERIODO"),
                        rs.getString("JORNADA"),
                        rs.getString("CURSO"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return docente;
    }

    @Override
    public List<DocenteViewDTO> read_combobox() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'read_combobox'");
    }
}