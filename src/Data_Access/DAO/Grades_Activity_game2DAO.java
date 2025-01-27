package Data_Access.DAO;

import Data_Access.DTO.Grades_Activity_game2DTO;
import Data_Access.Data_Helper_Sqlite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Grades_Activity_game2DAO extends Data_Helper_Sqlite implements IDAO<Grades_Activity_game2DTO> {

    @Override
    public Grades_Activity_game2DTO readby(Integer id) throws Exception {
        Grades_Activity_game2DTO registro = new Grades_Activity_game2DTO();
        String query = "SELECT "
                        + "g.id_grade_activity_game2, "
                        + "g.id_student_course, "
                        + "g.answer1, "
                        + "g.id_game2, "
                        + "g.state, "
                        + "g.date_created, "
                        + "g.date_updated "
                        + "FROM grades_activity_game2 g "
                        + "JOIN student_course sc ON g.id_student_course = sc.id_student_course "
                        + "JOIN game2 ga ON g.id_game2 = ga.id_game2 "
                        + "WHERE g.state = 1 AND g.id_grade_activity_game2 = " + id + ";";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                registro = new Grades_Activity_game2DTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7)
                );
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readby()");
        }
        return registro;
    }

    @Override
    public List<Grades_Activity_game2DTO> readall() {
        List<Grades_Activity_game2DTO> tabla = new ArrayList<>();
        String query = "SELECT "
                        + "g.id_grade_activity_game2, "
                        + "g.id_student_course, "
                        + "g.answer1, "
                        + "g.id_game2, "
                        + "g.state, "
                        + "g.date_created, "
                        + "g.date_updated "
                        + "FROM grades_activity_game2 g; "
                        + "JOIN student_course sc ON g.id_student_course = sc.id_student_course "
                        + "JOIN game2 ga ON g.id_game2 = ga.id_game2 "
                        + "WHERE g.state = 1";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Grades_Activity_game2DTO list = new Grades_Activity_game2DTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getInt(4),
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
    public boolean created(Grades_Activity_game2DTO entity) throws Exception {
        String query = "INSERT INTO grades_activity_game2 (id_student_course, answer1, id_game2, state, date_created, date_updated) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId_student_course());
            pstmt.setString(2, entity.getAnswer1());
            pstmt.setInt(3, entity.getId_game1());
            pstmt.setInt(4, entity.getState());
            pstmt.setString(5, entity.getDate_created());
            pstmt.setString(6, entity.getDate_updated());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "created()");
        }
    }

    @Override
    public boolean update(Grades_Activity_game2DTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE grades_activity_game2 SET id_student_course = ?, answer1 = ?, id_game2 = ?, state = ?, date_update = ? WHERE id_grade_activity_game2 = ?;";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,     entity.getId_student_course());
            pstmt.setString(2,  entity.getAnswer1());
            pstmt.setInt(3,     entity.getId_game1());
            pstmt.setInt(4,     entity.getState());
            pstmt.setString(5,  dtf.format(now).toString());
            pstmt.setInt(6,     entity.getId_grade_activity_game2());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE grades_activity_game2 SET state = ?, date_update = ? WHERE id_grade_activity_game2 = ?;";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 0);
            pstmt.setString(1, dtf.format(now).toString());
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
}