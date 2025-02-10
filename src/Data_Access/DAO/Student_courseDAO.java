package Data_Access.DAO;
 // ----no cambiar---
import Data_Access.Data_Helper_Sqlite;
import Data_Access.DAO.DAO_C.IDAO;
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
                            throw e;
                        }
                        return registro;
                    }
                
                    private Student_courseDTO Student_courseDTO(int int1, String string, String string2, int int2, String string3,
                            String string4) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'Student_courseDTO'");
                    }
                
                    @Override
    public List<Student_courseDTO> readall() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readall'");
    }

    @Override
    public List<Student_courseDTO> read_combobox() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read_combobox'");
    }

    @Override
    public List<Student_courseDTO> read_combobox2() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read_combobox2'");
    }

    @Override
    public boolean created(Student_courseDTO entity) throws Exception {
        String query = " INSERT INTO Student_course (id_student, id_course)"
                + " VALUES(?,?)";
        try {
            Connection conect = opConnection();
            PreparedStatement pstm = conect.prepareStatement(query);
            pstm.setInt(1,entity.getId_student());
            pstm.setInt(2,entity.getId_course());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean update(Student_courseDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Student_courseDTO> read_column() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read_column'");
    }

    @Override
    public List<Student_courseDTO> search_read(String DNI) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search_read'");
    }

    @Override
    public Student_courseDTO search_read_single(String DNI) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search_read_single'");
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
 
