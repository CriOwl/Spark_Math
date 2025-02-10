package Data_Access.VIEW;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Data_Access.Data_Helper_Sqlite;
import Data_Access.IVIEWDAO;

public class EstudianteViewDAO extends Data_Helper_Sqlite implements IVIEWDAO<EstudianteViewDTO>{

    @Override
    public EstudianteViewDTO readby(String id_course) throws Exception {
        EstudianteViewDTO estudiante = new EstudianteViewDTO();
        String query = "SELECT"
                +" sc.id_student_course,"
                +" CONCAT(p.name, ' ', p.last_name), "
                +" p.DNI, "
                +" p.email, "
                +" i.name, "
                +" i.amie, "
                +" cat_per.name, "
                +" cat_t.name, "
                +" CONCAT(cat_l.name, ' ', cat_p.name),"
                +" c.state "
                +" FROM vw_estudiante c" 
                +" JOIN Persona p ON sc.id_student = p.id_person " 
                +" JOIN Course c ON sc.id_course = c.id_course " 
                +" JOIN Institution i ON c.id_institution = i.id_institution " 
                +" JOIN Catalog cat_l ON c.id_catalog_level = cat_l.id_catalog " 
                +" JOIN Catalog cat_p ON c.id_catalog_parallel = cat_p.id_catalog " 
                +" JOIN Catalog cat_t ON c.id_catalog_time = cat_t.id_catalog "
                +" JOIN Catalog cat_per ON c.id_catalog_period = cat_per.id_catalog "
                +" WHERE c.state = 1 AND c.id_course = ?  ";

            try {
                Connection connect = opConnection();
                PreparedStatement stmt = connect.prepareStatement(query);
                stmt.setString(1, id_course);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    estudiante = new EstudianteViewDTO(
                            rs.getInt(1), // id_course
                            rs.getString(2), // name
                            rs.getString(3), // name
                            rs.getString(4), // amie
                            rs.getString(5), // name
                            rs.getString(6), // name
                            rs.getString(7), // name
                            rs.getString(8), // name
                            rs.getString(9), // name
                            rs.getString(10) // name
                    );
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        return estudiante;                              
    }

    @Override
    public EstudianteViewDTO readby(Integer id) throws Exception {
        EstudianteViewDTO estudiante = new EstudianteViewDTO();
        String query = "SELECT"
                +" sc.id_student_course,"
                +" CONCAT(p.name, ' ', p.last_name), "
                +" p.DNI, "
                +" p.email, "
                +" i.name, "
                +" i.amie, "
                +" cat_per.name, "
                +" cat_t.name, "
                +" CONCAT(cat_l.name, ' ', cat_p.name),"
                +" FROM vw_estudiante c" 
                +" JOIN Persona p ON sc.id_student = p.id_person " 
                +" JOIN Course c ON sc.id_course = c.id_course " 
                +" JOIN Institution i ON c.id_institution = i.id_institution " 
                +" JOIN Catalog cat_l ON c.id_catalog_level = cat_l.id_catalog " 
                +" JOIN Catalog cat_p ON c.id_catalog_parallel = cat_p.id_catalog " 
                +" JOIN Catalog cat_t ON c.id_catalog_time = cat_t.id_catalog "
                +" JOIN Catalog cat_per ON c.id_catalog_period = cat_per.id_catalog "
                +" WHERE c.state = 1 AND c.id_course = ?  ";

            try {
                Connection connect = opConnection();
                PreparedStatement stmt = connect.prepareStatement(query);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    estudiante = new EstudianteViewDTO(
                            rs.getInt(1), // id_course
                            rs.getString(2), // name
                            rs.getString(3), // name
                            rs.getString(4), // amie
                            rs.getString(5), // name
                            rs.getString(6), // name
                            rs.getString(7), // name
                            rs.getString(8), // name
                            rs.getString(9), // name
                            rs.getString(10) // name
                    );
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        return estudiante; 
    }

    @Override
    public List<EstudianteViewDTO> readall() throws Exception {
        List<EstudianteViewDTO> estudiantes = new ArrayList<>();
        EstudianteViewDTO estudiante = new EstudianteViewDTO();
        String query = "SELECT c.ID, c.ESTUDIANTE, c.CEDULA, c.CORREO, c.INSTITUCION, c.AMIE, c.PERIODO, c.JORNADA, c.CURSO, c.PROFESOR FROM vw_estudiante c ";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                estudiante = new EstudianteViewDTO(
                        rs.getInt(1), // id_course
                        rs.getString(2), // name
                        rs.getString(3), // name
                        rs.getString(4), // amie
                        rs.getString(5), // name
                        rs.getString(6), // name
                        rs.getString(7), // name
                        rs.getString(8), // name
                        rs.getString(9), // name
                        rs.getString(10) // name
                );
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return estudiantes;
    }

    @Override
    public List<EstudianteViewDTO> read_column() throws Exception {
        List<EstudianteViewDTO> columns = new ArrayList<>();
        EstudianteViewDTO column = new EstudianteViewDTO();
        String query = "PRAGMA table_info(vw_estudiante)";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                column = new EstudianteViewDTO(
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
    public List<EstudianteViewDTO> search_read(String DNI) throws Exception {
        List<EstudianteViewDTO> estudiantes = new ArrayList<>();
        EstudianteViewDTO estudiante = new EstudianteViewDTO();
        String query = "SELECT c.ID, c.ESTUDIANTE, c.CEDULA, c.CORREO, c.INSTITUCION, c.AMIE, c.PERIODO, c.JORNADA c.CURSO FROM vw_estudiante c WHERE c.ESTUDIANTE LIKE ? ";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, "%" + DNI + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                estudiante = new EstudianteViewDTO(
                    rs.getInt(1), // id_course
                    rs.getString(2), // name
                    rs.getString(3), // name
                    rs.getString(4), // amie
                    rs.getString(5), // name
                    rs.getString(6), // name
                    rs.getString(7), // name
                    rs.getString(8), // name
                    rs.getString(9), // name
                    rs.getString(10) // name
                );
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return estudiantes;
    }

    @Override
    public List<EstudianteViewDTO> read_combobox() throws Exception {
        List<EstudianteViewDTO> list_docente = new ArrayList<>();
        String query = "SELECT"
                +" sc.id_student_course,"
                +" CONCAT(p.name, ' ', p.last_name), "
                +" p.DNI, "
                +" p.email, "
                +" i.name, "
                +" i.amie, "
                +" cat_per.name, "
                +" cat_t.name, "
                +" CONCAT(cat_l.name, ' ', cat_p.name),"
                +" c.state "
                +" FROM vw_estudiante c" 
                +" JOIN Persona p ON sc.id_student = p.id_person " 
                +" JOIN Course c ON sc.id_course = c.id_course " 
                +" JOIN Institution i ON c.id_institution = i.id_institution " 
                +" JOIN Catalog cat_l ON c.id_catalog_level = cat_l.id_catalog " 
                +" JOIN Catalog cat_p ON c.id_catalog_parallel = cat_p.id_catalog " 
                +" JOIN Catalog cat_t ON c.id_catalog_time = cat_t.id_catalog "
                +" JOIN Catalog cat_per ON c.id_catalog_period = cat_per.id_catalog "
                +" WHERE c.state = 1 ";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                EstudianteViewDTO docente = new EstudianteViewDTO(
                    rs.getInt(1), // id_course
                    rs.getString(2), // name
                    rs.getString(3), // name
                    rs.getString(4), // amie
                    rs.getString(5), // name
                    rs.getString(6), // name
                    rs.getString(7), // name
                    rs.getString(8), // name
                    rs.getString(9), // name
                    rs.getString(10) // name
                );
                list_docente.add(docente);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list_docente;

    }
    
}
