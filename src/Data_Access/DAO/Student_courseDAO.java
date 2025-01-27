/* package Data_Access.DAO;
 // ----no cambiar---
import Data_Access.Data_Helper_Sqlite;
import Data_Access.DTO.Student_courseDTO;
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


public class Student_courseDAO extends Data_Helper_Sqlite implements IDAO  <Student_courseDTO> {
    @Override
    public Student_courseDTO readby(Integer id) throws Exception{
        Student_courseDTO registro=new Student_courseDTO();
        String query= "SELECT "
                        + "s.id_student_course, "
                        + "p.name, "
                        + "c.name, "
                        + "s.state, "
                        + "s.date_created, "
                        + "s.date_update "
                        + "FROM Student_course s "
                        + "JOIN Person p ON s.id_student=p.id_person "
                        + "JOIN Course c ON s.id_course=c.id_course "
                        + "WHERE s.state = 1 AND s.id_student_course = " + id + ";";
        try {
            Connection connect = opConnection();
            Statement stmt= connect.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                registro= Student_courseDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6)
                );
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readby()");
        }
        return registro;
    }
    
}
 */