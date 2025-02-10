package Data_Access.DAO;

import Data_Access.DTO.Game2DTO;
import Data_Access.DTO.Game2DTO;
import Data_Access.Data_Helper_Sqlite;
import Data_Access.DAO.DAO_C.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Game2DAO extends Data_Helper_Sqlite implements IDAO<Game2DTO> {

    @Override
    public Game2DAO readby(Integer id) throws Exception {
        Game2DAO registro = new Game2DTO();
        String query = "SELECT                                                          "
                        + "g.id_grade_activity_game1,                                   "
                        + "g.id_student_course,                                         "
                        + "g.answer,                                                    "
                        + "g.id_game1,                                                  "
                        + "g.state,                                                     "
                        + "g.date_created,                                              "
                        + "g.date_update                                                "
                        + "FROM grades_activity_game1 g                                 "
                        + "WHERE g.state = 1 AND g.id_grade_activity_game1 = " + id + ";";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                registro = new Game2DTO(rs.getInt(1),
                                                        rs.getInt(2),
                                                        rs.getString(3),
                                                        rs.getInt(4),
                                                        rs.getInt(5),
                                                        rs.getString(6),
                                                        rs.getString(7));
            }
        } catch (SQLException e) {
            throw  e; //new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return registro;
    }

    @Override
    public List<Game2DTO> readall() {
        List<Game2DTO> tabla = new ArrayList<>();
        String query = "SELECT                          "
                        + "g.id_grade_activity_game1,   "
                        + "g.id_student_course,         "
                        + "g.answer,                    "
                        + "g.id_game1,                  "
                        + "g.state,                     "
                        + "g.date_created,              "
                        + "g.date_update                "
                        + "FROM grades_activity_game1 g;";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Game2DTO list = new Game2DTO(rs.getInt(1),
                                                                             rs.getInt(2),
                                                                             rs.getString(3),
                                                                             rs.getInt(4),
                                                                             rs.getInt(5),
                                                                             rs.getString(6),
                                                                             rs.getString(7));
                tabla.add(list);
            }
        } catch (SQLException e) {
            throw e;                //new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return tabla;
    }

    @Override
    public boolean created(Game2DTO entity) throws Exception {
        String query = "INSERT INTO grades_activity_game1 (id_student_course, answer, id_game1, state, date_created, date_update) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId_student_course());
            pstmt.setString(2, entity.getAnswer());
            pstmt.setInt(3, entity.getId_game1());
            pstmt.setInt(4, entity.getState());
            pstmt.setString(5, entity.getDate_created());
            pstmt.setString(6, entity.getDate_update());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;                //new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(Game2DTO entity) throws Exception {
        DateTimeFormatter dtf       = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now           = LocalDateTime.now();
        String query                = "UPDATE grades_activity_game1 SET id_student_course = ?, answer = ?, id_game1 = ?, state = ?, date_update = ? WHERE id_grade_activity_game1 = ?;";
        try {
            Connection conn         = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId_student_course());
            pstmt.setString(2, entity.getAnswer());
            pstmt.setInt(3, entity.getId_game1());
            pstmt.setInt(4, entity.getState());
            pstmt.setString(5, dtf.format(now));
            pstmt.setInt(6, entity.getId_grade_activity_game1());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;                //new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        DateTimeFormatter dtf       = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now           = LocalDateTime.now();
        String query                = "UPDATE grades_activity_game1 SET state = 0, date_update = ? WHERE id_grade_activity_game1 = ?;";
        try {
            Connection conn         = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, dtf.format(now));
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;                //new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public List<Game2DTO> read_combobox() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read_combobox'");
    }

    @Override
    public List<Game2DTO> read_combobox2() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read_combobox2'");
    }

    @Override
    public List<Game2DTO> read_column() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read_column'");
    }

    @Override
    public List<Game2DTO> search_read(String DNI) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search_read'");
    }

    @Override
    public Game2DTO search_read_single(String DNI) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search_read_single'");
    }
}