package Data_Access.VIEW;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Data_Access.Data_Helper_Sqlite;
import Data_Access.IVIEWDAO;

public class DocentesViewDAO extends Data_Helper_Sqlite implements IVIEWDAO<DocentesViewDTO>{

    @Override
    public DocentesViewDTO readby(String id_course) throws Exception {
        DocentesViewDTO docente = new DocentesViewDTO();
        String query = "SELECT"
                +" c.id_course,"
                +" CONCAT(p.name, ' ' , p.last_name), "
                +" ins.name, "
                +" ins.amie, "
                +" cat_per.name, "
                +" cat_t.name, "
                +" CONCAT(cat_l.name,' ', cat_p.name),"
                +" c.state "
                +" FROM vw_docente c " 
                +" JOIN Persona p ON c.id_teacher = p.id_person " 
                +" JOIN Institution ins ON c.id_institution = ins.id_institution " 
                +" JOIN Catalog cat_l ON c.id_catalog_level = cat_l.id_catalog " 
                +" JOIN Catalog cat_per ON c.id_catalog_period = cat_per.id_catalog " 
                +" JOIN Catalog cat_p ON c.id_catalog_parallel = cat_p.id_catalog " 
                +" JOIN Catalog cat_t ON c.id_catalog_time = cat_t.id_catalog "
                +" WHERE c.state = 1 AND c.id_course = ?  ";

            try {
                Connection connect = opConnection();
                PreparedStatement stmt = connect.prepareStatement(query);
                stmt.setString(1, id_course);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    docente = new DocentesViewDTO(
                            rs.getInt(1), // id_course
                            rs.getString(2), // name
                            rs.getString(3), // name
                            rs.getString(4), // amie
                            rs.getString(5), // name
                            rs.getString(6), // name
                            rs.getString(7) // name
                    );
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        return docente;                              
    }

    @Override
    public DocentesViewDTO readby(Integer id) throws Exception {
        DocentesViewDTO docente = new DocentesViewDTO();
        String query = "SELECT"
                +" c.id_course,"
                +" CONCAT(p.name, ' ' , p.last_name), "
                +" ins.name, "
                +" ins.amie, "
                +" cat_per.name, "
                +" cat_t.name, "
                +" CONCAT(cat_l.name,' ', cat_p.name) "
                +" FROM vw_docente c " 
                +" JOIN Persona p ON c.id_teacher = p.id_person " 
                +" JOIN Institution ins ON c.id_institution = ins.id_institution " 
                +" JOIN Catalog cat_l ON c.id_catalog_level = cat_l.id_catalog " 
                +" JOIN Catalog cat_per ON c.id_catalog_period = cat_per.id_catalog " 
                +" JOIN Catalog cat_p ON c.id_catalog_parallel = cat_p.id_catalog " 
                +" JOIN Catalog cat_t ON c.id_catalog_time = cat_t.id_catalog "
                +" WHERE c.state = 1 AND c.id_course = ?  ";

            try {
                Connection connect = opConnection();
                PreparedStatement stmt = connect.prepareStatement(query);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    docente = new DocentesViewDTO(
                            rs.getInt(1), // id_course
                            rs.getString(2), // name
                            rs.getString(3), // name
                            rs.getString(4), // amie
                            rs.getString(5), // name
                            rs.getString(6), // name
                            rs.getString(7) // name
                    );
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        return docente;    
    }

    @Override
    public List<DocentesViewDTO> readall() throws Exception {
        List<DocentesViewDTO> docentes = new ArrayList<>();
        DocentesViewDTO docente = new DocentesViewDTO();
        String query = "SELECT c.ID, c.PROFESOR, c.INSTITUCION, c.AMIE, c.PERIODO, c.JORNADA, c.CURSO FROM vw_docente c ";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                docente = new DocentesViewDTO(
                        rs.getInt(1), // id_course
                        rs.getString(2), // name
                        rs.getString(3), // name
                        rs.getString(4), // amie
                        rs.getString(5), // name
                        rs.getString(6), // name
                        rs.getString(7) // name
                );
                docentes.add(docente);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return docentes;
    }

    @Override
    public List<DocentesViewDTO> read_column() throws Exception {
        List<DocentesViewDTO> columns = new ArrayList<>();
        DocentesViewDTO column = new DocentesViewDTO();
        String query = "PRAGMA table_info(vw_docente)";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                column = new DocentesViewDTO(
                        rs.getString(2) // name_column
                );
                columns.add(column);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return columns;
    }

    @Override
    public List<DocentesViewDTO> search_read(String DNI) throws Exception {
        List<DocentesViewDTO> docentes = new ArrayList<>();
        DocentesViewDTO docente = new DocentesViewDTO();
        String query = "SELECT c.ID, c.PROFESOR, c.INSTITUCION, c.AMIE, c.PERIODO, c.JORNADA, c.CURSO FROM vw_docente c WHERE c.PROFESOR LIKE ? ";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, "%" + DNI + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                docente = new DocentesViewDTO(
                        rs.getInt(1), // id_course
                        rs.getString(2), // name
                        rs.getString(3), // name
                        rs.getString(4), // amie
                        rs.getString(5), // name
                        rs.getString(6), // name
                        rs.getString(7) // name
                );
                docentes.add(docente);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return docentes;
    }

    @Override
    public List<DocentesViewDTO> read_combobox() throws Exception {
        List<DocentesViewDTO> list_docente = new ArrayList<>();
        String query = "SELECT"
                +" c.id_course,"
                +" CONCAT(p.name, ' ' , p.last_name), "
                +" ins.name, "
                +" ins.amie, "
                +" cat_per.name, "
                +" cat_t.name, "
                +" CONCAT(cat_l.name,' ', cat_p.name),"
                +" c.state "
                +" FROM vw_docente c " 
                +" JOIN Persona p ON c.id_teacher = p.id_person " 
                +" JOIN Institution ins ON c.id_institution = ins.id_institution " 
                +" JOIN Catalog cat_l ON c.id_catalog_level = cat_l.id_catalog " 
                +" JOIN Catalog cat_per ON c.id_catalog_period = cat_per.id_catalog " 
                +" JOIN Catalog cat_p ON c.id_catalog_parallel = cat_p.id_catalog " 
                +" JOIN Catalog cat_t ON c.id_catalog_time = cat_t.id_catalog "
                +" WHERE c.state = 1 ";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DocentesViewDTO docente = new DocentesViewDTO(
                        rs.getInt(1), // id_course
                        rs.getString(2), // name
                        rs.getString(3), // name
                        rs.getString(4), // amie
                        rs.getString(5), // name
                        rs.getString(6), // name
                        rs.getString(7) // name
                );
                list_docente.add(docente);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list_docente;

    }
    
}
